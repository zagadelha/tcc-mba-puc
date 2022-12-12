import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/app/services/api/api.service';
import { GlobalStorageService } from 'src/app/services/global-storage/global-storage.service';

@Component({
  selector: 'app-conta',
  templateUrl: './conta.page.html',
  styleUrls: ['./conta.page.scss'],
})
export class ContaPage implements OnInit {

  private nome: string;
  private email: string;
  private senha: string;
  
  constructor(private api: ApiService, private globalStorage: GlobalStorageService) { }

  ngOnInit() {
    this.obterDados();
  }

  obterDados() {  
          
    console.log('Logged ID: ' + this.globalStorage.userId);

    this.api.obterUsuario(this.globalStorage.userId).subscribe(data =>{                       

      console.log('Return data: ' + JSON.stringify(data));
      
      if (data['sucesso'] == true) {        
        this.nome = this.globalStorage.userName;
        this.email = this.globalStorage.userEmail;                
        //this.route.navigate(['/home']);                      

      } else {        
        console.log('Login failed');
        console.log('Result: ' + JSON.stringify(data));
        // redirect to home page
        // show reason message of error         
      }

    })
  }

}