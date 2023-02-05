package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.dto.ImportUserDTO;
import bg.softuni.mobilelele.model.entity.UserEntity;
import bg.softuni.mobilelele.model.entity.UserRoleEntity;
import bg.softuni.mobilelele.repository.UserRepository;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static bg.softuni.mobilelele.util.Util.createdNow;
import static bg.softuni.mobilelele.util.Util.readDataFromFile;

@Service
public class UserService {

    private static final Path INITIAL_DATA_USER = Path.of("src/main/resources/files/initial-data-user.json");

    private final UserRepository userRepository;
    private final UserRoleService userRoleService;
    private final ModelMapper modelMapper;
    private final Gson gson;

    public UserService(UserRepository userRepository, UserRoleService userRoleService,
                       ModelMapper modelMapper, Gson gson) {
        this.userRepository = userRepository;
        this.userRoleService = userRoleService;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    public void importInitialDataForEmptyUserRepository() throws IOException {

        if (this.userRepository.count() < 1) {

            //TODO: Validate input
            Arrays.stream(this.gson.fromJson(readDataFromFile(INITIAL_DATA_USER), ImportUserDTO[].class))
                    .map(x -> {
                        UserEntity user = this.modelMapper.map(x, UserEntity.class);

                        List<UserRoleEntity> userRoles = this.userRoleService.findAllRoles();
                        user.setRoles(userRoles);
                        user.setCreated(createdNow());

                        return user;
                    })
                    .forEach(this.userRepository::saveAndFlush);
        }
    }
}
