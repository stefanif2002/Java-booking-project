package mybooking;

import static java.lang.constant.ConstantDescs.NULL;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * The Customer class contains the information of a customer.
 * @author Stefanos Ifoulis (AEM: 3998)
 */

public class Customer extends SubUser {

private String lastName;
private String dateOfBirth;
private int id;
private double balance;
private LinkedList <Booking> myBookings;

    /**
     * Constructor that initializes the customers information.
     * @param name The name of the customer.
     * @param lastName The last name of the customer.
     * @param address The address of the customer.
     * @param email The email of the customer.
     * @param username The username of the customer.
     * @param password The password of the customer.
     * @param phoneNumber The phone number of the customer.
     * @param d The date of birth of the customer.
     * @param i The id of the customer.
     * @param pay The bank account balance of the customer.
     * @param personalPin The personal confirmation pin of the customer.
     */

    public Customer (String name, String lastName, String address, String email, String username, String password, String phoneNumber, String d, int i, double pay, int personalPin) {
        super(name, email, username, password, personalPin, address, phoneNumber);
        this.myBookings = new LinkedList <> ();
        this.lastName = lastName;
        dateOfBirth = d;
        id = i;
        balance = pay;
    }

    /**
     * Refactors customers last name.
     * @param l Customers last name.
     */
    
    public void setLastName (String l) {
        lastName = l;
    }

    /**
     * @return Customers last name.
     */
    
    public String getLastName () {
        return lastName;
    }

    /**
     * Refactors customers date of birth.
     * @param date Customers date of birth.
     */
    
    public void setDateOfBirth (String date) {
        dateOfBirth = date;
    }

    /**
     * Refactors customers id.
     * @param i Customers id.
     */

    public void setId (int i) {
        id = i;
    }

    /**
     * Refactors customers balance.
     * @param n Customers balance.
     */

    public void changeBalance(double n) {
        if (this.paymentConfirmation()) {
            balance += n;
        }
    }

    /**
     * @return Customers balance.
     */
    
    public double getBalance () {
        return balance;
    }
    

    /**
     * Places a booking.
     * @param name The accommodation.
     * @param beg The date of the arrival.
     * @param end The date of the departure.
     * @param time The time of the arrival.
     * @return True if the booking was successfully placed.
     */

    public boolean placeBooking (Accommodation name, int beg, int end, int time) {
        if (name.reservation(beg, end)) {
            Booking e = new Booking(name, beg, end, time,this.name);
            if (this.paymentConfirmation()) {
                if (this.payment(e.getPrice())) {
                    e.setPaymentStatus();
                    e.askForReserve();
                    myBookings.add(e);
                    return true;
                }
            }
            else {
                System.out.println("Presidure is canceled due too wrong payment confirmation.");
            }
        }
        return false;
    }

    /**
     * Verifies the user through his personal pin.
     * @return True if the user is verified and false otherwise.
     */
    
    private boolean paymentConfirmation () {
        Scanner myScan = new Scanner(System.in);
        for (int i=3; i>0; i--) {
            System.out.print("Insert your confirmation pin: ");
            int pin = myScan.nextInt();
            if (pin==personalPin) {
                return true;
            }
            else {
                System.out.println("Wrong confirmation pin. Please try again.");
                System.out.println("You have "+ i +" more tries.");
            }
        }
        return false;
    }

    /**
     * Carries out the payment.
     * @param price The price of the booking.
     * @return True if the payment was successful and false otherwise.
     */
    
    private boolean payment (double price) {
        if (balance>price) {
            balance -= price;
            return true;
        }
        System.out.println("Not enough balance to make this booking.");
        return false;
    }

    /**
     * Cancels the booking with the given name.
     * @param name
     */
    public void cancelBooking (Booking name) {
        if (this.paymentConfirmation()) {
            name.askForCancellation();
            this.refund(name);
            myBookings.remove(name);
        }
    }

    /**
     * Determines whether a booking exists or not.
     * @param name Booking name.
     * @return True if the booking exists.
     */

    public boolean bookingExist (String name) {
        for (Booking a : myBookings) {
            if (a.bookingName.equals(name))
                return true;
        }
        return false;
    }

    /**
     * Refunds the payment in case of cancellation.
     * @param name
     */
    
    private void refund (Booking name) {
        balance += name.getPrice();
    }

    /**
     * Prints customers bookings.
     */

    public void printMyBookings () {
        for (Booking a : myBookings)
            a.printInfo();
    }

    /**
     * Searches and returns the booking with the given name.
     * This method should only be used after the "bookingExist (String name)" method,
     * so that it's ensured that the booking exists.
     * @param n Name of the booking.
     * @return The booking.
     */
    
    public Booking returnBooking (String n) {
       for (Booking a : myBookings) {
           if (a.bookingName.equals(n))
               return a;
       }
       System.out.println("Booking not found");
       return (Booking) NULL;
    }

    /**
     * Prints customers information.
     */

    public void printCustomerInfo () {
        System.out.println("Customer info: ");
        super.printUsersInfo();
        System.out.println("Last name: " + lastName);
        System.out.println("Date of birth: " + dateOfBirth);
        System.out.println("Id: " + id);
        System.out.println("Balance: " + balance);
        if (myBookings.isEmpty())
            return;
        System.out.println("\nCustomers bookings: ");
        this.printMyBookings();
    }

}
