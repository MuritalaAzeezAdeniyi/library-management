package caverde.task.library.management.service;

import caverde.task.library.management.dto.request.AddBookRequest;
import caverde.task.library.management.dto.response.AddBookResponse;
import caverde.task.library.management.model.Book;
import caverde.task.library.management.repository.BookRepo;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepo bookRepository;

    public BookServiceImpl(BookRepo bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public AddBookResponse addBook(AddBookRequest addBookRequest) {
        Book book = new Book();
        book.setTitle(addBookRequest.getTitle());
        book.setAuthor(addBookRequest.getAuthor());
        book.setPublishYear(addBookRequest.getPublishYear());
        book.setStock(addBookRequest.getStock());
        bookRepository.save(book);

        AddBookResponse addBookResponse = new AddBookResponse();
        addBookResponse.setMessage("Book added successfully");
        return addBookResponse;
    }
}
