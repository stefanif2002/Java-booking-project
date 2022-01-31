package mybooking;

import java.util.ArrayList;

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
    
    public void addAccom (String a, double b, int c, int bed, String o, boolean[] list, Storage s) {
        myAc.add(a);
        s.everyAccommodation.put(a, new Accommodation (a, b, c, bed, o, list));
    }

    /**
     * Method to delete an accommodation.
     * @param s
     * @param name
     */
    
    public void accomDelete (Storage s, String name) {
        myAc.remove(name);
        s.everyAccommodation.remove(name);
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
     * Prints accommodations for the provider.
     * @param s
     * @return 
     */
    
    public ArrayList <Accommodation> returnAcProvidersAccoms (Storage s) {
        ArrayList <Accommodation> tt = new ArrayList <> ();
        for (String a : myAc) {
            tt.add(s.everyAccommodation.get(a));
        }
        if (tt.isEmpty())
            return null;
        return tt;
    }

    /**
     * Prints all reservations of the providers accommodations.
     * @param s
     * @return 
     */
    
    public ArrayList <Booking> printAllReservations (Storage s) {
        ArrayList <Booking> tt = new ArrayList <> ();
        if (myB.isEmpty()) {
            return null;
        }
        for (String a : myB) {
            tt.add(s.everyBooking.get(a));
        }
        return tt;
    }


}
