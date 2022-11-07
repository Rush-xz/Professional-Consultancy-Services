import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { logindetails } from 'src/app/logindetails';
import { LoginServiceService } from 'src/app/Service/login-service.service';
import { UserdetailsService } from 'src/app/Service/userdetails.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  user: logindetails = new logindetails;

  image = "/assets/profile.jpg";
  constructor(private loginservice: LoginServiceService, private userdetailservice: UserdetailsService, private router: Router) { }

  ngOnInit(): void {
    this.user = this.loginservice.getUser();
    this.getDetails();
  }

  UserDetails: any = {};

  getDetails() {

    this.userdetailservice.getDetails(this.user.id).subscribe(data => {
      this.UserDetails = data;
      console.log(this.UserDetails)

    },
      error => {
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
