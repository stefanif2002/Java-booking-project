package mybooking;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Manager class contains the information of a manager.
 * @author @author Stefanos Ifoulis (AEM: 3998)
 */

public class Manager {

    private String name;
    private String lastName;
    private String email;
    private final String username;
    private final String password;
    private final int personalPin;
    public ArrayList <Customer> customersWaitingList;
    public ArrayList <AcProvider> AcProvidersWaitingList;

    /**
     * Constructor that initializes the managers information.
     * @param name The name of the manager.
     * @param lastName The last name of the manager.
     * @param email The email of the manager.
     * @param user The username of the manager.
     * @param pass The password of the manager.
     * @param pin The personal confirmation pin of the manager.
     */

    public Manager (String name, String lastName, String email, String user, String pass, int pin) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        username = user;
        password = pass;
        personalPin = pin;
        customersWaitingList = new ArrayList<>();
        AcProvidersWaitingList = new ArrayList<>();
    }

    /**
     * @return Managers name.
     */

    public String getName() {
        return name;
    }

    /**
     * Refactors managers name.
     * @param name Managers name.
     */

    public void setName (String name) {
        this.name = name;
    }

    /**
     * @return Managers last name.
     */

    public String getLastName() {
        return lastName;
    }

    /**
     * Refactors managers last name.
     * @param lastName Managers last name.
     */

    public void setLastName (String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return Managers email.
     */

    public String getEmail() {
        return email;
    }

    /**
     * Refactors managers email.
     * @param email Managers email.
     */

    public void setEmail (String email) {
        this.email = email;
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
     * Verifies the user through his username and password.
     * @param user The given username.
     * @param pass The given password.
     * @return True if the given username and password match with the managers username and password.
     */
    
    public boolean checkLogInInfo (String user, String pass) {
        return user.equals(username) && pass.equals(password);
    }

    /**
     * Searches for the booking with the given name, inside the given list of bookings and prints its information.
     * @param myBookings The given list of bookings.
     * @param bookingName The given name.
     */

    public void findBooking (ArrayList <SubBooking> myBookings, String bookingName) {
        for (SubBooking booking : myBookings) {
            if (booking.bookingName.equalsIgnoreCase(bookingName)) {
                booking.printInfo();
                return;
            }
        }
    }

    /**
     * Searches for the customer with the given name, inside the given list of customers and prints his information.
     * @param customers The given list of customers.
     * @param customerInfo The given name.
     */
    
    public void findCustomer (ArrayList <Customer> customers, String customerInfo) {
        for (Customer customer : customers) {
            if ((customer.getName().equalsIgnoreCase(customerInfo))||(customer.getLastName().equalsIgnoreCase(customerInfo))||(customer.getEmail().equalsIgnoreCase(customerInfo))||(customer.getAddress().equalsIgnoreCase(customerInfo))||(customer.getPhoneNumber().equalsIgnoreCase(customerInfo))) {
                customer.printCustomerInfo();
                return;
            }
        }
        System.out.println("Customer not found.");
    }

    /**
     * Searches for the accommodation provider with the given name, inside the given list of accommodation providers and prints his information.
     * @param providers The given list of accommodation providers.
     * @param AcProviderInfo The given name.
     */
    
    public void findAcProvider (ArrayList <AcProvider> providers, String AcProviderInfo) {
        for (AcProvider user : providers) {
            if ((user.getName().equalsIgnoreCase(AcProviderInfo)) || (user.getBase().equalsIgnoreCase(AcProviderInfo)) || ( user.getEmail().equalsIgnoreCase(AcProviderInfo)) || (user.getPhoneNumber().equalsIgnoreCase(AcProviderInfo))) {
                user.printAcProvidersInfo();
                return;
            }
        }
        System.out.println("AcProvider not found.");
    }

    /**
     * Users applications control interface.
     */

    public void waitingList () {
        if (this.personalPinConfirmation()) {
            System.out.println();
            Scanner myScan = new Scanner(System.in);
            String temp = "aaa";
            if (customersWaitingList.isEmpty())
                System.out.println("There are no customer applications.\n");
            else {
                for (Customer a: customersWaitingList) {
                    a.printCustomerInfo();
                    System.out.println();
                    while (!temp.equals("accept") && !temp.equals("deny")) {
                        System.out.print("Accept or Deny application (type accept or deny): ");
                        temp = myScan.nextLine();
                        System.out.println();
                        switch (temp) {
                            case "accept" -> {
                                a.application(true);
                                System.out.println("Application successfully accepted.");
                            }
                            case "deny" -> {
                                a.application(false);
                                System.out.println("Application successfully denied.");
                            }
                            default -> System.out.println("Wrong input try again.");
                        }
                    }
                }
                customersWaitingList.clear();
            }

            temp = "aaa";

            if (AcProvidersWaitingList.isEmpty())
                System.out.println("There are no accommodation provider applications.\n");
            for (AcProvider a: AcProvidersWaitingList) {
                a.printAcProvidersInfo();
                while (!temp.equals("accept") && !temp.equals("deny")) {
                    System.out.println("Accept or Deny application (type accept or deny): ");
                    temp = myScan.nextLine();
                    System.out.println();
                    switch (temp) {
                        case "accept" -> {
                            a.application(true);
                            System.out.println("Application successfully accepted.");
                        }
                        case "deny" -> {
                            a.application(false);
                            System.out.println("Application successfully denied.");
                        }
                        default -> System.out.println("Wrong input try again.");
                    }
                }
            }
            AcProvidersWaitingList.clear();
        }
    }
}
