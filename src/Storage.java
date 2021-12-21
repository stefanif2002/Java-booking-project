package mybooking;

import static java.lang.constant.ConstantDescs.NULL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * The Storage class contains all the customers, accommodation providers, the manager
 * and every booking that has been placed (the ones that have been canceled are excluded).
 * Additionally it hosts the sign-up interface for both the customers and the accommodation providers.
 * Finally it includes the accommodation search algorithms.
 * @author @author Stefanos Ifoulis (AEM: 3998)
 */

public class Storage {

private ArrayList <Customer> customers;
private ArrayList <AcProvider> AcProviders;
public Manager manager;
private ArrayList <SubBooking> everyBooking;

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
        everyBooking = new ArrayList<>();
        manager = new Manager(name, lastName, email, user, pass, pin);
    }

    /**
     * Initializes the ArrayLists customers, AcProviders, everyBooking and the variable manager.
     * @param c List of customers.
     * @param a List of accommodation providers.
     * @param m The manager.
     */

    public Storage (ArrayList <Customer> c, ArrayList <AcProvider> a,Manager m) {
        customers = c;
        AcProviders = a;
        everyBooking = new ArrayList<>();
        manager = m;
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
    
    public  ArrayList <SubBooking> getBookings () {
        return everyBooking;
    }

    /**
     * Customer sign-up interface.
     * @return The new customer.
     */
    
    public Customer createCustomer () {
        Scanner myScan = new Scanner(System.in);
        String name, lastName, address, email, username, password, dateOfBirth, passwordCheck;
        String phoneNumber;
        int id, pin;
        double balance;
        boolean b = true;
        password = "aaa";
        passwordCheck = "ooo";
        username = "iii";
        System.out.print("Please insert your name: ");
        name = myScan.nextLine();
        System.out.print("Please insert your last name: ");
        lastName = myScan.nextLine();
        System.out.print("Please insert your email: ");
        email = myScan.nextLine();
        System.out.print("Please insert your address: ");
        address = myScan.nextLine();
        System.out.print("Please insert your phoneNumber: ");
        phoneNumber = myScan.nextLine();
        System.out.print("Please insert your id: ");
        id = myScan.nextInt();
        myScan.nextLine();
        System.out.print("Please insert your date of birth: ");
        dateOfBirth = myScan.nextLine();
        while (b) {
            System.out.print("Please insert your preferred username: ");
            username = myScan.nextLine();
            b = usernameExists("provider",username) ;
        }
        while (!password.equals(passwordCheck)) {
            System.out.print("Please insert your preferred password: ");
            password = myScan.nextLine();
            System.out.print("Please insert your preferred password again: ");
            passwordCheck = myScan.nextLine();
            if (!password.equals(passwordCheck))
                System.out.println("Passwords don't match, try again");
        }
        System.out.print("Please insert your bank account balance: ");
        balance = myScan.nextDouble();
        System.out.print("Please insert your personal payment confirmation pin: ");
        pin = myScan.nextInt();
        Customer a = new Customer (name, lastName, address, email, username, password, phoneNumber, dateOfBirth, id, balance, pin);
        customers.add(a);
        return a;
    }

    /**
     * Accommodation provider sign-up interface.
     * @return The new accommodation provider.
     */
    
    public AcProvider createAcProvider () {
        Scanner myScan = new Scanner(System.in);
        String name, base, email, username, password, passwordCheck;
        String phoneNumber;
        boolean b = true;
        password = "aaa";
        passwordCheck = "ooo";
        username = "iii";
        int pin;
        System.out.print("Please insert the name of your business: ");
        name = myScan.nextLine();
        System.out.print("Please insert the address of your business: ");
        base = myScan.nextLine();
        System.out.print("Please insert your email: ");
        email = myScan.nextLine();
        System.out.print("Please insert your phoneNumber: ");
        phoneNumber = myScan.nextLine();
        while (b) {
            System.out.print("Please insert your preferred username: ");
            username = myScan.nextLine();
            b = usernameExists("provider",username) ;
        }
        while (!password.equals(passwordCheck)) {
            System.out.print("Please insert your preferred password: ");
            password = myScan.nextLine();
            System.out.print("Please insert your preferred password again: ");
            passwordCheck = myScan.nextLine();
            if (!password.equals(passwordCheck))
                System.out.println("Passwords don't match, try again");
        }
        System.out.print("Please insert your personal confirmation pin: ");
        pin = myScan.nextInt();
        AcProvider a = new AcProvider (name, base, email, username, password, phoneNumber, pin);
        AcProviders.add(a);
        return a;
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
     * Checks whether the given username exists or not.
     * @param type The type of user for which check is needed (customer or provider).
     * @param name The given username.
     * @return True if the username exists otherwise returns false.
     */

    private boolean usernameExists(String type, String name) {
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
                a.printForCustomer();
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
        for (AcProvider temp : AcProviders) {
            if (temp.accomExist(name))
                return true;
        }
        return false;
    }

    /**
     * Accommodation search interface with criteria.
     * @param criteria The criteria.
     */

    public void AcSearch (ArrayList <String> criteria) {
        if (this.checkAccom()) {
            LinkedList <Accommodation> total = new LinkedList <> ();
            for (AcProvider tempAcPr : AcProviders) {
                tempAcPr.myAc.stream().filter(tempAc -> (tempAc.containsAcListOfServices(criteria))).forEachOrdered(tempAc -> {
                    total.add(tempAc);
                });
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
        for (AcProvider temp : AcProviders) {
            if (temp.accomExist(name))
                return temp.accomFind(name);
         }
        return (Accommodation) NULL;
    }

    /**
     * Prints a list of accommodation names and
     * then prints the full accommodation description for the one that the user picks.
     * @param temp The list of accommodations.
     */
    
    private void printAcSearch (LinkedList <Accommodation> temp) {
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
     * Adds a booking to the everyBooking list.
     * @param bN The bookings name.
     * @param cN The customers name.
     * @param aN The accommodations name.
     * @param b The date of the arrival.
     * @param e The date of the departure.
     * @param tA The time of Arrival.
     */

    public void addSubBooking (String bN, String cN, String aN, int b, int e, int tA) {
        SubBooking temp = new SubBooking (bN, cN, aN, b, e, tA);
        everyBooking.add(temp);
    }

    /**
     * Removes the booking with the given name.
     * @param name The name of the booking.
     */

    public void cancelBooking (String name) {
        for (SubBooking a : everyBooking) {
            if (a.bookingName.equals(name)) {
                everyBooking.remove(a);
                return;
            }
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
        for (SubBooking temp : everyBooking) {
            i++;
            System.out.print(i + ". ");
            System.out.println(temp.bookingName);
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
