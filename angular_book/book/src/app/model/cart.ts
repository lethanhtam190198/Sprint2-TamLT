import {CartDetail} from './cart-detail';

export interface Cart {
  id?: number;
  dateCreate?: string;
  cartDetailDtoList?: CartDetail[];
}
