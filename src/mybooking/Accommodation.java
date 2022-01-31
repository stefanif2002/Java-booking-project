package mybooking;

/**
 * The Accommodation class contains the information of a accommodation.
 * @author Stefanos Ifoulis (AEM: 3998)
 */

public class Accommodation {

private String name;
private double price;
private int squareMeters;
private int beds;
private boolean[] services;
private boolean[] availability;
private final String owner;

    /**
     * Constructor that initializes the accommodation information.
     * @param a The name of the accommodation.
     * @param b The price of the accommodation.
     * @param c The square meters of the accommodation.
     * @param bed
     * @param o The provider of the accommodation.
     * @param list
     */
    
     public Accommodation (String a, double b, int c, int bed, String o, boolean[] list) {
        availability = new boolean[30];
        beds = bed;
        services = list;
        name = a;
        price = b;
        squareMeters = c;
        owner = o;
        this.setAvailability();
    }

    /**
     * Constructor that initializes the accommodation information.
     * @param a The name of the accommodation.
     * @param b The price of the accommodation.
     * @param bed
     * @param c The square meters of the accommodation.
     * @param list The list of services of the accommodation.
     * @param av
     * @param o The provider of the accommodation.
     */
    
    public Accommodation (String a, String o, int bed, double b, int c, boolean[] av, boolean[] list) {
        availability = av;
        name = a;
        price = b;
        beds = bed;
        squareMeters = c;
        services = list;
        owner = o;
        this.setAvailability();
    }

    /**
     * @return The name of the accommodation.
     */
    
    public String getAcName () {
        return name;
    }
    
    public void setAcName (String a) {
        name = a;
    }
    
    public String getOwnersName () {
        return owner;
    }
    
    public AcProvider getAcProvider (Storage s) {
        return s.getAcProvider(owner);
    }
    
    public double getPrice () {
        return price;
    }
    
    public void setPrice (double b) {
        price = b;
    }
    
    public int getSquareMeters () {
        return squareMeters;
    }
    
    public void setSquareMeters (int c) {
        squareMeters = c;
    }
    
     public int getBeds () {
        return beds;
    }
    
    public void setBeds (int c) {
        beds = c;
    } 
    
    public boolean[] getAvailability () {
        return availability;
    }
    
    /**
     * @return The list of services of the accommodation.
     */
    
    public boolean[] getAcServicesList () {
        return services;
    }

    /**
     * Refactors accommodations list of services.
     * @param list
     */
    
    public void setAcServicesList (boolean[] list) {
        services = list;
    }

    /**
     * Returns final price.
     * @param days Number of days
     * @return Final price.
     */
    
    public double getAcFinalPrice (int days) {
        return price*days;
    }

    /**
     * Sets default availability.
     */

    private void setAvailability () {
        for (int i = 0; i<30; i++)
            availability [i] = true;
    }

    /**
     * Checks whether the service list contains a set of services.
     * @param a The set of services.
     * @return True if the service list contains the set of services and false otherwise.
     */

    public boolean containsAcListOfServices (boolean[] a) {
        for (int i=0; i<5; i++) {
            if (a[i] != services[i])
                return false;
        }
        return true;
    }

    /**
     * Removes a service.
     * @param i
     */
    
    public void removeAcService (int i) {
        services[i] = false;
    }

    /**
     * Reserves the accommodation for the given period if possible.
     * @param beg The day of arrival.
     * @param end The day of departure.
     * @return True if the reservation was successful.
     */
    
    public boolean reservation(int beg, int end) {
    return this.checkAvailability(beg, end);
    }

    /**
     * Checks the availability of the accommodation for the given period.
     * @param beg The day of arrival.
     * @param end The day of departure.
     * @return True if it is available.
     */
    
    private boolean checkAvailability (int beg, int end) {
        for (int i = beg; i<end+1; i++) {
            if (!availability[i])
                return false;
        }
        return true;
    }

    /**
     * Changes the availability of the accommodation for the given period.
     * @param beg The day of arrival.
     * @param end The day of departure.
     * @param a The availability factor.
     */
    
    public void changeAvailability (int beg, int end, boolean a) {
            for (int i = beg; i<end+1; i++) {
                availability[i] = a;
            }
    }

}
