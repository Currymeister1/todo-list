import { Component, OnInit } from '@angular/core';
import {Task} from '../../dto/task';
import {TaskService} from "../../service/task.service";


@Component({
  selector: 'app-tasks',
  templateUrl: './tasks.component.html',
  styleUrls: ['./tasks.component.css']
})
export class TasksComponent implements OnInit {
   public tasks: Task[] = []

  constructor(private _taskService: TaskService) { }

  ngOnInit(): void {
     this._taskService.getTasks().subscribe(data => this.tasks = data);
     console.log(this.tasks)
  }

}
