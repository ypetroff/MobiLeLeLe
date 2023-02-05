package bg.softuni.mobilelele.model.dto;

import bg.softuni.mobilelele.model.enums.Engine;
import bg.softuni.mobilelele.model.enums.Transmission;
import com.google.gson.annotations.Expose;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImportOfferDTO {

    @Expose
    @Size(max = 800)
    private String description;

    @Expose
    private Engine engine;

    @Expose
    private String imageUrl;

    @Expose
    @PositiveOrZero
    private Integer mileage;

    @Expose
    @Positive
    private BigDecimal price;

    @Expose
    private Transmission transmission;

    @Expose
    @Positive
    private Integer year;

    @Expose
    @NotBlank
    private String model;

    @Expose
    @NotBlank
    private String seller;
}
