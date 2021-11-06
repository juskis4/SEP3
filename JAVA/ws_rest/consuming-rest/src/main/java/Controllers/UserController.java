package Controllers;

import Services.IUserService;
import Services.UserService;
import Sockets.Models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class UserController {


    private IUserService userService;

    public UserController() throws IOException {
        userService = new UserService();
    }

    @GetMapping("/validateLogin")
    public ResponseEntity<User> ValidateLogin(@RequestParam String username, @RequestParam String password)
    {
        try{
            User user = userService.ValidateLogin(username,password);
            if(user == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(user);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
