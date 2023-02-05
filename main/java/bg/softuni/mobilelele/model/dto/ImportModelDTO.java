package bg.softuni.mobilelele.model.dto;

import bg.softuni.mobilelele.model.enums.ModelCategory;
import com.google.gson.annotations.Expose;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImportModelDTO {

    @Expose
    @NotBlank
    @Size(min = 3)
    private String name;

    @Expose
    @NotBlank
    private ModelCategory category;

    @Expose
    private String imageUrl;

    @Expose
    @NotBlank
    @Min(1886)
    private Integer startYear;

    @Expose
    @PastOrPresent
    private Integer endYear;

    @Expose
    @NotBlank
    @Size(min = 5)
    private String brand;
}
