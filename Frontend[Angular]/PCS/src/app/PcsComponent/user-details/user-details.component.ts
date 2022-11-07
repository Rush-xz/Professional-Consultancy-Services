import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserdetailsService } from 'src/app/Service/userdetails.service';

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.css']
})
export class UserDetailsComponent implements OnInit {
  image="/assets/profile.jpg";
  
  UserDetails:any={};
  id:any
  constructor(private route:ActivatedRoute,private userdetailservice:UserdetailsService,private router:Router) { }

  ngOnInit(): void {
    this.route.queryParams.subscribe(param =>{
      this.id = param;
      console.log(this.id.id);
      this.getDetails(this.id.id)
   }
     )

  }

  getDetails(id:any){
     
    this.userdetailservice.getDetails(id).subscribe(data=>{
      this.UserDetails=data;
      console.log(this.UserDetails)

    },
    error=>{
      console.log("Something went Wrong")

    }
    )
  }

onDelete(){
  this.userdetailservice.deleteEmp(this.id.id).subscribe(data=>{
    this.router.navigate(['/home'])
    console.log(data);
  });
}
}
