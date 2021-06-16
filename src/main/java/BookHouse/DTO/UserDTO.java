package BookHouse.DTO;

import BookHouse.domain.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    public UserDTO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.mail = user.getMail();

    }

    private Integer id;
    private String username;
    private String mail;
}