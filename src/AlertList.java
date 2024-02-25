// Basic class to store, manage, and sort a list of alert objects.
// Recommended to own and manage an instance of the CountyList class for county data referencing.

public class AlertList {

    private Alert[] alerts;
    private int size;
    private CountyList countyList;

    public AlertList(int capacity, CountyList countyList) {
        this.alerts = new Alert[capacity];
        this.size = 0;
        this.countyList = countyList;
    }

}