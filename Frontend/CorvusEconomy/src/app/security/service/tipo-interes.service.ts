import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { TipoInteres } from '../model/TipoInteres.model';

@Injectable({
  providedIn: 'root'
})
export class TipoInteresService {
  private baseUrl: string = `${environment.baseUrl}/interes`;
  
  constructor(private http: HttpClient) { }

  getAll(): Observable<TipoInteres[]> {
    return this.http.get<TipoInteres[]>(this.baseUrl);
}
}