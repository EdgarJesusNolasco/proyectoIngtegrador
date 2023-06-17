import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Cita } from '../components/models/cita';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CitaService {
  private rutaGlobal = 'http://localhost:8080/api/citas/'

  constructor(private http: HttpClient) { }
  
  //Crear paciente
  crearCita(cita: Cita):Observable<Object> {
    return this.http.post(`${this.rutaGlobal+'agregar'}`, cita,{
      observe:'response'
    })
      
  }
  //Obtener paciente
  getCitas():Observable<Cita[]> {
    return this.http.get<Cita[]>(`${this.rutaGlobal+'mostrar'}`);
  }



  eliminarCita(id: number) {
    return this.http.delete(this.rutaGlobal+'delete?id='+id,{
      observe:'response'
    });
  }
    
  //Actualizar paciente
  actualizarCita(id:number,cita:Cita):Observable<Object>{
    return this.http.put(`${this.rutaGlobal}update/${id}`,cita,{
      observe:'response'
    })
  }
    
  obtenerCita(id:number):Observable<Cita> {
    return this.http.get<Cita>(`${this.rutaGlobal}get/${id}`);
  }
}
