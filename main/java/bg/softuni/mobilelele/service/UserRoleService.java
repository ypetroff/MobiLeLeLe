package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.entity.UserRoleEntity;
import bg.softuni.mobilelele.model.enums.UserRole;
import bg.softuni.mobilelele.repository.UserRoleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserRoleService {

    private final UserRoleRepository userRoleRepository;

    public UserRoleService(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    public void importInitialDataForEmptyUserRoleRepository() {

        if(this.userRoleRepository.count() < 1) {
            List<UserRoleEntity> roles = new ArrayList<>();
            roles.add(new UserRoleEntity().setRole(UserRole.ADMIN));
            roles.add(new UserRoleEntity().setRole(UserRole.USER));

            this.userRoleRepository.saveAllAndFlush(roles);
        }
    }

    public List<UserRoleEntity> findAllRoles() {
        return this.userRoleRepository.findAll();
    }
}
