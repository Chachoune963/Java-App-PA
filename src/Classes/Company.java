package Classes;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private int id;
    private String name;
    private String type;
    private String address;
    private List<User> employees;

    public Company(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public Company(int id, String name, String type, String address) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.address = address;
        this.employees = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void addEmployee(User user)
    {
        this.employees.add(user);
    }

    public void removeEmployee(User user)
    {
        this.employees.remove(user);
    }

    public List<User> getEmployees()
    {
        return this.employees;
    }

    public User getSuper()
    {
        for (int i = 0; i < employees.size(); ++i)
        {
            if (employees.get(i).getStatus() == User.STATUS_SUPER)
            {
                return employees.get(i);
            }
        }
        return null;
    }
}
