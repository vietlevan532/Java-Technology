package POJO;

import javax.persistence.Entity;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Manufacture {
    public String name, location;
    public int id, employee;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setEmployee(int employee) {
        this.employee = employee;
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 120)
    public String getName() {
        return name;
    }

    @Basic
    @Column(name = "location", nullable = false, length = 120)
    public String getLocation() {
        return location;
    }

    @Basic
    @Column(name = "employee", nullable = false)
    public int getEmployee() {
        return employee;
    }

    @Override
    public String toString() {
        return "Manufacture{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", id=" + id +
                ", employee=" + employee +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manufacture that = (Manufacture) o;
        return id == that.id && employee == that.employee && name.equals(that.name) && location.equals(that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location, id, employee);
    }

    public void showInfo() {
        System.out.println(this);
    }
}
