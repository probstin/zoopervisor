import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', redirectTo: 'exhibits', pathMatch: 'full' },
  { path: 'exhibits', loadChildren: () => import('./exhibits/exhibits.module').then(m => m.ExhibitsModule) },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
