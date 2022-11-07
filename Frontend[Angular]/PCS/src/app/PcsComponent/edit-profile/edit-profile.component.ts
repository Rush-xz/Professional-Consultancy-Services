import { Component, OnInit } from '@angular/core';
import { ToolbarService, LinkService, ImageService, HtmlEditorService, TableService } from '@syncfusion/ej2-angular-richtexteditor';
import { logindetails } from 'src/app/logindetails';
import { LoginServiceService } from 'src/app/Service/login-service.service';
import { UserdetailsService } from 'src/app/Service/userdetails.service';


@Component({
  selector: 'app-edit-profile',
  templateUrl: './edit-profile.component.html',
  styleUrls: ['./edit-profile.component.css'],
  providers: [ToolbarService, LinkService, ImageService, HtmlEditorService, TableService]
})
export class EditProfileComponent implements OnInit {

  public tools: object = {
    items: [
      'Bold', 'Italic', 'Underline', 'StrikeThrough', '|',
      'FontName', 'FontSize', 'FontColor', 'BackgroundColor', '|',
      'LowerCase', 'UpperCase', '|', 'Undo', 'Redo', '|',
      'Formats', 'Alignments', '|', 'OrderedList', 'UnorderedList', '|',
      'Indent', 'Outdent', '|', 'CreateLink', 'CreateTable',
      'Image', '|', 'ClearFormat', 'Print', 'SourceCode', '|', 'FullScreen']
  };

  UserDetails: any = {};
  user: logindetails = new logindetails;

  image = "/assets/profile.jpg";
  password: any;
  conpassword: any


  constructor(private loginservice: LoginServiceService, private userdetailservice: UserdetailsService) { }

  ngOnInit(): void {
    this.user = this.loginservice.getUser();
    this.getDetails();
  }
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

  changePassword() {
    if (this.conpassword != this.password || this.password == null) {
      alert("Enter Correct password")
    }
    else {
      console.log(this.UserDetails)

      let data={
        "id":this.UserDetails.id,
        "name": this.UserDetails.name, 
        "password": this.password, 
        "bio":this.UserDetails.bio
      }

      console.log(data);

      this.userdetailservice.updateUser(data).subscribe(data=>{
        location.reload();
        console.log(data);
      })


    }
    console.log("Shailesh")
  }





}
