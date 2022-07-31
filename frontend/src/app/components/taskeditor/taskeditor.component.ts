import { Component, OnInit } from '@angular/core';
import {Task} from "../../dto/task";

@Component({
  selector: 'app-taskeditor',
  templateUrl: './taskeditor.component.html',
  styleUrls: ['./taskeditor.component.css']
})
export class TaskeditorComponent implements OnInit {
  // @ts-ignore
  task: Task = {name: '',description:'',ended:null, started:null, issuer:'',category:'Slightly Important'}
  constructor() { }

  ngOnInit(): void {
  }

}
