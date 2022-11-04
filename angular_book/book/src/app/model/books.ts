import {Category} from './category';
import {Discount} from './discount';

export interface Books {
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
  category?: Category;
  discount?: Discount;
  status?: boolean;
  sumQuantity?: number;
}
