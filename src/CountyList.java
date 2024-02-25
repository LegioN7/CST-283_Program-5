// List of County objects.
// Include the ability to search by FIPS code and return county object.

import java.io.BufferedReader;
import java.io.FileReader;

public class CountyList {
    private final County[] counties;
    private int size;

    public CountyList(int capacity) {
        counties = new County[capacity];
        size = 0;
    }

    public void addCounty(County county) {
        if (size < counties.length) {
            counties[size] = county;
            size++;
        } else {
            System.out.println("CountyList is full. Cannot add more counties.");
        }
    }

    public County getCountyByFipsCode(String countyFipsCode) {
        for (int i = 0; i < size; i++) {
            if (counties[i].getFipsCode().equals(countyFipsCode)) {
                return counties[i];
            }
        }
        return null;
    }

    public void readFipsCountyFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("fipsCounty.txt"));
            String line = reader.readLine();
            while (line != null) {
                String[] parts = line.split(" ", 2);
                String fipsCode = parts[0];
                String[] nameParts = parts[1].split(",", 2);
                String name = nameParts[0].trim();
                County county = new County(fipsCode, name);
                addCounty(county);
                line = reader.readLine();
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Error reading fipsCounty.txt file");
            e.printStackTrace();
        }
    }

    public void readPopCountyFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("popCounty.txt"));
            String line = reader.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                String fipsCode = fields[0];
                int population = Integer.parseInt(fields[1]);
                County county = getCountyByFipsCode(fipsCode);
                county.setPopulation(population);
                line = reader.readLine();
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Error reading popCounty.txt file");
            e.printStackTrace();
        }
    }
}