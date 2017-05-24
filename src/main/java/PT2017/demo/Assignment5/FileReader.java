package PT2017.demo.Assignment5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {

    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public List<MonitoredData> getMonitoredData(String filename) {
        List<MonitoredData> list = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(filename))) { //if this reads all lines, how does it process it line by line
            list = stream.map(line -> { // aici, pentru fiecare element (care e o linie?) din stream 
                String[] array = line.split("\\t\\t"); // de ce ai folosit duble \\t\\
                return new MonitoredData(LocalDateTime.parse(array[0], FORMAT), LocalDateTime.parse(array[1], FORMAT), array[2].trim());
            }).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("error while trying to write to file!");
        }
        return list;
    }
}
