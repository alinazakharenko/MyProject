package zakharenko.project.java.beans;

public class Book {

    private long id;
    private String name;
    private String material;
    private String parameter;
    private String client;
    private int number;
    private double date;
    private long users_id;

    public Book() {
    }

    public Book(long id, String name, String material, String parameter, String client, int number, double date, long users_id) {
        this.id = id;
        this.name = name;
        this.material = material;
        this.parameter = parameter;
        this.client = client;
        this.number = number;
        this.date = date;
        this.users_id = users_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getmaterial() {
        return material;
    }

    public void setmaterial(String material) {
        this.material = material;
    }

    public String getparameter() {
        return parameter;
    }

    public void setparameter(String parameter) {
        this.parameter = parameter;
    }

    public String getclient() {
        return client;
    }

    public void setclient(String client) {
        this.client = client;
    }

    public int getnumber() {
        return number;
    }

    public void setnumber(int number) {
        this.number = number;
    }

    public double getdate() {
        return date;
    }

    public void setdate(double date) {
        this.date = date;
    }

    public long getUsers_id() {
        return users_id;
    }

    public void setUsers_id(long users_id) {
        this.users_id = users_id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", material='" + material + '\'' +
                ", parameter='" + parameter + '\'' +
                ", client='" + client + '\'' +
                ", number=" + number +
                ", date=" + date +
                ", users_id=" + users_id +
                '}';
    }
}