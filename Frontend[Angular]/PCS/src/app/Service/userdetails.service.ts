import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserdetailsService {

  constructor(private http:HttpClient) { }
  
  baseurl="http://localhost:8002"

  
  getDetails(id:any):Observable<any>{
    return this.http.get(`${this.baseurl}/getemployees/`+id);
  }

  getallEmployee():Observable<any>{
    return this.http.get(`${this.baseurl}/employees`);
  }

  getnoEmployee():Observable<any>{
    return this.http.get(`${this.baseurl}/total-employees`);
  }

  getnocerti():Observable<any>{
    return this.http.get(`${this.baseurl}/total-certificates`);
  }

  getnoskill():Observable<any>{
    return this.http.get(`${this.baseurl}/total-skills`);
  }

  deleteEmp(id:any){
    return this.http.delete(`${this.baseurl}/delete/employees/`+id);
  }



  updateUser(data:any){
     
    return this.http.put(`${this.baseurl}/employees/`+data.id,data);

  }

  userSearch(data:any){
     
    return this.http.get(`${this.baseurl}/employees/`,data);

  }




}
