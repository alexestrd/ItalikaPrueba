import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  private Url = environment.apiUrl;

  constructor(private http: HttpClient) { }

  obtenerClientes(){
    return this.http.get(`${this.Url}/cliente`)
  }
  obtenerCliente(id:string){
    return this.http.get(`${this.Url}/cliente/{id}`)
  }
  registrarCliente()
}
