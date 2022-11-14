package vn.com.vti.entity;

public class Position {

    private int id;

    private String  name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(PositionName name) {
        this.name = String.valueOf(name);
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }

}
