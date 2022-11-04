import {Component, OnInit} from '@angular/core';
import {Books} from '../model/books';
import {BooksService} from '../service/books.service';
import {ActivatedRoute, Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';
import {TokenStorageService} from '../service/token-storage.service';
import {ShareService} from '../service/share.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-category-book',
  templateUrl: './category-book.component.html',
  styleUrls: ['./category-book.component.css']
})
export class CategoryBookComponent implements OnInit {
  bookList: Books[] = [];

  error: string;
  check: string[] = [];
  page = 0;
  previousPageStyle = 'inline-block';
  nextPageStyle = 'inline-block';
  totalElements = 0;
  pageSize: number;
  numberOfElement: number;
  cart: any = this.bookService.getCart();

  constructor(private bookService: BooksService,
              private router: Router,
              private activeRouter: ActivatedRoute,
              private toast: ToastrService) {
  }

  ngOnInit(): void {
    this.getList();
  }

  getList() {
    this.pageSize = 8;
    this.activeRouter.paramMap.subscribe(param => {
      if (param.get('id') === null && param.get('search') == null) {
        this.bookService.getCategoryBook(this.page).subscribe(value => {
          // this.totalElements = value.totalElements;
          this.bookList = value.content;
          // this.numberOfElement = value.content.length;
          // if (value.first) {
          //   this.previousPageStyle = 'none';
          // } else {
          //   this.previousPageStyle = 'inline-block';
          // }
          // if (value.last) {
          //   this.nextPageStyle = 'none';
          // } else {
          //   this.nextPageStyle = 'inline-block';
          // }
        }, error => 'lỗi');
        return;
      }
      this.bookService.getAll(+param.get('id'), param.get('search')).subscribe(value => {
        if (value !== null) {
          // this.totalElements = value.totalElements;
          this.bookList = value.content;
          // this.numberOfElement = value.content.length;
          // if (value.first) {
          //   this.previousPageStyle = 'none';
          // } else {
          //   this.previousPageStyle = 'inline-block';
          // }
          // if (value.last) {
          //   this.nextPageStyle = 'none';
          // } else {
          //   this.nextPageStyle = 'inline-none';
          // }
          console.log(value);
        }
      });
    });
  }


  previousPage() {
    this.page--;
    this.getList();
  }

  nextPage() {
    this.page++;
    this.getList();
  }
  addToCart(book: any) {
    const idx = this.cart.findIndex((item: any) => {
      return item.id === book.id;
    });
    if (idx >= 0) {
      this.cart[idx].quantity += 1;
    } else {
      const cartItem: any = {
        image: book.image,
        id: book.id,
        author: book.author,
        name: book.name,
        price: book.price,
        discount: book.discount.percent,
        quantity: 1,
      };
      this.cart.push(cartItem);
    }
    this.bookService.saveCart(this.cart);
    Swal.fire({
      title: 'Thông Báo!',
      text: 'Thêm vào giỏ thành công',
      color: '#EBA850',
      icon: 'success',
      iconColor: ' #EBA850',
      timer: 1000
    });
  }

}
