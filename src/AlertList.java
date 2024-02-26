// Basic class to store, manage, and sort a list of alert objects.
// Recommended to own and manage an instance of the CountyList class for county data referencing.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * This class represents a list of Alert objects.
 * It provides functionality to store, manage, and sort these alerts.
 * It also provides methods to read alert data from a file and store it in the alert array.
 * It is recommended to own and manage an instance of the CountyList class for county data referencing.
 */
public class AlertList {

    private final Alert[] alerts;
    public static String ALERTS_FILE = "alerts.txt";
    private final CountyList countyList;

    /**
     * Constructs a new AlertList with the specified capacity and CountyList.
     *
     * @param capacity the capacity of the list
     * @param countyList the CountyList to be used for county data referencing
     */
    public AlertList(int capacity, CountyList countyList) {
        this.alerts = new Alert[capacity];
        this.countyList = countyList;
    }

    /**
     * Returns the list of alerts.
     *
     * @return an array containing all the alerts in the list
     */
    public Alert[] getAlerts() {
        return alerts;
    }

    /**
     * Reads the data from the alert file and stores it in the alert array.
     */
    public void readData() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm");

        int lines = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(ALERTS_FILE))) {
            while (reader.readLine() != null) lines++;
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(ALERTS_FILE))) {
            String line;
            int i = 0;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                int countyFipsCode = Integer.parseInt(fields[0]);
                LocalDateTime startDate = LocalDateTime.parse(fields[1], formatter);
                LocalDateTime endDate = LocalDateTime.parse(fields[2], formatter);
                String alertCode = fields[3];
                try {
                    alerts[i] = new Alert(countyFipsCode, startDate, endDate, alertCode);
                    i++;
                } catch (Exception e) {
                    System.out.println("Error creating Alert from line " + (i + 1) + ": " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }


}