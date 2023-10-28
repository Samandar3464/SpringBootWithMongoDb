package uz.pdp.javawithmongodb.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.javawithmongodb.dacument.lesson1.Users;
import uz.pdp.javawithmongodb.service.UserService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/test/user")
public class UserController {

    private final UserService userService;

    @PostMapping
    public Users saveStudent(@RequestBody Users users){
        return userService.create(users);
    }

    @PutMapping
    public Users updateStudent(@RequestBody Users users){
      return   userService.update(users);
    }

    @GetMapping
    public Users getUser(@PathVariable(name = "id") String id){
        return userService.get(id);
    }
    @DeleteMapping
    public boolean deleteUser(@PathVariable(name = "id") String id){
        return userService.delete(id);
    }
}
