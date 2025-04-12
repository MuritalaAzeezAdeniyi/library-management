package caverde.task.library.management;

import caverde.task.library.management.dto.request.LoginRequest;
import caverde.task.library.management.dto.request.RegisterUserRequest;
import caverde.task.library.management.dto.response.LoginResponse;
import caverde.task.library.management.dto.response.RegisterUserResponse;
import caverde.task.library.management.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserServiceImplTest {
    @Autowired
    private UserServiceImpl userService;
    @Test
    public void testThatUserCanRegister(){
        RegisterUserRequest request = new RegisterUserRequest();
        request.setFullName("Waheed Azeez");
        request.setEmail("heed@gmail.com");
        request.setPassword("password");
        RegisterUserResponse response = userService.registerUser(request);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Successfully registered");

    }
    @Test
    public void testThatUserCanLogin(){
        LoginRequest request = new LoginRequest();
        request.setEmail("aheed@gmail.com");
        request.setPassword("password");
        LoginResponse response = userService.login(request);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Successfully logged in");

    }

}
