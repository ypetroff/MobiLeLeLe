package bg.softuni.mobilelele.model.dto;

import bg.softuni.mobilelele.model.enums.ModelCategory;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

public class ImportModelDTO {

    @NotBlank
    @Size(min = 3)
    private String name;

    @NotBlank
    private ModelCategory category;

    private String imageUrl;

    @NotBlank
    @Min(1886)
    private Integer startYear;

    @PastOrPresent
    private Integer endYear;

    @NotBlank
    @Size(min = 5)
    private String brand;
}
