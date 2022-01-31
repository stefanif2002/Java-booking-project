package mybooking;

import java.util.ArrayList;
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
private ArrayList <String> myBookings;

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
     * @param access
     * @param checked
     * @param myBookings
     */

    public Customer (String name, String lastName, String address, String email, String username, String password, String phoneNumber, String d, int i, double pay, int personalPin, boolean access, boolean checked, ArrayList <String> myBookings) {
        super(name, email, username, password, personalPin, address, phoneNumber, access, checked);
        this.myBookings = myBookings;
        this.lastName = lastName;
        dateOfBirth = d;
        id = i;
        balance = pay;
    }
    
    public Customer (String name, String lastName, String address, String email, String username, String password, String phoneNumber, String d, int i, double pay, int personalPin, boolean access, boolean checked) {
        super(name, email, username, password, personalPin, address, phoneNumber, access, checked);
        this.myBookings = new ArrayList <> ();
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
    
    public String getDateOfBirth () {
        return dateOfBirth;
    }

    /**
     * Refactors customers id.
     * @param i Customers id.
     */

    public void setId (int i) {
        id = i;
    }
    
    public int getId () {
        return id;
    }
    
    public ArrayList <String> getMyBookings() {
        return myBookings;
    }

    /**
     * Refactors customers balance.
     * @param n Customers balance.
     */

    public void changeBalance(double n) {
            balance += n;
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
     * @param pin
     * @param s
     * @return True if the booking was successfully placed.
     */

    public boolean placeBooking (Accommodation name, int beg, int end, int time, Storage s) {
        if (name.reservation(beg, end)) {
            Booking e = new Booking(name.getAcName(), beg, end, time,this.name, s);
            if (this.payment(e.getPrice())) {
                e.setPaymentStatus();
                e.askForReserve(s);
                addBooking (e,s);
                return true;
            }
        }
        return false;
    }
    
    private void addBooking (Booking e, Storage s) {
        s.everyBooking.put(e.bookingName, e);
        myBookings.add(e.bookingName);
    }

    /**
     * Verifies the user through his personal pin.
     * @return True if the user is verified and false otherwise.
     */

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
     * @param pin
     * @param s
     */
    public void cancelBooking (Booking name, Storage s) {
            name.askForCancellation(s);
            this.refund(name);
            deleteBooking(name, s);
    }
    
    private void deleteBooking (Booking name, Storage s) {
        myBookings.remove(name.bookingName);
        s.everyBooking.remove(name.bookingName);
    }

    /**
     * Determines whether a booking exists or not.
     * @param name Booking name.
     * @param s
     * @return True if the booking exists.
     */

    public boolean bookingExist (String name, Storage s) {
        return s.everyBooking.containsKey(name) && myBookings.contains(name);
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
     * @param s
     * @return 
     */

    public ArrayList <Booking> returnMyBookings (Storage s) {
        ArrayList <Booking> tt = new ArrayList <> ();
        if (myBookings.isEmpty())
            return null;
        for (String a : myBookings) {
               tt.add(s.everyBooking.get(a));
        }
        if (tt.isEmpty())
            return null;
        return tt;
    }

    /**
     * Searches and returns the booking with the given name.This method should only be used after the "bookingExist (String name)" method,
     * so that it's ensured that the booking exists.
     * @param n Name of the booking.
     * @param s
     * @return The booking.
     */
    
    public Booking returnBooking (String n, Storage s) {
        return s.everyBooking.get(n);
    }

}
