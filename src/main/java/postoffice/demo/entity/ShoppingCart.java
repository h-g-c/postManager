package postoffice.demo.entity;
import lombok.Data;

@Data
public class ShoppingCart {

    int id;
    int newspaperId;
    int number;
    int totalMoney;
    String userName;
    int price;


}
