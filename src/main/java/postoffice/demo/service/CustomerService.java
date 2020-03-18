package postoffice.demo.service;

import postoffice.demo.entity.Customer;
import postoffice.demo.util.ResultMap;


public interface CustomerService {
    ResultMap addUser(Customer user);
    ResultMap deleteByUserName(String userName);
    ResultMap getUserInformation(String userName);
    boolean signIn(String userName, String password);
    ResultMap update(Customer user);
}
