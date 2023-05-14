package Classes;

import java.util.List;

public class User {
    public static int STATUS_BANNED = -1;
    public static int STATUS_NORMAL = 0;
    public static int STATUS_LEADER = 1;
    public static int STATUS_SUPER = 2;

    private int id;
    private String lastname;
    private String firstname;
    private String email;
    private String phonenum;
    private int status;

    private int id_team;
    private int id_comp;

    public User(int id, String lastname, String firstname, String email, String phonenum, int status, int id_team, int id_comp) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.phonenum = phonenum;
        this.status = status;
        this.id_team = id_team;
        this.id_comp = id_comp;
    }

    public int getId() {
        return id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getId_team() {
        return id_team;
    }

    public void setId_team(int id_team) {
        this.id_team = id_team;
    }

    public int getId_comp() {
        return id_comp;
    }

    public void setId_comp(int id_comp) {
        this.id_comp = id_comp;
    }

    @Override
    public String toString() {
        return this.id + ": " + this.firstname + " " + this.lastname + " (" + this.status + "): " + this.email + " & " + this.phonenum;
    }
}
