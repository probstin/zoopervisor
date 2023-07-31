import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { SharedModule } from '../shared/shared.module';
import { ExhibitListItemComponent } from './components/exhibit-list-item/exhibit-list-item.component';
import { ExhibitListComponent } from './containers/exhibit-list/exhibit-list.component';
import { ExhibitService } from './services/exhibit.service';

@NgModule({
  declarations: [
    ExhibitListComponent,
    ExhibitListItemComponent
  ],
  imports: [
    CommonModule,
    SharedModule
  ],
  providers: [ExhibitService],
  exports: [ExhibitListComponent]
})
export class ExhibitModule { }
