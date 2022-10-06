import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {LoginComponent} from './login/login.component';
import {BodyComponent} from './body/body.component';
import {CartComponent} from './cart/cart.component';
import {DetailComponent} from './detail/detail.component';
import {ListBookComponent} from './list-book/list/list-book.component';
import {CreateComponent} from './list-book/create/create.component';
import {EditComponent} from './list-book/edit/edit.component';
import {CategoryBookComponent} from './category-book/category-book.component';


const routes: Routes = [
  {path: '', component: BodyComponent},
  {path: 'cart', component: CartComponent},
  {path: 'detail/:id', component: DetailComponent},
  {path: 'listBook', component: ListBookComponent},
  {path: 'listBook/create', component: CreateComponent},
  {path: 'listBook/edit/:id', component: EditComponent},
  {path: 'vietnameseLiterature', component: CategoryBookComponent},
  {path: 'login', component: LoginComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
