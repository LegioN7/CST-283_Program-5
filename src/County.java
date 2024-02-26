// Data for one county: FIPS code, population, and name.

/**
 * This class represents a single county.
 * It includes properties for the county's FIPS code, population, and name.
 */
public class County {
    private final int fipsCode;
    private final String name;
    private int population;

    /**
     * Constructs a new County with the specified FIPS code and name.
     *
     * @param fipsCode the FIPS code of the county
     * @param name the name of the county
     */
    public County(int fipsCode, String name) {
        this.fipsCode = fipsCode;
        this.name = name;
    }

    /**
     * Returns the FIPS code of this county.
     *
     * @return the FIPS code of this county
     */
    public int getFipsCode() {
        return fipsCode;
    }

    /**
     * Returns the population of this county.
     *
     * @return the population of this county
     */
    public int getPopulation() {
        return population;
    }

    /**
     * Sets the population of this county to the specified value.
     *
     * @param population the new population of this county
     */
    public void setPopulation(int population) {
        this.population = population;
    }

    /**
     * Returns the name of this county.
     *
     * @return the name of this county
     */
    public String getName() {
        return name;
    }
}