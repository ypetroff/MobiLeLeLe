package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.dto.ImportBrandDTO;
import bg.softuni.mobilelele.model.entity.BrandEntity;
import bg.softuni.mobilelele.repository.BrandRepository;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;

import static bg.softuni.mobilelele.util.Util.createdNow;
import static bg.softuni.mobilelele.util.Util.readDataFromFile;

@Service
public class BrandService {

    private static final Path INITIAL_DATA_BRAND = Path.of("src/main/resources/files/initial-data-brand.json");

    private final BrandRepository brandRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;

    public BrandService(BrandRepository brandRepository, ModelMapper modelMapper, Gson gson) {
        this.brandRepository = brandRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    public void importInitialDataForEmptyBrandRepository() throws IOException {

        if(this.brandRepository.count() < 1) {
            //TODO: Validate input
            Arrays.stream(this.gson.fromJson(readDataFromFile(INITIAL_DATA_BRAND), ImportBrandDTO[].class))
                    .map(x -> {
                        BrandEntity brand = this.modelMapper.map(x, BrandEntity.class);
                        brand.setCreated(createdNow());
                        return brand;
                    })
                    .forEach(this.brandRepository::saveAndFlush);
        }
    }
}
