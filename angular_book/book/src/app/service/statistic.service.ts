import {Injectable} from '@angular/core';
import {HttpClient, HttpEvent} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../../environments/environment';
import {Books} from '../model/books';

const URL = `${environment.apiUrl}`;

@Injectable({
  providedIn: 'root'
})
export class StatisticService {

  constructor(private http: HttpClient) {
  }

  getListSellingTop10(startDate: string, endDate: string): Observable<Books[]> {
    return this.http.get<Books[]>(URL + `/statistic/` + startDate + '/' + endDate);
  }
}
