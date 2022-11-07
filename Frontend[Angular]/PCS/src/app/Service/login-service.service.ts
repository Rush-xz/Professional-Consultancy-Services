import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { logindetails } from '../logindetails';

@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {

  constructor(private http:HttpClient) { }

  baseurl="http://localhost:8002"

  doLogin(credential:any){

    return this.http.post(`${this.baseurl}/token`,credential)

  }



  loginUser(token: string){
    localStorage.setItem("Token",token)
    return true;

  }

  islogedin(){
    let token=localStorage.getItem("Token");
    if(token==undefined  ||  token==null || token==''){
      return false;
    }
    else return true;
  }

  logout(){
    localStorage.removeItem("Token");
    localStorage.removeItem("username");
    return true;
  }

  getToken(){
    return localStorage.getItem("Token");
  }

  setUser(user:logindetails){
    localStorage.setItem("user",JSON.stringify(user))
    return true;
  }

  getUser(){
   
    let localitems=localStorage.getItem("user")||"";
    let user:logindetails =JSON.parse(localitems);
    return user
  }


 addSkills(skill:any,id:any){
   let data={
     "sdesc": skill.sdesc,
     "stitle": skill.cname, 
     "scategory": skill.scategory
   }
  return this.http.post(`${this.baseurl}/addskills/`+id,data)

 }

 addCertificate(certificate:any,id:any){
  let data={
      "cname" :certificate.stitle,
      "cexpiryDate":  certificate.cexpiryDate,
  }
console.log(data)
 return this.http.post(`${this.baseurl}/addcertificates/`+id, data)

}


}
