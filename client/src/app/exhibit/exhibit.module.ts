import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ExhibitListComponent } from './containers/exhibit-list/exhibit-list.component';
import { ExhibitService } from './services/exhibit.service';

@NgModule({
  declarations: [ExhibitListComponent],
  imports: [CommonModule],
  providers: [ExhibitService],
  exports: [ExhibitListComponent]
})
export class ExhibitModule { }
