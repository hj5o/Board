package hj5o.board.practice2;

import hj5o.board.practice2.model.User;
import hj5o.board.practice2.persistence.UserDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserDAOTest {

    @Autowired
    private UserDAO userDAO;

    @Test
    void getUserListTest() {
        User user = new User();
        user.setUsername("test");
        user.setPassword("testpw");
        user.setEmail("test@gmail.com");

        int before = userDAO.getUserList().size();
        userDAO.insertUser(user);
        int after = userDAO.getUserList().size();

        System.out.println(before + " " + after);
    }
}
