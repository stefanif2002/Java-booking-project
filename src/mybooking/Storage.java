package mybooking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * The Storage class contains all the customers, accommodation providers, the manager
 * and every booking that has been placed (the ones that have been canceled are excluded).
 * Additionally it hosts the sign-up interface for both the customers and the accommodation providers.
 * Finally it includes the accommodation search algorithms.
 * @author @author Stefanos Ifoulis (AEM: 3998)
 */

public class Storage {

public ArrayList <Customer> customers;
public ArrayList <AcProvider> AcProviders;
public Manager manager;
public HashMap <String, Booking> everyBooking;
public HashMap <String, Accommodation> everyAccommodation;

    /**
     * Constructor that initializes the ArrayLists customers, AcProviders, everyBooking and the variable manager.
     * @param name The name of the manager.
     * @param lastName The last name of the manager.
     * @param email The email of the manager.
     * @param user The username of the manager.
     * @param pass The password of the manager.
     * @param pin The personal confirmation pin of the manager.
     */

    public Storage (String name, String lastName, String email, String user, String pass, int pin) {
        customers = new ArrayList <> ();
        AcProviders = new ArrayList<>();
        everyBooking = new HashMap<>();
        everyAccommodation = new HashMap<>();
        manager = new Manager(name, lastName, email, user, pass, pin);
    }

    /**
     * Initializes the ArrayLists customers, AcProviders, everyBooking and the variable manager.
     * @param c List of customers.
     * @param a List of accommodation providers.
     * @param m The manager.
     */

    public Storage (ArrayList <Customer> c, ArrayList <AcProvider> a, Manager m) {
        customers = c;
        AcProviders = a;
        everyBooking = new HashMap<>();
        everyAccommodation = new HashMap<>();
        manager = m;
    }
    
    public void addCustomer (Customer a) {
        customers.add(a);
    }
    
    public void addProvider (AcProvider a) {
        AcProviders.add(a);
    } 

    /**
     * Removes the given customer form the customers list.
     * @param temp The customer that is going to be deleted.
     */

    public void removeCustomer (Customer temp) {
        customers.remove(temp);
    }

    /**
     * Removes the given accommodation provider form the customers list.
     * @param temp The accommodation provider that is going to be deleted.
     */

    public void removeAcProvider (AcProvider temp) {
        AcProviders.remove(temp);
    }
    
    /**
     * @return List of customers.
     */
    
    public  ArrayList <Customer> getCostumers () {
        return customers;
    }

    /**
     * @return List of accommodation providers.
     */
    
    public  ArrayList <AcProvider> getAcProviders () {
        return AcProviders;
    }

    /**
     * @return List of Bookings.
     */
    
    public  HashMap <String, Booking> getBookings () {
        return everyBooking;
    }

    /**
     * Checks whether the given username exists or not.
     * @param type The type of user for which check is needed (customer or provider).
     * @param name The given username.
     * @return True if the username exists otherwise returns false.
     */

    public boolean usernameExists(String type, String name) {
        if (type.equals("customer")) {
            for (Customer a : customers) {
                if (a.getUsername().equals(name)) {
                    System.out.println("Unfortunately a user with the specific username exists.");
                    return true;
                }
            }
        }
        else if (type.equals("provider")) {
            for (AcProvider a : AcProviders) {
                if (a.getUsername().equals(name)) {
                    System.out.println("Unfortunately a user with the specific username exists.");
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks whether any accommodations exist.
     * @return True if at least 1 accommodation exists and false if there is none.
     */

    private boolean checkAccom () {
        for (AcProvider a : AcProviders) {
            if (!a.accomIsEmpty())
                return true;
        }
        return false;
    }

    /**
     * Accommodation search interface with no criteria.
     */

    public void AcSearch () {
        if (this.checkAccom()) {
            Scanner myScan = new Scanner(System.in);
            String b;
            for (AcProvider a : AcProviders) {
                a.printForCustomer(this);
            }
            System.out.println("Which accommodation would you like to see info for: ");
            b = myScan.nextLine();
            if (AcSearch(b)) {
                Accommodation temp = AcReturn(b);
                temp.printFullDescription();
            }
            else
                System.out.println("Accommodation not found.");
        }
        else {
            System.out.println("Unfortunately there are no accommodations yet.");
        }
    }

    /**
     * Checks whether an accommodation exists with the given name.
     * @param name The name of the accommodation.
     * @return True if there is an accommodation with the given name otherwise returns false.
     */

    public boolean AcSearch (String name) {
        return this.everyAccommodation.containsKey(name);
    }

    /**
     * Accommodation search interface with criteria.
     * @param criteria The criteria.
     */

    public void AcSearch (ArrayList <String> criteria) {
        if (this.checkAccom()) {
            ArrayList <Accommodation> total = new ArrayList <> ();
            for (AcProvider tempAcPr : AcProviders) {
                total.addAll(tempAcPr.AcSearch(this, criteria));
            }
            if (total.isEmpty()) {
                System.out.println("No accommodations found with the specific criteria.");
                return;
            }
            this.printAcSearch(total);
        }
        else {
            System.out.println("Unfortunately there are no accommodations yet.");
        }
    }

    /**
     * Searches and returns the accommodation with the given name.
     * This method should only be used after the "AcSearch (String name)" method,
     * so that it's ensured that the accommodation exists.
     * @param name The name of the accommodation.
     * @return The accommodation.
     */

    public Accommodation AcReturn (String name) {
        return this.everyAccommodation.get(name);
    }

    /**
     * Prints a list of accommodation names and
     * then prints the full accommodation description for the one that the user picks.
     * @param temp The list of accommodations.
     */
    
    private void printAcSearch (ArrayList <Accommodation> temp) {
        Scanner myScan = new Scanner(System.in);
        String b;
        for (Accommodation accommodation : temp) {
            System.out.println(accommodation.getAcName());
        }
        System.out.println("Which accommodation would you like to see info for: ");
        b = myScan.nextLine();
        for (Accommodation a: temp ) {
            if (a.getAcName().equals(b))
                a.printFullDescription();
        }
    }

    /**
     * Prints all the bookings that exist.
     * @return True if there has been placed at least 1 booking and false if there is none.
     */

    public boolean printAllBookings () {
        System.out.println();
        int i = 0;
        if (everyBooking.isEmpty()) {
            System.out.println("There are no bookings placed yet.");
            return false;
        }
        for (String temp : everyBooking.keySet()) {
            i++;
            System.out.print(i + ". ");
            System.out.println(everyBooking.get(temp).bookingName);
        }
        return true;
    }

    /**
     * Prints all the users of the given type (customer or accommodation provider).
     * @param type The type of the user (customer or provider).
     * @return true if at least 1 user, of the certain type, exists and false otherwise.
     */
    
    public boolean printAllUsers (String type) {
        int i = 0;
        if (type.equals("customer")) {
            if (customers.isEmpty()) {
                System.out.println("There are no customers yet.");
                return false;
            }
            for (Customer temp : customers) {
                i++;
                System.out.println(i + ". " + temp.getName());
            }
        }
        else if (type.equals("provider")) {
            if (AcProviders.isEmpty()) {
                System.out.println("There are no accommodation providers yet.");
                return false;
            }
            for (AcProvider temp : AcProviders) {
                i++;
                System.out.println(i + ". " +temp.getName());
            }
        }
        return true;
    }


}
