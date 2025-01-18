package model;

import java.util.List;
import org.apache.ibatis.annotations.*;

public interface User {
    @Select("SELECT * FROM users")
    List<User> getAllUsers();
    
    @Insert("INSERT INTO Users (name, email) VALUES (#{name}, #{email})")
    void insertUser(User user);
}
