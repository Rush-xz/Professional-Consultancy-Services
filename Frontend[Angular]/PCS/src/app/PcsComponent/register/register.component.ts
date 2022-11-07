import { Component, OnInit } from '@angular/core';
import { Certificates } from 'src/app/Model/Certificates';
import { Employee } from 'src/app/Model/Employee';
import { Skills } from 'src/app/Model/Skills';
import { LoginServiceService } from 'src/app/Service/login-service.service';
import { RegisterService } from 'src/app/Service/register.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  employee: Employee = new Employee;
  skill: Skills = new Skills;
  certificate: Certificates = new Certificates;
  message: any={};

  islogedin = false;

  constructor(private registerservice: RegisterService, private loginservice: LoginServiceService) { }

  ngOnInit(): void {

    this.islogedin = this.loginservice.islogedin();

  }

  onSubmit() {
    if (this.employee != null && this.skill != null && this.certificate != null) {
      this.registerservice.doLogin(this.employee, this.skill, this.certificate).subscribe(data => {
         console.log(data);
        this.message = data;

      }
        , error => {
        
        }
      )
    }
    else {
      alert("Every Fields are mandatory");
    }
  }
}
