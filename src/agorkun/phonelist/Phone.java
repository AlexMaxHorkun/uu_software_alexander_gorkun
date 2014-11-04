package agorkun.phonelist;

/**
 * @author Alexander Gorkun.
 */
public class Phone {
    private int id;
    private String name;
    private String lastname;
    private String phone;

    public Phone(){}

    public Phone(int id, String name, String lname, String p){
        this();
        this.id=id;
        this.name=name;
        lastname=lname;
        phone=p;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
