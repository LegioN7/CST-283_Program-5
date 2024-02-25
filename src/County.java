// Data for one county: FIPS code, population, and name.

public class County {
    private final String fipsCode;
    private final String name;
    private int population;

    public County(String fipsCode, String name) {
        this.fipsCode = fipsCode;
        this.name = name;
    }

    public String getFipsCode() {
        return fipsCode;
    }
    public int getPopulation() {
        return population;
    }

    public String getName() {
        return name;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}