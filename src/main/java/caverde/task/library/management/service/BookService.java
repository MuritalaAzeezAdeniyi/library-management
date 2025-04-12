package caverde.task.library.management.service;

import caverde.task.library.management.dto.request.AddBookRequest;
import caverde.task.library.management.dto.request.BorrowBookRequest;
import caverde.task.library.management.dto.request.ReturnBookRequest;
import caverde.task.library.management.dto.response.AddBookResponse;
import caverde.task.library.management.dto.response.BorrowBookResponse;
import caverde.task.library.management.dto.response.ReturnBookResponse;

public interface BookService {
    AddBookResponse addBook(AddBookRequest addBookRequest);
    BorrowBookResponse borrowBook(BorrowBookRequest borrowBookRequest);
    ReturnBookResponse returnBook(ReturnBookRequest returnBookRequest);
}
