import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, catchError, map, mergeMap, of, startWith, tap, throwError } from 'rxjs';
import { ContentState } from 'src/app/shared/models/api-observable';
import { environment } from 'src/environments/environment.development';

@Injectable()
export class ExhibitsService {

  ZOOPERVISOR_API_URL!: string;
  exhibitsCopy$: BehaviorSubject<any> = new BehaviorSubject(null);

  constructor(private _http: HttpClient) {
    this.ZOOPERVISOR_API_URL = environment.apiUrl;
  }

  // ==================
  // data retrieval
  // ==================

  public getExhibits(): Observable<any> {
    if (this.exhibitsCopy$.value !== null) {
      return of(({ state: ContentState.LOADED, data: this.exhibitsCopy$.value }))
    }
    
    return this._getExhibits()
      .pipe(
        tap(({ exhibits }: any) => this.exhibitsCopy$.next(exhibits)),
        map(({ exhibits }: any) => ({ state: ContentState.LOADED, data: exhibits })),
        startWith({ state: ContentState.LOADING }),
        catchError((e: any) => of({ state: ContentState.ERROR, error: e.message }))
      );
  }

  public getExhibitDetails(uuid: string): Observable<any> {
    if (this.exhibitsCopy$.value !== null) {
      return this.exhibitsCopy$.pipe(
        map((exhibits: any[]) => exhibits.find((exhibit: any) => exhibit.uuid === uuid)),
        mergeMap((exhibit: any) => this._getCatalog(exhibit).pipe(map((catalog: any) => ({ ...exhibit, catalog: [...catalog] })))),
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

  private _getExhibits() {
    return this._http.get<any>(`${this.ZOOPERVISOR_API_URL}/exhibits`);
  }

  private _getCatalog(exhibit: any): Observable<any> {
    return this._http.get<any>(`${this.ZOOPERVISOR_API_URL}/catalog?name=${exhibit.animals[0].species}&limit=${exhibit.animals.length}`);
  }

}
