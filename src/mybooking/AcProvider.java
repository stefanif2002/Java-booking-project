package mybooking;

import static java.lang.constant.ConstantDescs.NULL;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The AcProvider class contains the information of a accommodation provider.
 * @author Stefanos Ifoulis (AEM: 3998)
 */

public class AcProvider {

public ArrayList <Accommodation> myAc;
private String name;
private String base;
private String email;
private String username;
private String password;
private String phoneNumber;
private final int personalPin;
private ArrayList <SubBooking> myB;
private boolean access;
private boolean checked;

    /**
     * Constructor that initializes the providers information.
     * @param name The name of the provider.
     * @param base The last name of the provider.
     * @param email The email of the provider.
     * @param user The username of the provider.
     * @param pass The password of the provider.
     * @param phoneNumber The phone number of the provider.
     * @param pin The personal confirmation pin of the provider.
     */

    public AcProvider (String name, String base, String email, String user, String pass, String phoneNumber, int pin) {
        myAc = new ArrayList <> ();
        myB = new ArrayList <> ();
        this.name = name;
        this.base = base;
        this.email = email;
        username = user;
        password = pass;
        this.phoneNumber = phoneNumber;
        personalPin = pin;
        access = false;
        checked = false;
    }

    /**
     * Refactors providers phone.
     * @param phone Providers phone.
     */
    
    public void setPhoneNumber (String phone) {
        phoneNumber = phone;
    }

    /**
     * @return Providers phone.
     */
    
    public String getPhoneNumber () {
        return phoneNumber;
    }

    /**
     * Refactors providers email.
     * @param email Providers email.
     */
    
    public void setEmail (String email) {
        this.email = email;
    }

    /**
     * @return Providers email.
     */
    
    public String getEmail () {
        return email;
    }

    /**
     * Refactors providers username.
     * @param user Providers username.
     */
    
    private void setUsername (String user) {
        username = user;
    }

    /**
     * @return Managers name.
     */

    public String getUsername () {
        return username;
    }

    /**
     * Refactors providers password.
     * @param pass Providers password.
     */
    
    private void setPassword (String pass) {
        password = pass;
    }

    /**
     * Refactors providers username or password.
     * @param a Type of change, username or password.
     * @param b Providers username or password.
     */
    
    public void changeLoginInfo (String a, String b) {
        switch (a) {
            case "username" -> this.setUsername(b);
            case "password" -> this.setPassword(b);
            default -> System.out.println("Wrong Input");
        }
    }

    /**
     * Refactors providers username and password.
     * @param a Does nothing, just helps differ for the other changeLoginInfo(...) method.
     * @param b Providers username.
     * @param c Providers password.
     */
    
    public void changeLoginInfo (String a, String b, String c) {
        this.setUsername(b);
        this.setPassword(c);
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
     * Refactors providers name.
     * @param name Providers name.
     */
    
    public void setName (String name) {
        this.name = name;
    }

    /**
     * @return Providers name.
     */
    
    public String getName () {
        return name;
    }

    /**
     * Refactors providers name.
     * @param base Providers name.
     */
    
    public void setBase (String base) {
        this.base = base;
    }

    /**
     * @return Providers base.
     */
    
    public String getBase () {
        return base;
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
     * Prints the providers information.
     */

    public void printAcProvidersInfo () {
        System.out.println("Customer info: ");
        System.out.println("Name: " + name);
        System.out.println("Base: " + base);
        System.out.println("Phone number: " + phoneNumber);
        System.out.println("Email: " + email);
        if (myAc.isEmpty())
            return;
        System.out.println("\nProviders accommodations: ");
        for (Accommodation a: myAc) {
            a.printFullDescription();
        }
    }

    /**
     * Verifies the user through his personal pin.
     * @return True if the user is verified and false otherwise.
     */
    
    public boolean personalPinConfirmation () {
        Scanner myScan = new Scanner(System.in);
        for (int i=3; i>0; i--) {
            System.out.print("Insert your confirmation pin: ");
            int pin = myScan.nextInt();
            if (pin==personalPin) {
                return true;
            }
            else {
                System.out.println("Wrong confirmation pin. Please try again");
                System.out.println("You have "+ (i-1) +" more tries.");
            }
        }
        return false;
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
        SubBooking t = new SubBooking (n.getAcName() + " - " + costumerName, costumerName, n.getAcName(), b, e, tA);
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
