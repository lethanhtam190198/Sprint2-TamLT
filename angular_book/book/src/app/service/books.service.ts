import {Injectable} from '@angular/core';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Books} from '../model/books';

const URL = `${environment.apiUrl}`;

@Injectable({
  providedIn: 'root'
})

export class BooksService {

  constructor(private http: HttpClient) {
  }

  getList1(): Observable<Books[]> {
    return this.http.get<Books[]>(URL);
  }

  findById(id: number): Observable<Books> {
    return this.http.get<Books>(URL + `/detail` + `/${id}`);
  }

  getList2(): Observable<Books[]> {
    return this.http.get<Books[]>(URL + '/list2');
  }

  getListAllBook(page: number, category: string, name: string, author: string, size: number): Observable<Books[]> {
    return this.http.get<Books[]>(URL + '/listAllBook?page=' + page + '&keyCategory=' + category + '&keyName=' + name + '&keyAuthor=' + author + '&size=' + size);
  }

  save(book: Books): Observable<Books> {
    return this.http.post<Books>(URL + '/create', book);
  }

  delete(id: number): Observable<Books> {
    // @ts-ignore
    return this.http.put<Books>(`${URL}/delete/${id}`);
  }

  edit(id: number, book: Books): Observable<Books> {
    return this.http.put<Books>(`${URL}/edit/${id}`, book);
  }

  getVietnameseLiterature(): Observable<Books[]> {
    return this.http.get<Books[]>(URL + '/categoryBook');
  }

  getCart() {
    const cartJson = localStorage.getItem('cart');
    if (cartJson) {
      return JSON.parse(cartJson);
    } else {
      return [];
    }
  }

  saveCart(cart: any) {
    const cartJson = JSON.stringify(cart);
    localStorage.setItem('cart', cartJson);
  }

  getCartTotalQuantity() {
    const cart = this.getCart();
    let total = 0;
    cart.forEach((item: any) => {
      total += item.quantity;
    });
    return total;
  }

  getCartTotalMany() {
    const cart = this.getCart();
    let total = 0;
    cart.forEach((item: any) => {
      total += item.price * item.quantity;
    });
    return total;
  }

  getTotalBook() {
    const cart = this.getCart();
    const total = this.getCartTotalQuantity();
    return total;
  }

  totalMoneyAll() {
    const cart = this.getCart();
    let totalAll = 0;
    cart.forEach((item: any) => {
      totalAll += (item.price * item.quantity) * (1 - (item.discount / 100));
    });
    return totalAll;
  }

  checkCode(code: string): Observable<string> {
    return this.http.get<string>(URL + '/check/' + code);
  }

  getAll(idCategory: number, search: string): Observable<any> {
    if (idCategory === 0) {
      return this.http.get<any>(URL + '/categoryBooks?name=' + search);
    } else {
      return this.http.get<any>(URL + '/categoryBooks?idCategory=' + idCategory + '&name=@');
    }
  }

  getCategoryBook(page: number): Observable<any> {
    return this.http.get<any>(URL + '/categoryBooks/?page' + page);
  }
}
