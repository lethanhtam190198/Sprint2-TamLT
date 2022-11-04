import {Component, OnInit} from '@angular/core';
import {TokenStorageService} from '../service/token-storage.service';
import {CustomerService} from '../service/customer.service';

@Component({
  selector: 'app-detail-customer',
  templateUrl: './detail-customer.component.html',
  styleUrls: ['./detail-customer.component.css']
})
export class DetailCustomerComponent implements OnInit {

  customer: any;
  username: string;
  users: any = [];

  constructor(private tokenStorageService: TokenStorageService,
              private customerService: CustomerService) {
  }

  ngOnInit(): void {
    this.loadHeader();
    this.customerService.getCustomer(this.username).subscribe(customers => {
      this.customer = customers;
    });
  }

  loadHeader(): void {
    if (this.tokenStorageService.getToken()) {
      this.username = this.tokenStorageService.getUser().username;
    }
  }

}
