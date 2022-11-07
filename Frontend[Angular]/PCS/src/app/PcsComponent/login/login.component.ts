import { analyzeAndValidateNgModules } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { logindetails } from 'src/app/logindetails';
import { LoginServiceService } from 'src/app/Service/login-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username:any
  password:any

  errorMessage:any

  constructor(private loginservice:LoginServiceService) { }

  ngOnInit(): void {
  }



  onSubmit(){
  let credentials={
    "username":this.username, 
    "password":this.password,
  }
  console.log(credentials);

  this.loginservice.doLogin(credentials).subscribe(data=>{

   let  loginDetails:logindetails = Object.assign(new logindetails(), data)
    this.loginservice.loginUser(loginDetails.token);
    this.loginservice.setUser(loginDetails)
    if(loginDetails.role== 'Hr'){
       window.location.href = '/hrdashboard';
    }
    else   if(loginDetails.role== 'Manager'){
      window.location.href = '/employerdashboard';
    }
    else 
    window.location.href = '/employeedashboard';
  

  },
  error=>{ 
    console.error(error);
    this.errorMessage="Invalid Login credentials"
  })

  }

}
