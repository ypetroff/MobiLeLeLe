package bg.softuni.mobilelele.model.entity;

import bg.softuni.mobilelele.model.enums.UserRole;
import jakarta.persistence.*;

@Entity
@Table(name = "user_role")
public class UserRoleEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column
    private UserRole role;
}
