package postoffice.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import postoffice.demo.entity.Customer;

import java.util.List;

@Mapper
public interface CustomerDao {
    List<Customer> getAll();
    int insert(Customer user);
    String  getPasswordByUserName(String userName);
    int deleteByUserName(String userName);
    Customer getInformationByUserName(String userName);
    Customer isExistUser(String userName);
    int updateByUserName(Customer customer);
}
