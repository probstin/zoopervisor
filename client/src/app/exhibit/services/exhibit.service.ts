import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.development';

@Injectable()
export class ExhibitService {

  EXHIBITS_API!: string;

  constructor(private _http: HttpClient) {
    this.EXHIBITS_API = environment.apiUrl;
  }

  public getExhibits(): Observable<any> {
    return this._http.get(`${this.EXHIBITS_API}/exhibits`);
  }

}
