package space.haobingo.service.bill;

import org.junit.Test;
import space.haobingo.dao.BaseDao;
import space.haobingo.dao.bill.BillDao;
import space.haobingo.dao.bill.BillDaoImpl;
import space.haobingo.pojo.Bill;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BillServiceImpl implements BillService{

    private BillDao billDao;
    public BillServiceImpl(){
        billDao = new BillDaoImpl();
    }

    public List<Bill> getBillList(Bill bill) {
        List<Bill> billList = new ArrayList<Bill>();
        Connection connection=null;
        System.out.println("query productName ---- > " + bill.getProductName());
        System.out.println("query providerId ---- > " + bill.getProviderId());
        System.out.println("query isPayment ---- > " + bill.getIsPayment());
        try {
            connection=BaseDao.getConnection();
            billList=billDao.getBillList(connection,bill);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return billList;
    }


    public boolean add(Bill bill) {
        boolean flag = false;
        Connection connection = null;
        try {
            connection = BaseDao.getConnection();//获得连接
            connection.setAutoCommit(false);//开启JDBC事务管理
            int updateRows = billDao.add(connection,bill);
            connection.commit();
            if(updateRows > 0){
                flag = true;
                System.out.println("add success!");
            }else{
                System.out.println("add failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                System.out.println("rollback==================");
                connection.rollback();//失败就回滚
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }finally{
            //在service层进行connection连接的关闭
            BaseDao.closeResource(connection, null, null);
        }
        return flag;
    }

    public boolean deleteBillById(String delId) {
        boolean flag=false;
        int delNum=0;
        Connection connection=null;
        try {
            connection=BaseDao.getConnection();
            delNum=billDao.deleteBillById(connection,delId);
            if(delNum>0){
                flag=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return flag;
    }

    public Bill getBillById(String id) {
        Bill bill = new Bill();
        Connection connection=null;
        try {
            connection=BaseDao.getConnection();
            bill = billDao.getBillById(connection, id);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return bill;
    }

    public boolean modify(Bill bill) {
        Boolean flag=false;
        int modifyNum=0;
        Connection connection=null;
        try {
            connection=BaseDao.getConnection();
            modifyNum=billDao.modify(connection,bill);
            if(modifyNum>0){
                flag=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return flag;
    }

}
