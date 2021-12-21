package mybooking;

import static java.lang.constant.ConstantDescs.NULL;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * The Customer class contains the information of a customer.
 * @author Stefanos Ifoulis (AEM: 3998)
 */

public class Customer {

private String name;
private String lastName;
private String dateOfBirth;
private int id;
private double balance;
private final int paymentAccountPin;
private final String address;
private String phoneNumber;
private String email;
private String username;
private String password;
private LinkedList <Booking> myBookings;
private boolean access;
private boolean checked;

    /**
     * Constructor that initializes the customers information.
     * @param name The name of the customer.
     * @param lastName The last name of the customer.
     * @param ad The address of the customer.
     * @param email The email of the customer.
     * @param user The username of the customer.
     * @param pass The password of the customer.
     * @param phoneNumber The phone number of the customer.
     * @param d The date of birth of the customer.
     * @param i The id of the customer.
     * @param pay The bank account balance of the customer.
     * @param pin The personal confirmation pin of the customer.
     */

    public Customer (String name, String lastName, String ad, String email, String user, String pass, String phoneNumber, String d, int i, double pay, int pin) {
        this.myBookings = new LinkedList <> ();
        this.name = name;
        this.lastName = lastName;
        dateOfBirth = d;
        id = i;
        balance = pay;
        paymentAccountPin = pin;
        address = ad;
        this.phoneNumber = phoneNumber;
        this.email = email;
        username = user;
        password = pass;
        checked = false;
        access = false;
    }

    /**
     * Refactors customers name.
     * @param n Customers name.
     */

    public void setName (String n) {
        name = n;
    }

    /**
     * @return Customers name.
     */
    
    public String getName () {
        return name;
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
     * @return Customers address.
     */

    public String getAddress () {
        return address;
    }

    /**
     * Refactors customers phone number.
     * @param phone Customers phone number.
     */
    
    public void setPhoneNumber (String phone) {
        phoneNumber = phone;
    }

    /**
     * @return Customers phone number.
     */
    
    public String getPhoneNumber () {
        return phoneNumber;
    }

    /**
     * Refactors customers email.
     * @param e Customers email.
     */
    
    public void setEmail (String e) {
        email = e;
    }

    /**
     * @return Customers email.
     */
    
    public String getEmail () {
        return email;
    }

    /**
     * Refactors customers username.
     * @param user Customers username.
     */
    
    private void setUsername (String user) {
        username = user;
    }

    /**
     * @return Customers username.
     */

    public String getUsername () {
        return username;
    }

    /**
     * Refactors customers password.
     * @param pass Customers password.
     */
    
    private void setPassword (String pass) {
        password = pass;
    }

    /**
     * Refactors customers username or password.
     * @param a Type of change, username or password.
     * @param b Customers username or password.
     */

    public void changeLoginInfo (String a, String b) {
        switch (a) {
            case "username" -> this.setUsername(b);
            case "password" -> this.setPassword(b);
            default -> System.out.println("Wrong Input");
        }
    }

    /**
     * Refactors customers username and password.
     * @param a Does nothing, just helps differ for the other changeLoginInfo(...) method.
     * @param b Customers username.
     * @param c Customers password.
     */
    
    public void changeLoginInfo (String a, String b, String c) {
        this.setUsername(b);
        this.setPassword(b);
    }

    /**
     * Changes the status of the user according to the managers approval or denial.
     * @param temp True if the manager approved the user and false otherwise.
     */
    
    public void application (boolean temp) {
        checked = true;
        access = temp;
    }

    /**
     * Defines whether the user should gain access according to the access variable.
     * @return 0 if the user has access, 1 if the user was rejected from the manager and
     * 2 if the manager hasn't checked his application yet.
     */
    
    public int statusReport () {
        if (access){
            System.out.println("\nWelcome!");
            return 0;
        }
        else if (checked) {
            System.out.println("Unfortunately your application was rejected, please try to re-enrol.");
            return 1;
        }
        else {
            System.out.println("Unfortunately the manager hasn't yet confirmed your application.");
            return 2;
        }
    }

    /**
     * Verifies the user through his username and password.
     * @param user The given username.
     * @param pass The given password.
     * @return True if the given username and password match with the providers username and password.
     */
    
    public boolean checkLogInInfo (String user, String pass) {
        return user.equals(username) && pass.equals(password);
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
            if (pin==paymentAccountPin) {
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
        System.out.println("Name: " + name);
        System.out.println("Last name: " + lastName);
        System.out.println("Date of birth: " + dateOfBirth);
        System.out.println("Id: " + id);
        System.out.println("Address: " + address);
        System.out.println("Phone number: " + phoneNumber);
        System.out.println("Email: " + email);
        System.out.println("Balance: " + balance);
        if (myBookings.isEmpty())
            return;
        System.out.println("\nCustomers bookings: ");
        this.printMyBookings();
    }

}
