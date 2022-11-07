import { Component, OnInit } from '@angular/core';
import { ToolbarService, LinkService, ImageService, HtmlEditorService, TableService } from '@syncfusion/ej2-angular-richtexteditor';
import { logindetails } from 'src/app/logindetails';
import { Certificates } from 'src/app/Model/Certificates';
import { LoginServiceService } from 'src/app/Service/login-service.service';



@Component({
  selector: 'app-certificate',
  templateUrl: './certificate.component.html',
  styleUrls: ['./certificate.component.css'],
  providers: [ToolbarService, LinkService, ImageService, HtmlEditorService, TableService]
})
export class CertificateComponent implements OnInit {

   certificate: Certificates = new Certificates;
   user: logindetails = new logindetails; 

  public tools: object = {
    items: [
           'Bold', 'Italic', 'Underline', 'StrikeThrough', '|',
           'FontName', 'FontSize', 'FontColor', 'BackgroundColor', '|',
           'LowerCase', 'UpperCase', '|', 'Undo', 'Redo', '|',
           'Formats', 'Alignments', '|', 'OrderedList', 'UnorderedList', '|',
           'Indent', 'Outdent', '|', 'CreateLink','CreateTable',
           'Image', '|', 'ClearFormat', 'Print', 'SourceCode', '|', 'FullScreen']
   };

  constructor(private loginservice:LoginServiceService) { }

  ngOnInit(): void {
    this.user = this.loginservice.getUser();
  }

 onSubmit(){
   this.loginservice.addCertificate(this.certificate,this.user.id).subscribe(data=>{
     alert("Certificate Added Successfully")
   })
  
  console.log(this.certificate)
  console.log(this.user.id)


 }

}
