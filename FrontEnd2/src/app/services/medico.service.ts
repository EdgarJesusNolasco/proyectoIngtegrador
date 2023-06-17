import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Medico } from '../components/models/medico';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MedicoService {

  private rutaGlobal = 'http://localhost:8080/api/medicos/'

  constructor(private http: HttpClient) { }
  
  //Crear paciente
  crearPaciente(medico: Medico):Observable<Object> {
    return this.http.post(`${this.rutaGlobal+'agregar'}`, medico,{
      observe:'response'
    })
      
  }
  //Obtener paciente
  getMetdicos():Observable<Medico[]> {
    return this.http.get<Medico[]>(`${this.rutaGlobal+'mostrar'}`);
  }



  eliminarMedico(id: number) {
    return this.http.delete(this.rutaGlobal+'delete?id='+id,{
      observe:'response'
    });
  }
    
  //Actualizar paciente
  actualizarMedico(id:number,medico:Medico):Observable<Object>{
    return this.http.put(`${this.rutaGlobal}update/${id}`,medico,{
      observe:'response'
    })
  }
    
  obtenerMedico(id:number):Observable<Medico> {
    return this.http.get<Medico>(`${this.rutaGlobal}get/${id}`);
  }

}
