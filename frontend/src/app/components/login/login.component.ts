import { Component, OnInit } from '@angular/core';
import {IssuerService} from "../../service/issuer.service";
import {Router} from "@angular/router";
import {Issuer} from "../../dto/issuer";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  issuer: Issuer = {'id':'','name':'','role':''}
  name:string=''
  group:string=''
  showError: boolean = false
  constructor(private _issuerService:IssuerService,private router: Router) { }

  ngOnInit(): void {
  }

  login(){
    this._issuerService.getCreds(this.name, this.group).subscribe(data =>
      {this.issuer = data;
       if(data){
         // @ts-ignore
         localStorage.setItem('issuer',JSON.stringify(this.issuer));
         this.router.navigate(['task']);
         this.showError = false;
       }
      }, error => {this.showError = true}
    )



  }


}
