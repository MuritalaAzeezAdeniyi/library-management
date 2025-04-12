package caverde.task.library.management.service;

import caverde.task.library.management.dto.request.LoginRequest;
import caverde.task.library.management.dto.request.RegisterUserRequest;
import caverde.task.library.management.dto.response.LoginResponse;
import caverde.task.library.management.dto.response.RegisterUserResponse;

public interface UserService {
    RegisterUserResponse registerUser(RegisterUserRequest registerUserRequest);
    LoginResponse login(LoginRequest loginRequest);
}
