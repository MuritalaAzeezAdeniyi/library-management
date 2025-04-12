package caverde.task.library.management;

import caverde.task.library.management.dto.request.AddBookRequest;
import caverde.task.library.management.dto.request.BorrowBookRequest;
import caverde.task.library.management.dto.request.ReturnBookRequest;
import caverde.task.library.management.dto.response.AddBookResponse;
import caverde.task.library.management.dto.response.BorrowBookResponse;
import caverde.task.library.management.dto.response.ReturnBookResponse;
import caverde.task.library.management.model.Book;
import caverde.task.library.management.service.BookServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BookServiceTest {
    @Autowired
    private BookServiceImpl bookService;

    @Test
    public void testThatBookCanBeAdded(){
        AddBookRequest request = new AddBookRequest();
        request.setTitle("Java");
        request.setAuthor("James Bond");
        request.setPublishYear(2025L);
        request.setStock(1L);

        AddBookResponse response = bookService.addBook(request);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Book added successfully");
    }

    @Test
    public void testThatBookCanBeBorrow(){
        BorrowBookRequest request = new BorrowBookRequest();
        request.setTitle("Java");
        request.setEmail("aheed@gmail.com");
        BorrowBookResponse response = bookService.borrowBook(request);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Book Borrowed successfully");
    }

    @Test
    public void testThatBookCanBeReturn(){
        ReturnBookRequest request = new ReturnBookRequest();
        request.setTitle("Java");
        request.setEmail("aheed@gmail.com");
        ReturnBookResponse response = bookService.returnBook(request);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Book Returned successfully");
    }
}
