import { Component } from '@angular/core';
import { Medico } from '../models/medico';
import { MedicoService } from 'src/app/services/medico.service';
import { EspecialidadService } from 'src/app/services/especialidad.service';
import { Especialidad } from '../models/especialidad';

@Component({
  selector: 'app-medicos',
  templateUrl: './medicos.component.html',
  styleUrls: ['./medicos.component.css']
})
export class MedicosComponent {
  medicos : Medico[];
  medico : Medico = new Medico();
  display : Boolean=false;
  listEsp: Especialidad[];
  constructor(private medicoService:MedicoService, private especialidadService:EspecialidadService){}
  ngOnInit():void{
    this.getMedicos();
    this.especialidadService.getEspecialidades().subscribe(data=>{
      this.listEsp = data;
    })
  }

  crearMedico(){
    this.medicoService.crearPaciente(this.medico).subscribe(result=>{
      this.getMedicos();
      console.log(result);
    });
  }
  showDialog(idMedico:number){
    this.medicoService.obtenerMedico(idMedico).subscribe(result =>{
      console.log(result);
      this.medico = result
    });

    this.display=!this.display;
  }
  eliminarMedico(idMedico:number){
    this.medicoService.eliminarMedico(idMedico).subscribe(result =>{
      this.getMedicos();
    })  
  }
  actualizarMedico(idMedico:number){
    
    this.medicoService.actualizarMedico(idMedico,this.medico).subscribe(result =>{
      console.log(result);
      this.getMedicos();
    });
    this.display=!this.display;

  }
  getMedicos(){
    this.medicoService.getMetdicos().subscribe(data=>{
      this.medicos = data;
    })
  }




}
