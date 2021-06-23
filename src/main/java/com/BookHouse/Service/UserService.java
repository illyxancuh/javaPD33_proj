package com.BookHouse.Service;

import com.BookHouse.DTO.UserDTO;
import com.BookHouse.Domain.User;
import com.BookHouse.exception.ItemNotFoundException;
import com.BookHouse.Interface.IUserService;
import com.BookHouse.Repos.UserRepository;
import lombok.AllArgsConstructor;
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
    public UserDTO add(User user) {
        return new UserDTO(userRepository.save(user));
    }

}