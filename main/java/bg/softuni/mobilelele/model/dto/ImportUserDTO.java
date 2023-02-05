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
public class ImportUserDTO {

    @Expose
    @NotBlank
    @Size(min = 5, max = 15)
    private String username;

    @Expose
    @NotBlank
    @Size(min = 8, max = 800)
    private String password;

    @Expose
    @NotBlank
    @Size(min = 5, max = 100)
    private String firstName;

    @Expose
    @NotBlank
    @Size(min = 5, max = 100)
    private String lastName;

    @Expose
    private String imageUrl;
}
