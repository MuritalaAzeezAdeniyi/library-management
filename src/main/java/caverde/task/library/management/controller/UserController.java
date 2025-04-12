package caverde.task.library.management.controller;

import caverde.task.library.management.dto.request.RegisterUserRequest;
import caverde.task.library.management.dto.response.ApiResponse;
import caverde.task.library.management.dto.response.RegisterUserResponse;
import caverde.task.library.management.service.UserService;
import caverde.task.library.management.service.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController{
    private final UserServiceImpl userService;
    public UserController(UserServiceImpl userService){
        this.userService = userService;
    }

    public ResponseEntity <?> registerUser(@RequestBody RegisterUserRequest request){
        try{
            RegisterUserResponse response = userService.registerUser(request);
            return new ResponseEntity<>(new ApiResponse(true,response),HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
