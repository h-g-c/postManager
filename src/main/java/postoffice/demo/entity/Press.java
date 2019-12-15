package postoffice.demo.entity;

public class Press {
    int id;
    String address;
    String name;
    String represent;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    Press()
    {
        address="";
        name="";
        represent="";
    }




}
