import { Component, OnInit } from '@angular/core';
import {Issuer} from "../../dto/issuer";
import {IssuerService} from "../../service/issuer.service";

@Component({
  selector: 'app-registeration',
  templateUrl: './registeration.component.html',
  styleUrls: ['./registeration.component.css']
})
export class RegisterationComponent implements OnInit {

  issuer: Issuer = {"id":'',"name":'',"role": ''}
  constructor(private _issuerService:IssuerService) { }

  ngOnInit(): void {
  }

  registerIssuer(){
    this._issuerService.registerIssuer(this.issuer).subscribe()
  }

}
