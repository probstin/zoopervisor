import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { ReplaceUnderscorePipe } from './pipes/replace-underscore.pipe';

@NgModule({
  declarations: [ReplaceUnderscorePipe],
  imports: [CommonModule],
  exports: [ReplaceUnderscorePipe, HttpClientModule]
})
export class SharedModule { }
