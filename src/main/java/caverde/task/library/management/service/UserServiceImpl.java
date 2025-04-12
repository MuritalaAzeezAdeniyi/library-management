package caverde.task.library.management.service;

import caverde.task.library.management.dto.request.LoginRequest;
import caverde.task.library.management.dto.request.RegisterUserRequest;
import caverde.task.library.management.dto.response.LoginResponse;
import caverde.task.library.management.dto.response.RegisterUserResponse;
import caverde.task.library.management.exception.EmailAlreadyExistException;
import caverde.task.library.management.exception.InvalidCredentialException;
import caverde.task.library.management.model.User;
import caverde.task.library.management.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private  UserRepo userRepository;

//    public UserServiceImpl(UserRepo userRepository) {
//        this.userRepository = userRepository;
//    }

    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest registerUserRequest) {
          validateUserEmail(registerUserRequest.getEmail());
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

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail())
                .orElse(null);
        if(user.getPassword().equals(loginRequest.getPassword())) {
            user.setLogging(true);
            userRepository.save(user);
        }
        LoginResponse response = new LoginResponse();
        response.setMessage("Successfully logged in");
        return response;
    }


    private void validateUserEmail(String email) {
      Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            throw new EmailAlreadyExistException(String.
                    format("User with email %s already exist", email));
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
