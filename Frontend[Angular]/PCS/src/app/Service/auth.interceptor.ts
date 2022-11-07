import { HttpEvent, HttpHandler, HttpHeaders, HttpInterceptor, HttpRequest } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { LoginServiceService } from "./login-service.service";

@Injectable()
export class AuthInterceptor implements HttpInterceptor{

    constructor(private loginservice:LoginServiceService){

    }

    intercept(req: HttpRequest<any>, next: HttpHandler){

        let newreq=req
        let token=this.loginservice.getToken(); 
        
        if(token !=null){
       
       newreq=newreq.clone({setHeaders:{Authorization:`Bearer ${token}` }   })
  //            newreq = newreq.clone({
  //          headers: new HttpHeaders({
  //           'Access-Control-Allow-Origin': 'http://localhost:4200/',
  //            'Authorization': `Bearer ${token}`,
  //            'Access-Control-Allow-Methods': 'GET, POST, PUT, DELETE'
  //   })
  // });


        }

        return next.handle(newreq);

    }
    
}