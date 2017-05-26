package PT2017.demo.Assignment5;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MonitoredData {

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String activity;

    public MonitoredData(LocalDateTime startTime, LocalDateTime endTime, String activityLabel) {
        this.setStartTime(startTime);
        this.setEndTime(endTime);
        this.setActivity(activityLabel);
    }

    public long getDay()
    {
    	return startTime.toLocalDate().getDayOfMonth();
    }
    
    public LocalDateTime getStartTime() {
        return startTime;
    }
                        
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

}