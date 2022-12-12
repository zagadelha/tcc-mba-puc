import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ApiService } from 'src/app/services/api/api.service';
import { GlobalStorageService } from 'src/app/services/global-storage/global-storage.service';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.page.html',
  styleUrls: ['./cadastro.page.scss'],
})
export class CadastroPage implements OnInit {

  private nome: string;
  private email: string;
  private senha: string;

  constructor(private route: Router, private api : ApiService, private globalStorage: GlobalStorageService) { }

  nextpage() {
    this.route.navigate(['/home']);
  }

  ngOnInit() {
  }

  cadastrar() {    
    
    this.api.cadastrarUsuario(this.nome, this.email, this.senha).subscribe(data =>{

      if (data['sucesso'] == true) {
        console.log('Cadastro realizado com sucesso!');        
        console.log('Return data: ' + JSON.stringify(data));
        this.globalStorage.updateLoggedUser(data);
        this.route.navigate(['/home']);
                
      } else {
        console.log('Cadastro com falha!');
        this.route.navigate(['/cadastro']);
        // show reason message of error         
      }

    })

  }
  
}
