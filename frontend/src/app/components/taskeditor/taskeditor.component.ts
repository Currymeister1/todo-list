import { Component, OnInit } from '@angular/core';
import {Task} from "../../dto/task";
import {TaskService} from "../../service/task.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-taskeditor',
  templateUrl: './taskeditor.component.html',
  styleUrls: ['./taskeditor.component.css']
})
export class TaskeditorComponent implements OnInit {
  // @ts-ignore
  task: Task = {name: '', description:'',ended:null, started:null, issuer: JSON.parse(localStorage.getItem('issuer')).id ,category:'Slightly Important'}
  constructor(private route: ActivatedRoute, private _taskService: TaskService) { }

   categories: string[] = ['Slightly Important', 'Important', 'Very Important']

  ngOnInit(): void {
    this.fetchTaskById()
  }

  fetchTaskById(){
    let id = this.route.snapshot.paramMap.get('id')
    this._taskService.getTaskById(id).subscribe(data => this.task = data)

  }
  updateTask(){
    this._taskService.updateTask(this.task).subscribe( data => this.task )
  }

}
