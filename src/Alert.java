// One alert. Includes date/time, code, and all data related to one alert.
// Includes functionality necessary to write alert description.

import java.time.LocalDateTime;

/**
 * This class represents a single alert.
 * It includes properties for the alert's code, start date, end date, and the county FIPS code.
 * It provides functionality necessary to retrieve these properties.
 */
public class Alert {
    private final String alertCode;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
    private final int countyFipsCode;

    /**
     * Constructs a new Alert with the specified county FIPS code, start date, end date, and alert code.
     *
     * @param countyFipsCode the FIPS code of the county
     * @param startDate the start date of the alert
     * @param endDate the end date of the alert
     * @param alertCode the code of the alert
     */
    public Alert(int countyFipsCode, LocalDateTime startDate, LocalDateTime endDate, String alertCode) {
        this.countyFipsCode = countyFipsCode;
        this.startDate = startDate;
        this.endDate = endDate;
        this.alertCode = alertCode;
    }

    /**
     * Returns the FIPS code of the county for this alert.
     *
     * @return the FIPS code of the county
     */
    public int getCountyFipsCode() {
        return countyFipsCode;
    }

    /**
     * Returns the start date of this alert.
     *
     * @return the start date of this alert
     */
    public LocalDateTime getStartDate() {
        return LocalDateTime.from(this.startDate);
    }

    /**
     * Returns the end date of this alert.
     *
     * @return the end date of this alert
     */
    public LocalDateTime getEndDate() {
        return LocalDateTime.from(this.endDate);
    }

    /**
     * Returns the code of this alert.
     *
     * @return the code of this alert
     */
    public String getCode() {
        return alertCode;
    }


}