package bg.softuni.mobilelele.configuration;

import bg.softuni.mobilelele.repository.*;
import bg.softuni.mobilelele.service.SeedService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final BrandRepository brandRepository;
    private final ModelRepository modelRepository;
    private final OfferRepository offerRepository;
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final SeedService seedService;

    public DataInitializer(BrandRepository brandRepository, ModelRepository modelRepository,
                           OfferRepository offerRepository, UserRepository userRepository,
                           UserRoleRepository userRoleRepository, SeedService seedService) {
        this.brandRepository = brandRepository;
        this.modelRepository = modelRepository;
        this.offerRepository = offerRepository;
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.seedService = seedService;
    }

    @Override
    public void run(String... args) throws Exception {

        this.seedService.importAll();
    }
}
