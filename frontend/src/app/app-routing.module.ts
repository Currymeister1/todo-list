import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import {TasksComponent} from "./components/tasks/tasks.component";
import {TaskeditorComponent} from "./components/taskeditor/taskeditor.component";
import {TaskcreatorComponent} from "./components/taskcreator/taskcreator.component";
import {TaskDisplayComponent} from "./components/task-display/task-display.component";

const routes: Routes = [
    {path: '', redirectTo:'task', pathMatch:'full'},
    {path: 'task', component: TasksComponent},
    {path: 'task/edit/:id', component: TaskeditorComponent},
    {path: 'task/create', component: TaskcreatorComponent},
    {path: 'task/display/:id', component: TaskDisplayComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
