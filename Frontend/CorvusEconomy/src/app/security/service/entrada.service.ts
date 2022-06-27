import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Entrada } from '../model/entrada.model';

@Injectable({
  providedIn: 'root'
})
export class EntradaService {

  constructor(private http: HttpClient) { }

  save(data: any): Observable<Entrada> {
    return this.http.post<Entrada>(`${environment.baseUrl}/entrada/guardar`, data);
}
}
