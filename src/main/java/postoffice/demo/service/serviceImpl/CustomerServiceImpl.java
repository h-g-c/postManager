package postoffice.demo.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import postoffice.demo.dao.CustomerDao;
import postoffice.demo.dao.OrderDao;
import postoffice.demo.dao.ShoppingCartDao;
import postoffice.demo.entity.Customer;
import postoffice.demo.util.ResultMap;
import postoffice.demo.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDao customerManager;
    @Autowired
    ShoppingCartDao shoppingManager;
    @Autowired
    OrderDao orderManager;

    @Override
    public ResultMap addUser(Customer user) {
        if (customerManager.isExistUser(user.getUserName()) != null){
            return ResultMap.errno(-1, "user is exit");
        }
        else {
            try {
           return ResultMap.errno(customerManager.insert(user));
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return ResultMap.errno(-1, "insert error");
            }
        }
    }

    @Override
    public ResultMap deleteByUserName(String userName) {
try{
    if(customerManager.deleteByUserName(userName)==1) {
    return ResultMap.errno(0,"success");
    }
    else {
        return ResultMap.errno(-1, "user does not exist");
    }
    }catch (Exception e) {
    return ResultMap.errno(-1,"delete error");
    }
    }

    @Override
    public ResultMap getUserInformation(String userName) {
        System.out.println(userName);
        if (customerManager.isExistUser(userName) == null)
            return ResultMap.errno(-1, "user does not exist");
        else return ResultMap.data(customerManager.getInformationByUserName(userName));
    }

    @Override
    public ResultMap signIn(String userName, String password) {
        if (password.equals(customerManager.getPasswordByUserName(userName)))
            return ResultMap.errno(0, "loginIn success");
        else return ResultMap.errno(-1, "Wrong account or password");
    }

    @Override
    public ResultMap update(Customer user) {
        try{
            if(customerManager.updateByUserName(user)==1)
            {  orderManager.updateByUserName(user);
                return ResultMap.errno(0,"success");}
            else return ResultMap.errno(-1,"user does not exist");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return ResultMap.errno(-1,"update error");
        }
    }
}
