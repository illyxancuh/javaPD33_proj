package com.BookHouse.Controller;

import com.BookHouse.DTO.UserDTO;
import com.BookHouse.Domain.User;
import com.BookHouse.Interface.IUserService;
import com.BookHouse.Utils.Patch;
import com.BookHouse.exception.ItemNotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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


    @PatchMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<User> updateUser(@PathVariable Integer id,@RequestBody JsonPatch patch){

        return userService.update(id, patch);
    }
}
