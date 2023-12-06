package space.haobingo.dao.role;

import space.haobingo.pojo.Role;

import java.sql.Connection;
import java.util.List;

public interface RoleDao {
    public List<Role> getRoleList(Connection connection) throws Exception;
}
