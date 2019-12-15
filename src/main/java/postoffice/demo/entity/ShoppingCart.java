package postoffice.demo.entity;

public class ShoppingCart {

    int id;
    int newspaperId;
    int number;
    int totalMoney;
    String userName;
    int price;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }


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
}
