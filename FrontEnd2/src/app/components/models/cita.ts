import { Time } from "@angular/common";

export class Cita {
    id:number;
    fecha:Date=new Date;
    hora:Time;
    dni:string;
    estado:string ="Activo";
    especialidad:string;
    medico:string;

}
