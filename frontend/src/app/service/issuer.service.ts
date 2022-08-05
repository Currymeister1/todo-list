import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {Issuer} from "../dto/issuer";

@Injectable({
  providedIn: 'root'
})
export class IssuerService {

  constructor(private http:HttpClient) { }
  httpOptions = {headers: new HttpHeaders({'Content-Type': 'application/json'})};
  BASE_URL:string = 'http://localhost:8080/issuers';

  getCreds(name: string, group: string): Observable<Issuer>{
    let headers = new HttpHeaders().set('Content-Type', 'application/json');
    let params = new HttpParams().set("name",name).set("role", group)
    return this.http.get<Issuer>(this.BASE_URL, {headers: headers,params: params})
  }


  registerIssuer(issuer:Issuer){
    return this.http.post<Issuer>(this.BASE_URL,issuer,this.httpOptions);
  }
}
