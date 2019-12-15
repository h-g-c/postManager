package postoffice.demo.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import postoffice.demo.dao.CustomerDao;
import postoffice.demo.dao.NewspaperDao;
import postoffice.demo.dao.ShoppingCartDao;
import postoffice.demo.entity.Newspaper;
import postoffice.demo.entity.Order;
import postoffice.demo.entity.ShoppingCart;
import postoffice.demo.result.ResultMap;
import postoffice.demo.service.OrderService;
import postoffice.demo.service.ShoppingCartService;

import java.util.Map;

@Service
public class shoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    ShoppingCartDao cartManager;
    @Autowired
    NewspaperDao newspaperManager;
    @Autowired
    CustomerDao customerManager;
    @Autowired
    OrderService orderService;

    @Override
    public ResultMap getMyCart(String userName) {
        try {
            return ResultMap.data(cartManager.getByUserName(userName));
        } catch (Exception e) {
            return ResultMap.errno(-1, "select error");
        }
    }

    @Override
    public ResultMap addGoods(ShoppingCart newCart) {
        try {
            Newspaper goods = newspaperManager.getById(newCart.getNewspaperId());
            if (goods == null ||newCart.getNumber() <= 0)
                return ResultMap.errno(-1, "goods number  error or newspaperId not exits ");
            if (cartManager.getByUserNameAndNewspaperId(newCart.getNewspaperId(), newCart.getUserName()) == null) {
                newCart.setPrice(goods.getPrice());
                newCart.setTotalMoney(newCart.getNumber() * newCart.getPrice());
                return ResultMap.errno(cartManager.addGoods(newCart));
            } else {

                return changeGoodsNumber(newCart.getUserName(),newCart.getNewspaperId(), newCart.getNumber());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResultMap.errno(-1, "insert error");
        }
    }

    @Override
    public ResultMap deleteCart(String userName,Integer newspaperId) {
        try {
            int values;
            values = cartManager.delete(userName,newspaperId);
            return ResultMap.errno(values);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResultMap.errno(-1, "delete error");
        }
    }

    @Override
    public ResultMap changeGoodsNumber(String userName,Integer newspaperId,Integer number) {
        try {
            ShoppingCart cart = cartManager.getByUserNameAndNewspaperId(newspaperId,userName);
            if (cart == null)
                return ResultMap.errno(-1, "userName or newspaperId not exit");
            ResultMap result = new ResultMap();
            if (cart.getNumber() + number <=0)
                return ResultMap.errno(-1, "商品数量不能小于等于0");
            result.put("userName", cart.getUserName());
            result.put("newspaperId", cart.getNewspaperId());
            result.put("number", cart.getNumber() +number);
            result.put("totalMoney", cart.getTotalMoney() + number* cart.getPrice());
            return ResultMap.errno(cartManager.changeGoodsNumber(result));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResultMap.errno(-1, "delete error");
        }
    }

    @Override
    public ResultMap generateOrder(String userName,Integer newspaperId) {
        try {
            ShoppingCart cart = cartManager.getByUserNameAndNewspaperId(newspaperId,userName);
            Newspaper newspaper=newspaperManager.getById(newspaperId);
            if (cart == null||newspaper==null)
                return ResultMap.errno(-1, "userName or newspaperId not exit");
            if(cart.getNumber()>newspaper.getNumber())
                return ResultMap.errno(-1,"newspaper number not enough");
            newspaper.setNumber(newspaper.getNumber()-cart.getNumber());
            Order order = new Order();
            order.setNewspaperId(cart.getNewspaperId());
            order.setCustomerName(customerManager.getInformationByUserName(cart.getUserName()).getReallyName());
            order.setTotalMoney(cart.getTotalMoney());
            order.setGoodsNumber(cart.getNumber());
            order.setUserName(cart.getUserName());
            order.setReceivingAddress(customerManager.getInformationByUserName(cart.getUserName()).getUserAddress());
            order.setCustomerPhoneNumber(customerManager.getInformationByUserName(cart.getUserName()).getPhoneNumber());
            order.setOver(false);
            ResultMap result= orderService.addOrder(order);
            newspaperManager.update(newspaper);
            deleteCart(userName,newspaperId);
            return result;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResultMap.errno(-1, "generateOrder error");
        }
    }
}
