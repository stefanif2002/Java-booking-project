package mybooking;

/**
 * The Booking class contains the information of a booking.
 * @author Stefanos Ifoulis (AEM: 3998)
 */

public class Booking {

public final String bookingName;
private final String costumerName;
private final Accommodation name;
private boolean paymentStatus = false;
private boolean reservationStatus = false;
private int beginning;
private int ending;
private int timeOfArrival;
private double price;

    /**
     * Constructor that initializes the bookings information.
     * @param n The name of the accommodation.
     * @param beg The date of the arrival.
     * @param end The date of the departure.
     * @param time The time of the arrival.
     * @param name The name of the customer.
     */
    
    public Booking (Accommodation n, int beg, int end, int time, String name) {
        bookingName = n.getAcName() + " - " + name;
        this.name = n;
        costumerName = name;
        beginning = beg;
        ending = end;
        timeOfArrival = time;
        this.setPrice(beg, end);
    }

    /**
     * Sets payment status.
     */

    public void setPaymentStatus () {
        paymentStatus = true;
    }

    /**
     * Sets reservation status.
     */
    
    private void setReservationStatus (boolean a) {
        reservationStatus = a;
    }

    /**
     * Change booking details.
     * @param beg The date of the arrival.
     * @param end The date of the departure.
     * @param time The time of the arrival.
     */
    
    public void changeDetails (int beg, int end, int time) {
        beginning = beg;
        ending = end;
        timeOfArrival = time;
    }

    /**
     * Sets price.
     * @param beg The date of the arrival.
     * @param end The date of the departure.
     */
    
    private void setPrice (int beg, int end) {
        price = name.getAcFinalPrice(end-beg);
    }

    /**
     * @return Price.
     */
    
    public double getPrice () {
        return price;
    }

    /**
     * Asks for reservation confirmation from the provider.
     */

    public void askForReserve () {
       name.getAcProvider().reservationConf(name, costumerName, beginning, ending, timeOfArrival);
       this.setReservationStatus(true);
    }

    /**
     * Asks for cancellation confirmation from the provider.
     */
    
    public void askForCancellation () {
       name.getAcProvider().reservationCancel(bookingName, name, beginning, ending);
       this.setReservationStatus(false);
    }

    /**
     * Prints bookings information.
     */

    public void printInfo () {
        System.out.println("Booking name: " + bookingName);
        System.out.println("Costumer name: " + costumerName);
        System.out.println("Accommodation name: " + name);
        System.out.println("Beginning day: " + (beginning+1));
        System.out.println("Ending day: " + (ending+1));
        System.out.println("Time of arrival: " + timeOfArrival);
        System.out.println();
    }

}
