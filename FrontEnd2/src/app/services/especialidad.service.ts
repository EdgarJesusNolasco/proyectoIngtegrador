import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Especialidad } from '../components/models/especialidad';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EspecialidadService {
  //Conectar con el Backend or apuntador hacia la ruta
  private rutaGlobal = 'http://localhost:8080/api/especialidades/'

  constructor(private http: HttpClient) { }
  
  //Crear paciente
  crearEspecialidad(especialidad: Especialidad):Observable<Object> {
    return this.http.post(`${this.rutaGlobal+'agregar'}`, especialidad,{
      observe:'response'
    })
      
  }
  //Obtener paciente
  getEspecialidades():Observable<Especialidad[]> {
    return this.http.get<Especialidad[]>(`${this.rutaGlobal+'mostrar'}`);
  }



  eliminarEspecialidad(id: number) {
    return this.http.delete(this.rutaGlobal+'delete?id='+id,{
      observe:'response'
    });
  }
    
  //Actualizar paciente
  actualizarEspecialidad(id:number,paciente:Especialidad):Observable<Object>{
    return this.http.put(`${this.rutaGlobal}update/${id}`,paciente,{
      observe:'response'
    })
  }
    
  obtenerEspecialidad(id:number):Observable<Especialidad> {
    return this.http.get<Especialidad>(`${this.rutaGlobal}get/${id}`);
  }
}
