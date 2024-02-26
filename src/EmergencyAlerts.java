// CST-283
// Aaron Pelto
// Winter 202

/*
    The Department of Homeland Security, the National Weather Service, and FEMA all require a program
    that will provide advisory information in the event of a weather or national security emergency.

    Your program will receive a file of information in this form:
    <countyFIPScode> , <startDateANDtime> , <endDateANDtime> , <warningCode>

    For each line, your program should process the coded information and provide a clear-text message
    explaining the warning.

    Two examples are provided below:
    For input:
    26111,202002121300,202002131200,WWS
    11001,202007010000,202007112359,YELLOW


    Produce the following output:

    Winter Storm Warning for Midland County, MI
    February 12, 2020 1:00pm - February 13, 2020 12:00 pm
    Population Impact: 83,919


    Significant risk of terrorist attacks for District of Columbia, DC
    July 1, 2020 12:00 am - July 11, 2020 11:59 pm
    Population Impact: 646,449


    The government has created a dataset of FIPS codes.
    Each county in the U.S. is assigned a unique five-digit code.
    This code is used to identify the county when alerts are generated.
    It is most used for weather warnings, but also could be used for industrial or national emergencies.
    For example, for Saginaw County, MI, the code is 26145.
        (Note: the 26 is Michigan's state code and the 145 is the unique county identifier within the state.)
    Features to note:
        ● Times are presented in a 24-hour military format. Be sure to decode to a traditional format that
    includes am/pm
        ● Add a feature that will insert commas as needed to represent the periods (groups of three) for
    larger numbers
 */

/*
    Your program should be driven by a list of warning messages (found in file alerts.txt).
    Each line of data in this file represents a distinct warning message disseminated by an agency of the U.S. Government.
    Ultimately, the output should be sorted with
        (1) security warnings at the top,
        (2) weather alerts to follow in the order of warnings, then watches, and finally advisories.

*/

/*
    The warningList.txt file is your reference for the warning messages and is provided in a less than
    useful format.
    You are free to reformat that in any way you wish, but please keep this as an external reference
        (i.e., avoid hard coding the content in the program code
        instead reorganize it for easier reading via file input).
 */

public class EmergencyAlerts {

    private static Alert[] alerts;

    /**
     * The main method reads the county and alert data, generates alerts based on this data,
     * and then processes and prints these alerts.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Get the countyList
        CountyList countyList = new CountyList(5000);
        // Read the FIPS and population data
        countyList.readFipsCountyFile();
        countyList.readPopCountyFile();

        // Get the alertList
        AlertList alertList = new AlertList(100, countyList);
        // Read the alert data - alerts.txt file
        alertList.readData();

        // Get the alerts
        alerts = alertList.getAlerts();

        // Process and print the alerts
        AlertProcessor alertProcessor = new AlertProcessor(countyList);
        for (Alert alert : alerts) {
            if (alert != null) {
                generateAlert(alert, alertProcessor);
            }
        }
    }


    /**
     * The generateAlert method processes and prints a single alert.
     *
     * @param alert          the alert to be processed
     * @param alertProcessor the alert processor to process the alert
     */
    public static void generateAlert(Alert alert, AlertProcessor alertProcessor) {
        // Generate the alert
        // Print the alert
        System.out.println(alertProcessor.formatAlertInfo(alert));
    }
}