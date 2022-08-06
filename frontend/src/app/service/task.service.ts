import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";

import {Task} from "../dto/task";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  constructor(private http:HttpClient) { }

  httpOptions = {headers: new HttpHeaders({'Content-Type': 'application/json'})};
  BASE_URL:string = 'http://localhost:8080/tasks';

  getTasks(groupName:string): Observable<Task[]>{
    return this.http.get<Task[]>(this.BASE_URL+`/group/${groupName}`);
  }

  saveTask(task: Task): Observable<Task>{
    return this.http.post<Task>(this.BASE_URL,task,this.httpOptions)
  }

  getTaskById(id: string | null): Observable<Task>{
    return this.http.get<Task>(this.BASE_URL+`/${id}`);
  }

  deleteTaskById(id: number | undefined): Observable<Task>{
    return this.http.delete<Task>(this.BASE_URL+`/${id}`)
  }

  updateTask(task: Task): Observable<Task>{
    return this.http.put<Task>(this.BASE_URL,task,this.httpOptions)
  }
}
