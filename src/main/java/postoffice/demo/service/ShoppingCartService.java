package postoffice.demo.service;

import postoffice.demo.entity.ShoppingCart;
import postoffice.demo.result.ResultMap;

import java.util.Map;

public interface ShoppingCartService {
    ResultMap getMyCart(String userName);
    ResultMap addGoods(ShoppingCart cart);
    ResultMap deleteCart(String userName,Integer newspaperId);
    ResultMap changeGoodsNumber(String userName,Integer newspaperId,Integer number);
    ResultMap generateOrder(String userName,Integer newspaperId);
}
