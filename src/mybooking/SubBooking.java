package mybooking;

/**
 * The Booking class contains the information of a booking.
 * @author Stefanos Ifoulis (AEM: 3998)
 */

public class SubBooking {

public final String bookingName;
public final String costumerName;
public final Accommodation accommodation;
public final int beginning;
public final int ending;
public final int timeOfArrival;

    /**
     * Constructor that initializes the bookings information.
     * @param bookingName The name of the booking.
     * @param costumerName The name of the customer.
     * @param accommodation The accommodation.
     * @param beginning The date of the arrival.
     * @param ending The date of the departure.
     * @param timeOfArrival The time of the arrival.
     */

    public SubBooking (String bookingName, String costumerName, Accommodation accommodation, int beginning, int ending, int timeOfArrival) {
        this.bookingName = bookingName;
        this.costumerName = costumerName;
        this.accommodation = accommodation;
        this.beginning = beginning;
        this.ending = ending;
        this.timeOfArrival = timeOfArrival;
    }


    /**
     * Prints bookings information.
     */

    public void printInfo () {
        System.out.println("Booking name: " + bookingName);
        System.out.println("Costumer name: " + costumerName);
        System.out.println("Accommodation name: " + accommodation.getAcName());
        System.out.println("Beginning day: " + (beginning+1));
        System.out.println("Ending day: " + (ending+1));
        System.out.println("Time of arrival: " + timeOfArrival);
        System.out.println();
    }

}
  