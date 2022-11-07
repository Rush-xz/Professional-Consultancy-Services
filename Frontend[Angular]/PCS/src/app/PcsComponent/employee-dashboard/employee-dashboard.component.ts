import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { logindetails } from 'src/app/logindetails';
import { LoginServiceService } from 'src/app/Service/login-service.service';
import { UserdetailsService } from 'src/app/Service/userdetails.service';

@Component({
  selector: 'app-employee-dashboard',
  templateUrl: './employee-dashboard.component.html',
  styleUrls: ['./employee-dashboard.component.css']
})
export class EmployeeDashboardComponent implements OnInit {
  UserDetails:any={};
  user: logindetails = new logindetails; 
  image="/assets/profile.jpg";
  constructor(private userdetailservice:UserdetailsService,private loginservice:LoginServiceService,private router: Router) { }

  ngOnInit(): void {
    this.user = this.loginservice.getUser();
    this.getDetails();
  }


  getDetails(){
     
    this.userdetailservice.getDetails(this.user.id).subscribe(data=>{
      this.UserDetails=data;
      console.log(this.UserDetails)

    },
    error=>{
      console.log("Something went Wrong")

    }
    )
  }

  
  onDelete() {
    this.userdetailservice.deleteEmp(this.user.id).subscribe(data => {
      this.loginservice.logout();
      location.reload();
    });

   
    this.router.navigate(['/home'])

  }





}
