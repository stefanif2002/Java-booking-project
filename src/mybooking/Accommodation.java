package mybooking;

import java.util.ArrayList;

/**
 * The Accommodation class contains the information of a accommodation.
 * @author Stefanos Ifoulis (AEM: 3998)
 */

public class Accommodation {

private final String name;
private final double price;
private final int squareMeters;
private ArrayList <String> servicesList = new ArrayList <> ();
private boolean[] availability;
private final String owner;

    /**
     * Constructor that initializes the accommodation information.
     * @param a The name of the accommodation.
     * @param b The price of the accommodation.
     * @param c The square meters of the accommodation.
     * @param o The provider of the accommodation.
     */
    
     public Accommodation (String a, double b, int c, String o) {
        availability = new boolean[30];
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
     * @param c The square meters of the accommodation.
     * @param list The list of services of the accommodation.
     * @param av
     * @param o The provider of the accommodation.
     */
    
    public Accommodation (String a, String o, double b, int c, boolean[] av, ArrayList <String> list) {
        availability = av;
        name = a;
        price = b;
        squareMeters = c;
        servicesList = list;
        owner = o;
        this.setAvailability();
    }

    /**
     * @return The name of the accommodation.
     */
    
    public String getAcName () {
        return name;
    }
    
    public String getOwnersName () {
        return owner;
    }
    
    public double getPrice () {
        return price;
    }
    
    public int getSquareMeters () {
        return squareMeters;
    }
    
    public boolean[] getAvailability () {
        return availability;
    }

    /**
     * @param s
     * @return The provider of the accommodation.
     */

    public AcProvider getAcProvider (Storage s) {
        for (AcProvider temp : s.AcProviders) {
            if (temp.name.equals(owner))
                return temp;
        }
        return (AcProvider) null;
    }

    /**
     * @return The list of services of the accommodation.
     */
    
    public ArrayList <String> getAcServicesList () {
        return servicesList;
    }

    /**
     * Refactors accommodations list of services.
     * @param list
     */
    
    public void setAcServicesList (ArrayList <String> list) {
        servicesList = list;
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
     * Prints accommodations services list.
     */

    public void printAcServicesList () {
        System.out.println(servicesList);
    }

    /**
     * Adds service.
     * @param a The service.
     */
    
    public void addAcService (String a) {
        servicesList.add(a);
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

    public boolean containsAcListOfServices (ArrayList <String> a) {
        return servicesList.containsAll(a);
    }

    /**
     * Removes a service.
     * @param a The service.
     */
    
    public void removeAcService (String a) {
        servicesList.remove(a);
    }

    /**
     * Reserves the accommodation for the given period if possible.
     * @param beg The day of arrival.
     * @param end The day of departure.
     * @return True if the reservation was successful.
     */
    
    public boolean reservation(int beg, int end) {
        if (this.checkAvailability(beg, end)) {
            return true;
        }
        else {
            System.out.println("No availability, please choose another set of dates.");
            return false;
        }
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

    /**
     * Prints full description.
     */

    public void printFullDescription () {
        System.out.println("Accommodation's name: " + name);
        System.out.println("Accommodation's owner: " + owner);
        System.out.println("Accommodation's price: " + price);
        System.out.println("Accommodation's squareMeters: " + squareMeters);
        System.out.println("Accommodation's servicesList: ");
        servicesList.forEach(temp -> {
            System.out.println(temp);
        });
        
    }

}
