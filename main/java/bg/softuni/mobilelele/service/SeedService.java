package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.dto.ImportBrandDTO;
import bg.softuni.mobilelele.model.dto.ImportModelDTO;
import bg.softuni.mobilelele.model.entity.BrandEntity;
import bg.softuni.mobilelele.model.entity.ModelEntity;
import bg.softuni.mobilelele.repository.*;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Service
public class SeedService {

    private static final Path INITIAL_DATA_BRAND = Path.of("src/main/resources/files/initial-data-brand.json");
    private static final Path INITIAL_DATA_MODEL = Path.of("resources/files/initial-data-model.json");
    private static final Path INITIAL_DATA_OFFER = Path.of("resources/files/initial-data-offer.json");
    private static final Path INITIAL_DATA_USER = Path.of("resources/files/initial-data-user.json");

    private static final LocalDateTime now = LocalDateTime.now();


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

    public void importAll() throws IOException {

        importInitialDataForEmptyBrandRepository();
        importInitialDataForEmptyModelRepository();
        importInitialDataForEmptyOfferRepository();
        importInitialDataForEmptyUserRepository();
        importInitialDataForEmptyUserRoleRepository();
    }

    private void importInitialDataForEmptyBrandRepository() throws IOException {
        if(this.brandRepository.count() < 1) {
            //TODO: Validate input
            Arrays.stream(this.gson.fromJson(readDataFromFile(INITIAL_DATA_BRAND), ImportBrandDTO[].class))
                    .map(x -> {
                        BrandEntity brand = this.modelMapper.map(x, BrandEntity.class);
                        brand.setCreated(now);
                        return brand;
                    })
                    .forEach(this.brandRepository::saveAndFlush);
        }
    }

    private void importInitialDataForEmptyModelRepository() throws IOException {
        if(this.modelRepository.count() < 1) {

            //TODO: Validate input
            Arrays.stream(this.gson.fromJson(readDataFromFile(INITIAL_DATA_MODEL), ImportModelDTO[].class))
                    .map(x -> {
                        ModelEntity model = this.modelMapper.map(x, ModelEntity.class);
                        model.setCreated(now);
                        return model;
                    })
                    .forEach(this.modelRepository::saveAndFlush);
        }
    }

    private void importInitialDataForEmptyOfferRepository() {
    }

    private void importInitialDataForEmptyUserRepository() {
    }

    private void importInitialDataForEmptyUserRoleRepository() {
    }
    //TODO: Add validator

    private String readDataFromFile(Path path) throws IOException {
        return Files.readString(path);
    }
}
