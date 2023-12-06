package space.haobingo.service.user;

import space.haobingo.dao.BaseDao;
import space.haobingo.pojo.User;

import java.util.List;

public interface UserService {
    public User login(String userCode,String password);
    public boolean updatePwd(int id,String password);
    public int getUserCount(String queryUserName,int queryUserRole);
    public List<User> getUserList(String queryUserName,int queryUserRole,int currentPageNo,int pageSize);
    public Boolean add(User user);

    public User selectUserCodeExist(String userCode);

    public boolean deleteUserById(Integer delId);
    public User getUserById(Integer id);
    public Boolean modify(User user);
}
