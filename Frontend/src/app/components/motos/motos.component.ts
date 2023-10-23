import { Component } from '@angular/core';
import { Moto } from 'src/app/models/motoModel';
import { CostoService } from 'src/app/services/costo.service';
import { MotoService } from 'src/app/services/moto.service';

@Component({
  selector: 'app-motos',
  templateUrl: './motos.component.html',
  styleUrls: ['./motos.component.css']
})
export class MotosComponent {
motos: any =[];
data!: Moto;

constructor(private motoService: MotoService, private costoService: CostoService){

}

ngOnInit(): void{
  this.motoService.obtenerMotos().subscribe(
    res => {
      this.motos = res;
    },
    err => console.error(err)
  )
}

  precios(data: Moto){
    this.data = data;
    this.costoService.Datos(this.data);
  }
}
