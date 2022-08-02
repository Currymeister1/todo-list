import { Component, OnInit } from '@angular/core';
import {IssuerService} from "../../service/issuer.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  name: string =''
  group: string =''
  id: String = ''
  showError: boolean = false
  constructor(private _issuerService:IssuerService,private router: Router) { }

  ngOnInit(): void {
  }

  login(){
    this._issuerService.getCreds(this.name, this.group).subscribe(id =>
      {this.id = id;
       if(id){
         // @ts-ignore
         localStorage.setItem('token',this.id);
         this.router.navigate(['task']);
         this.showError = false;
       }
      }, error => {this.showError = true}
    )



  }


}
