package mybooking;

/**
 * The Booking class contains the information of a booking.
 * @author Stefanos Ifoulis (AEM: 3998)
 */

public class SubBooking {

public final String bookingName;
public final String costumerName;
public final String accommodationName;
public final int beginning;
public final int ending;
public final int timeOfArrival;

    /**
     * Constructor that initializes the bookings information.
     * @param bN The name of the booking.
     * @param cN The name of the customer.
     * @param aN The name of the accommodation.
     * @param b The date of the arrival.
     * @param e The date of the departure.
     * @param tA The time of the arrival.
     */

    public SubBooking (String bN, String cN, String aN, int b, int e, int tA) {
        bookingName = bN;
        costumerName = cN;
        accommodationName = aN;
        beginning = b;
        ending = e;
        timeOfArrival = tA;
    }

    /**
     * Prints bookings information.
     */
    
    public void printInfo () {
        System.out.println("Booking name: " + bookingName);
        System.out.println("Costumer name: " + costumerName);
        System.out.println("Accommodation name: " + accommodationName);
        System.out.println("Beginning day: " + (beginning+1));
        System.out.println("Ending day: " + (ending+1));
        System.out.println("Time of arrival: " + timeOfArrival);
        System.out.println();
    }
}
  