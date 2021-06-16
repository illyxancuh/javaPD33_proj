package BookHouse.servise;

import BookHouse.DTO.UserDTO;
import BookHouse.domain.User;
import BookHouse.exceptions.ItemNotFoundException;
import BookHouse.interfaces.IUserService;
import BookHouse.repos.UserRepository;
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