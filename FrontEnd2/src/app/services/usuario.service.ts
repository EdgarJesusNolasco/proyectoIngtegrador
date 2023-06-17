import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Usuario } from '../components/models/usuario';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {
  private rutaGlobal = 'http://localhost:8080/api/usuarios/'

  constructor(private http: HttpClient) { }
  
  //Crear paciente
  crearUsuario(medico: Usuario):Observable<Object> {
    return this.http.post(`${this.rutaGlobal+'agregar'}`, medico,{
      observe:'response'
    })
      
  }
  //Obtener paciente
  getUsuarios():Observable<Usuario[]> {
    return this.http.get<Usuario[]>(`${this.rutaGlobal+'mostrar'}`);
  }



  eliminarUsuario(id: number) {
    return this.http.delete(this.rutaGlobal+'delete?id='+id,{
      observe:'response'
    });
  }
    
  //Actualizar paciente
  actualizarUsuario(id:number,medico:Usuario):Observable<Object>{
    return this.http.put(`${this.rutaGlobal}update/${id}`,medico,{
      observe:'response'
    })
  }
    
  obtenerUsuario(id:number):Observable<Usuario> {
    return this.http.get<Usuario>(`${this.rutaGlobal}get/${id}`);
  }

}
