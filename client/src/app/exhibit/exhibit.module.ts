import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { SharedModule } from '../shared/shared.module';
import { ExhibitListItemComponent } from './components/exhibit-list-item/exhibit-list-item.component';
import { ExhibitListComponent } from './containers/exhibit-list/exhibit-list.component';
import { ExhibitService } from './services/exhibit.service';
import { ExhibitDetailsComponent } from './containers/exhibit-details/exhibit-details.component';
import { ExhibitRoutingModule } from './exhibit-routing.module';
import { CardModule } from 'primeng/card';
import { ChipModule } from 'primeng/chip';
import { SkeletonModule } from 'primeng/skeleton';

const primeModules = [CardModule, ChipModule, SkeletonModule];

@NgModule({
  declarations: [
    ExhibitListComponent,
    ExhibitListItemComponent,
    ExhibitDetailsComponent
  ],
  imports: [
    CommonModule,
    ExhibitRoutingModule,
    SharedModule,
    ...primeModules
  ],
  providers: [ExhibitService],
  exports: [ExhibitListComponent]
})
export class ExhibitModule { }
