import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListreservationsComponent } from './reservation/listreservations/listreservations.component';
import { AddreservationsComponent } from './reservation/addreservations/addreservations.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { HomeComponent } from './components/home/home.component';
import { DetailReservationsComponent } from './reservation/detail-reservations/detail-reservations.component';

@NgModule({
  declarations: [
    AppComponent,
    ListreservationsComponent,
    AddreservationsComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    DetailReservationsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
