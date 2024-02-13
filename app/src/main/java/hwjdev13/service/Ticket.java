package hwjdev13.service;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.checkerframework.checker.units.qual.C;

@Table( name= "ticket")
@Entity
@Data

public class Ticket {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private long id;
    @Column
    private String created_at;//created_at TIMESTAMP

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name="client_id", nullable=false)
      private Client client;


 //   @ToString.Exclude
    @ManyToOne
    @JoinColumn(name="from_planet_id", nullable=false)
    private Planet planetFrom;

  //  @ToString.Exclude
    @ManyToOne
    @JoinColumn(name="to_planet_id", nullable=false)
    private Planet planetTo;


}
