package com.BookHouse.Controller;

import com.BookHouse.DTO.UserDTO;
import com.BookHouse.Domain.User;
import com.BookHouse.Interface.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("user")
@AllArgsConstructor
public class UserController {
    private final IUserService userService;

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public User getUserById(@PathVariable Integer id){
        return userService.findById(id);
    }

    @PostMapping("add")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO addUser(@RequestBody User user){
        return userService.add(user);
    }
}
