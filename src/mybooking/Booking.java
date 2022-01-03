package mybooking;

/**
 * The Booking class contains the information of a booking.
 * @author Stefanos Ifoulis (AEM: 3998)
 */

public class Booking extends SubBooking {

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
     */
    
    public Booking (Accommodation accommodation, int beginning, int ending, int timeOfArrival, String costumerName) {
        super(accommodation.getAcName() + costumerName, costumerName, accommodation, beginning, ending, timeOfArrival);
        this.setPrice(beginning, ending);
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
    
    private void setPrice (int beg, int end) {
        price = accommodation.getAcFinalPrice(end-beg);
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
       accommodation.getAcProvider().reservationConf(accommodation, costumerName, beginning, ending, timeOfArrival);
       this.setReservationStatus(true);
    }

    /**
     * Asks for cancellation confirmation from the provider.
     */
    
    public void askForCancellation () {
       accommodation.getAcProvider().reservationCancel(bookingName, accommodation, beginning, ending);
       this.setReservationStatus(false);
    }

}
