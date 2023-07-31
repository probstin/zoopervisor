import { Component, Input } from '@angular/core';
import { IExhibit } from '../../models/exhibit';

@Component({
  selector: 'app-exhibit-list-item',
  templateUrl: './exhibit-list-item.component.html',
  styleUrls: ['./exhibit-list-item.component.scss']
})
export class ExhibitListItemComponent {

  @Input() exhibit!: IExhibit;

}
