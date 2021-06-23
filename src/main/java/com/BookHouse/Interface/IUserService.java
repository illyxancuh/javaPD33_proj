package com.BookHouse.Interface;

import com.BookHouse.DTO.UserDTO;
import com.BookHouse.Domain.User;

public interface IUserService {
    UserDTO add(User user);
    User findById(Integer id);

}
