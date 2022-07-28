package nebolsin.dao;

import nebolsin.model.User;
import java.util.List;

public interface UserDAO {
    List<User> allUsers();
    void add(User user);
    void delete(User user);
    void edit(User user);
    User getUser(int id);
}
