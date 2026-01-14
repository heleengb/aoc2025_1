package software.ulpgc.aoc.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class TextFileReader implements InputReader {
    private final Path filePath;

    public TextFileReader(Path filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<String> readContent() throws IOException {
        try (Stream<String> stream = Files.lines(filePath)) {
            return stream.toList(); // lista de las lineas del archivo
        }
    }
}