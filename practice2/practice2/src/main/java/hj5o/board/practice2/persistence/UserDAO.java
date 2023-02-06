package hj5o.board.practice2.persistence;

import hj5o.board.practice2.model.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UserDAO {

    @Autowired(required = false)
    private SqlSessionTemplate mybatis;

    public void insertUser(User user) {
        mybatis.insert("insertUser", user);
    }

    public void updateUser(User user) {
        mybatis.update("updateUser", user);
    }

    public void deleteUser(User user) {
        mybatis.delete("deleteUser", user);
    }

    public User getUser(User user) {
        return mybatis.selectOne("getUser", user);
    }

    public List<User> getUserList() {
        return mybatis.selectList("getUserList");
    }
}
