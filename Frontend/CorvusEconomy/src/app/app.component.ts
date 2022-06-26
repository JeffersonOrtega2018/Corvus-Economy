import {Component} from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'FrontendCorvusEconomy';

  constructor(private route: Router) {

  }

//obtener el usario logueado
  getCurrentUserEmail() {
    let currentUserString = localStorage.getItem('currentUser');
    if (currentUserString) {
      console.log(`currentUser: ${currentUserString}`);
      let currentUser = (JSON.parse(currentUserString));
      console.log(currentUser);
      return currentUser.email;
    } else {
      return null;
    }
  }

  signOut() {
    localStorage.removeItem('currentUser');
    localStorage.removeItem('accessToken');
    this.route.navigate(['sign-in']).then();
    console.log("Sign Out");

  }
}
