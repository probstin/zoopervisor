import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { ApiObservable, ContentState } from 'src/app/shared/models/api-observable';
import { ExhibitsService } from '../../services/exhibits.service';

@Component({
  selector: 'app-exhibit-list',
  templateUrl: './exhibit-list.component.html'
})
export class ExhibitListComponent {

  public readonly ContentState = ContentState;
  public exhibits$!: Observable<ApiObservable<any>>;
  public skeletons: number[] = [0, 1, 2, 3, 4, 5, 6, 7];

  constructor(private _exhibitService: ExhibitsService) {
    this.exhibits$ = this._exhibitService.getExhibits();
  }

}
