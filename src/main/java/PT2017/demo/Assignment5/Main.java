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
		System.out.println(monitoredDataList.get(2).getStartTime().toLocalTime());
		// 1
		long distinctDaysCount = getDistinctDaysCount(monitoredDataList);
		graphicalInterface.setDisplayCountDistinctDays(distinctDaysCount);

		// 2
		Map<String, Long> distinctActionTypeCount = getDistinctActionTypeCount(monitoredDataList);
		FileWriter fileWriter = new FileWriter();
		fileWriter.writeDistinctActionTypeCount(distinctActionTypeCount, "distinctActionTypeCount.txt");

		// 3 TODO
		// Map<Integer, Map<String, Long>> distinctActionTypeCountByDay =
		// getDistinctActionTypeCountByDay(monitoredDataList);
		// fileWriter.writeMap(distinctActionTypeCountByDay,
		// "getDistinctActionTypeCountByDay.txt");

		// 4
		Map<String, Duration> activityDuration = getActivityDuration(monitoredDataList);
		Map<String, Duration> filteredActivityDuration = activityDuration.entrySet().stream()
				.filter(entry -> entry.getValue().toMinutes() > 60 * 10)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		fileWriter.writeActivityDuration(filteredActivityDuration, "filteredActivityDuration.txt");
	}

	private static long getDistinctDaysCount(List<MonitoredData> monitoredDataList) {
		long distinctDays = monitoredDataList.stream()
				.map(it -> Arrays.asList(it.getStartTime().toLocalDate(), it.getEndTime().toLocalDate()))
				.flatMap(it -> it.stream()).distinct().count();

		return distinctDays;
	}

	private static Map<String, Long> getDistinctActionTypeCount(List<MonitoredData> monitoredDataList) {
		Map<String, Long> map = monitoredDataList.stream()
				.collect(Collectors.groupingBy(MonitoredData::getActivity, Collectors.counting()));
		return map;
				}

	// private static Map<Integer, Map<String, Long>>
	// getDistinctActionTypeCountByDay(List<MonitoredData> monitoredDataList) {
	// TODO
	// Map<String, Long> map = monitoredDataList.stream()
	// .collect(Collectors.groupingBy(MonitoredData::getActivity,
	// Collectors.counting()));
	// return null;
	// }

	private static Map<String, Duration> getActivityDuration(List<MonitoredData> monitoredDataList) {
		Map<String, List<MonitoredData>> map = monitoredDataList.stream()
				.collect(Collectors.groupingBy(MonitoredData::getActivity, Collectors.toList()));

		Map<String, Duration> resultMap = map.entrySet().stream().map(entry -> {
			Duration duration = entry.getValue().stream()
					.map(it -> Duration.between(it.getStartTime(), it.getEndTime()))
					.reduce(Duration.ZERO, (a, b) -> a.plus(b));
			return new AbstractMap.SimpleEntry<>(entry.getKey(), duration);
		}).collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue));

		return resultMap;
	}
}
