package postoffice.demo.entity;


import lombok.Data;

@Data
public class Newspaper {
int id;
String categories;
int price;
int number;



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
