import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavComponent } from './PcsComponent/nav/nav.component';
import { FooterComponent } from './PcsComponent/footer/footer.component';
import { HrDashboardComponent } from './PcsComponent/hr-dashboard/hr-dashboard.component';
import { EmployeeDashboardComponent } from './PcsComponent/employee-dashboard/employee-dashboard.component';
import { ErrorPageComponent } from './PcsComponent/error-page/error-page.component';
import { SkillsComponent } from './PcsComponent/skills/skills.component';
import { FormsModule } from '@angular/forms';
import { RichTextEditorModule } from '@syncfusion/ej2-angular-richtexteditor';
import { EditProfileComponent } from './PcsComponent/edit-profile/edit-profile.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { LoginServiceService } from './Service/login-service.service';
import { AuthGuard } from './Service/auth.guard';
import { AuthInterceptor } from './Service/auth.interceptor';
import { LoginComponent } from './PcsComponent/login/login.component';
import { RegisterComponent } from './PcsComponent/register/register.component';
import { HomeComponent } from './PcsComponent/home/home.component';
import { EmployerDashboardComponent } from './PcsComponent/employer-dashboard/employer-dashboard.component';
import { RegisterService } from './Service/register.service';
import { CertificateComponent } from './PcsComponent/certificate/certificate.component';
import { ProfileComponent } from './PcsComponent/profile/profile.component';
import { UserDetailsComponent } from './PcsComponent/user-details/user-details.component';

@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    FooterComponent,
    HrDashboardComponent,
    EmployeeDashboardComponent,
    ErrorPageComponent,
    SkillsComponent,
    EditProfileComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    EmployerDashboardComponent,
    CertificateComponent,
    ProfileComponent,
    UserDetailsComponent,
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    RichTextEditorModule,
    HttpClientModule,
  ],
  providers: [LoginServiceService,AuthGuard,RegisterService, UserDetailsComponent, [{provide:HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi:true}] ],
  bootstrap: [AppComponent]
})
export class AppModule { }
