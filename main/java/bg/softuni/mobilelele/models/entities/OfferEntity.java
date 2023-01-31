package bg.softuni.mobilelele.models.entities;

import bg.softuni.mobilelele.models.enums.Engine;
import bg.softuni.mobilelele.models.enums.Trasmission;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "offers")
public class OfferEntity extends BaseEntity {

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column
    private Engine engine;

    @Column(name = "image_url")
    private String imageUrl;

    @Column
    private Integer mileage;

    @Column
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @Column
    private Trasmission trasmission;
    //year of offered car
    @Column
    private Integer year;

    @Column
    private LocalDateTime created;

    @Column
    private LocalDateTime modified;

    @ManyToOne
   private ModelEntity model;

   @ManyToOne
   private UserEntity seller;

}
