package fullStack.implementation.web.controller;

import fullStack.implementation.persistence.entity.User;
import fullStack.implementation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user){
        if(user.getIdUsuario()==null || !this.userService.exist(user.getIdUsuario())){
            return ResponseEntity.ok(this.userService.save(user));
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/validation/{email}")
    public  ResponseEntity<Optional<User>> getUserEmail(@PathVariable("email") String email){
        return  ResponseEntity.ok(this.userService.getUserEmail(email));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") int id){
        return ResponseEntity.ok(this.userService.getUser(id));
    }
}
