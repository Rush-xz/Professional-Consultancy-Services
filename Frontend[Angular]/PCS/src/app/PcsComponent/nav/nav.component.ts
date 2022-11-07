import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { logindetails } from 'src/app/logindetails';
import { LoginServiceService } from 'src/app/Service/login-service.service';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {
  step:any
  constructor(private loginservice:LoginServiceService,private router:Router ) { }
  
  
  islogedin=false;
  user: logindetails = new logindetails; 

  ngOnInit(): void {
    this.islogedin=this.loginservice.islogedin();
    this.user = this.loginservice.getUser();
  }

  logout(){
    this.loginservice.logout();
    location.reload();
     
  }

}
