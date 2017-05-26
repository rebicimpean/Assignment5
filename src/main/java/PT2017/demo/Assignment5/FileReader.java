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
        try (Stream<String> stream = Files.lines(Paths.get(filename))) { 
            list = stream.map(line -> { 
                String[] array = line.split("\\t\\t"); 
                return new MonitoredData(LocalDateTime.parse(array[0], FORMAT), LocalDateTime.parse(array[1], FORMAT), array[2].trim());
            }).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("error while trying to write to file!");
        }
        return list;
    }
}
