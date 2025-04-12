package caverde.task.library.management.controller;

import caverde.task.library.management.dto.request.AddBookRequest;
import caverde.task.library.management.dto.request.BorrowBookRequest;
import caverde.task.library.management.dto.request.ReturnBookRequest;
import caverde.task.library.management.dto.response.AddBookResponse;
import caverde.task.library.management.dto.response.ApiResponse;
import caverde.task.library.management.dto.response.BorrowBookResponse;
import caverde.task.library.management.dto.response.ReturnBookResponse;
import caverde.task.library.management.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    private final BookService bookService;
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @PostMapping("/addBook")
    public ResponseEntity<?> addBook(@RequestBody AddBookRequest addBookRequest) {
        try{
            AddBookResponse addBookResponse = bookService.addBook(addBookRequest);
            return new ResponseEntity<>(new ApiResponse(true,addBookResponse), HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
     @PostMapping("/borrowBook")
   public ResponseEntity<?> borrowBook(@RequestBody BorrowBookRequest borrowBookRequest) {
        try{
            BorrowBookResponse borrowBookResponse = bookService.borrowBook(borrowBookRequest);
            return new ResponseEntity<>(new ApiResponse(true,borrowBookResponse), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
   }
    @PostMapping("/returnBook")
   public ResponseEntity <?> returnBook(@RequestBody ReturnBookRequest returnBookRequest) {
        try{
            ReturnBookResponse returnBookResponse = bookService.returnBook(returnBookRequest);
            return new ResponseEntity<>(new ApiResponse(true,returnBookResponse), HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
   }
}
