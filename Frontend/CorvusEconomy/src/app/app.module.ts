import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { SignInComponent } from './security/pages/sign-in/sign-in.component';
import { SignUpComponent } from './security/pages/sign-up/sign-up.component';
import { ResetPasswordComponent } from './security/pages/reset-password/reset-password.component';
import { ChangePasswordComponent } from './security/pages/change-password/change-password.component';
import { InputComponent } from './public/input/input.component';
import { OutputComponent } from './public/output/output.component';
import {AppRoutingModule} from "./app-routing.modules";
import {RouterModule} from "@angular/router";
import {HttpClientModule} from "@angular/common/http";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatCardModule} from "@angular/material/card";
import {MatSelectModule} from "@angular/material/select";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {MatButtonModule} from "@angular/material/button";
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatIconModule} from "@angular/material/icon";
import {MatInputModule} from "@angular/material/input";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MatCheckboxModule} from "@angular/material/checkbox";
import {MatSliderModule} from "@angular/material/slider";
import {MatDatepickerModule} from "@angular/material/datepicker";
import {SignInService} from "./security/service/sign-in.service";
import {RouterTestingModule} from "@angular/router/testing";
import {MatListModule} from "@angular/material/list";

@NgModule({
  declarations: [
    AppComponent,
    SignInComponent,
    SignUpComponent,
    ResetPasswordComponent,
    ChangePasswordComponent,
    InputComponent,
    OutputComponent
  ],
  imports: [
    BrowserModule,

    RouterTestingModule,
    AppRoutingModule,
    RouterModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatSliderModule,
    MatButtonModule,
    MatToolbarModule,
    MatIconModule,
    MatCardModule,
    MatInputModule,
    MatCheckboxModule,
    MatFormFieldModule,
    MatSelectModule,
    MatDatepickerModule,
    FormsModule,
    ReactiveFormsModule,
    MatListModule,
  ],
  providers: [SignInService],
  bootstrap: [AppComponent]
})
export class AppModule { }
