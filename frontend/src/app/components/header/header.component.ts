import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {TaskService} from "../../service/task.service";
import {IssuerService} from "../../service/issuer.service";
import {Issuer} from "../../dto/issuer";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  issuers: Issuer[] = []
  // @ts-ignore
  group: string = JSON.parse(localStorage.getItem('issuer')).role
  constructor(private _router:Router) { }

  ngOnInit(): void {
  }

  logout(){
    localStorage.clear()
    this._router.navigate(["login"])
  }



}
