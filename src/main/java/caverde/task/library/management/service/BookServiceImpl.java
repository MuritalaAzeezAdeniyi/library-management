package caverde.task.library.management.service;

import caverde.task.library.management.dto.request.AddBookRequest;
import caverde.task.library.management.dto.request.BorrowBookRequest;
import caverde.task.library.management.dto.response.AddBookResponse;
import caverde.task.library.management.dto.response.BorrowBookResponse;
import caverde.task.library.management.model.Book;
import caverde.task.library.management.model.Transaction;
import caverde.task.library.management.repository.BookRepo;
import caverde.task.library.management.repository.TransactionRepo;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepo bookRepository;
    private final TransactionRepo transactionRepository;

    public BookServiceImpl(BookRepo bookRepository,TransactionRepo transactionRepository) {
        this.bookRepository = bookRepository;
        this.transactionRepository = transactionRepository;
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

    @Override
    public BorrowBookResponse borrowBook(BorrowBookRequest borrowBookRequest) {
        Book book = findBookByTitle(borrowBookRequest.getTitle());
        if(book.getStock() > 0) {
            book.setStock(book.getStock() - 1);
            bookRepository.save(book);

            Transaction transaction = new Transaction();
            transaction.setEmail(borrowBookRequest.getEmail());
            transaction.setTitle(borrowBookRequest.getTitle());
            transaction.setTransactionType("borrow");
            transactionRepository.save(transaction);
        }

        BorrowBookResponse borrowBookResponse = new BorrowBookResponse();
        borrowBookResponse.setMessage("Book Borrowed successfully");
        return borrowBookResponse;
    }

    private Book findBookByTitle(String title) {
        Book book = bookRepository.findByTitle(title);
        if(book == null) {
            throw new RuntimeException("Book not found");
        }
        return book;
    }
}
