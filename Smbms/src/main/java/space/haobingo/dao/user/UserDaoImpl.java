package space.haobingo.dao.user;

import com.mysql.cj.util.StringUtils;
import space.haobingo.dao.BaseDao;
import space.haobingo.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    public User getLoginUser(Connection connection, String userCode) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        User user = null;
        if (connection != null) {
            String sql = "select * from smbms.smbms_user where userCode = ?";
            Object[] params = {userCode};
            rs = BaseDao.execute(rs, connection, preparedStatement, sql, params);
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUserCode(rs.getString("userCode"));
                user.setUserName(rs.getString("userName"));
                user.setUserPassword(rs.getString("userPassword"));
                user.setGender(rs.getInt("gender"));
                user.setBirthday(rs.getDate("birthday"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setUserRole(rs.getInt("userRole"));
                user.setCreatedBy(rs.getInt("createdBy"));
                user.setCreationDate(rs.getTimestamp("creationDate"));
                user.setModifyBy(rs.getInt("modifyBy"));
                user.setModifyDate(rs.getTimestamp("modifyDate"));
            }
            BaseDao.closeResource(null, preparedStatement, rs);
        }
        return user;
    }

    public int updatePwd(Connection connection, int id, String userPassword) throws SQLException {
        int updateRows = 0;
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            String sql = "update   smbms.smbms_user  set  userPassword =? where  id =? ";
            Object[] params = {userPassword, id};
            updateRows = BaseDao.execute(connection, preparedStatement, sql, params);
        }
        System.out.println("dao:"+userPassword);
        BaseDao.closeResource(null, preparedStatement, null);
        return updateRows;
    }

    public int getUserCount(Connection connection, String userName, int userRole) throws Exception {
        int count =0;
        PreparedStatement preparedStatement =null;
        ResultSet resultSet = null;
        if(connection!=null){
            StringBuffer sql = new StringBuffer();
            sql.append("select count(1) as count from smbms.smbms_user u ,smbms.smbms_role r where u.userRole=r.id");
            ArrayList<Object> list = new ArrayList<Object>();
            if(!StringUtils.isNullOrEmpty(userName)){
                sql.append(" and u.userName like %");
                list.add("%"+userName+"%");
            }
            if(userRole>0&&userRole<4){
                sql.append(" and u.userRole = ?");
                list.add(userRole);
            }
            Object[] params = list.toArray();
            System.out.println("当前的sql语句为------------>"+sql);
            resultSet = BaseDao.execute(resultSet, connection, preparedStatement, sql.toString(), params);

            if(resultSet.next()){
                count = resultSet.getInt("count");
            }
            BaseDao.closeResource(null,preparedStatement,resultSet);
        }
        return count;
    }

    public List<User> getUserList(Connection connection, String userName, int userRole, int currentPageNo, int pageSize) throws Exception {
        ArrayList<User> userList = new ArrayList<User>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        if(connection!=null){
            StringBuffer sql = new StringBuffer();
            sql.append("select u.*,r.roleName as userRoleName from smbms.smbms_user u,smbms.smbms_role r where u.userRole = r.id");
            List<Object> list = new ArrayList<Object>();
            if(!StringUtils.isNullOrEmpty(userName)){
                sql.append(" and u.userName like ?");
                list.add("%"+userName+"%");
            }
            if(userRole>0&&userRole<4){
                sql.append(" and u.userRole = ?");
                list.add(userRole);
            }
            sql.append(" order by creationDate DESC limit ?,?");
            currentPageNo = (currentPageNo -1)*pageSize;
            list.add(currentPageNo);
            list.add(pageSize);
            Object [] params = list.toArray();
            System.out.println("sql ----> " + sql.toString());
            resultSet = BaseDao.execute(resultSet, connection, preparedStatement, sql.toString(), params);
            while(resultSet.next()){
                User _user = new User();
                _user.setId(resultSet.getInt("id"));
                _user.setUserCode(resultSet.getString("userCode"));
                _user.setUserName(resultSet.getString("userName"));
                _user.setGender(resultSet.getInt("gender"));
                _user.setBirthday(resultSet.getDate("birthday"));
                _user.setPhone(resultSet.getString("phone"));
                _user.setUserRole(resultSet.getInt("userRole"));
                _user.setUserRoleName(resultSet.getString("userRoleName"));
                userList.add(_user);
            }
            BaseDao.closeResource(null,preparedStatement,resultSet);
        }
        return userList;
    }

    public int add(Connection connection, User user) throws Exception {
        int updateNum = 0;
        PreparedStatement preparedStatement = null;
        if(connection!=null){
            String sql = "insert into  smbms.smbms_user\n" +
                    "(userCode,userName,userPassword,gender,birthday,phone,address,userRole,createdBy,creationDate)\n" +
                    "values\n" +
                    "(?,?,?,?,?,?,?,?,?,?)";
            Object[] params = {
                    user.getUserCode(),
                    user.getUserName(),
                    user.getUserPassword(),
                    user.getGender(),
                    user.getBirthday(),
                    user.getPhone(),
                    user.getAddress(),
                    user.getUserRole(),
                    user.getCreatedBy(),
                    user.getCreationDate()
            };
            updateNum = BaseDao.execute(connection,preparedStatement,sql,params);
            BaseDao.closeResource(null,preparedStatement,null);
        }
        return updateNum;
    }

    public int deleteUserById(Connection connection, Integer delId) throws Exception {
        PreparedStatement preparedStatement = null;
        int deleteNum =0;
        if(connection!=null){
            String sql = "delete from smbms.smbms_user where id = ?";
            Object [] params = {delId};
            deleteNum = BaseDao.execute(connection, preparedStatement, sql, params);
            BaseDao.closeResource(null,preparedStatement,null);
        }
        return deleteNum;
    }

    @Override
    public User getUserById(Connection connection, Integer id) throws Exception {
        User user = new User();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        if(connection!=null){
            String sql = "select u.*,r.roleName as userRoleName from smbms.smbms_user u , smbms.smbms_role r where u.id = ? and u.userRole = r.id";
            Object [] params = {id};
            resultSet = BaseDao.execute(resultSet,connection,preparedStatement,sql,params);
            while(resultSet.next()){
                user.setId(resultSet.getInt("id"));
                user.setUserCode(resultSet.getString("userCode"));
                user.setUserName(resultSet.getString("userName"));
                user.setUserPassword(resultSet.getString("userPassword"));
                user.setGender(resultSet.getInt("gender"));
                user.setBirthday(resultSet.getDate("birthday"));
                user.setPhone(resultSet.getString("phone"));
                user.setAddress(resultSet.getString("address"));
                user.setUserRole(resultSet.getInt("userRole"));
                user.setCreatedBy(resultSet.getInt("createdBy"));
                user.setCreationDate(resultSet.getDate("creationDate"));
                user.setModifyBy(resultSet.getInt("modifyBy"));
                user.setModifyDate(resultSet.getDate("modifyDate"));
                user.setUserRoleName(resultSet.getString("userRoleName"));
            }
            BaseDao.closeResource(null,preparedStatement,resultSet);
        }
        return user;
    }

    @Override
    public int modify(Connection connection, User user) throws Exception {
        System.out.println("进入UserDaoImpl方法(验证有效)---user");
        int updateNum = 0;
        PreparedStatement preparedStatement = null;
        if(connection!=null){
            System.out.println("进入UserDaoImpl方法---user");
            String sql = "update smbms.smbms_user set " +
                    "userName = ?,gender = ?, birthday = ?," +
                    "phone = ?,address = ?,userRole = ?,modifyBy = ?," +
                    "modifyDate = ? where id =?";
            Object [] params =
                    {user.getUserName(),
                    user.getGender(),
                    user.getBirthday(),
                    user.getPhone(),
                    user.getAddress(),
                    user.getUserRole(),
                    user.getModifyBy(),
                    user.getModifyDate(),
                    user.getId()};
            updateNum = BaseDao.execute(connection, preparedStatement, sql, params);
            BaseDao.closeResource(null,preparedStatement,null);
            System.out.println("sql---------->"+sql);
        }
        System.out.println("退出UserDaoImpl方法---user");
        return updateNum;
    }
}
