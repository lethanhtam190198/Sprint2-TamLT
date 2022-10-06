import {Component, OnInit} from '@angular/core';
import {BooksService} from '../service/books.service';
import {ActivatedRoute, ParamMap} from '@angular/router';
import {Books} from '../model/books';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {

  id?: number;
  name?: string;
  code?: string;
  description?: string;
  dimension?: string;
  image?: string;
  publisher?: string;
  quantity?: number;
  releaseDate?: string;
  price?: number;
  totalPages?: number;
  translator?: string;
  author?: string;

  listBooks1: Books[] = [];
  listBooks2: Books[] = [];
  cart: any = this.bookService.getCart();

  constructor(private bookService: BooksService,
              private activatedRoute: ActivatedRoute) {
    this.activatedRoute.paramMap.subscribe((paraMap: ParamMap) => {
      this.id = +paraMap.get('id');
      this.detailBooks(this.id);
    });
  }

  ngOnInit(): void {
  }

  detailBooks(id: number) {
    this.bookService.findById(id).subscribe(detailBooks => {
      this.name = detailBooks.name;
      this.code = detailBooks.code;
      this.description = detailBooks.description;
      this.dimension = detailBooks.dimension;
      this.image = detailBooks.image;
      this.publisher = detailBooks.publisher;
      this.quantity = detailBooks.quantity;
      this.releaseDate = detailBooks.releaseDate;
      this.price = detailBooks.price;
      this.totalPages = detailBooks.totalPages;
      this.translator = detailBooks.translator;
      this.author = detailBooks.author;
    });
  }
  addToCart(book: any) {
    const idx = this.cart.findIndex((item: any) => {
      // tslint:disable-next-line:triple-equals
      return item.id == book.id;
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
