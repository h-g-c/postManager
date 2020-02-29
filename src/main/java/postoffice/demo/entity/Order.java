package postoffice.demo.entity;


import lombok.Data;

@Data
public class Order {
int id;
int newspaperId;
String customerName;
String userName;
    int totalMoney;
    int goodsNumber;
    boolean over;
    String receivingAddress;
    String customerPhoneNumber;

    public void  ToString()
    {
        System.out.println(
                "customerName:"+customerName+"\n"+
            " customerPhoneNumber:"+customerPhoneNumber+ "\n"+
            "goodsNumber:"+ goodsNumber+"\n"+
            "id:"+id+"\n"+
            "newspaperId:"+newspaperId+"\n"+
            "isOver:"+ over+"\n"+
            "receivingAddress:"+receivingAddress+"\n"+
            "totalMoney:"+totalMoney+"\n" +
            "userName:"+userName+"\n"
);

    }





}
