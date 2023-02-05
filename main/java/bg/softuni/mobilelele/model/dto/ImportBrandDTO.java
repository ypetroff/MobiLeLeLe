package bg.softuni.mobilelele.model.dto;

import com.google.gson.annotations.Expose;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImportBrandDTO {

    @Expose
    @NotBlank
    @Size(min = 5)
    private String name;

}
