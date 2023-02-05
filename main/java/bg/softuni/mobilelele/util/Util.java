package bg.softuni.mobilelele.util;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;

@Component
public class Util {

    public static String readDataFromFile(Path path) throws IOException {
        return Files.readString(path);
    }

    public static LocalDateTime createdNow() {
        return LocalDateTime.now();
    }
}
