import {Component, OnInit} from '@angular/core';
import {Books} from '../model/books';
import {BooksService} from '../service/books.service';
import {ActivatedRoute, Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';
import {TokenStorageService} from '../service/token-storage.service';
import {ShareService} from '../service/share.service';

@Component({
  selector: 'app-category-book',
  templateUrl: './category-book.component.html',
  styleUrls: ['./category-book.component.css']
})
export class CategoryBookComponent implements OnInit {
  listVietnameseLiterature: Books[] = [];

  constructor(private bookService: BooksService,
              private router: Router,
              private activeRouter: ActivatedRoute,
              private toast: ToastrService,
              private tokenStorageService: TokenStorageService,
              private shareService: ShareService) {
  }

  ngOnInit(): void {
  }

}
