import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, catchError, map, of, startWith, tap } from 'rxjs';
import { ContentState } from 'src/app/shared/models/api-observable';
import { environment } from 'src/environments/environment.development';

@Injectable()
export class ExhibitService {

  EXHIBITS_API!: string;
  exhibitsCopy$: BehaviorSubject<any> = new BehaviorSubject(null);

  constructor(private _http: HttpClient) {
    this.EXHIBITS_API = environment.apiUrl;
  }

  public getExhibits(): Observable<any> {
    return this._http
      .get(`${this.EXHIBITS_API}/exhibits`)
      .pipe(
        tap(({ exhibits }: any) => this.exhibitsCopy$.next(exhibits)),
        map(({ exhibits }: any) => ({ state: ContentState.LOADED, data: exhibits })),
        startWith({ state: ContentState.LOADING }),
        catchError((e: any) => of({ state: ContentState.ERROR, error: e.message }))
      );
  }

}
