package space.haobingo.service.role;

import org.junit.Test;
import space.haobingo.dao.BaseDao;
import space.haobingo.dao.role.RoleDao;
import space.haobingo.dao.role.RoleDaoImpl;
import space.haobingo.pojo.Role;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class RoleServiceImpl implements RoleService{
    private RoleDao roleDao;
    public RoleServiceImpl(){
        roleDao = new RoleDaoImpl();
    }
    public List<Role> getRoleList() {
        List<Role> roleList = null;
        Connection connection = null;

        try {
            connection = BaseDao.getConnection();
            roleList = roleDao.getRoleList(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return roleList;
    }

//    @Test
//    public  void test(){
//        RoleServiceImpl roleService = new RoleServiceImpl();
//        List<Role> roleList = roleService.getRoleList();
//        for(Role role : roleList){
//            System.out.println(role.getRoleName());
//        }
//    }
}

