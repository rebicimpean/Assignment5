package PT2017.demo.Assignment5;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;
import java.util.Map;

public class FileWriter {

    public void writeDistinctActionTypeCount(Map<String, Long> map, String filename) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filename))) {
            map.entrySet().stream().forEach( entry ->
            {
                try {
                    writer.write(entry.getKey() + "  " + entry.getValue() + System.getProperty("line.separator"));
                } catch (IOException e) {
                    throw new RuntimeException("error while trying to write to file!");
                }
            });
        } catch (IOException e) {
            throw new RuntimeException("error while trying to write to file!");
        }
    }
    
    public void writeDistinctActionCountForEachDay(Map<Long, Map<String, Long>> map, String filename) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filename))) {
            map.entrySet().stream().forEach( entry ->
            {
                try {
                    writer.write(entry.getKey() + "  " + entry.getValue() + System.getProperty("line.separator"));
                } catch (IOException e) {
                    throw new RuntimeException("error while trying to write to file!");
                }
            });
        } catch (IOException e) {
            throw new RuntimeException("error while trying to write to file!");
        }
    }

    public void writeActivityDuration(Map<String, Duration> map, String filename) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filename))) {
            map.entrySet().stream().forEach( entry ->
            {
                try {
                    writer.write(entry.getKey() + "  "
                            + entry.getValue().toString().substring(2).replaceAll("(\\d[HMS])(?!$)", "$1 ").toLowerCase()
                            + System.getProperty("line.separator"));
                } catch (IOException e) {
                    throw new RuntimeException("error while trying to write to file!");
                }
            });
        } catch (IOException e) {
            throw new RuntimeException("error while trying to write to file!");
        }
    }

    public void writeAverageResult(List<String> list, String filename) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filename))) {
            list.stream().forEach( it ->
            {
                try {
                    writer.write(it + System.getProperty("line.separator"));
                } catch (IOException e) {
                    throw new RuntimeException("error while trying to write to file!");
                }
            });
        } catch (IOException e) {
            throw new RuntimeException("error while trying to write to file!");
        }
    }
}
