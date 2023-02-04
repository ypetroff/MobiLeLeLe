package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.dto.ImportBrandDTO;
import bg.softuni.mobilelele.model.entity.BrandEntity;
import bg.softuni.mobilelele.repository.*;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class SeedService {

    private static final Path INITIAL_DATA_BRAND = Path.of("resources/files/initial-data-brand.txt");

    private final BrandRepository brandRepository;
    private final ModelRepository modelRepository;
    private final OfferRepository offerRepository;
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;

    public SeedService(BrandRepository brandRepository,
                       ModelRepository modelRepository,
                       OfferRepository offerRepository,
                       UserRepository userRepository,
                       UserRoleRepository userRoleRepository, ModelMapper modelMapper, Gson gson) {
        this.brandRepository = brandRepository;
        this.modelRepository = modelRepository;
        this.offerRepository = offerRepository;
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    private void importInitialDataForEmptyBrandRepository() throws IOException {
        if(this.brandRepository.count() < 1) {
            importBrandData();
        }
    }
//TODO: Add validator
    private void importBrandData() throws IOException {
        //TODO: Validate input
        Arrays.stream(this.gson.fromJson(readDataFromFile(INITIAL_DATA_BRAND), ImportBrandDTO[].class))
                .map(x -> modelMapper.map(x, BrandEntity.class))
                .forEach(this.brandRepository::saveAndFlush);
    }

    private String readDataFromFile(Path path) throws IOException {
        return Files.readString(path);
    }
}
