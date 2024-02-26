// List of County objects.
// Include the ability to search by FIPS code and return county object.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * This class represents a list of County objects.
 * It provides the ability to add a county to the list, get the list of counties,
 * and search for a county by its FIPS code.
 * It also provides methods to read county data from files.
 */
public class CountyList {
    public static String FIPS_FILE = "fipsCounty.txt";
    public static String POP_FILE = "popCounty.txt";
    private final County[] counties;
    private int size;

    /**
     * Constructs a new CountyList with the specified capacity.
     *
     * @param capacity the capacity of the list
     */
    public CountyList(int capacity) {
        this.counties = new County[capacity];
        this.size = 0;
    }

    /**
     * Adds a county to the list.
     *
     * @param county the county to add to the list
     */
    public void addCounty(County county) {
        // Add a county to the list
        // Check if the array is full
        // If not, add the county to the list
        // If full, print an error message
        if (size < counties.length) {
            counties[size] = county;
            size++;
        } else {
            System.out.println("County array is full. Cannot add more counties.");
        }
    }

    /**
     * Returns the list of counties.
     *
     * @return an array containing all the counties in the list
     */
    public County[] getCounties() {
        // Return a copy of the array
        County[] result = new County[size];
        // Copy the array
        System.arraycopy(counties, 0, result, 0, size);
        return result;
    }

    /**
     * Returns the county with the specified FIPS code.
     *
     * @param countyFipsCode the FIPS code of the county to return
     * @return the county with the specified FIPS code, or null if there is no such county
     */
    public County getCountyByFipsCode(int countyFipsCode) {
        // Search the list for the county with the FIPS code
        for (int i = 0; i < size; i++) {
            // If found, return the county
            if (counties[i].getFipsCode() == countyFipsCode) {
                return counties[i];
            }
        }
        return null;
    }

    /**
     * Reads the FIPS county file and stores the data in the county objects.
     */
    public void readFipsCountyFile() {
        // Read the FIPS file and store the data in the county objects
        try (BufferedReader reader = new BufferedReader(new FileReader(FIPS_FILE))) {
            String line = reader.readLine();
            while (line != null) {
                // Split the line into FIPS code and name
                String[] parts = line.split(" ", 2);
                // Parse the fields
                // Store the data in the county objects
                // Add the county to the list
                int fipsCode = Integer.parseInt(parts[0]);
                String[] nameParts = parts[1].split(",", 2);
                String name = nameParts[0].trim();
                County county = new County(fipsCode, name);
                addCounty(county);
                line = reader.readLine();
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error reading fipsCounty.txt file");
            e.printStackTrace();
        }
    }

    /**
     * Reads the population county file and stores the population in the county objects.
     */
    public void readPopCountyFile() {
        // Read the population file and store the population in the county objects
        try (BufferedReader reader = new BufferedReader(new FileReader(POP_FILE))) {
            String line = reader.readLine();
            while (line != null) {
                // Split the line into FIPS code and population
                String[] fields = line.split(",");
                // Parse the fields
                // Store the data in the county objects
                // Set the population
                int fipsCode = Integer.parseInt(fields[0]);
                int population = Integer.parseInt(fields[1]);
                County county = getCountyByFipsCode(fipsCode);
                county.setPopulation(population);
                line = reader.readLine();
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error reading popCounty.txt file");
            e.printStackTrace();
        }
    }
}
