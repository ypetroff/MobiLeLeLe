package bg.softuni.mobilelele.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "brands")
public class BrandEntity extends BaseEntity {

    @Column
    private String name;

    @Column
    private LocalDateTime created;

    @Column
    private LocalDateTime modified;
}
