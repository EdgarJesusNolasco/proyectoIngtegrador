import { Component, OnInit } from '@angular/core';
import { Cita } from '../models/cita';
import { CitaService } from 'src/app/services/cita.service';
import { SelectItem } from 'primeng/api';
import { Paciente } from '../models/paciente';
import { PacienteService } from 'src/app/services/paciente.service';
import { Medico } from '../models/medico';
import { MedicoService } from 'src/app/services/medico.service';
import { Especialidad } from '../models/especialidad';
import { EspecialidadService } from 'src/app/services/especialidad.service';

@Component({
  selector: 'app-citas',
  templateUrl: './citas.component.html',
  styleUrls: ['./citas.component.css']
})
export class CitasComponent implements OnInit {

  citas : Cita[];
  cita : Cita = new Cita();
  display : Boolean=false;
  date:any;
  listPaciente: Paciente[];
  listMedico: Medico[];
  listEsp:Especialidad[];


  constructor(private citaService:CitaService,private espService:EspecialidadService,private pacienteService:PacienteService,private medicoService:MedicoService){}
  ngOnInit(): void {
    this.getCitas()
    this.pacienteService.getPacientes().subscribe(data=>{
      this.listPaciente = data;
    })
    this.medicoService.getMetdicos().subscribe(data=>{
      this.listMedico = data;
    })
    this.espService.getEspecialidades().subscribe(data=>{
      this.listEsp = data;
    })
  }

  crearCita(){
    this.citaService.crearCita(this.cita).subscribe(result=>{
      this.getCitas();
      console.log(result);
    });
    
    this.display=!this.display;
    this.getCitas();
    this.ngOnInit();
  }
  showDialogEditar(idCita:number){
    this.citaService.obtenerCita(idCita).subscribe(result =>{
      console.log(result);
      this.cita = result
    });

    this.display=!this.display;
  }
  showDialogAgregar(){
   
    this.display=!this.display;
  }
  eliminarCita(idCita:number){
    this.citaService.eliminarCita(idCita).subscribe(result =>{
      this.getCitas();
    })  
  }
  actualizarCita(idCita:number){
    
    this.citaService.actualizarCita(idCita,this.cita).subscribe(result =>{
      console.log(result);
      this.getCitas();
    });
    this.display=!this.display;

  }
  getCitas(){
    this.citaService.getCitas().subscribe(data=>{
      this.citas = data;
    })
  }



}