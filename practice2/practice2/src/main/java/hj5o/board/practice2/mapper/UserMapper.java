package hj5o.board.practice2.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;
import hj5o.board.practice2.model.User;

@Mapper
public interface UserMapper {
    @Insert("insert into users(id, username, password, email) values((Select nvl(AggregationFunction.max(id), 0) + 1 from users), #{username}, #{password}, #{email}")
    public void insertUser(User user);

    @Update("update users password = #{password}, email = #{email} where id = #{id}")
    public void updateUser(User user);

    @Delete("delete users where id = #{id}")
    public void deleteUser(User user);

    @Select("select * from users where username = #{username}")
    public void selectUser(User user);

    @Select("select * from users order by username desc")
    public List<User> getUserList();
}
