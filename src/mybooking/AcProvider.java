package mybooking;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The AcProvider class contains the information of a accommodation provider.
 * @author Stefanos Ifoulis (AEM: 3998)
 */

public class AcProvider extends SubUser{

public ArrayList <String> myAc;
private ArrayList <String> myB;

    /**
     * Constructor that initializes the providers information.
     * @param name The name of the provider.
     * @param address The last name of the provider.
     * @param email The email of the provider.
     * @param username The username of the provider.
     * @param password The password of the provider.
     * @param phoneNumber The phone number of the provider.
     * @param personalPin The personal confirmation pin of the provider.
     * @param access
     * @param checked
     * @param myAc
     * @param myB
     */

    public AcProvider (String name, String address, String email, String username, String password, String phoneNumber, int personalPin, boolean access, boolean checked, ArrayList <String> myAc, ArrayList <String> myB) {
        super(name, email, username, password, personalPin, address, phoneNumber, access, checked);
        this.myAc = myAc;
        this.myB = myB;
    }
    
    public AcProvider (String name, String address, String email, String username, String password, String phoneNumber, int personalPin, boolean access, boolean checked) {
        super(name, email, username, password, personalPin, address, phoneNumber, access, checked);
        this.myAc = new ArrayList <> ();
        this.myB = new ArrayList <> ();
    }
    
    public ArrayList <String> getMyBookings() {
        return myB;
    }
    
    public ArrayList <String> getAccommodations() {
        return myAc;
    }

    /**
     * Prints the providers information.
     * @param s
     */

    public void printAcProvidersInfo (Storage s) {
        System.out.println("Customer info: ");
        super.printUsersInfo();
        if (myAc.isEmpty())
            return;
        System.out.println("\nProviders accommodations: ");
        for (String a: myAc)
            s.everyAccommodation.get(a).printFullDescription();
    }
    
    public void printAcProviderForManager (Storage s) {
        System.out.println("Providers info: ");
        super.printUsersInfo();
    }

    /**
     * Method to create an accommodation.
     * @param s
     */

    public void accomCreate (Storage s) {
        Scanner myScan = new Scanner(System.in);
        if (this.personalPinConfirmation()) {
            String instName;
            double instPrice;
            int instSquare;
            System.out.print("Please insert the name of the accommodation: ");
            instName = myScan.nextLine();
            System.out.print("Please insert the price of the accommodation: ");
            instPrice = myScan.nextDouble();
            System.out.print("Please insert the square meters of the accommodation: ");
            instSquare = myScan.nextInt();
            Accommodation e = new Accommodation (instName, instPrice, instSquare, this.name);
            this.addAccServices(e);
            myAc.add(e.getAcName());
            s.everyAccommodation.put(e.getAcName(), e);
        }
        else
            System.out.println("Inability to create accommodation due to wrong insertance of pin");
    }

    /**
     * Method to delete an accommodation.
     * @param s
     */
    
    public void accomDelete (Storage s) {
        Scanner myScan = new Scanner(System.in);
        if (this.personalPinConfirmation()) {
            this.printAllAccommodations(s);
            String instName;
            System.out.print("Please insert the name of the accommodation: ");
            instName = myScan.nextLine();
            myAc.remove(instName);
            s.everyAccommodation.remove(instName);
        }
        else
            System.out.println("Inability to delete accommodation due to wrong insertance of pin");
    }

    /**
     * Method to determine whether an accommodation with the given name exists.
     * @param n The given name.
     * @param s
     * @return True if an accommodation with the given name exists and false otherwise.
     */
    
    public boolean accomExist (String n, Storage s) {
        return s.everyAccommodation.containsKey(n) && myAc.contains(n);
    }

    /**
     * Method to determine whether at least 1 accommodation exists.
     * @return True if at least 1 accommodation exists and false otherwise.
     */
    
    public boolean accomIsEmpty () {
        return myAc.isEmpty();
    }

    /**
     * Searches and returns the accommodation with the given name.This method should only be used after the "accomExist (String n)" method,
 o that it's ensured that the accommodation exists.
     * @param n The name of the accommodation.
     * @param s
     * @return The accommodation.
     */
    
    public Accommodation accomFind (String n, Storage s) {
        return s.everyAccommodation.get(n);
    }

    /**
     * Confirms customers reservations.
     * @param n The accommodation.
     * @param t
     * @param b The date of the arrival.
     * @param e The date of the departure.
     * @param tA The time of Arrival.
     */
    
    public void reservationConf (Accommodation n, Booking t,  int b, int e, int tA) {
        n.changeAvailability(b, e, false);
        myB.add(t.bookingName);
    }

    /**
     * Cancels customers reservations.
     * @param bookingName The name of the booking.
     * @param n The accommodation.
     * @param b The date of the arrival.
     * @param e The date of the departure.
     */
    
    public void reservationCancel (String bookingName, Accommodation n, int b, int e) {
        n.changeAvailability(b, e, true);
        if (myB.contains(bookingName))
            myB.remove(bookingName);
    }

    /**
     * Adds services to an accommodations service list.
     * @param n The accommodation.
     */
    
    public void addAccServices (Accommodation n) {
        int total;
        Scanner myScan = new Scanner(System.in);
        System.out.print("Please insert the total of services that you want to insert: ");
        total = myScan.nextInt();
        myScan.nextLine();
        for (int i=0; i<total; i++) {
            System.out.print("Please insert the service that you want to insert: ");
            n.addAcService(myScan.nextLine());
        }

    }

    /**
     * Prints accommodations for the customers.
     * @param s
     */

    public void printForCustomer (Storage s) {
        int counter =0;
        if (myAc.isEmpty()) 
            return;
        System.out.println("Accommodation provider: " + name );
        System.out.println();
        for (String temp : myAc) {
            System.out.println("Accommodation " + (counter+1) + ": " + s.everyAccommodation.get(temp).getAcName());
            counter++;
        }
    }

    /**
     * Prints accommodations for the provider.
     * @param s
     */
    
    public void printForAcProvider (Storage s) {
        this.printAllAccommodations(s);
    }

    /**
     * Prints all accommodations.
     * @param s
     */
    
    private void printAllAccommodations (Storage s) {
        int counter =0;
        if (myAc.isEmpty()) {
            System.out.println("No accommodations found.");
            return;
        }
        for (String temp : myAc) {
            System.out.println("Accommodation " + (counter+1) + ": " + s.everyAccommodation.get(temp).getAcName());
            counter++;
        }
    }

    /**
     * Prints all reservations of the providers accommodations.
     * @param s
     */
    
    public void printAllReservations (Storage s) {
        System.out.println();
        if (myB.isEmpty()) {
            System.out.println("No reservations found.");
            return;
        }
        for (String a : myB) {
            s.everyBooking.get(a).printInfo(s);
        }
    }
    
    public ArrayList <Accommodation> AcSearch (Storage s, ArrayList <String> criteria) {
        ArrayList <Accommodation> total = new ArrayList <> ();
        for (String temp : myAc) {
            total.add(s.everyAccommodation.get(temp));
        }
        return total;
    }

}
