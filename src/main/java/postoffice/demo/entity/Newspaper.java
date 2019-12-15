package postoffice.demo.entity;


import lombok.Data;


public class Newspaper {
int id;
String categories;
int price;
int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRepresent() {
        return represent;
    }

    public void setRepresent(String represent) {
        this.represent = represent;
    }

    public int getPressId() {
        return pressId;
    }

    public void setPressId(int pressId) {
        this.pressId = pressId;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    String name;
String represent;
int pressId;
int postalCode;

Newspaper()
{
    name="";
    represent="";
    pressId=0;
    postalCode=0;
    categories="";
    price=0;
    number=0;
}

}
