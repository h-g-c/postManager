package postoffice.demo.entity;


import lombok.Data;

@Data
public class Press {
    int id;
    String address;
    String name;
    String represent;



    Press()
    {
        address="";
        name="";
        represent="";
    }




}
