package PT2017.demo.Assignment5;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import junit.framework.TestCase;

public class TestClass extends TestCase {

	@Test
	public void test(){
	    DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
	    MonitoredData obj0 = new MonitoredData(LocalDateTime.parse("2014-02-11 12:30:12", FORMAT), LocalDateTime.parse("2014-02-11 12:50:12", FORMAT), "Showering");
	    MonitoredData obj1 = new MonitoredData(LocalDateTime.parse("2014-02-12 12:35:15", FORMAT), LocalDateTime.parse("2014-02-12 12:50:00", FORMAT), "Grooming");
	    MonitoredData obj2 = new MonitoredData(LocalDateTime.parse("2014-02-13 12:00:00", FORMAT), LocalDateTime.parse("2014-02-13 12:50:00", FORMAT), "Lunch");
	    MonitoredData obj3 = new MonitoredData(LocalDateTime.parse("2014-02-14 12:30:50", FORMAT), LocalDateTime.parse("2014-02-14 12:50:00", FORMAT), "Leaving");
	    
	    MonitoredData obj4 = new MonitoredData(LocalDateTime.parse("2014-02-11 15:30:00", FORMAT), LocalDateTime.parse("2014-02-11 16:00:00", FORMAT), "Showering");
	    MonitoredData obj5 = new MonitoredData(LocalDateTime.parse("2014-02-12 15:35:15", FORMAT), LocalDateTime.parse("2014-02-12 16:50:00", FORMAT), "Grooming");
	    MonitoredData obj6 = new MonitoredData(LocalDateTime.parse("2014-02-13 15:00:00", FORMAT), LocalDateTime.parse("2014-02-13 16:50:00", FORMAT), "Lunch");
	    MonitoredData obj7 = new MonitoredData(LocalDateTime.parse("2014-02-14 15:30:50", FORMAT), LocalDateTime.parse("2014-02-14 16:50:00", FORMAT), "Leaving");
	    
	    List<MonitoredData> monitoredDataList = new ArrayList<MonitoredData>();
	    monitoredDataList.addAll(Arrays.asList(obj0, obj1, obj2, obj3, obj4, obj5, obj6, obj7));
	    
		String activity = "Showering";
		String start = "2014-02-11 12:30:12";
		Assert.assertTrue(obj0.getActivity().equals(activity));
		Assert.assertTrue(Utilities.getDistinctDaysCount(monitoredDataList) == 4 );
	}
}
