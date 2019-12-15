package postoffice.demo.entity;




public class Order {
int id;
int newspaperId;
String customerName;
String userName;
    int totalMoney;
    int goodsNumber;
    boolean isOver;
    String receivingAddress;
    String customerPhoneNumber;
    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getNewspaperId() {
        return newspaperId;
    }

    public void setNewspaperId(int newspaperId) {
        this.newspaperId = newspaperId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }

    public int getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(int goods_number) {
        this.goodsNumber = goods_number;
    }

    public boolean isOver() {
        return isOver;
    }

    public void setOver(boolean over) {
        isOver = over;
    }

    public String getReceivingAddress() {
        return receivingAddress;
    }

    public void setReceivingAddress(String receivingAddress) {
        this.receivingAddress = receivingAddress;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }


    public void  ToString()
    {
        System.out.println(
                "customerName:"+customerName+"\n"+
            " customerPhoneNumber:"+customerPhoneNumber+ "\n"+
            "goodsNumber:"+ goodsNumber+"\n"+
            "id:"+id+"\n"+
            "newspaperId:"+newspaperId+"\n"+
            "isOver:"+ isOver+"\n"+
            "receivingAddress:"+receivingAddress+"\n"+
            "totalMoney:"+totalMoney+"\n" +
            "userName:"+userName+"\n"
);

    }





}
