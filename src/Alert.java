// One alert. Includes date/time, code, and all data related to one alert.
// Includes functionality necessary to write alert description.

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Alert {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
    private final String alertCode;
    private final CountyList countyList;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
    private final String countyFipsCode;

    public Alert(String countyFipsCode, String startDate, String endDate, String alertCode, CountyList countyList) {
        this.countyFipsCode = countyFipsCode;
        this.countyList = countyList;
        this.startDate = LocalDateTime.parse(startDate, DATE_TIME_FORMATTER);
        this.endDate = LocalDateTime.parse(endDate, DATE_TIME_FORMATTER);
        this.alertCode = alertCode;
    }

    public String getCountyFipsCode() {
        return this.countyFipsCode;
    }

    public LocalDateTime getStartDate() {
        return this.startDate;
    }

    public LocalDateTime getEndDate() {
        return this.endDate;
    }

    public String getCode() {
        return alertCode;
    }

}