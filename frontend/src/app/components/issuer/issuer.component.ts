import { Component, OnInit } from '@angular/core';
import {IssuerService} from "../../service/issuer.service";
import {Issuer} from "../../dto/issuer";

@Component({
  selector: 'app-issuer',
  templateUrl: './issuer.component.html',
  styleUrls: ['./issuer.component.css']
})
export class IssuerComponent implements OnInit {
  issuer: Issuer = {id:'',"name":'', "role":''}

  constructor(private _issuerService:IssuerService) { }

  ngOnInit(): void {
    this.getIssuer();
  }

  getIssuer(){
    // @ts-ignore
    this.issuer = JSON.parse(localStorage.getItem('issuer'))
  }
}
