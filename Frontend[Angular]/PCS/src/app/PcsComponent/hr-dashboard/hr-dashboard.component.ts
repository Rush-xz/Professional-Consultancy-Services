import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserdetailsService } from 'src/app/Service/userdetails.service';
import { UserDetailsComponent } from '../user-details/user-details.component';

@Component({
  selector: 'app-hr-dashboard',
  templateUrl: './hr-dashboard.component.html',
  styleUrls: ['./hr-dashboard.component.css']
})
export class HrDashboardComponent implements OnInit {

  noofcerti: any
  noofemp: any
  nofskill: any
  skills: any =[] ;
  skillsname:any=""

  constructor(private userdetailservice: UserdetailsService, private user: UserDetailsComponent, private route: Router
  ) { }

  ngOnInit(): void {
    this.getDetails();
    this.getNumber()


  }

  employeedetails: any = [{}]

  getDetails() {

    this.userdetailservice.getallEmployee().subscribe(data => {
      this.employeedetails = data
      console.log(  this.employeedetails);
      for (let i=0;i<this.employeedetails.length;i++) {
        for(let j=0;j<this.employeedetails[i].skills.length;j++){
          this.skillsname += this.employeedetails[i].skills[j].stitle+', ';
        }
        this.skills.push(this.skillsname);
        this.skillsname="";
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

    console.log(employee.id);


  }


  getNumber() {
    this.userdetailservice.getnoEmployee().subscribe(data => {
      this.noofemp = data;
    })

    this.userdetailservice.getnocerti().subscribe(data => {
      this.noofcerti = data;
    })
    this.userdetailservice.getnoskill().subscribe(data => {
      this.nofskill = data;
    })


  }




}
