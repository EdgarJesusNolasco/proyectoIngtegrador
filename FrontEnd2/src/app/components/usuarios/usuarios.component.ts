import { Component, OnInit } from '@angular/core';
import { Usuario } from '../models/usuario';
import { UsuarioService } from 'src/app/services/usuario.service';

@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html',
  styleUrls: ['./usuarios.component.css']
})
export class UsuariosComponent implements OnInit{
  usuarios : Usuario[];
  usuario : Usuario = new Usuario();

  display : Boolean=false;

  constructor(private usuarioService:UsuarioService){}
  ngOnInit(): void {
    this.getUsuarios();
  }

  getUsuarios(){
    this.usuarioService.getUsuarios().subscribe(result=>{
      this.usuarios = result;
    })
  }
  crearPaciente(){
    this.usuarioService.crearUsuario(this.usuario).subscribe(result=>{
      this.getUsuarios();
      console.log(result);
    });
    
  }
  eliminarUsuario(idUsuario:number){
    this.usuarioService.eliminarUsuario(idUsuario).subscribe(result =>{
      this.getUsuarios();
    })   
  }
  showDialog(idUsuario:number){
    this.usuarioService.obtenerUsuario(idUsuario).subscribe(result =>{
      console.log(result);
      this.usuario = result
    });

    this.display=!this.display;
  }
  actualizarUsuario(idUsuario:number){
    this.usuarioService.actualizarUsuario(idUsuario,this.usuario).subscribe(result =>{
      console.log(result);
      this.getUsuarios();
  });
    this.display=!this.display;

  }
}
