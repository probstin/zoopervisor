import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { ExhibitService } from '../../services/exhibit.service';

@Component({
  selector: 'app-exhibit-list',
  templateUrl: './exhibit-list.component.html',
  styleUrls: ['./exhibit-list.component.scss']
})
export class ExhibitListComponent {

  public exhibits$!: Observable<any[]>;

  constructor(private _exhibitService: ExhibitService) {
    this.exhibits$ = this._exhibitService.getExhibits();
  }

}
