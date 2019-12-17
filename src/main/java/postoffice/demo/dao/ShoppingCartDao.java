package postoffice.demo.dao;

import postoffice.demo.entity.Customer;
import postoffice.demo.entity.Newspaper;
import postoffice.demo.entity.ShoppingCart;

import java.util.List;
import java.util.Map;

public interface ShoppingCartDao {

    List<ShoppingCart> getByUserName(String userName);
    int addGoods(ShoppingCart shoppingCart);
    int update(Map<String ,Object> map);
    int changeGoodsNumber(Map<String ,Object> map);
    int delete(String userName,Integer newspaperId);
    ShoppingCart getByUserNameAndNewspaperId(int newspaperId, String userName);
    int updateByNewspaperId(Newspaper newspaper);
    int deleteByNewspaperId(int id);

}
