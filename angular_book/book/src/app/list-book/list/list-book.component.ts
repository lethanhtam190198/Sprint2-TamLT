import {Component, OnInit} from '@angular/core';
import {BooksService} from '../../service/books.service';
import {Books} from '../../model/books';
import {CategoryService} from '../../service/category.service';
import {ToastrService} from 'ngx-toastr';
import {Title} from '@angular/platform-browser';
import {FormControl, FormGroup} from '@angular/forms';
import {Category} from '../../model/category';

@Component({
  selector: 'app-list-book',
  templateUrl: './list-book.component.html',
  styleUrls: ['./list-book.component.css']
})
export class ListBookComponent implements OnInit {
  books: Books[] = [];
  categories: Category[] = [];
  id: number;
  name: string;
  author: string;
  searchForm: FormGroup = new FormGroup({
    author: new FormControl(''),
    name: new FormControl(''),
    category: new FormGroup({
      name: new FormControl('')
    })
  });

  categorySearch = '';
  nameSearch = '';
  authorSearch = '';
  number: number;
  indexPagination = 0;
  totalPage: string[];
  numberOfElement = 0;
  totalElements = 0;
  pageSize: number;
  previousPageStyle = 'inline-block';
  nextPageStyle = 'inline-block';
  displayPagination = 'inline-block';
  constructor(private bookService: BooksService,
              private categoryService: CategoryService,
              private toast: ToastrService,
              private title: Title) {
    this.title.setTitle('');
  }

  ngOnInit(): void {
    this.getCategory();
    this.searchBook();
    this.getListSearch();
  }

  getCategory(): void {
    this.categoryService.getAll().subscribe(category => {
      this.categories = category;
    });
  }

  openDelete(id: number, name: string, author: string): void {
    this.id = id;
    this.name = name;
    this.author = author;
  }

  delete(id: number): void {
    this.bookService.delete(id).subscribe(() => {
      this.toast.success('Xoá Thành Công..', 'Thông Báo');
      this.getListSearch();
    }, e => {
      this.toast.error('Xoá Thất Bại..', 'Thông Báo');
      console.log(e);
    });
  }
  getListSearch() {
    this.bookService.getListAllBook(this.indexPagination, this.categorySearch, this.nameSearch,
      this.authorSearch, this.pageSize).subscribe((data?: any) => {
      if (data === null) {
        this.totalPage = new Array(0);
        this.books = [];
        this.displayPagination = 'none';
      } else {
        this.number = data?.number;
        // console.log(this.number);
        this.pageSize = data?.size;
        this.numberOfElement = data?.numberOfElements;
        this.books = data?.content;
        // console.log(this.books + ' ok');
        this.totalElements = data?.totalElements;
      }
      this.checkPreviousAndNext();
    }, error => {
      this.books = null;
    });
  }
  searchBook() {
    this.categorySearch = this.searchForm.value.category.name;
    this.authorSearch = this.searchForm.value.author;
    this.nameSearch = this.searchForm.value.name;
    this.getListSearch();
  }

  previousPage(event: any) {
    event.preventDefault();
    this.indexPagination--;
    this.ngOnInit();
  }

  nextPage(event: any) {
    event.preventDefault();
    this.indexPagination++;
    this.ngOnInit();
  }

  checkPreviousAndNext() {
    if (this.indexPagination === 0) {
      this.previousPageStyle = 'none';
    } else if (this.indexPagination !== 0) {
      this.previousPageStyle = 'inline-block';
    }
    if (this.indexPagination < (this.totalPage.length - 1)) {
      this.nextPageStyle = 'inline-block';
    } else if (this.indexPagination === (this.totalPage.length - 1) || this.indexPagination > (this.totalPage.length - 1)) {
      this.nextPageStyle = 'none';
    }
  }

  totalElement($event: any) {
    switch ($event.target.value) {
      case '8':
        this.pageSize = 8;
        this.indexPagination = 0;
        this.ngOnInit();
        break;
      case '16':
        this.pageSize = 16;
        this.indexPagination = 0;
        this.ngOnInit();
        break;
      case '24':
        this.pageSize = 24;
        this.indexPagination = 0;
        this.ngOnInit();
        break;
      case 'full':
        this.pageSize = this.totalElements;
        this.indexPagination = 0;
        this.ngOnInit();
        break;
    }
  }
}
