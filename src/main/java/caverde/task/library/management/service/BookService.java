package caverde.task.library.management.service;

import caverde.task.library.management.dto.request.AddBookRequest;
import caverde.task.library.management.dto.response.AddBookResponse;

public interface BookService {
    AddBookResponse addBook(AddBookRequest addBookRequest);
}
