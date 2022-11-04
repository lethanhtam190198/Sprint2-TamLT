import {Component, OnInit} from '@angular/core';
import {Cart} from '../model/cart';
import {CartDetailService} from '../service/cart-detail.service';
import {TokenStorageService} from '../service/token-storage.service';
import {Router} from '@angular/router';
import {Title} from '@angular/platform-browser';

@Component({
  selector: 'app-cart-detail',
  templateUrl: './cart-detail.component.html',
  styleUrls: ['./cart-detail.component.css']
})
export class CartDetailComponent implements OnInit {

  history: any = {};
  cart: Cart = {
    cartDetailDtoList: []
  };

  constructor(private cartDetailService: CartDetailService,
              private tokenStorageService: TokenStorageService,
              private router: Router,
              private title: Title) {
    this.title.setTitle('Chi Tiết Giỏ Hàng');
  }

  ngOnInit(): void {
    this.cartDetailService.getHistory(this.tokenStorageService.getUser().username).subscribe(value => {
      this.history = value;
      console.log(value);
    });
  }
  getTotalPrice(cart: Cart) {
    let total = 0;
    for (const item of cart.cartDetailDtoList) {
      total += (item.book.price * item.quantity) * (1 - (item.book.discount.percent / 100));
    }
    return total;
  }

  showDetail(item: Cart) {
    this.cart = item;
  }
}
