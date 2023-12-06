package space.haobingo.service.user;

import org.junit.Test;
import space.haobingo.dao.BaseDao;
import space.haobingo.dao.user.UserDao;
import space.haobingo.dao.user.UserDaoImpl;
import space.haobingo.pojo.User;

import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class UserServiceImpl implements UserService{

    private UserDao userDao;
    public UserServiceImpl(){
        userDao=new UserDaoImpl();
    }

    public User login(String userCode, String password) {
        Connection connection = null;
        User user = null;
        connection= BaseDao.getConnection();
        try {
            user = userDao.getLoginUser(connection,userCode);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return user;
    }

    public boolean updatePwd(int id, String password) {
        boolean flag = false;
        Connection connection = null;
        System.out.println("service:"+password);
        try {
            connection = BaseDao.getConnection();
            if(userDao.updatePwd(connection,id,password)>0){
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return flag;
    }

    public int getUserCount(String queryUserName, int queryUserRole) {
        int count = 0;
        Connection connection =null;
        try {
            connection = BaseDao.getConnection();
            count = userDao.getUserCount(connection, queryUserName, queryUserRole);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return count;
    }

    public List<User> getUserList(String queryUserName, int queryUserRole, int currentPageNo, int pageSize) {
        List<User> userList = null;
        Connection connection = null;
        System.out.println("queryUserName ---- > " + queryUserName);
        System.out.println("queryUserRole ---- > " + queryUserRole);
        System.out.println("currentPageNo ---- > " + currentPageNo);
        System.out.println("pageSize ---- > " + pageSize);
        connection = BaseDao.getConnection();
        try {
            userList = userDao.getUserList(connection, queryUserName, queryUserRole, currentPageNo, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return userList;
    }

    public Boolean add(User user) {
        boolean flag =false;
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            connection.setAutoCommit(false);
            int updateRows = userDao.add(connection, user);
            System.out.println("准备事务提交");
            connection.commit();
            if(updateRows>0){
                flag = true;
                System.out.println("添加用户成功");
            }else{
                System.out.println("添加用户失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                System.out.println("准备事务回滚");
                connection.rollback();
            } catch (SQLException ex) {
                e.printStackTrace();
                System.out.println("事务回滚失败");
            }
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return flag;
    }

    public User selectUserCodeExist(String userCode) {
        User user = null;
        Connection connection = null;
        try{
            connection = BaseDao.getConnection();
            user= userDao.getLoginUser(connection, userCode);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return user;
    }

    @Override
    public boolean deleteUserById(Integer delId) {
        boolean flag =false;
        Connection connection = null;
        try{
            connection = BaseDao.getConnection();
            int i = userDao.deleteUserById(connection, delId);
            if(i>0){
                flag = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return flag;
    }

    @Override
    public User getUserById(Integer id) {
        User user = null;
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            user = userDao.getUserById(connection, id);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return user;
    }

    @Override
    public Boolean modify(User user) {
        System.out.println("进入UserServiceImpl方法(未验证)---user");
        Boolean flag = false;
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();
            connection.setAutoCommit(false);
            int updateNum = userDao.modify(connection, user);
            connection.commit();
            if(updateNum>0){
                flag = true;
                System.out.println("进入UserServiceImpl方法");
                System.out.println("修改用户成功");
            }else{
                System.out.println("修改用户失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("修改失败，回滚事务");
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        System.out.println("退出UserServiceImpl方法---user");
        return flag;
    }
//    @Test
//    public void test() throws Exception {
//        UserServiceImpl userService = new UserServiceImpl();
//        User user = userDao.getUserById(BaseDao.getConnection(), 19);
//        System.out.println(user.toString());
//        System.out.println("-------------------------------");
//        user.setUserName("张三");
//        boolean modify = userService.modify(user);
//        if(modify){
//            System.out.println(user.toString());
//        }
//    }


//    @Test
//    public void test(){
//        UserServiceImpl userService = new UserServiceImpl();
//        User user = userService.getUserById(19);
//        System.out.println(user.toString());
//    }

//    @Test
//    public void test(){
//        UserServiceImpl userService = new UserServiceImpl();
//        boolean b = userService.deleteUserById(8);
//        if (b){
//            System.out.println("删除成功");
//        }
//    }

//    @Test
//    public void test(){
//        UserServiceImpl userService = new UserServiceImpl();
//        User user = userService.login("wen", "34543");
//        System.out.println(user.getUserPassword());
//    }

//    @Test
//    public void test(){
//        UserServiceImpl userService = new UserServiceImpl();
//        int userCount = userService.getUserCount(null, 0);
//        System.out.println(userCount);
//    }


//    @Test
//    public void test(){
//        UserServiceImpl userService = new UserServiceImpl();
//        User user = new User();
//        user.setUserCode("haobing");
//        user.setUserName("haobing");
//        user.setUserPassword("1111111");
//        user.setGender(2);
//        user.setBirthday(new Date(1438692801));
//        user.setPhone("15879634456");
//        user.setAddress("北京");
//        user.setUserRole(1);
//        user.setCreatedBy(2);
//        user.setCreationDate(new Date(1438693801));
//        userService.add(user);
//        int userCount = userService.getUserCount(null, 0);
//        System.out.println(userCount);
//    }

//    @Test
//    public void test() throws ParseException {
////        System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
//        boolean flag = false;
//        System.out.println(flag);
//        System.out.println(!flag);
//    }
}
