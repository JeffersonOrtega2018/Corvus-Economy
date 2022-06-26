import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Login } from '../model/login-user.model';
import { User } from '../model/user.model';


@Injectable({
  providedIn: 'root',
})
export class IdentityService {
  constructor(private http: HttpClient) {}

  login(model: Login): Observable<Login> {
    return this.http.post(`${environment.baseUrl}/signin`, model);
  }

  create(data: any): Observable<User> {
    return this.http.post<User>(`${environment.baseUrl}/signup`, data);
}
}
