package com.BookHouse.Interface;

import com.BookHouse.DTO.UserDTO;
import com.BookHouse.Domain.User;
import com.github.fge.jsonpatch.JsonPatch;
import org.springframework.http.ResponseEntity;

public interface IUserService {
    UserDTO add(User user);
    User findById(Integer id);
    ResponseEntity<User> update(Integer id, JsonPatch patch);
    void deleteById(Integer id);
}
