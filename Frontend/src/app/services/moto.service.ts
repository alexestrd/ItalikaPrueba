import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class MotoService {

  private Url = environment.apiUrl;
  constructor(private http: HttpClient) { }

  obtenerMotos(){
    return this.http.get(`${this.Url}/moto`)
  }
}
