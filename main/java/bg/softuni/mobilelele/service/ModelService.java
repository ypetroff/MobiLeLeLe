package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.dto.ImportModelDTO;
import bg.softuni.mobilelele.model.entity.BrandEntity;
import bg.softuni.mobilelele.model.entity.ModelEntity;
import bg.softuni.mobilelele.repository.BrandRepository;
import bg.softuni.mobilelele.repository.ModelRepository;
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
public class ModelService {

    private static final Path INITIAL_DATA_MODEL = Path.of("src/main/resources/files/initial-data-model.json");

    private final BrandRepository brandRepository;
    private final ModelRepository modelRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;

    public ModelService(BrandRepository brandRepository, ModelRepository modelRepository,
                        ModelMapper modelMapper, Gson gson) {
        this.brandRepository = brandRepository;
        this.modelRepository = modelRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    public void importInitialDataForEmptyModelRepository() throws IOException {

        if(this.modelRepository.count() < 1) {

            //TODO: Validate input
            Arrays.stream(this.gson.fromJson(readDataFromFile(INITIAL_DATA_MODEL), ImportModelDTO[].class))
                    .map(x -> {
                        ModelEntity model = this.modelMapper.map(x, ModelEntity.class);
                        model.setCreated(createdNow());

                        Optional<BrandEntity> brand = this.brandRepository.findByName(x.getBrand());

                        brand.ifPresent(model::setBrand);

                        return model;
                    })
                    .forEach(this.modelRepository::saveAndFlush);
        }
    }
}
