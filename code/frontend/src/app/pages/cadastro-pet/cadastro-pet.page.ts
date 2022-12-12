import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { PetModel } from 'src/app/model/PetModel';
import { ApiService } from 'src/app/services/api/api.service';
import { GlobalStorageService } from 'src/app/services/global-storage/global-storage.service';

@Component({
  selector: 'app-cadastro-pet',
  templateUrl: './cadastro-pet.page.html',
  styleUrls: ['./cadastro-pet.page.scss'],
})
export class CadastroPetPage implements OnInit {

  public pet: PetModel;
  allPets: PetModel[];
  statusCode: number;

  //Create form
  petForm = new FormGroup({
    id: new FormControl('', Validators.required),
    nome: new FormControl('', Validators.required),
    dataNascimento: new FormControl('', Validators.required),
    sexo: new FormControl('', Validators.required),
    tipoSanguineo: new FormControl('', Validators.required),
    porte: new FormControl('', Validators.required),
    raca: new FormControl('', Validators.required),
    disponivelAdocao: new FormControl('', Validators.required),
    disponivelCruzamento: new FormControl('', Validators.required),
    disponivelMaeDeLeite: new FormControl('', Validators.required),
    usuarioId: new FormControl('', Validators.required)
  });

  constructor(private route: Router, private api: ApiService, private globalStorage: GlobalStorageService) { }

  ngOnInit() {
    this.pet = new PetModel();
  }

  //cadastrarPet(pet: PetModel) {    
  cadastrarPet() {

    console.log('Entrei no Cadastro Pet');
    this.pet.usuarioId = this.globalStorage.userId;

    this.api.cadastrarPet(this.pet).subscribe(data => {

      if (data['sucesso'] == true) {
        console.log('Pet cadastrado com sucesso!');
        console.log('Return data: ' + JSON.stringify(data));
        //this.globalStorage.getPetsByUser();
        this.route.navigate(['/home']);

      } else {
        console.log('Cadastro do Pet com falha!');
        this.route.navigate(['/cadastro-pet']);
        // show reason message of error.  
      }

    })
  }

  //Handle create Pet
  onPetFormSubmit() {

    console.log('Entrei no onPetFormSubmit...');

    let pet = this.petForm.value;
    pet.id = '1';

    this.api.createPet(pet)
      .subscribe(statusCode => {
        //Expecting success code 201 from server
        this.statusCode = statusCode;
        //this.getAllArticles();
        //this.backToCreateArticle();
      },
        errorCode => this.statusCode = errorCode
      );

  }

}
