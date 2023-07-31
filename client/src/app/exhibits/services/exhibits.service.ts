import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, catchError, map, mergeMap, of, startWith, tap, throwError } from 'rxjs';
import { ApiObservable, ContentState } from 'src/app/shared/models/api-observable';
import { environment } from 'src/environments/environment.development';
import { IExchangeAnimal } from '../models/exchange-animal';
import { IExhibit, IExhibitApiResponse } from '../models/exhibit';

@Injectable()
export class ExhibitsService {

  ZOOPERVISOR_API_URL!: string;
  exhibitsCopy$: BehaviorSubject<IExhibit[]> = new BehaviorSubject([] as IExhibit[]);

  constructor(private _http: HttpClient) {
    this.ZOOPERVISOR_API_URL = environment.apiUrl;
  }

  // ==================
  // data retrieval
  // ==================

  public getExhibits(): Observable<ApiObservable<IExhibit[]>> {
    const exhibitSubjectValue = this.exhibitsCopy$.value;

    if (exhibitSubjectValue !== null && this.exhibitsCopy$.value.length) {
      return of(({ state: ContentState.LOADED, data: this.exhibitsCopy$.value }))
    }

    return this._getExhibits()
      .pipe(
        tap(({ exhibits }) => this.exhibitsCopy$.next(exhibits)),
        map(({ exhibits }) => ({ state: ContentState.LOADED, data: exhibits })),
        startWith({ state: ContentState.LOADING }),
        catchError((e: any) => of({ state: ContentState.ERROR, error: e.message }))
      );
  }

  public getExhibitDetails(uuid: string): Observable<ApiObservable<any>> {
    const exhibitSubjectValue = this.exhibitsCopy$.value;

    if (exhibitSubjectValue !== null && this.exhibitsCopy$.value.length) {
      return this.exhibitsCopy$.pipe(
        map((exhibits: any) => exhibits.find((exhibit: any) => exhibit.uuid === uuid)),
        mergeMap((exhibit: any) => this._getCatalog(exhibit.animals).pipe(map((catalog: any) => ({ ...exhibit, catalog: [...catalog] })))),
        map((catalog: any[]) => ({ state: ContentState.LOADED, data: catalog })),
        startWith({ state: ContentState.LOADING }),
        catchError((e: any) => of({ state: ContentState.ERROR, error: e.message }))
      )
    }

    return throwError(() => new Error('REDIRECT'));
  }

  // ==================
  // helpers
  // ==================

  private _getExhibits(): Observable<IExhibitApiResponse> {
    return this._http.get<IExhibitApiResponse>(`${this.ZOOPERVISOR_API_URL}/exhibits`);
  }

  private _getCatalog(animals: IExchangeAnimal[]): Observable<any> {
    return this._http.get<any>(`${this.ZOOPERVISOR_API_URL}/catalog?name=${animals[0].species}&limit=${animals.length}`);
  }

}
