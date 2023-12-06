package space.haobingo.dao.role;

import space.haobingo.dao.BaseDao;
import space.haobingo.pojo.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoleDaoImpl implements RoleDao{
    public List<Role> getRoleList(Connection connection) throws Exception {
        List<Role> roleList = new ArrayList<Role>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        if(connection!=null){
            String sql = "select * from smbms.smbms_role";
            Object [] params = {};
            resultSet = BaseDao.execute(resultSet, connection, preparedStatement, sql, params);
            while(resultSet.next()){
                Role _role = new Role();
                _role.setId(resultSet.getInt("id"));
                _role.setRoleCode(resultSet.getString("roleCode"));
                _role.setRoleName(resultSet.getString("roleName"));
                roleList.add(_role);
            }
        }
        BaseDao.closeResource(null,preparedStatement,resultSet);
        return roleList;
    }
}
