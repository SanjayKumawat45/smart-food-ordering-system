package models;

public class User {

    private int id;
    private String name;
    private String email;
    private String password;

    public User(){
        this.id = 0;
        this.name = "Unknown";
        this.email = "not_provided@example.com";
        this.password = "";
    }

    public User (int id, String name, String email, String password){
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString(){
        return "User {" +
                "id =" + id +
                ", name='" + name +'\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
