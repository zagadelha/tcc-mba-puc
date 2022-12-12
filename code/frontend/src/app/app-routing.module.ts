import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'login',
    pathMatch: 'full'
  },
  /**
  {
    path: 'folder/:id',
    loadChildren: () => import('./folder/folder.module').then( m => m.FolderPageModule)
  },  **/
  {
    path: 'login',
    loadChildren: () => import('./pages/login/login.module').then( m => m.LoginPageModule)
  },
  {
    path: 'cadastro',
    loadChildren: () => import('./pages/cadastro/cadastro.module').then( m => m.CadastroPageModule)
  },
  {
    path: 'recuperar-senha',
    loadChildren: () => import('./pages/recuperar-senha/recuperar-senha.module').then( m => m.RecuperarSenhaPageModule)
  },
  {
    path: 'home',
    loadChildren: () => import('./pages/home/home.module').then( m => m.HomePageModule)
  },
  {
    path: 'conta',
    loadChildren: () => import('./pages/conta/conta.module').then( m => m.ContaPageModule)
  },
  {
    path: 'relatorios',
    loadChildren: () => import('./pages/relatorios/relatorios.module').then( m => m.RelatoriosPageModule)
  },
  {
    path: 'loja',
    loadChildren: () => import('./pages/loja/loja.module').then( m => m.LojaPageModule)
  },
  {
    path: 'central-anuncio',
    loadChildren: () => import('./pages/central-anuncio/central-anuncio.module').then( m => m.CentralAnuncioPageModule)
  },
  {
    path: 'cadastro-pet',
    loadChildren: () => import('./pages/cadastro-pet/cadastro-pet.module').then( m => m.CadastroPetPageModule)
  }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {}
