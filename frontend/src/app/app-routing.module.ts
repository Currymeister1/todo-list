import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import {TasksComponent} from "./components/tasks/tasks.component";
import {TaskeditorComponent} from "./components/taskeditor/taskeditor.component";
import {TaskcreatorComponent} from "./components/taskcreator/taskcreator.component";
import {TaskDisplayComponent} from "./components/task-display/task-display.component";
import {LoginComponent} from "./components/login/login.component";
import {AuthGuard} from "./service/auth.guard";

const routes: Routes = [
    {path: '', redirectTo:'task', pathMatch:'full'},
    {path: 'task', component: TasksComponent, canActivate:[AuthGuard]},
    {path: 'task/edit/:id', component: TaskeditorComponent, canActivate:[AuthGuard]},
    {path: 'task/create', component: TaskcreatorComponent, canActivate:[AuthGuard]},
    {path: 'task/display/:id', component: TaskDisplayComponent, canActivate:[AuthGuard]},
    {path: 'login', component: LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
