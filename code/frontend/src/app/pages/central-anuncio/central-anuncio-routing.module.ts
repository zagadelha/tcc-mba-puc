import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { CentralAnuncioPage } from './central-anuncio.page';

const routes: Routes = [
  {
    path: '',
    component: CentralAnuncioPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class CentralAnuncioPageRoutingModule {}
