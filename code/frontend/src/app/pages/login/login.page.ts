import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ApiService } from 'src/app/services/api/api.service';
import { GlobalStorageService } from 'src/app/services/global-storage/global-storage.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.page.html',
  styleUrls: ['./login.page.scss'],
})
export class LoginPage implements OnInit {
  
  private email: string;
  private senha: string;

  constructor(private route: Router, private api : ApiService, private globalStorage : GlobalStorageService) { }

  ngOnInit() {
    //caso seja um logout devo limpar as variaveis 
    this.eraseGlobalVars();
    //this.email = 'ana@mail.com';
    //this.senha = '123';
  }

  goHome(){
    this.route.navigate(['/home']);
  }

  login() {  
        
    console.log('Email: ' + this.email + ' - Senha: ' + this.senha);
    this.api.loginSimples(this.email, this.senha).subscribe(data =>{                       
      
      if (data['sucesso'] == true) {        
        this.globalStorage.userId = data['objeto'].id;
        this.globalStorage.userName = data['objeto'].nome;
        this.globalStorage.userEmail = data['objeto'].email;
        this.route.navigate(['/home']);                      

      } else {        
        console.log('Login failed');
        console.log('Result: ' + data);
        // redirect to home page
        // show reason message of error         
      }

    })
  }
   
  eraseGlobalVars() {
    this.globalStorage.userId = '';
    this.globalStorage.userName = '';
    this.globalStorage.userEmail = '';
  }

}



