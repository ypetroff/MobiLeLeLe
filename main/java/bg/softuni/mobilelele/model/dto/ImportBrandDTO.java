package bg.softuni.mobilelele.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class ImportBrandDTO {

    @Size(min = 5)
    private String name;

    @NotEmpty
    private String created;

    @NotEmpty
    private String modified;
}
