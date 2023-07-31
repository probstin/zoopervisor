import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable, catchError, of } from 'rxjs';
import { ApiObservable } from 'src/app/shared/models/api-observable';
import { ExhibitService } from '../../services/exhibit.service';

@Component({
  selector: 'app-exhibit-details',
  templateUrl: './exhibit-details.component.html',
  styleUrls: ['./exhibit-details.component.scss']
})
export class ExhibitDetailsComponent implements OnInit {

  exhibit$!: Observable<ApiObservable<any>>;
  returnLink: string = 'exhibits';

  constructor(
    private _exhibitService: ExhibitService,
    private _route: ActivatedRoute,
    private _router: Router
  ) { }

  // =================
  // lifecycle
  // =================

  ngOnInit(): void {
    const exhibitId = this._route.snapshot.params['uuid'];

    if (exhibitId) {
      this.exhibit$ = this._exhibitService
        .getExhibitDetails(exhibitId)
        .pipe(
          catchError((e: any) => {
            console.log(exhibitId)
            console.log(e.message)
            if (e.message === 'REDIRECT') {
              this._router.navigateByUrl(this.returnLink);
            }

            return of(e);
          }));
    }
  }
}
