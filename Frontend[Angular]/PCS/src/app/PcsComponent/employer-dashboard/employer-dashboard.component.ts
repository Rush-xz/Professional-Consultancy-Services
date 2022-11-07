import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Skills } from 'src/app/Model/Skills';
import { UserdetailsService } from 'src/app/Service/userdetails.service';
import { UserDetailsComponent } from '../user-details/user-details.component';

@Component({
  selector: 'app-employer-dashboard',
  templateUrl: './employer-dashboard.component.html',
  styleUrls: ['./employer-dashboard.component.css']
})
export class EmployerDashboardComponent implements OnInit {

  skills: any = [];
  skillsname: any = ""
  search: any;

  constructor(private userdetailservice: UserdetailsService, private user: UserDetailsComponent, private route: Router) { }

  ngOnInit(): void {
    this.getDetails();
  }

  employeedetails: any

  getDetails() {

    this.userdetailservice.getallEmployee().subscribe(data => {
      this.employeedetails = data
      console.log(this.employeedetails);
      for (let i = 0; i < this.employeedetails.length; i++) {
        for (let j = 0; j < this.employeedetails[i].skills.length; j++) {
          this.skillsname += this.employeedetails[i].skills[j].stitle + ', ';
        }
        this.skills.push(this.skillsname);
        this.skillsname = "";
      }
      console.log(data);
    },
      error => {
        console.log(error);
      }
    )
  }


  showDetails(employee: any) {
    let id = employee.id
    this.route.navigate(['/user'], { queryParams: { id } });
    console.log(employee.id)
  }

  onSearch() {

    
    this.userdetailservice.userSearch(this.search).subscribe(data=>{


    }
    )

    console.log(this.search)
  }



}
