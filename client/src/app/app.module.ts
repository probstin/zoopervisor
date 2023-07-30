import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { ExhibitModule } from './exhibit/exhibit.module';

@NgModule({
  declarations: [AppComponent],
  imports: [
    BrowserModule,
    HttpClientModule,
    ExhibitModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
