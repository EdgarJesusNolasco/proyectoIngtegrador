import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { BodyComponent } from './components/pacientes/body.component';
import { ButtonModule } from 'primeng/button';
import { TableModule } from 'primeng/table';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { DialogModule } from 'primeng/dialog';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MenubarModule } from 'primeng/menubar';
import { LogginComponent } from './components/loggin/loggin.component';
import { CitasComponent } from './components/citas/citas.component';
import { DropdownModule } from 'primeng/dropdown';
import { MedicosComponent } from './components/medicos/medicos.component';
import { UsuariosComponent } from './components/usuarios/usuarios.component';
import { CalendarModule } from 'primeng/calendar';


import { PasswordModule } from 'primeng/password';
import { EspecialidadesComponent } from './components/especialidades/especialidades.component';
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    BodyComponent,
    LogginComponent,
    CitasComponent,
    MedicosComponent,
    UsuariosComponent,
    EspecialidadesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ButtonModule,
    TableModule,
    FormsModule,
    ReactiveFormsModule,
    DialogModule,
    BrowserAnimationsModule,
    MenubarModule,
    DropdownModule,
    PasswordModule,
    CalendarModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
