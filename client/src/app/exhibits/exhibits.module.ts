import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { SharedModule } from '../shared/shared.module';
import { ExhibitListItemComponent } from './components/exhibit-list-item/exhibit-list-item.component';
import { ExhibitListComponent } from './containers/exhibit-list/exhibit-list.component';
import { ExhibitsService } from './services/exhibits.service';
import { ExhibitDetailsComponent } from './containers/exhibit-details/exhibit-details.component';
import { ExhibitsRoutingModule } from './exhibits-routing.module';
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
    ExhibitsRoutingModule,
    SharedModule,
    ...primeModules
  ],
  providers: [ExhibitsService],
  exports: [ExhibitListComponent]
})
export class ExhibitsModule { }
