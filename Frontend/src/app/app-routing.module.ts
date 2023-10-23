import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MotosComponent } from './components/motos/motos.component';
import { CotizacionComponent } from './components/cotizacion/cotizacion.component';

const routes: Routes = [
  {path: '', component: MotosComponent},
  {path: 'costo', component: CotizacionComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
