package PT2017.demo.Assignment5;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Map;

public class FileWriter {

    public void writeDistinctActionTypeCount(Map<String, Long> map, String filename) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filename))) {
            map.entrySet().stream().forEach( entry -> //and if you want to store the entrySet do you store it in a Set object
            {// entrySet iti returneaza toate intrarile, practic e seturile de intrari
                try {
                    writer.write(entry.getKey() + "  " + entry.getValue() + System.getProperty("line.separator")); //ce face asta
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
                    entry.getValue();
                    long s = entry.getValue().getSeconds();
                    writer.write(entry.getKey() + "  "
                            + entry.getValue().toString().substring(2).replaceAll("(\\d[HMS])(?!$)", "$1 ").toLowerCase() //ce face asta
                            + System.getProperty("line.separator"));
                } catch (IOException e) {
                    throw new RuntimeException("error while trying to write to file!");
                }
            });
        } catch (IOException e) {
            throw new RuntimeException("error while trying to write to file!");
        }
    }
}
