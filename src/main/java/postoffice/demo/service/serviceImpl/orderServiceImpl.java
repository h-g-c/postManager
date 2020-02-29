package postoffice.demo.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import postoffice.demo.dao.OrderDao;
import postoffice.demo.entity.Order;
import postoffice.demo.util.ResultMap;
import postoffice.demo.service.OrderService;

import java.util.List;

@Service
public class orderServiceImpl implements OrderService {
    @Autowired
    OrderDao orderManager;

    @Override
    public ResultMap getAll() {
        return ResultMap.data(orderManager.getAll());
    }

    @Override
    public ResultMap getByUserName(String userName) {
        return ResultMap.data(orderManager.selectByUserName(userName));
    }

    @Override
    public ResultMap getByNewspaperId(int id) {
        List<Order> allNewspaper=orderManager.selectByNewspaperId(id);
        int totalNUmber=0;
        int totalMoney=0;
        for(Order order:allNewspaper)
        {totalNUmber+=order.getGoodsNumber();
        totalMoney+=order.getTotalMoney();
        }
        ResultMap result=new ResultMap();
        result.put("totalMoney",totalMoney);
        result.put("totalNumber",totalNUmber);
        return ResultMap.data(result);
    }

    @Override
    public ResultMap deleteById(int id) {
        try{
            if(orderManager.deleteById(id)==1)
                return ResultMap.errno(0,"success");
            else return ResultMap.errno(-1,"id not exit");

        }catch (Exception e)
        {
            return ResultMap.errno(-1,"delete error");
        }
    }

    @Override
    public ResultMap addOrder(Order order) {
        try{
            return ResultMap.errno(orderManager.insert(order));
        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResultMap.errno(-1,"insert error");
        }
    }

    @Override
    public ResultMap updateById(Order order) {
        try{
            return ResultMap.errno(orderManager.update(order));

        }catch (Exception e){
            return  ResultMap.errno(-1,"update error");
        }
    }

    @Override
    public ResultMap getNewspaperSalesVolume() {

        try{
            return ResultMap.data(orderManager.getNewspaperTotalMoneyAndTotalNumber());

        }catch (Exception e){
            System.out.println(e.getMessage());
            return  ResultMap.errno(-1,"select error");
        }
    }

    @Override
    public ResultMap setOrderIsOver(int id) {
        try{
            return ResultMap.errno(orderManager.setOrderIsOver(id));

        }catch (Exception e){
            return ResultMap.errno(-1,"setOrderIsOver error");
        }
    }
}
