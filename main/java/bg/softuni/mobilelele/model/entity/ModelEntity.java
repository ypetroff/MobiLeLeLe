package bg.softuni.mobilelele.model.entity;

import bg.softuni.mobilelele.model.enums.ModelCategory;
import jakarta.persistence.*;
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
@Table(name = "models")
public class ModelEntity extends BaseEntity {

    @Column
    private String name;

    @Enumerated(EnumType.STRING)
    @Column
    private ModelCategory category;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "start_year")
    private Integer startYear;

    @Column(name = "end_year")
    private Integer endYear;

    @Column
    private LocalDateTime created;

    @Column
    private LocalDateTime modified;

    @ManyToOne
    private BrandEntity brand;
}
