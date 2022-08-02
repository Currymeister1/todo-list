import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class IssuerService {

  constructor(private http:HttpClient) { }
  BASE_URL:string = 'http://localhost:8080/issuers';

  getCreds(name: string, group: string): Observable<string>{
    let headers = new HttpHeaders().set('Content-Type', 'application/json');
    let params = new HttpParams().set("name",name).set("role", group)
    return this.http.get(this.BASE_URL, {headers: headers,params: params,responseType: 'text'})
  }

}
