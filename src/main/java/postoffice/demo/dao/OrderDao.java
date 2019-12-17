package postoffice.demo.dao;

import postoffice.demo.entity.Customer;
import postoffice.demo.entity.Order;

import java.util.List;
import java.util.Map;

public interface OrderDao {

    List<Order> getAll();

    int deleteById(int id);

    int insert(Order order);

    int update(Order order);

    List<Order> selectByNewspaperId(int id);

    List<Map<String, Object>> getNewspaperTotalMoneyAndTotalNumber();

    List<Order> selectByUserName(String userName);

    int setOrderIsOver(int orderId);

    int updateByUserName(Customer user);
}