import { Component, OnInit } from '@angular/core';
import {Task} from '../../dto/task'
import {TaskService} from "../../service/task.service";
@Component({
  selector: 'app-taskcreator',
  templateUrl: './taskcreator.component.html',
  styleUrls: ['./taskcreator.component.css']
})
export class TaskcreatorComponent implements OnInit {

  // @ts-ignore
  task: Task = {name: '',description:'',ended:null, started:null, issuer:'',category:'Slightly Important'}

  categories: string[] = ['Slightly Important', 'Important', 'Very Important']

  constructor(private _taskService: TaskService) { }

  ngOnInit(): void {
  }

  saveTask():void{
    console.log(this.task)
    this._taskService.saveTask(this.task).subscribe();
  }

}
