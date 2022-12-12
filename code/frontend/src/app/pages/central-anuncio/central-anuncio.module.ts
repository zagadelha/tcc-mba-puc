import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { CentralAnuncioPageRoutingModule } from './central-anuncio-routing.module';

import { CentralAnuncioPage } from './central-anuncio.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    CentralAnuncioPageRoutingModule
  ],
  declarations: [CentralAnuncioPage]
})
export class CentralAnuncioPageModule {}
