import { Injectable } from '@angular/core';
import { PetModel } from 'src/app/model/PetModel';
import { ApiService } from '../api/api.service';

@Injectable({
  providedIn: 'root'
})
export class GlobalStorageService {
    
  public userId: string;
  public userName: string;
  public userEmail: string;

  constructor(private api: ApiService) { }

  updateLoggedUser(data: Object) {
    this.userId = data['objeto'].id;
    this.userName = data['objeto'].nome;
    this.userEmail = data['objeto'].email;
  }

  // getPetsByUser(): any {    
  //   console.log('Getting Pets for user ID: ' + this.userId);
  //   this.api.getPetsByUser(this.userId).subscribe(data =>{
  //     if (data['sucesso'] == true) {        
  //       console.log('Success on getting Pets. Return data: ' + JSON.stringify(data['objeto']));
  //       return data['objeto'];
  //     } else {        
  //       console.log('Failure on getting Pets. Return data: ' + JSON.stringify(data['objeto']));
  //       return new Object();
  //     }
  //   })
  // }  

}

