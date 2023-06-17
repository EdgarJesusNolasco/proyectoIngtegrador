import { Component } from '@angular/core';
import { Especialidad } from '../models/especialidad';
import { EspecialidadService } from 'src/app/services/especialidad.service';

@Component({
  selector: 'app-especialidades',
  templateUrl: './especialidades.component.html',
  styleUrls: ['./especialidades.component.css']
})
export class EspecialidadesComponent {
  especialidades : Especialidad[];
  especialidad : Especialidad = new Especialidad();

  display : Boolean=false;



  constructor(private especialidadService:EspecialidadService){}
  ngOnInit(): void {
    this.getEspecialidades();
  }

  getEspecialidades(){
    this.especialidadService.getEspecialidades().subscribe(result=>{
      this.especialidades = result;
    })
  }
  crearEspecialidad(){
    this.especialidadService.crearEspecialidad(this.especialidad).subscribe(result=>{
      this.getEspecialidades();
      console.log(result);
    });
    
  }
  eliminarEspecialidad(idEspecialidad:number){
    this.especialidadService.eliminarEspecialidad(idEspecialidad).subscribe(result =>{
      this.getEspecialidades();
    })   
  }
  showDialog(idEspecialidad:number){
    this.especialidadService.obtenerEspecialidad(idEspecialidad).subscribe(result =>{
      console.log(result);
      this.especialidad = result
    });

    this.display=!this.display;
  }
  actualizarEspecialidad(idEspecialidad:number){
    this.especialidadService.actualizarEspecialidad(idEspecialidad,this.especialidad).subscribe(result =>{
      console.log(result);
      this.getEspecialidades();
  });
    this.display=!this.display;

  }
}
