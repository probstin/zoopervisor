import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, map } from 'rxjs';

@Injectable()
export class ExhibitService {

  constructor(private _http: HttpClient) { }

  public getExhibits(): Observable<any> {
    return this._http
      .get('http://localhost:8080/api/v1/exhibits')
  }

}
