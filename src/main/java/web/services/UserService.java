package web.services;

import org.springframework.stereotype.Service;
import web.models.User;

import java.util.List;

@Service
public interface UserService {
    public List<User> getAllUsers();

    public void saveUser(User user);

    public User getUser(int id);

    public void deleteUser(int id);
}
