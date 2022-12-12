import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { GlobalStorageService } from './services/global-storage/global-storage.service';

@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.scss'],
})
export class AppComponent {
  public appPages = [    
    { title: 'Conta',  url: 'conta', icon: 'person' },
    { title: 'Relatórios', url: 'relatorios', icon: 'podium' },
    { title: 'Loja', url: 'loja', icon: 'cart' },
    { title: 'Central de Anúncio', url: 'central-anuncio', icon: 'megaphone' },
    { title: 'Sair', url: '/login', icon: 'exit' },
  ];  

  constructor(private route: Router, private globalStorage: GlobalStorageService) {}

  nextpage() {    
    this.route.navigate(['/login']);    
  }

  

}


