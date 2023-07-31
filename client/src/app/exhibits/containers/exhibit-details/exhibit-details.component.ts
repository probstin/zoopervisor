import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable, catchError, filter, mergeMap, of } from 'rxjs';
import { ApiObservable, ContentState } from 'src/app/shared/models/api-observable';
import { IExhibit } from '../../models/exhibit';
import { ExhibitsService } from '../../services/exhibits.service';

@Component({
  selector: 'app-exhibit-details',
  templateUrl: './exhibit-details.component.html'
})
export class ExhibitDetailsComponent {

  public readonly ContentState = ContentState;
  public exhibit$!: Observable<ApiObservable<IExhibit>>;
  public returnLink: string = '/exhibits';

  constructor(
    private _exhibitService: ExhibitsService,
    private _route: ActivatedRoute,
    private _router: Router
  ) {
    this.exhibit$ = this._route.params.pipe(
      filter(({ uuid }) => uuid),
      mergeMap(({ uuid }) => this._exhibitService.getExhibitDetails(uuid)),
      catchError((e: any) => {
        if (e.message === 'REDIRECT') {
          this._router.navigateByUrl(this.returnLink);
        }

        return of(e);
      }));
  }

}
