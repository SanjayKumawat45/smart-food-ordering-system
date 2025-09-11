package models;

public class Customer extends User {
    private String address;
    private String phoneNumber;

    public Customer(){
        super();
        this.address = "Not Provided";
        this.phoneNumber = "000000000";
    }

    public Customer(int id, String name, String email, String password, String address, String phoneNumber) {
        super(id, name, email, password);
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString(){
        return "Customer {" +
                "id=" + getId() +
                ", name ='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}


