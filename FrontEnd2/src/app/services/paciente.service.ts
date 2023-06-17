import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Paciente } from '../components/models/paciente';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PacienteService {
  //Conectar con el Backend or apuntador hacia la ruta
  private rutaGlobal = 'http://localhost:8080/api/pacientes/'

  constructor(private http: HttpClient) { }
  
  //Crear paciente
  crearPaciente(paciente: Paciente):Observable<Object> {
    return this.http.post(`${this.rutaGlobal+'agregar'}`, paciente,{
      observe:'response'
    })
      
  }
  //Obtener paciente
  getPacientes():Observable<Paciente[]> {
    return this.http.get<Paciente[]>(`${this.rutaGlobal+'mostrar'}`);
  }



  eliminarPaciente(id: number) {
    return this.http.delete(this.rutaGlobal+'delete?id='+id,{
      observe:'response'
    });
  }
    
  //Actualizar paciente
  actualizarPaciente(id:number,paciente:Paciente):Observable<Object>{
    return this.http.put(`${this.rutaGlobal}update/${id}`,paciente,{
      observe:'response'
    })
  }
    
  obtenerPaciente(id:number):Observable<Paciente> {
    return this.http.get<Paciente>(`${this.rutaGlobal}get/${id}`);
  }

}
