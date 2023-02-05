package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.dto.ImportOfferDTO;
import bg.softuni.mobilelele.model.entity.ModelEntity;
import bg.softuni.mobilelele.model.entity.OfferEntity;
import bg.softuni.mobilelele.model.entity.UserEntity;
import bg.softuni.mobilelele.repository.ModelRepository;
import bg.softuni.mobilelele.repository.OfferRepository;
import bg.softuni.mobilelele.repository.UserRepository;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;

import static bg.softuni.mobilelele.util.Util.createdNow;
import static bg.softuni.mobilelele.util.Util.readDataFromFile;

@Service
public class OfferService {

    private static final Path INITIAL_DATA_OFFER = Path.of("src/main/resources/files/initial-data-offer.json");

    private final UserRepository userRepository;
    private final ModelRepository modelRepository;
    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;

    public OfferService(UserRepository userRepository, ModelRepository modelRepository,
                        OfferRepository offerRepository, ModelMapper modelMapper, Gson gson) {
        this.userRepository = userRepository;
        this.modelRepository = modelRepository;
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    public void importInitialDataForEmptyOfferRepository() throws IOException {

        if(this.offerRepository.count() < 1) {

            //TODO: Validate input
            Arrays.stream(this.gson.fromJson(readDataFromFile(INITIAL_DATA_OFFER), ImportOfferDTO[].class))
                    .map(x -> {
                        OfferEntity offer = this.modelMapper.map(x, OfferEntity.class);
                        offer.setCreated(createdNow());

                        Optional<ModelEntity> model = this.modelRepository.findByName(x.getModel());
                        model.ifPresent(offer::setModel);

                        Optional<UserEntity> seller = this.userRepository.findByUsername(x.getSeller());
                        seller.ifPresent(offer::setSeller);

                        return offer;
                    })
                    .forEach(this.offerRepository::saveAndFlush);
        }
    }
}
