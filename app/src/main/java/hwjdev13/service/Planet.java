package hwjdev13.service;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Table( name= "planet")
@Entity

public class Planet {
    @Id
    private String id;
    @Column
    private String name;

    @OneToMany(mappedBy="planetFrom")
    private List<Ticket> ticketsFrom;
    @OneToMany(mappedBy="planetTo")
    private List<Ticket> ticketsTo;
     public Planet(){

    }
    public Planet(String id, String name){
        this.id=id;
        this.name=name;
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
