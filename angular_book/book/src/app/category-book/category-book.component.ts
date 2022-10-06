import {Component, OnInit} from '@angular/core';
import {Books} from '../model/books';
import {BooksService} from '../service/books.service';

@Component({
  selector: 'app-category-book',
  templateUrl: './category-book.component.html',
  styleUrls: ['./category-book.component.css']
})
export class CategoryBookComponent implements OnInit {
  listVietnameseLiterature: Books[] = [];

  constructor(private bookService: BooksService) {
  }

  ngOnInit(): void {
    this.getVietnameseLiterature();
  }

  private getVietnameseLiterature() {
    this.bookService.getVietnameseLiterature().subscribe((books: any) => {
      if (books != null) {
        this.listVietnameseLiterature = books.content;
        console.log(books);
      }
    });
  }
}
