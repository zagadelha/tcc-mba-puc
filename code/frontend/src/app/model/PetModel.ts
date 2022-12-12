import { Injectable } from "@angular/core";

@Injectable({
  providedIn: 'root'
})
export class PetModel {

  id?: string;
  nome?: string;
  dataNascimento?: string;
  sexo?: string;
  tipoSanguineo?: string;
  porte?: string;
  raca?: string;
  disponivelAdocao?: string;
  disponivelCruzamento?: string;
  disponivelMaeDeLeite?: string;
  usuarioId?: string;

  // constructor(pet) {
  //     {
  //       this.id = pet.id;
  //       this.nome = pet.nome;
  //       this.dataNascimento = pet.dataNascimento;          
  //     }
  // }

  //

}
