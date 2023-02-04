package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.repository.*;
import org.springframework.stereotype.Service;

import java.nio.file.Path;

@Service
public class SeedService {

    private static final Path INITIAL_DATA_BRAND = Path.of("resources/files/initial-data-brand.txt");

    private final BrandRepository brandRepository;
    private final ModelRepository modelRepository;
    private final OfferRepository offerRepository;
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;

    public SeedService(BrandRepository brandRepository,
                       ModelRepository modelRepository,
                       OfferRepository offerRepository,
                       UserRepository userRepository,
                       UserRoleRepository userRoleRepository) {
        this.brandRepository = brandRepository;
        this.modelRepository = modelRepository;
        this.offerRepository = offerRepository;
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }

    private void importInitialDataForEmptyBrandRepository() {
        if(this.brandRepository.count() < 1) {
            importBrandData();
        }
    }

    private void importBrandData() {
    }
}
