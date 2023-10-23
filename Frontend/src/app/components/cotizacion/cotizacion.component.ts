import { Component } from '@angular/core';
import { Costo } from 'src/app/models/costoModel';
import { Moto } from 'src/app/models/motoModel';
import { CostoService } from 'src/app/services/costo.service';
import { ProyeccionService } from 'src/app/services/proyeccion.service';

@Component({
  selector: 'app-cotizacion',
  templateUrl: './cotizacion.component.html',
  styleUrls: ['./cotizacion.component.css']
})
export class CotizacionComponent {
  Datos: any = {};
  precios: any = {};
  precio:any;
  accesorio!: any;
  seguro!: number;
  mensuali!: number;
  proyec: any = {};
  tasaA!:number;
  tasaM!:number;
  constructor(private costoService: CostoService, private proyeccionService: ProyeccionService) { }

  ngOnInit() {
    this.obtenerDatos();
  }
  async obtenerDatos() {
    this.costoService.EnvDatos().then((data: Moto) => {
      if (data) {
        this.Datos = {
          id_moto: data.id_moto,
          modelo: data.modelo,
          version: data.version,
          id_costo: data.id_costo
        }
        console.log(this.Datos.id_costo)
        this.costoService.obtenerCosto(parseInt(this.Datos.id_costo)).subscribe((Data: Costo) => {
          this.precios = Data;
          this.precio = this.precios[0].precio;
          this.accesorio = this.precios[0].costos_accesorios;
          this.seguro = this.precios[0].seguro;
          console.log(this.precios)
        },(e) => {
          console.log('El error es:', e)
        });
      }

    });

  }

  valormen(event:any){
    this.mensuali = parseInt(event.target.value,10);
    console.log(this.mensuali)
  }

  proyeccion(){
  const data ={
    "precio" : this.precio,
    "mensualidades" : this.mensuali
  }
  console.log(data);
  this.proyeccionService.obtenerCostos(data).subscribe(dato =>{
   this.proyec = dato;
   this.tasaA = this.proyec.tasaAnual*100;
   this.tasaM = this.proyec.tasaMensual*100
   console.log(this.proyec)
  },(e) =>{
    console.error(e)
  })
  
  }


}

