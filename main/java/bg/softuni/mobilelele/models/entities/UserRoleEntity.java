package bg.softuni.mobilelele.models.entities;

import bg.softuni.mobilelele.models.enums.UserRole;
import jakarta.persistence.*;

@Entity
@Table(name = "user_role")
public class UserRoleEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column
    private UserRole role;
}
