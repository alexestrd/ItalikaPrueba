import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Costo } from '../models/costoModel';
import { Moto } from '../models/motoModel';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CostoService {
  private data!: Moto;
  private Url = environment.apiUrl;
  constructor(private http: HttpClient) { }

  Datos(data: Moto){
    this.data = data;
  }

  async EnvDatos(): Promise<Moto>{
    return await this.data;
  }

  obtenerCostos(){
    return this.http.get(`${this.Url}/costo`)
  }
  obtenerCosto(id:number): Observable<Costo>{
    console.log(id)
    return this.http.get<Costo>(`${this.Url}/costo/${id}`)
  }
  registrarCliente(data: Costo){
    return this.http.post(`${this.Url}/costo`, data)
  }
}
