package caverde.task.library.management.service;

import caverde.task.library.management.dto.request.RegisterUserRequest;
import caverde.task.library.management.dto.response.RegisterUserResponse;
import caverde.task.library.management.exception.EmailAlreadyExistException;
import caverde.task.library.management.exception.InvalidCredentialException;
import caverde.task.library.management.model.User;
import caverde.task.library.management.repository.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepository;

    public UserServiceImpl(UserRepo userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest registerUserRequest) {
          validateUserEmail(registerUserRequest);
          validateUserInfo(registerUserRequest);
          User user = new User();
          user.setEmail(registerUserRequest.getEmail());
          user.setPassword(registerUserRequest.getPassword());
          user.setFullName(registerUserRequest.getFullName());
          userRepository.save(user);

          RegisterUserResponse response = new RegisterUserResponse();
          response.setEmail(registerUserRequest.getEmail());
          response.setMessage("Successfully registered");
        return response;
    }


    private void validateUserEmail(RegisterUserRequest registerUserRequest) {
        User user = userRepository.findByEmail(registerUserRequest.getEmail());
        if (user != null) {
            throw new EmailAlreadyExistException(String.
                    format("User with email %s already exist", registerUserRequest.getEmail()));
        }
    }


    private void validateUserInfo(RegisterUserRequest registerUserRequest) {
        if(registerUserRequest.getEmail().trim().isEmpty() ||
                registerUserRequest.getPassword().trim().isEmpty() ||
                registerUserRequest.getFullName().trim().isEmpty()) {
            throw new InvalidCredentialException("Invalid credentials");
        }
    }
}
