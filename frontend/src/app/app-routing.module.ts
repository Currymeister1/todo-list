import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import {TasksComponent} from "./components/tasks/tasks.component";
import {TaskeditorComponent} from "./components/taskeditor/taskeditor.component";
import {TaskcreatorComponent} from "./components/taskcreator/taskcreator.component";

const routes: Routes = [
    {path: '', redirectTo:'task', pathMatch:'full'},
    {path: 'task', component: TasksComponent},
    {path: 'task/edit/:id', component: TaskeditorComponent},
    {path: 'task/create', component: TaskcreatorComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
