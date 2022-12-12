import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PetModel } from 'src/app/model/PetModel';
import { ApiService } from 'src/app/services/api/api.service';
import { GlobalStorageService } from 'src/app/services/global-storage/global-storage.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.page.html',
  styleUrls: ['./home.page.scss'],
})
export class HomePage implements OnInit {

  public pet: PetModel;
  public pets: PetModel[];
  public showCadastroPet: boolean;

  constructor(private route: Router, private globalStorage: GlobalStorageService, private api: ApiService) {
    //console.log('Starting constructor');
    //this.pets = this.getPetsByUser();
    //this.showNewPet();
    //console.log('Pets data: ' + this.pets);
  }


  ngOnInit() {
    console.log('Starting OnInit method');
    console.log('showCadastroPet: ' + this.showCadastroPet);
    this.pet = new PetModel();
    this.pets = this.getPetsByUser();
    this.showCadastroPet = false;
    // this.showCadastroPet = false;
    //this.pets = this.globaStorage.getPetsByUser();
    //console.log('Loaded pets on init method: ' + JSON.stringify(this.pets));
  }

  ngOnChanges() {
    console.log('Entrei onChange...');

  }

  getPetsByUser(): any {
    console.log('Obtendo os Pets do usuario: ' + this.globalStorage.userId);
    this.api.getPetsByUser(this.globalStorage.userId).subscribe(data => {
      if (data['sucesso'] == true) {
        this.pets = data['objeto'];
        return data['objeto'];
      } else {
        return new Object();
      }
    })
  }

  goCadastroPet() {
    console.log('Entrei no Cadastro Pet...');
    this.route.navigate(['/cadastro-pet']);
  }

  novoPet(){
    console.log('Habilitando tela de cadastro de Pet...');
    this.showCadastroPet = true;
    this.pet = new PetModel();
  }

  teste() {
    console.log('Entrei no CLICK da lista!!!');
  }

  // showEmptyScreen(){
    
  //   console.log('isEmpty(): ' + this.isEmpty());
  //   console.log('!this.showCadastroPet: ' + !this.showCadastroPet);

  //   if (this.isEmpty() && !this.showCadastroPet) {
  //     return true;
  //   } else {
  //     return false;
  //   }
  // }

  // showPetList(){
  //   if (!this.isEmpty() && !this.showCadastroPet) {
  //     console.log('showPetList: ' + true);
  //     return true;
  //   } else {
  //     console.log('showPetList: ' + false);
  //     return false;
  //   }
  // }

  // showNewPet(){
  //   if (this.showCadastroPet) {     
  //     return true;
  //   } else {
  //     return false;
  //   }
  // }

  isEmpty() {
    console.log('this.pets: ' + this.pets);
    if (typeof this.pets === 'undefined' || this.pets === null || this.pets.length === 0)
      return true;
    else
      return false;
  }

  cadastrarPet() {

    console.log('Entrei no Cadastro Pet na Home');
    this.pet.usuarioId = this.globalStorage.userId;

    console.log('this.globalStorage.userId: ' + this.globalStorage.userId);
    console.log('this.pet.usuarioId: ' + this.pet.usuarioId);

    this.api.cadastrarPet(this.pet).subscribe(data => {

      if (data['sucesso'] == true) {
        console.log('Pet cadastrado com sucesso!');
        console.log('Return data: ' + JSON.stringify(data));
        this.pets = this.getPetsByUser();
        // this.pets = this.globalStorage.getPetsByUser();
        //this.route.navigate(['/home']);
        this.showCadastroPet = false;
        this.pet = new PetModel();

      } else {
        console.log('Cadastro do Pet com falha!');
        this.route.navigate(['/cadastro-pet']);
        // show reason message of error.  
      }

    })
  }




}



