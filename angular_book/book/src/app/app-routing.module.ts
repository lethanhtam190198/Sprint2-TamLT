import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {LoginComponent} from './login/login.component';
import {BodyComponent} from './body/body.component';
import {CartComponent} from './cart/cart.component';


const routes: Routes = [
  {path: '', component: BodyComponent},
  {path: 'login', component: LoginComponent},
  {path: 'cart', component: CartComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
