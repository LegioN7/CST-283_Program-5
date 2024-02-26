// Driver class with high-level actions using one AlertList object.

import java.time.format.DateTimeFormatter;

/**
 * This class is a driver class that performs high-level actions using an AlertList object.
 * It includes properties for alert types and levels, and references to a CountyList, AlertList, and AlertCalendar.
 * It provides functionality to get the alert type and level, and to format the alert information.
 */
public class AlertProcessor {

    // TEMPORARY ALERT TYPE AND LEVEL DATA
    private static final String[] ALERT_TYPES = {"AF", "FF", "FG", "FL", "FR", "HS", "HT", "IS", "TO", "TR", "TS", "TY", "WI", "HU", "SN", "WS", "WW", "ZR", "BS", "BZ", "HW", "SV", "EH"};
    private static final String[] ALERT_TYPE_NAMES = {"Ash Fall", "Flash Flood", "Dense Fog", "Flood", "Frost", "Heavy Snow", "Heat", "Ice Storm", "Tornado", "Tropical Storm", "Tsunami", "Typhoon", "Wind", "Hurricane", "Snow", "Winter Storm", "Winter Weather", "Freezing Rain", "Blowing Snow", "Blizzard", "High Wind", "Severe Thunderstorm", "Excessive Heat"};
    private static final char[] ALERT_LEVELS = {'W', 'A', 'Y'};
    private static final String[] ALERT_LEVEL_NAMES = {"Warning", "Watch", "Advisory"};


    private final CountyList countyList;

    /**
     * Constructs a new AlertProcessor with the specified CountyList, AlertList, and AlertCalendar.
     *
     * @param countyList the CountyList to be used for county data referencing
     */
    public AlertProcessor(CountyList countyList) {
        this.countyList = countyList;
    }

    /**
     * Returns the alert type based on the provided code.
     *
     * @param code the alert code
     * @return the alert type
     */
    public String getAlertType(String code) {
        String alertTypeCode = code.toUpperCase();

        switch (alertTypeCode) {
            case "RED":
                return "Severe risk of terrorist attacks";
            case "ORANGE":
                return "High risk of terrorist attacks";
            case "YELLOW":
                return "Significant risk of terrorist attacks";
            case "BLUE":
                return "General risk of terrorist attack";
            case "GREEN":
                return "Low risk of terrorist attacks";
            default:
                if (alertTypeCode.length() > 2) {
                    alertTypeCode = alertTypeCode.substring(1);
                }
                for (int i = 0; i < ALERT_TYPES.length; i++) {
                    if (ALERT_TYPES[i].equals(alertTypeCode)) {
                        return ALERT_TYPE_NAMES[i];
                    }
                }
        }

        return "Unknown Alert";
    }

    /**
     * Returns the alert level based on the provided code.
     *
     * @param code the alert code
     * @return the alert level
     */
    public String getAlertLevel(String code) {
        String alertTypeCode = code.toUpperCase();

        if (alertTypeCode.equals("RED") || alertTypeCode.equals("ORANGE") || alertTypeCode.equals("YELLOW") || alertTypeCode.equals("BLUE") || alertTypeCode.equals("GREEN")) {
            return "";
        }

        if (alertTypeCode.length() > 2) {
            char alertLevelCode = code.charAt(0);

            for (int i = 0; i < ALERT_LEVELS.length; i++) {
                if (ALERT_LEVELS[i] == alertLevelCode) {
                    return ALERT_LEVEL_NAMES[i];
                }
            }
        }

        return "Unknown Alert Level";
    }

    /**
     * Formats the alert information into a string.
     *
     * @param alert the alert to format
     * @return a string containing the formatted alert information
     */
    public String formatAlertInfo(Alert alert) {
        County county = countyList.getCountyByFipsCode(alert.getCountyFipsCode());

        // Format the alert information
        String countyName = county.getName();
        String alertType = getAlertType(alert.getCode());
        String alertLevel = getAlertLevel(alert.getCode());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy h:mm a");
        String startDate = alert.getStartDate().format(formatter);
        String endDate = alert.getEndDate().format(formatter);
        int population = county.getPopulation();

        String alertInfo = alertType;
        if (!alertLevel.isEmpty()) {
            alertInfo += " " + alertLevel;
        }

        alertInfo += " for " + countyName + "\n" +
                startDate + " - " + endDate + "\n" +
                "Population Impact: " + String.format("%,d", population) + "\n";

        return alertInfo;
    }
}