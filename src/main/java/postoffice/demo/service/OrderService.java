package postoffice.demo.service;

import postoffice.demo.entity.Order;
import postoffice.demo.result.ResultMap;

public interface OrderService {

    ResultMap getAll();
    ResultMap getByUserName(String userName);
    ResultMap getByNewspaperId(int newspaperId);
    ResultMap deleteById(int orderId);
    ResultMap addOrder(Order order);
    ResultMap updateById(Order order);
    ResultMap getNewspaperSalesVolume();
    ResultMap setOrderIsOver(int id);
}
