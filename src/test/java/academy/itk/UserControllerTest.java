package academy.itk;

import academy.itk.api.dto.UserDto;
import academy.itk.controller.UserController;
import academy.itk.service.UserService;
import org.instancio.Instancio;
import org.instancio.junit.InstancioSource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private UserService userService;

    @ParameterizedTest
    @InstancioSource
    public void getUserById_happy(UUID id, UserDto userDto) throws Exception {
        Mockito.when(userService.getUserById(id)).thenReturn(userDto);

        mockMvc.perform(get("/api/v1/user/" + id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(userDto.getId().toString()))
                .andExpect(jsonPath("$.name").value(userDto.getName()))
                .andExpect(jsonPath("$.email").value(userDto.getEmail()))
                .andExpect(jsonPath("$.orders.length()").value(userDto.getOrders().size()));
    }

    @Test
    public void getUsers_happy() throws Exception {
        final var usersDto = Instancio.createList(UserDto.class);
        Mockito.when(userService.getUsers()).thenReturn(usersDto);

        mockMvc.perform(get("/api/v1/user/all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(usersDto.get(0).getId().toString()))
                .andExpect(jsonPath("$[0].name").value(usersDto.get(0).getName()))
                .andExpect(jsonPath("$[0].email").value(usersDto.get(0).getEmail()));
    }
}