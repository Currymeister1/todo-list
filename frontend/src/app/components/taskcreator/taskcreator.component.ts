import { Component, OnInit } from '@angular/core';
import {Task} from '../../dto/task'
@Component({
  selector: 'app-taskcreator',
  templateUrl: './taskcreator.component.html',
  styleUrls: ['./taskcreator.component.css']
})
export class TaskcreatorComponent implements OnInit {

  // @ts-ignore
  task: Task = {name: '',description:'',ended:null, started:null, issuer:'',category:'Slightly Important'}

  categories: string[] = ['Slightly Important', 'Important', 'Very Important']

  constructor() { }

  ngOnInit(): void {
  }

  logger():void{
    console.log(this.task)
  }

}
