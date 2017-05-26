package PT2017.demo.Assignment5;

import java.time.Duration;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Utilities {

	/**
	 * Counts how many distinct days there are in a list with objects of type
	 * MonitoredData
	 * 
	 * @param List<MonitoredData>
	 *            monitoredDataList
	 * @return long distinctDays
	 */
	protected static long getDistinctDaysCount(List<MonitoredData> monitoredDataList) {
		long distinctDays = monitoredDataList.stream()
				.map(it -> Arrays.asList(it.getStartTime().toLocalDate(), it.getEndTime().toLocalDate()))
				.flatMap(it -> it.stream()).distinct().count();
		return distinctDays;
	}

	/**
	 * Maps to each activity type the number of occurrences in the log
	 * 
	 * @param monitoredDataList
	 * @return Map<String, Long>
	 */
	protected static Map<String, Long> getDistinctActionTypeCount(List<MonitoredData> monitoredDataList) {
		Map<String, Long> map = monitoredDataList.stream()
				.collect(Collectors.groupingBy(MonitoredData::getActivity, Collectors.counting()));
		return map;
	}

	/**
	 * Maps for each day the activities and they number  
	 * @param monitoredDataList
	 * @return Map<Long, Map<String,Long>>
	 */
	protected static Map<Long, Map<String, Long>> getActionCountForEachDay(List<MonitoredData> monitoredDataList){
		return monitoredDataList.stream()
				.collect(Collectors.groupingBy(MonitoredData::getDay, Collectors.groupingBy(MonitoredData::getActivity, Collectors.counting())));
	}

	/**
	 * Counts the total duration of each activity from the input file and
	 * filters those with duration larger than 10 hours
	 * 
	 * @param monitoredDataList
	 * @return Map<String, Duration>
	 */
	protected static Map<String, Duration> getActivityDuration(List<MonitoredData> monitoredDataList) {
		// Step 1
		Map<String, List<MonitoredData>> map = monitoredDataList.stream()
				.collect(Collectors.groupingBy(MonitoredData::getActivity, Collectors.toList()));

		// Step 2
		Map<String, Duration> activityDuration = map.entrySet().stream().map(entry -> {
			Duration duration = entry.getValue().stream()
					.map(it -> Duration.between(it.getStartTime(), it.getEndTime())) // Step
					// 2a
					.reduce(Duration.ZERO, (a, b) -> a.plus(b)); // Step 2b

			// We want to return from this map a entry map, with the key the
			// activity and the value the duration.
			return new AbstractMap.SimpleEntry<>(entry.getKey(), duration);
		}).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

		// Step 3
		return activityDuration.entrySet().stream().filter(entry -> entry.getValue().toHours() > 10)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

	}

	/**
	 * Filters the activities that have 90% of the monitoring samples with
	 * duration less than 5 minutes
	 * 
	 * @param monitoredDataList
	 * @return
	 */
	protected static List<String> getAverageResult(List<MonitoredData> monitoredDataList) {
		// Step 1
		Map<String, List<MonitoredData>> map = monitoredDataList.stream()
				.collect(Collectors.groupingBy(MonitoredData::getActivity, Collectors.toList()));

		// Step 2
		List<String> filteredActivities = map.entrySet().stream().filter(entry -> {
			// Step 2a
			List<Duration> durationList = entry.getValue().stream()
					.map(it -> Duration.between(it.getStartTime(), it.getEndTime())).collect(Collectors.toList());

			// Filter the activities that have 90% of the monitoring samples
			// with duration less than 5 minutes.
			long totalCount = durationList.size();
			// then 90% of those are :
			long percentCount = totalCount - totalCount / 10;

			// Step 2b
			long durationsLessThan5MinutesCount = durationList.stream().filter(it -> it.toMinutes() < 5).count();

			return (durationsLessThan5MinutesCount > percentCount);
		}).map(it -> it.getKey()).collect(Collectors.toList());

		return filteredActivities;
	}

}
