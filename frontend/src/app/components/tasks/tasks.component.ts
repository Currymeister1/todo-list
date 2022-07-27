import { Component, OnInit } from '@angular/core';
import {Task} from '../../dto/task';


@Component({
  selector: 'app-tasks',
  templateUrl: './tasks.component.html',
  styleUrls: ['./tasks.component.css']
})
export class TasksComponent implements OnInit {
    tasks: Task[] =[
      {name: 'Cleaning',
      description: 'Household chore',
      end: new Date('2020-12-12'),
      issuer: 'Mark',
      category: 'Important'},
      
      {name: 'house',
      description: 'Household chore',
      end: new Date('2020-12-12'),
      issuer: 'Mark',
      category: 'Important'}
  ]

  constructor() { }
  
  ngOnInit(): void {
  }

}
