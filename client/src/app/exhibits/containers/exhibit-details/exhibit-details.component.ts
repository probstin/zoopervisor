import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable, catchError, filter, mergeMap, of } from 'rxjs';
import { ApiObservable, ContentState } from 'src/app/shared/models/api-observable';
import { ExhibitsService } from '../../services/exhibits.service';

@Component({
  selector: 'app-exhibit-details',
  templateUrl: './exhibit-details.component.html'
})
export class ExhibitDetailsComponent implements OnInit {

  public readonly ContentState = ContentState;
  public exhibit$!: Observable<ApiObservable<any>>;
  public returnLink: string = '/exhibits';

  constructor(
    private _exhibitService: ExhibitsService,
    private _route: ActivatedRoute,
    private _router: Router
  ) { }

  // =================
  // lifecycle
  // =================

  ngOnInit(): void {
    this.exhibit$ = this._route.params.pipe(
      filter(({ uuid }: any) => uuid),
      mergeMap(({ uuid }) => this._exhibitService.getExhibitDetails(uuid)),
      catchError((e: any) => {
        if (e.message === 'REDIRECT') {
          this._router.navigateByUrl(this.returnLink);
        }

        return of(e);
      }));
  }

}
