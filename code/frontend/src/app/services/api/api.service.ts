import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { PetModel } from 'src/app/model/PetModel';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  //private API_URL = 'http://localhost:8080/4pet-api';
  private  API_URL = 'https://crucial-garden-365615.uc.r.appspot.com/4pet-api';


  constructor(private http: HttpClient) { }

  loginSimples(email: string, password: string) {

    var data = {
      email: email,
      senha: password
    };
    return this.http.post(this.API_URL + '/login-simples', data);
  }


  cadastrarUsuario(nome: string, email: string, senha: string) {

    var data = {
      nome: nome,
      email: email,
      senha: senha
    };
    return this.http.post(this.API_URL + '/usuario', data);
  }

  obterUsuario(id: string) {
    return this.http.get(this.API_URL + '/usuario/' + id);
  }

  cadastrarPet(pet: PetModel) {

    console.log('API - Cadastro do Pet');

    var data = {
      nome: pet.nome,
      dataNascimento: pet.dataNascimento,
      sexo: pet.sexo,
      tipoSanguineo: pet.tipoSanguineo,
      porte: pet.porte,
      raca: pet.raca,
      disponivelAdocao: pet.disponivelAdocao,
      disponivelCruzamento: pet.disponivelCruzamento,
      disponivelMaeDeLeite: pet.disponivelMaeDeLeite,
      usuarioId: pet.usuarioId
    };
    return this.http.post(this.API_URL + '/pet', data);
  }

  getPetsByUser(id: string) {
    return this.http.get(this.API_URL + '/pets/' + id);
  }

  //Create article
  createPet(pet: PetModel): Observable<number> {
    let httpHeaders = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return this.http.post<PetModel>(this.API_URL + "/" + pet.id, pet, {
      headers: httpHeaders,
      observe: 'response'
    }
    ).pipe(
      map(res => res.status),
      catchError(this.handleError)
    );
  }

  private handleError(error: any) {
    console.error(error);
    return throwError(error);
  }

}



