package mybooking;

import static java.lang.constant.ConstantDescs.NULL;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The AcProvider class contains the information of a accommodation provider.
 * @author Stefanos Ifoulis (AEM: 3998)
 */

public class AcProvider extends SubUser{

public ArrayList <Accommodation> myAc;
private ArrayList <SubBooking> myB;

    /**
     * Constructor that initializes the providers information.
     * @param name The name of the provider.
     * @param address The last name of the provider.
     * @param email The email of the provider.
     * @param username The username of the provider.
     * @param password The password of the provider.
     * @param phoneNumber The phone number of the provider.
     * @param personalPin The personal confirmation pin of the provider.
     */

    public AcProvider (String name, String address, String email, String username, String password, String phoneNumber, int personalPin) {
        super(name, email, username, password, personalPin, address, phoneNumber);
        myAc = new ArrayList <> ();
        myB = new ArrayList <> ();
    }

    /**
     * Prints the providers information.
     */

    public void printAcProvidersInfo () {
        System.out.println("Customer info: ");
        super.printUsersInfo();
        if (myAc.isEmpty())
            return;
        System.out.println("\nProviders accommodations: ");
        for (Accommodation a: myAc) {
            a.printFullDescription();
        }
    }

    /**
     * Method to create an accommodation.
     */

    public void accomCreate () {
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
            Accommodation e = new Accommodation (instName, instPrice, instSquare, this);
            this.addAccServices(e);
            myAc.add(e);
        }
        else
            System.out.println("Inability to create accommodation due to wrong insertance of pin");
    }

    /**
     * Method to delete an accommodation.
     */
    
    public void accomDelete () {
        Scanner myScan = new Scanner(System.in);
        if (this.personalPinConfirmation()) {
            this.printAllAccommodations();
            String instName;
            System.out.print("Please insert the name of the accommodation: ");
            instName = myScan.nextLine();
            myAc.remove(this.accomFind(instName));
        }
        else
            System.out.println("Inability to delete accommodation due to wrong insertance of pin");
    }

    /**
     * Method to determine whether an accommodation with the given name exists.
     * @param n The given name.
     * @return True if an accommodation with the given name exists and false otherwise.
     */
    
    public boolean accomExist (String n) {
        for (Accommodation e : myAc) {
            if (e.getAcName().equals(n))
                return true;
        }
        return false;
    }

    /**
     * Method to determine whether at least 1 accommodation exists.
     * @return True if at least 1 accommodation exists and false otherwise.
     */
    
    public boolean accomIsEmpty () {
        return myAc.isEmpty();
    }

    /**
     * Searches and returns the accommodation with the given name.
     * This method should only be used after the "accomExist (String n)" method,
     * o that it's ensured that the accommodation exists.
     * @param n The name of the accommodation.
     * @return The accommodation.
     */
    
    public Accommodation accomFind (String n) {
        for (Accommodation e : myAc) {
            if (e.getAcName().equals(n))
                return e;
        }
        return (Accommodation) NULL;
    }

    /**
     * Confirms customers reservations.
     * @param n The accommodation.
     * @param costumerName The name of the costumer.
     * @param b The date of the arrival.
     * @param e The date of the departure.
     * @param tA The time of Arrival.
     */
    
    public void reservationConf (Accommodation n, String costumerName,  int b, int e, int tA) {
        n.changeAvailability(b, e, false);
        SubBooking t = new SubBooking (n.getAcName() + " - " + costumerName, costumerName, n, b, e, tA);
        myB.add(t);
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
        for (SubBooking a : myB) {
            if (bookingName.equals(a.bookingName)) {
                myB.remove(a);
                return;
            }
        }
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
     */

    public void printForCustomer () {
        int counter =0;
        if (myAc.isEmpty()) 
            return;
        System.out.println("Accommodation provider: " + name );
        System.out.println();
        for (Accommodation temp : myAc) {
            System.out.println("Accommodation " + (counter+1) + ": " + temp.getAcName());
            counter++;
        }
    }

    /**
     * Prints accommodations for the provider.
     */
    
    public void printForAcProvider () {
        this.printAllAccommodations();
    }

    /**
     * Prints all accommodations.
     */
    
    private void printAllAccommodations () {
        int counter =0;
        if (myAc.isEmpty()) {
            System.out.println("No accommodations found.");
            return;
        }
        for (Accommodation temp : myAc) {
            System.out.println("Accommodation " + (counter+1) + ": " + temp.getAcName());
            counter++;
        }
    }

    /**
     * Prints all reservations of the providers accommodations.
     */
    
    public void printAllReservations () {
        System.out.println();
        if (myB.isEmpty()) {
            System.out.println("No reservations found.");
            return;
        }
        for (SubBooking a : myB) {
            a.printInfo();
        }
    }

}
