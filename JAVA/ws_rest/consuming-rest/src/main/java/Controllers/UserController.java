package Controllers;

import Services.UserService;
import Sockets.Models.User;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/SEP3Group3")
public class UserController {


    private UserService userService;

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
