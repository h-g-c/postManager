package postoffice.demo.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import postoffice.demo.entity.ShoppingCart;
import postoffice.demo.util.ResultMap;
import postoffice.demo.service.ShoppingCartService;
@RestController
@RequestMapping(value = "/postoffice/cart",method = RequestMethod.POST)
@Api(value = "购物车中的内容进行管理")
public class ShoppingCartController {
@Autowired
ShoppingCartService shoppingCartService;
//
//    @ApiOperation(value = "获取某人的购物车中所有的内容",notes = "成功返回0,失败返回-1")
//    @RequestMapping(value = "/getMyCart",produces = "application/json")
//    public ResultMap getMyCart(@RequestBody Map<String ,Object> map)
//    {
//        if(map.get("userName")==null)
//            return ResultMap.errno(-1,"Cannot get value");
//        return shoppingCartService.getMyCart(map.get("userName").toString());
//    }

    @ApiOperation(value = "获取某人的购物车中所有的内容",notes = "成功返回0,失败返回-1")
    @RequestMapping(value = "/getMyCart")
    public ResultMap getMyCart(String userName)
    {
        if(userName==null)
            return ResultMap.errno(-1,"Cannot get value");
        return shoppingCartService.getMyCart(userName);
    }

    @ApiOperation(value = "向购物车中增加物品",notes = "成功返回0,失败返回-1")
    @RequestMapping(value = "/addGoods",produces = "application/json")
    public ResultMap addGoods(@RequestBody ShoppingCart cart)
    {
        return shoppingCartService.addGoods(cart);
    }

    @ApiOperation(value = "改变购物车中已有物品的数量",notes = "成功返回0,失败返回-1")
    @RequestMapping(value = "/changeGoodsNumber")
    public ResultMap change(String userName, Integer newspaperId, Integer number)
    { if(userName==null||newspaperId==null||number==null)
        return ResultMap.errno(-1,"values is null");
        return shoppingCartService.changeGoodsNumber(userName, newspaperId, number);
    }

    @ApiOperation(value = "将某人购物车中某样物品删除",notes = "成功返回0,失败返回-1")
    @RequestMapping(value = "/deleteCart")
    public ResultMap delete(String userName, Integer newspaperId)
    {
        if(userName==null||newspaperId==null)
            return ResultMap.errno(-1,"values is null");
        return shoppingCartService.deleteCart(userName, newspaperId);
    }

    @ApiOperation(value = "将购物车中的某样物品购买，即将其生成订单",notes = "成功返回0,失败返回-1")
    @RequestMapping(value = "/generateOrder")
    public ResultMap generateOrder( String userName,Integer newspaperId)
    {  if(userName==null||newspaperId==null)
        return ResultMap.errno(-1,"values is null");
        return shoppingCartService.generateOrder(userName, newspaperId);
    }
}
