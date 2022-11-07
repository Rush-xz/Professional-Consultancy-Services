import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CertificateComponent } from './PcsComponent/certificate/certificate.component';
import { EditProfileComponent } from './PcsComponent/edit-profile/edit-profile.component';
import { EmployeeDashboardComponent } from './PcsComponent/employee-dashboard/employee-dashboard.component';
import { EmployerDashboardComponent } from './PcsComponent/employer-dashboard/employer-dashboard.component';
import { ErrorPageComponent } from './PcsComponent/error-page/error-page.component';
import { HomeComponent } from './PcsComponent/home/home.component';
import { HrDashboardComponent } from './PcsComponent/hr-dashboard/hr-dashboard.component';
import { LoginComponent } from './PcsComponent/login/login.component';
import { ProfileComponent } from './PcsComponent/profile/profile.component';
import { RegisterComponent } from './PcsComponent/register/register.component';
import { SkillsComponent } from './PcsComponent/skills/skills.component';
import { UserDetailsComponent } from './PcsComponent/user-details/user-details.component';
import { AuthGuard } from './Service/auth.guard';

const routes: Routes = [
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  { path: 'home',              component: HomeComponent  },
  { path: 'register',          component: RegisterComponent },
  { path: 'hrdashboard',       component:HrDashboardComponent, pathMatch: 'full', canActivate:[AuthGuard]  },
  { path: 'certificate',       component:CertificateComponent, pathMatch: 'full', canActivate:[AuthGuard]  },
  { path: 'employerdashboard', component:EmployerDashboardComponent, pathMatch: 'full', canActivate:[AuthGuard]  },
  { path: 'employeedashboard', component: EmployeeDashboardComponent ,pathMatch: 'full', canActivate:[AuthGuard]   },
  { path: 'add-skills',        component: SkillsComponent,pathMatch: 'full', canActivate:[AuthGuard]   },
  { path: 'edit-profile',      component: EditProfileComponent,pathMatch: 'full', canActivate:[AuthGuard]   },
  { path: 'profile',      component:ProfileComponent,pathMatch: 'full', canActivate:[AuthGuard]   },
  { path: 'user',      component:UserDetailsComponent,pathMatch: 'full', canActivate:[AuthGuard]   },
  { path: 'login',             component: LoginComponent  },
  
  //{ path: '**', component:ErrorPageComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
