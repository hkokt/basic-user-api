package br.com.auth;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import br.com.auth.application.controller.AuthenticationController;
import br.com.auth.application.dto.authentication.RegisterDto;
import br.com.auth.domain.model.user.UserRole;
import br.com.auth.domain.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class AuthApplicationTests {

    @Mock
    private UserService userService;

    @InjectMocks
    private AuthenticationController userController;

    @Test
    public void testRegister() throws Exception {
        RegisterDto registerDto = new RegisterDto("John Doe", "john@example.com", "password123", UserRole.USER);
        doNothing().when(userService).register(registerDto);

        ResponseEntity<Object> response = userController.register(registerDto);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(userService, times(1)).register(registerDto);
    }

    @Test
    public void testRegisterFailure() throws Exception {
        RegisterDto registerDto = new RegisterDto("John Doe", "john@example.com", "password123", UserRole.USER);
        doThrow(RuntimeException.class).when(userService).register(registerDto);
        ResponseEntity<Object> response = userController.register(registerDto);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        verify(userService, times(1)).register(registerDto);
    }


}

