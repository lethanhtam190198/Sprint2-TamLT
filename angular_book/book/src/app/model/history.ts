import {Cart} from './cart';
import {CartDetail} from './cart-detail';

export interface History {
  id?: number;
  name?: string;
  address?: string;
  phone?: number;
  cartDtoList?: Cart[];
}
