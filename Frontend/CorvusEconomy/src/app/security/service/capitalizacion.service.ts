import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Capitalizacion } from '../model/capitalizacion.model';

@Injectable({
  providedIn: 'root'
})
export class CapitalizacionService {
  private baseUrl: string = `${environment.baseUrl}/capit`;
  
  constructor(private http: HttpClient) { }

  getAll(): Observable<Capitalizacion[]> {
    return this.http.get<Capitalizacion[]>(this.baseUrl);
}
}
