// Driver class with high-level actions using one AlertList object.

import java.time.format.DateTimeFormatter;

public class AlertProcessor {
    private final CountyList countyList;
    private final AlertList alertList;
    private final AlertCalendar alertCalendar;

    public AlertProcessor(CountyList countyList, AlertList alertList, AlertCalendar alertCalendar) {
        this.countyList = countyList;
        this.alertList = alertList;
        this.alertCalendar = alertCalendar;
    }

    public String getAlertType(String code) {
        String alertTypeCode = code.toUpperCase();
        if (alertTypeCode.length() > 2) {
            alertTypeCode = alertTypeCode.substring(1);
        }

        switch (alertTypeCode) {
            // Weather Warning Level Indicators
            case "AF" -> {
                return "Ash Fall";
            }
            case "FF" -> {
                return "Flash Flood";
            }
            case "FG" -> {
                return "Dense Fog";
            }
            case "FL" -> {
                return "Flood";
            }
            case "FR" -> {
                return "Frost";
            }
            case "HS" -> {
                return "Heavy Snow";
            }
            case "HT" -> {
                return "Heat";
            }
            case "IS" -> {
                return "Ice Storm";
            }
            case "TO" -> {
                return "Tornado";
            }
            case "TR" -> {
                return "Tropical Storm";
            }
            case "TS" -> {
                return "Tsunami";
            }
            case "TY" -> {
                return "Typhoon";
            }
            case "WI" -> {
                return "Wind";
            }
            case "HU" -> {
                return "Hurricane";
            }
            case "SN" -> {
                return "Snow";
            }
            case "WS" -> {
                return "Winter Storm";
            }
            case "WW" -> {
                return "Winter Weather";
            }
            case "ZR" -> {
                return "Freezing Rain";
            }
            case "BS" -> {
                return "Blowing Snow";
            }
            case "BZ" -> {
                return "Blizzard";
            }
            case "HW" -> {
                return "High Wind";
            }
            case "SV" -> {
                return "Severe Thunderstorm";
            }
            case "EH" -> {
                return "Excessive Heat";
            }
            default -> {

                // National Security Warning Level Indicators
                switch (code.toUpperCase()) {
                    case "RED" -> {
                        return "Severe risk of terrorist attacks";
                    }
                    case "ORANGE" -> {
                        return "High risk of terrorist attacks";
                    }
                    case "YELLOW" -> {
                        return "Significant risk of terrorist attacks";
                    }
                    case "BLUE" -> {
                        return "General risk of terrorist attack";
                    }
                    case "GREEN" -> {
                        return "Low risk of terrorist attacks";
                    }
                    default -> {
                        return "Unknown Alert";
                    }
                }
            }
        }
    }

    public String getAlertLevel(String code) {
        char alertLevelCode = code.charAt(0);
        return switch (alertLevelCode) {
            case 'W' -> "Warning";
            case 'A' -> "Watch";
            case 'Y' -> "Advisory";
            default -> "Unknown Alert Level";
        };
    }


    public String formatAlertInfo(Alert alert) {
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy h:mm a");

        County county = countyList.getCountyByFipsCode(alert.getCountyFipsCode());
        if (county == null) {
            return "County not found for alert with code: " + alert.getCode();
        }

        String alertType = getAlertType(alert.getCode());
        String alertLevel = getAlertLevel(alert.getCode());
        String countyName = county.getName();
        int population = county.getPopulation();
        String startDate = alert.getStartDate().format(outputFormatter);
        String endDate = alert.getEndDate().format(outputFormatter);

        return alertType + " (" + alertLevel + ") for " + countyName + "\n" +
                "From: " + startDate + "\n" +
                "To: " + endDate + "\n" +
                "Population Impact: " + population + "\n";
    }

}