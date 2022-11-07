import { formatDate } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  constructor(private http:HttpClient) { }
  
  baseurl="http://localhost:8002"

  doLogin(employee:any,skills:any,certificate:any){

    
    let date=new Date(); 
    const registerdetails={
      "name": employee.name,
      "email":employee.email,
      "password":employee.password,
      "role":employee.role,
      "bio":employee.bio,
      "registerDate":formatDate(date, 'yyyy-MM-dd', 'en-US'),
      "isActive":1,
      "skills":[
          {
              "stitle":skills.cname,
              "scategory":skills.scategory,
              "sdesc":skills.sdesc
          }
      ],
      "certificates":[
          {
              "cname":certificate.stitle,
              "cexpiryDate":certificate.cexpiryDate
          }
      ]
  
    }

    return this.http.post(`${this.baseurl}/register`,registerdetails)

  }


}
