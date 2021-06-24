package com.BookHouse.Service;

import com.BookHouse.DTO.UserDTO;
import com.BookHouse.Domain.User;
import com.BookHouse.Utils.Patch;
import com.BookHouse.exception.ItemNotFoundException;
import com.BookHouse.Interface.IUserService;
import com.BookHouse.Repos.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepository;


    @Override
    public User findById(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("User with id has not found!"));
        return user;
    }

    @Override
    public ResponseEntity<User> update(Integer id, JsonPatch patch) {
        Patch userPatch = new Patch();
        try {
            User user = userRepository.findById(id)
                    .orElseThrow(() -> new ItemNotFoundException("User with id has not found"));
            User userPatched = userPatch.applyPatchToUser(patch, user);

            return ResponseEntity.ok(userPatched);
        } catch (JsonPatchException | JsonProcessingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } catch (ItemNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Override
    public UserDTO add(User user) {
        return new UserDTO(userRepository.save(user));
    }

}