import { Component, OnInit } from '@angular/core';
import {Task} from "../../dto/task";
import {ActivatedRoute, Router} from "@angular/router";
import {TaskService} from "../../service/task.service";

@Component({
  selector: 'app-task-display',
  templateUrl: './task-display.component.html',
  styleUrls: ['./task-display.component.css']
})
export class TaskDisplayComponent implements OnInit {
  id: string | null = ''
  // @ts-ignore
  task: Task = {name: '',description:'',ended:null, started:null, issuer:'',category:'Slightly Important'}
  constructor(private route: ActivatedRoute, private _taskService: TaskService, private _router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id')
    this._taskService.getTaskById(this.id).subscribe(data => this.task = data)
  }



}
