import { Injectable } from '@angular/core';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {CartDetail} from '../model/cart-detail';
import {Observable} from 'rxjs';
const URL = `${environment.apiUrl}`;
@Injectable({
  providedIn: 'root'
})
export class CartDetailService {

  constructor(private http: HttpClient) {
  }

  saveCartDetail(username: string, cartDetail: CartDetail[]) {
    return this.http.post(URL + '/saveCart/' + username, cartDetail);
  }

  getHistory(username: string): Observable<History> {
    return this.http.get<History>(URL + '/history/' + username);
  }
}
