import {Books} from './books';

export interface CartDetail {
  id?: number;
  quantity?: number;
  idBook?: number;
  book?: Books;
}
