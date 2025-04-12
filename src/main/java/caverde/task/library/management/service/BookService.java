package caverde.task.library.management.service;

import caverde.task.library.management.dto.request.AddBookRequest;
import caverde.task.library.management.dto.request.BorrowBookRequest;
import caverde.task.library.management.dto.response.AddBookResponse;
import caverde.task.library.management.dto.response.BorrowBookResponse;

public interface BookService {
    AddBookResponse addBook(AddBookRequest addBookRequest);
    BorrowBookResponse borrowBook(BorrowBookRequest borrowBookRequest);
}
