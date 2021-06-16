package BookHouse.interfaces;

import BookHouse.DTO.UserDTO;
import BookHouse.domain.User;

public interface IUserService {
    User findById(Integer id);
    UserDTO add(User user);
}
