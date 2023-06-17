import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BodyComponent } from './components/pacientes/body.component';
import { LogginComponent } from './components/loggin/loggin.component';
import { CitasComponent } from './components/citas/citas.component';
import { MedicosComponent } from './components/medicos/medicos.component';
import { UsuariosComponent } from './components/usuarios/usuarios.component';
import { EspecialidadesComponent } from './components/especialidades/especialidades.component';
import { HeaderComponent } from './components/header/header.component';

const routes: Routes = [
  {path:'loggin',component:LogginComponent},
  {path:'citas',component:CitasComponent},
  {path:'pacientes',component:BodyComponent},
  {path:'medicos',component:MedicosComponent},
  {path:'usuarios',component:UsuariosComponent},
  {path:'especialidades',component:EspecialidadesComponent},
  
  {path:'header',component:HeaderComponent},
  {path:'',redirectTo:'loggin',pathMatch:'full'},
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {  }
