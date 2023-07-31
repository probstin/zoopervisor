import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-exhibit-list-item',
  templateUrl: './exhibit-list-item.component.html',
  styleUrls: ['./exhibit-list-item.component.scss']
})
export class ExhibitListItemComponent {

  @Input() exhibit: any;

}
