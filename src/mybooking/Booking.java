package mybooking;

/**
 * The Booking class contains the information of a booking.
 * @author Stefanos Ifoulis (AEM: 3998)
 */

public class Booking {
    
public final String bookingName;
public final String costumerName;
public final String accommodation;
public final int beginning;
public final int ending;
public final int timeOfArrival;
private boolean paymentStatus = false;
private boolean reservationStatus = false;
private double price;

    /**
     * Constructor that initializes the bookings information.
     * @param accommodation The name of the accommodation.
     * @param beginning The date of the arrival.
     * @param ending The date of the departure.
     * @param timeOfArrival The time of the arrival.
     * @param costumerName The name of the customer.
     * @param s
     */
    
    public Booking (String accommodation, int beginning, int ending, int timeOfArrival, String costumerName, Storage s) {
        this.bookingName = accommodation + " - " + costumerName;
        this.costumerName = costumerName;
        this.accommodation = accommodation;
        this.beginning = beginning;
        this.ending = ending;
        this.timeOfArrival = timeOfArrival;
        this.setPrice(beginning, ending, s);
    }
    
    public Booking (String bookingName , String costumerName, String accommodation, int beginning, int ending, int timeOfArrival, double price, boolean paymentStatus, boolean reservationStatus, Storage s) {
        this.bookingName = bookingName;
        this.costumerName = costumerName;
        this.accommodation = accommodation;
        this.beginning = beginning;
        this.ending = ending;
        this.timeOfArrival = timeOfArrival;
        this.setPrice(beginning, ending, s);
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
     * Sets price.
     * @param beg The date of the arrival.
     * @param end The date of the departure.
     */
    
    private void setPrice (int beg, int end, Storage s) {
        price = getAccommodation(s).getAcFinalPrice(end-beg);
    }

    /**
     * @return Price.
     */
    
    public double getPrice () {
        return price;
    }
    
    public boolean getPaymentStatus () {
        return paymentStatus;
    }
    
    public boolean getReservationStatus () {
        return reservationStatus;
    }
    
    public Customer getCustomer (Storage s) {
        return s.getCustomer(costumerName);
    }

    /**
     * Asks for reservation confirmation from the provider.
     * @param s
     */

    public void askForReserve (Storage s) {
       getAccommodation(s).getAcProvider(s).reservationConf(getAccommodation(s), this, beginning, ending, timeOfArrival);
       this.setReservationStatus(true);
    }

    /**
     * Asks for cancellation confirmation from the provider.
     * @param s
     */
    
    public void askForCancellation (Storage s) {
       getAccommodation(s).getAcProvider(s).reservationCancel(bookingName, getAccommodation(s), beginning, ending);
       this.setReservationStatus(false);
    }

    
    private Accommodation getAccommodation (Storage s) {
        return s.everyAccommodation.get(accommodation);
    }

}
