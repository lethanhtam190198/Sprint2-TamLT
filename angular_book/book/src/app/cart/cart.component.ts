import {Component, OnInit} from '@angular/core';
import {BooksService} from '../service/books.service';
import Swal from 'sweetalert2';
import {Title} from '@angular/platform-browser';
import {Router} from '@angular/router';
import {render} from 'creditcardpayments/creditCardPayments';
import {CustomerService} from '../service/customer.service';
import {TokenStorageService} from '../service/token-storage.service';
import {CartDetailService} from '../service/cart-detail.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  totalQuantity: number = this.book.getCartTotalQuantity();
  totalMoney: number = this.book.getCartTotalMany();
  totalAllMoney: number = this.book.totalMoneyAll();
  name: string;
  customer: any;
  username: string;
  users: any = [];

  constructor(private title: Title,
              private router: Router,
              private book: BooksService,
              private customerService: CustomerService,
              private tokenStorageService: TokenStorageService,
              private cartDetailService: CartDetailService) {
    this.title.setTitle('Giỏ hàng');
  }

  cart: any = [] = [];

  paypals() {
    // document.getElementById('paypal').innerHTML = '<div id="btnPayPal"></div>';
    const username = this.tokenStorageService.getUser().username;
    if (this.totalAllMoney > 0) {
      render({
        id: '#paypal',
        currency: 'USD',
        value: String((this.totalAllMoney / 23000).toFixed(2)),
        onApprove: (details) => {
          for (const item of this.cart) {
            item.book = {
              id: item.id
            };
          }
          this.cartDetailService.saveCartDetail(username, this.cart).subscribe();
          Swal.fire({
            title: 'Thanh toán thành công',
            icon: 'success',
            iconColor: ' #EBA850',
            timer: 2000
          });
          this.cart = [];
          this.book.saveCart(this.cart);
        }
      });
    } else {
    }
  }

  ngOnInit(): void {
    this.cart = this.book.getCart();
    this.paypals();
    this.getCustomer();
  }

  subTotal(cart: any) {
    return (cart.quantity * cart.price) * (1 - (cart.discount / 100));
  }

  totalMoneyAll(cart: any) {
    let totalAll = 0;
    cart.forEach((item: any) => {
      totalAll += (item.price * item.quantity) * (1 - (item.discount / 100));
    });
    return totalAll;
  }


  payment() {
    Swal.fire({
      title: 'Thông Báo!',
      text: 'Đăng nhập để mua hàng',
      color: '#EBA850',
      icon: 'warning',
      iconColor: ' #EBA850',
      timer: 2000
    });
    this.router.navigate(['/login']);
  }

  updateQuantity(idx: number, ev: any) {
    let newQuantity = ev.target.value;
    newQuantity = newQuantity > 0 ? newQuantity : 1;
    newQuantity = newQuantity <= 100 ? newQuantity : 100;
    ev.target.value = newQuantity;
    this.cart[idx].quantity = ev.target.value;
    this.book.saveCart(this.cart);
    this.totalMoney = this.book.getCartTotalMany();
    this.totalQuantity = this.book.getCartTotalQuantity();
  }

  reduce(idx: number, quantity: any) {
    // tslint:disable-next-line:radix
    let newQuantity = parseInt(quantity) - 1;
    newQuantity = newQuantity > 0 ? newQuantity : 1;
    newQuantity = newQuantity <= 100 ? newQuantity : 100;
    this.cart[idx].quantity = newQuantity;
    this.book.saveCart(this.cart);
    this.totalMoney = this.book.getCartTotalMany();
    this.totalQuantity = this.book.getCartTotalQuantity();
  }

  up(idx: number, quantity: any) {
    // tslint:disable-next-line:radix
    let newQuantity = parseInt(quantity) + 1;
    newQuantity = newQuantity > 0 ? newQuantity : 1;
    this.cart[idx].quantity = newQuantity;
    this.book.saveCart(this.cart);
    this.totalMoney = this.book.getCartTotalMany();
    this.totalQuantity = this.book.getCartTotalQuantity();
  }

  delete(i: number) {
    // tslint:disable-next-line:variable-name
    const _this = this;
    const swalWithBootstrapButtons = Swal.mixin({
      customClass: {
        confirmButton: 'btn btn-success',
        cancelButton: 'btn btn-danger'
      },
      buttonsStyling: false
    });
    swalWithBootstrapButtons.fire({
      title: 'Bạn có chắc không muốn xoá?',
      text: 'Hành động này không thể hoàn tác!',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Đồng ý!',
      cancelButtonText: 'Hủy!',
      reverseButtons: true
    }).then((result) => {
      if (result.isConfirmed) {
        swalWithBootstrapButtons.fire(
          'Xóa!',
          'Đã xóa thành công',
          'success'
        );
        _this.cart.splice(i, 1);
        _this.book.saveCart(this.cart);
      } else if (
        result.dismiss === Swal.DismissReason.cancel
      ) {
        swalWithBootstrapButtons.fire(
          'Đã hủy',
          'Huỷ thành công :)',
          'success'
        );
      }
    });
  }

  clearCart() {
    const swalWithBootstrapButtons = Swal.mixin({
      customClass: {
        confirmButton: 'btn btn-success',
        cancelButton: 'btn btn-danger'
      },
      buttonsStyling: false
    });
    swalWithBootstrapButtons.fire({
      title: 'Bạn có chắc chắn muốn xoá tất cả không?',
      text: 'Hành động này không thể hoàn tác!',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Đồng ý!',
      cancelButtonText: 'Hủy!',
      reverseButtons: true
    }).then((result) => {
      if (result.isConfirmed) {
        swalWithBootstrapButtons.fire(
          'Xóa!',
          'Đã xóa thành công',
          'success'
        );
        sessionStorage.clear();
        this.cart = [];
      } else if (
        /* Read more about handling dismissals below */
        result.dismiss === Swal.DismissReason.cancel
      ) {
        swalWithBootstrapButtons.fire(
          'Đã hủy',
          'Huỷ thành công :)',
          'success'
        );
      }
    });
  }

  getCustomer() {
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
