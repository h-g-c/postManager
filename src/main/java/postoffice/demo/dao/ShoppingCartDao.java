package postoffice.demo.dao;

import postoffice.demo.entity.ShoppingCart;

import java.util.Map;

public interface ShoppingCartDao {

    ShoppingCart getByUserName(String userName);
    int addGoods(ShoppingCart shoppingCart);
    int update(Map<String ,Object> map);
    int changeGoodsNumber(Map<String ,Object> map);
    int delete(String userName,Integer newspaperId);
    ShoppingCart getByUserNameAndNewspaperId(int newspaperId, String userName);

}
