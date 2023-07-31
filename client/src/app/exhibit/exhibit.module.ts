import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { SharedModule } from '../shared/shared.module';
import { ExhibitListItemComponent } from './components/exhibit-list-item/exhibit-list-item.component';
import { ExhibitListComponent } from './containers/exhibit-list/exhibit-list.component';
import { ExhibitService } from './services/exhibit.service';
import { ExhibitDetailsComponent } from './containers/exhibit-details/exhibit-details.component';
import { ExhibitRoutingModule } from './exhibit-routing.module';

@NgModule({
  declarations: [
    ExhibitListComponent,
    ExhibitListItemComponent,
    ExhibitDetailsComponent
  ],
  imports: [
    CommonModule,
    ExhibitRoutingModule,
    SharedModule
  ],
  providers: [ExhibitService],
  exports: [ExhibitListComponent]
})
export class ExhibitModule { }
