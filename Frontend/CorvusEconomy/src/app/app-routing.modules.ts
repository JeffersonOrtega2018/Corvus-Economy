import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import {SignInComponent} from "./security/pages/sign-in/sign-in.component";
import {SignUpComponent} from "./security/pages/sign-up/sign-up.component";
import {ResetPasswordComponent} from "./security/pages/reset-password/reset-password.component";
import {ChangePasswordComponent} from "./security/pages/change-password/change-password.component";
import {InputComponent} from "./public/input/input.component";
import {OutputComponent} from "./public/output/output.component";

const routes: Routes = [
  { path: "", redirectTo: "sign-in", pathMatch: "full" },
  { path: "sign-in", component: SignInComponent },
  { path: "sign-up", component: SignUpComponent },
  { path: "reset-password", component: ResetPasswordComponent },
  { path: "change-password", component: ChangePasswordComponent },
  { path: "input", component: InputComponent },
  { path: "output", component: OutputComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
