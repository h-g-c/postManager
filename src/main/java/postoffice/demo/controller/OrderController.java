package postoffice.demo.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import postoffice.demo.entity.Order;
import postoffice.demo.util.ResultMap;
import postoffice.demo.service.OrderService;

@RestController
@RequestMapping(value = "/postoffice/order",method = RequestMethod.POST)
@Api(value = "进行订单的展示以及修改")
public class OrderController {
    @Autowired
    OrderService orderService;

    @ApiOperation(value = "获取订单的所有信息",notes = "成功返回0,失败返回-1")
    @RequestMapping(value = "/getAll",produces = "application/json")
    public ResultMap getAll()
    {
        return orderService.getAll();
    }


    @ApiOperation(value = "通过订单的id号删除订单",notes = "成功返回0,失败返回-1")
    @RequestMapping(value = "/deleteById")
    public ResultMap deleteById(Integer orderId)
    { if(orderId==null)
        return ResultMap.errno(-1,"Cannot get value");
        return orderService.deleteById(orderId);
    }

    @ApiOperation(value = "通过订单的id 修改订单",notes = "成功返回0,失败返回-1")
    @RequestMapping(value = "/updateOrder",produces = "application/json")
    public ResultMap update(@RequestBody Order order)  {

        return orderService.updateById(order);
    }
    @ApiOperation(value = "生成一份订单,一般不调用,报纸的生成一般通过购物车中物品直接生成",notes = "成功返回0,失败返回-1")
    @RequestMapping(value = "/addOrder",produces = "application/json")
    public ResultMap addOrder(@RequestBody Order order)
    {order.ToString();
        return orderService.addOrder(order);
    }

    @ApiOperation(value = "通过某用户的用户名,获取他的所有订单",notes = "成功返回0,失败返回-1")
    @RequestMapping(value = "/getByUserName")
    public ResultMap getByUserName(String userName)
    {
        if(userName==null)
            return ResultMap.errno(-1,"Cannot get value");
        return orderService.getByUserName(userName);

    }

    @ApiOperation(value = "报纸的总销量和销量金额",notes = "成功返回0,失败返回-1")
    @RequestMapping(value = "/getByNewspaperInformation",produces = "application/json")
    public ResultMap getByNewspaperId(Integer newspaperId)
    {
        if(newspaperId==null)
            return ResultMap.errno(-1,"Cannot get value");
        return orderService.getByNewspaperId(newspaperId);
    }
    @ApiOperation(value = "得到所有报纸的总销售额",notes = "成功返回0,失败返回-1")
    @RequestMapping(value = "/getNewspaperSalesVolume",produces = "application/json")
    public ResultMap getSalesVolume()
    {
        return orderService.getNewspaperSalesVolume();
    }

    @ApiOperation(value = "将该订单转化为已处理完成",notes = "成功返回0,失败返回-1")
    @RequestMapping(value = "/setOrderIsOver")
    public ResultMap setOrderIsOver(Integer orderId)
    {
        if(orderId==null)
            return ResultMap.errno(-1,"Cannot get value");
        return orderService.setOrderIsOver(orderId);
    }



}
