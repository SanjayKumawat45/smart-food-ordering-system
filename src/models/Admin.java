package models;

public class Admin extends User{
    private String role;

    public Admin(){
        super();
        this.role = "System Admin";
    }

    public Admin(int id, String name, String email, String password, String role){
        super(id, name, email, password);
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString(){
        return "Admin {" +
                "id=" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
