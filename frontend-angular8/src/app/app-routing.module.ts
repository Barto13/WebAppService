import { EmployeeDetailsComponent } from './employee-details/employee-details.component';
import { CreateEmployeeComponent } from './create-employee/create-employee.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { UpdateEmployeeComponent } from './update-employee/update-employee.component';
import { ProductListComponent } from './product-list/product-list.component';
import { CreateProductComponent } from './create-product/create-product.component';
import { UpdateProductComponent } from './update-product/update-product.component';
import { ProductDetailsComponent } from './product-details/product-details.component';
import { UserListComponent } from './user-list/user-list.component';
import { CreateUserComponent } from './create-user/create-user.component';
import { UpdateUserComponent } from './update-user/update-user.component';
import { UserDetailsComponent } from './user-details/user-details.component';
import { ServiceListComponent } from './service-list/service-list.component';
import { CreateServiceComponent } from './create-service/create-service.component';
import { UpdateServiceComponent } from './update-service/update-service.component';
import { ServiceDetailsComponent } from './service-details/service-details.component';

import { LoginComponent } from './login/login.component';
import { AuthGuardService } from './service/auth-guard.service';
import { PayuComponent } from './payu/payu.component';
import { PaymentComponent } from './payment/payment.component';
import { RegisterComponent } from './register/register.component';

const routes: Routes = [
  // { path: '', redirectTo: 'employee', pathMatch: 'full' },
  { path: 'employees', component: EmployeeListComponent,canActivate:[AuthGuardService] },
  { path: 'add', component: CreateEmployeeComponent,canActivate:[AuthGuardService] },
  { path: 'update/:id', component: UpdateEmployeeComponent,canActivate:[AuthGuardService] },
  { path: 'details/:id', component: EmployeeDetailsComponent,canActivate:[AuthGuardService] },
  
  { path: 'products', component: ProductListComponent,canActivate:[AuthGuardService] },
  { path: 'P-add', component: CreateProductComponent,canActivate:[AuthGuardService] },
  { path: 'P-update/:id', component: UpdateProductComponent,canActivate:[AuthGuardService] },
  { path: 'P-details/:id', component: ProductDetailsComponent,canActivate:[AuthGuardService] },

  { path: 'users', component: UserListComponent,canActivate:[AuthGuardService] },
  { path: 'U-add', component: CreateUserComponent,canActivate:[AuthGuardService] },
  { path: 'U-update/:id', component: UpdateUserComponent,canActivate:[AuthGuardService] },
  { path: 'U-details/:id', component: UserDetailsComponent,canActivate:[AuthGuardService] },

  { path: 'services', component: ServiceListComponent,canActivate:[AuthGuardService] },
  { path: 'Service-add', component: CreateServiceComponent,canActivate:[AuthGuardService] },
  { path: 'Service-update/:id', component: UpdateServiceComponent,canActivate:[AuthGuardService] },
  { path: 'Service-details/:id', component: ServiceDetailsComponent,canActivate:[AuthGuardService] },

  { path: 'login', component: LoginComponent},
  { path: '', component: LoginComponent},
  { path: 'logout', component: LoginComponent,canActivate:[AuthGuardService]},
  { path: 'payment', component: PaymentComponent,canActivate:[AuthGuardService]},
  { path: 'register', component: RegisterComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
