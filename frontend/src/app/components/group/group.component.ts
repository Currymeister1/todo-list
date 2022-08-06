import { Component, OnInit } from '@angular/core';
import {IssuerService} from "../../service/issuer.service";
import {Issuer} from "../../dto/issuer";

@Component({
  selector: 'app-group',
  templateUrl: './group.component.html',
  styleUrls: ['./group.component.css']
})
export class GroupComponent implements OnInit {

  issuers: Issuer[] = []
  constructor(private _issuerService:IssuerService) { }

  ngOnInit(): void {
    this.getGroup();
  }


  getGroup(){
    // @ts-ignore
    let groupName = JSON.parse(localStorage.getItem('issuer')).role

    this._issuerService.getGroup(groupName).subscribe(data => this.issuers = data);

  }
}
