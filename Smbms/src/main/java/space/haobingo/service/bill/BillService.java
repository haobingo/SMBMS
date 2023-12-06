package space.haobingo.service.bill;

import space.haobingo.pojo.Bill;

import java.util.List;

public interface BillService {
    public boolean add(Bill bill);
    public List<Bill> getBillList(Bill bill);
    public boolean deleteBillById(String delId);

    public Bill getBillById(String id);
    public boolean modify(Bill bill);
}
