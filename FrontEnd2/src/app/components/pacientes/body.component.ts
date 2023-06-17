import { Component, OnInit } from '@angular/core';
import { Paciente } from '../models/paciente';
import { PacienteService } from 'src/app/services/paciente.service';

@Component({
  selector: 'app-body',
  templateUrl: './body.component.html',
  styleUrls: ['./body.component.css']
})
export class BodyComponent implements OnInit{
  pacientes : Paciente[];
  paciente : Paciente = new Paciente();

  display : Boolean=false;



  constructor(private pacienteService:PacienteService){}
  ngOnInit(): void {
    this.getPacientes();
  }

  getPacientes(){
    this.pacienteService.getPacientes().subscribe(result=>{
      this.pacientes = result;
    })
  }
  crearPaciente(){
    this.pacienteService.crearPaciente(this.paciente).subscribe(result=>{
      this.getPacientes();
      console.log(result);
    });
    
  }
  eliminarPaciente(idPaciente:number){
    this.pacienteService.eliminarPaciente(idPaciente).subscribe(result =>{
      this.getPacientes();
    })   
  }
  showDialog(idpaciente:number){
    this.pacienteService.obtenerPaciente(idpaciente).subscribe(result =>{
      console.log(result);
      this.paciente = result
    });

    this.display=!this.display;
  }
  actualizarPaciente(idPaciente:number){
    this.pacienteService.actualizarPaciente(idPaciente,this.paciente).subscribe(result =>{
      console.log(result);
      this.getPacientes();
  });
    this.display=!this.display;

  }
}
