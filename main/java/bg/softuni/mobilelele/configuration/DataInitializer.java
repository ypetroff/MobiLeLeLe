package bg.softuni.mobilelele.configuration;

import bg.softuni.mobilelele.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final BrandRepository brandRepository;
    private final ModelRepository modelRepository;
    private final OfferRepository offerRepository;
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;

    public DataInitializer(BrandRepository brandRepository, ModelRepository modelRepository,
                           OfferRepository offerRepository, UserRepository userRepository,
                           UserRoleRepository userRoleRepository) {
        this.brandRepository = brandRepository;
        this.modelRepository = modelRepository;
        this.offerRepository = offerRepository;
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
//TODO: create a files to insert at least one representative of each entity table in the DB
// add seed service and populate the DB
    }
}
