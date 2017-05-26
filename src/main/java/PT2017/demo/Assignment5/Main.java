package PT2017.demo.Assignment5;

import java.time.Duration;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		List<MonitoredData> monitoredDataList = new FileReader().getMonitoredData("Activities.txt");
		Gui graphicalInterface = new Gui();

		// 1
		long distinctDaysCount = Utilities.getDistinctDaysCount(monitoredDataList);
		graphicalInterface.setDisplayCountDistinctDays(distinctDaysCount);
		
		// 2
		Map<String, Long> distinctActionTypeCount = Utilities.getDistinctActionTypeCount(monitoredDataList);
		FileWriter fileWriter = new FileWriter();
		fileWriter.writeDistinctActionTypeCount(distinctActionTypeCount, "distinctActionTypeCount.txt");

		//3
		Map<Long, Map<String,Long> > distinctActionCountForEachDay = Utilities.getActionCountForEachDay(monitoredDataList);
		fileWriter.writeDistinctActionCountForEachDay(distinctActionCountForEachDay, "distinctActionCountForEachDay.txt");
		// 4
		Map<String, Duration> filteredActivityDuration = Utilities.getActivityDuration(monitoredDataList);
		fileWriter.writeActivityDuration(filteredActivityDuration, "filteredActivityDuration.txt");

		// 5
		List<String> averageResult = Utilities.getAverageResult(monitoredDataList);
		fileWriter.writeAverageResult(averageResult, "averageResult.txt");

	}
}
