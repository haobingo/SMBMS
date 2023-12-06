package space.haobingo.dao.user;

import space.haobingo.pojo.User;
import space.haobingo.util.Constants;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    public User getLoginUser(Connection connection,String userCode) throws SQLException;
    public int updatePwd(Connection connection,int id,String userPassword) throws SQLException;
    public int getUserCount(Connection connection,String userName,int userRole) throws Exception;
    public List<User> getUserList(Connection connection,String userName,int userRole,int currentPageNo,int pageSize) throws Exception;

    public int add(Connection connection,User user) throws Exception;

    public int deleteUserById(Connection connection,Integer delId) throws Exception;
    public User getUserById(Connection connection,Integer id) throws Exception;
    public int modify(Connection connection,User user) throws Exception;
}
