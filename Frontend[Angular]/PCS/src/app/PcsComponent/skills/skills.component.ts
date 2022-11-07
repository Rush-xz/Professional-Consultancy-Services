import { formatDate } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ToolbarService, LinkService, ImageService, HtmlEditorService, TableService } from '@syncfusion/ej2-angular-richtexteditor';
import { logindetails } from 'src/app/logindetails';
import { Skills } from 'src/app/Model/Skills';
import { LoginServiceService } from 'src/app/Service/login-service.service';



@Component({
  selector: 'app-skills',
  templateUrl: './skills.component.html',
  styleUrls: ['./skills.component.css'],
  providers: [ToolbarService, LinkService, ImageService, HtmlEditorService, TableService]
})
export class SkillsComponent implements OnInit {

  skill: Skills = new Skills;
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
    this.skill.sdesc=''
  }
  onsubmit(){
    
    console.log(this.skill)

    this.loginservice.addSkills(this.skill,this.user.id).subscribe(data=>{
      alert("Skill Added Successfully")
    })

  }

}
