package hwjdev13.service;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import java.util.List;
import java.util.Objects;
import java.util.Set;

@Table( name= "client")
@Entity
@Data

public class Client {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private long id;
    @Column
    private String name;

    @OneToMany(mappedBy="client", fetch = FetchType.EAGER)  //, fetch = FetchType.LAZY
     private List<Ticket> tickets;


}
