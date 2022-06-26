import { Component} from '@angular/core';
import {Router} from "@angular/router";
import { Login } from '../../model/login-user.model';
import { IdentityService } from '../../service/identity.service';
import { UserStorageService } from '../../service/user-storage.service';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent {
  public model: Login = new Login();
  public invalid?: boolean;

  constructor(
    private identityService: IdentityService,
    private userStorageService: UserStorageService,
    private router: Router
  ) {}

  ngOnInit(): void {}

  onSubmit(): void {
    let self = this;

    self.router.navigate(['/']);

    this.identityService.login(this.model).subscribe({
      next(data) {
        //console.log(data);
        self.userStorageService.set(data);
        self.router.navigate(['/input']);
      },
      error() {
        self.invalid = true;
      },
    });
  }

}
