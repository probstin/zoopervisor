import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ExhibitListComponent } from './containers/exhibit-list/exhibit-list.component';
import { ExhibitDetailsComponent } from './containers/exhibit-details/exhibit-details.component';

const routes: Routes = [
  { path: '', component: ExhibitListComponent, title: 'Exhibits - Zoopervisor' },
  { path: ':uuid', component: ExhibitDetailsComponent, title: 'Exhibit - Zoopervisor' }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ExhibitRoutingModule { }
