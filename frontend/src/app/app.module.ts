import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TasksComponent } from './components/tasks/tasks.component';
import { HeaderComponent } from './components/header/header.component';
import { TaskeditorComponent } from './components/taskeditor/taskeditor.component';
import { TaskcreatorComponent } from './components/taskcreator/taskcreator.component';
import { TaskDisplayComponent } from './components/task-display/task-display.component';
import { LoginComponent } from './components/login/login.component';
import { IssuerComponent } from './components/issuer/issuer.component';
import { RegisterationComponent } from './components/registeration/registeration.component';

@NgModule({
  declarations: [
    AppComponent,
    TasksComponent,
    HeaderComponent,
    TaskeditorComponent,
    TaskcreatorComponent,
    TaskDisplayComponent,
    LoginComponent,
    IssuerComponent,
    RegisterationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
