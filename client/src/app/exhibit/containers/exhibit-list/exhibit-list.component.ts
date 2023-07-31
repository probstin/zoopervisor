import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { ApiObservable, ContentState } from 'src/app/shared/models/api-observable';
import { ExhibitService } from '../../services/exhibit.service';

@Component({
  selector: 'app-exhibit-list',
  templateUrl: './exhibit-list.component.html',
  styleUrls: ['./exhibit-list.component.scss']
})
export class ExhibitListComponent {

  public readonly ContentState = ContentState;

  public exhibits$!: Observable<ApiObservable<any>>;

  constructor(private _exhibitService: ExhibitService) {
    this.exhibits$ = this._exhibitService.getExhibits();
  }

}
