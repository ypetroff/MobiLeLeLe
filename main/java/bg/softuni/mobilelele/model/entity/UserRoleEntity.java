package bg.softuni.mobilelele.model.entity;

import bg.softuni.mobilelele.model.enums.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_role")
public class UserRoleEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column
    private UserRole role;

    public UserRoleEntity setRole(UserRole role) {
        this.role = role;
        return this;
    }
}
