package bg.softuni.mobilelele.configuration;

import bg.softuni.mobilelele.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRoleService userRoleService;
    private final UserService userService;
    private final BrandService brandService;
    private final ModelService modelService;
    private final OfferService offerService;

    public DataInitializer(UserRoleService userRoleService,
                           UserService userService, BrandService brandService,
                           ModelService modelService, OfferService offerService) {
        this.userRoleService = userRoleService;
        this.userService = userService;
        this.brandService = brandService;
        this.modelService = modelService;
        this.offerService = offerService;
    }

    @Override
    public void run(String... args) throws Exception {

        this.userRoleService.importInitialDataForEmptyUserRoleRepository();
        this.userService.importInitialDataForEmptyUserRepository();
        this.brandService.importInitialDataForEmptyBrandRepository();
        this.modelService.importInitialDataForEmptyModelRepository();
        this.offerService.importInitialDataForEmptyOfferRepository();
    }
}
