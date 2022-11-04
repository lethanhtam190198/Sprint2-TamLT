import { Injectable } from '@angular/core';
import {environment} from '../../environments/environment';
import {Observable} from 'rxjs';
import {Customer} from '../model/customer';
import {HttpClient} from '@angular/common/http';

const URL = `${environment.apiUrl1}`;

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http: HttpClient) { }
  getCustomer(username: string): Observable<Customer> {
    return this.http.get<Customer>(`${URL}/detail/` + username);
  }
}
