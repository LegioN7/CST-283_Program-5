
// Class to manage the calendar date
public class AlertCalendar {
    public String convertMilitaryToStandard(String militaryTime) {
        String year = militaryTime.substring(0, 4);
        String month = militaryTime.substring(4, 6);
        String day = militaryTime.substring(6, 8);
        int hour = Integer.parseInt(militaryTime.substring(8, 10));
        String minute = militaryTime.substring(10, 12);

        String period;
        if (hour >= 12) {
            period = "PM";
            if (hour > 12) {
                hour -= 12;
            }
        } else {
            period = "AM";
            if (hour == 0) {
                hour = 12;
            }
        }

        return String.format("%s-%s-%s %02d:%s %s", year, month, day, hour, minute, period);
    }
}