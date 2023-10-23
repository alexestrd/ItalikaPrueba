import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ProyeccionService {
  private Url = environment.apiUrl;
  constructor(private http: HttpClient) { }

  obtenerCostos(data:any){
    return this.http.post(`${this.Url}/proyeccion/realizar`, data)
  }
}
