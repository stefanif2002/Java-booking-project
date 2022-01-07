package mybooking;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Manager class contains the information of a manager.
 * @author @author Stefanos Ifoulis (AEM: 3998)
 */

public class Manager extends User {

    private String lastName;
    public ArrayList <Customer> customersWaitingList;
    public ArrayList <AcProvider> AcProvidersWaitingList;

    /**
     * Constructor that initializes the managers information.
     * @param name The name of the manager.
     * @param lastName The last name of the manager.
     * @param email The email of the manager.
     * @param username The username of the manager.
     * @param password The password of the manager.
     * @param personalPin The personal confirmation pin of the manager.
     */

    public Manager (String name, String lastName, String email, String username, String password, int personalPin) {
        super(name, email, username, password, personalPin);
        this.lastName = lastName;
        customersWaitingList = new ArrayList<>();
        AcProvidersWaitingList = new ArrayList<>();
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
     * Searches for the booking with the given name, inside the given list of bookings and prints its information.
     * @param s
     * @param bookingName The given name.
     */

    public void findBooking (Storage s, String bookingName) {
        s.everyBooking.get(bookingName).printInfo(s);
    }

    /**
     * Searches for the customer with the given name, inside the given list of customers and prints his information.
     * @param customers The given list of customers.
     * @param customerInfo The given name.
     * @param s
     */
    
    public void findCustomer (ArrayList <Customer> customers, String customerInfo, Storage s) {
        for (Customer customer : customers) {
            if ((customer.getName().equalsIgnoreCase(customerInfo))||(customer.getLastName().equalsIgnoreCase(customerInfo))||(customer.getEmail().equalsIgnoreCase(customerInfo))||(customer.getAddress().equalsIgnoreCase(customerInfo))||(customer.getPhoneNumber().equalsIgnoreCase(customerInfo))) {
                customer.printCustomerInfo(s);
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
    
    public void findAcProvider (ArrayList <AcProvider> providers, String AcProviderInfo, Storage s) {
        for (AcProvider user : providers) {
            if ((user.getName().equalsIgnoreCase(AcProviderInfo)) || (user.getAddress().equalsIgnoreCase(AcProviderInfo)) || ( user.getEmail().equalsIgnoreCase(AcProviderInfo)) || (user.getPhoneNumber().equalsIgnoreCase(AcProviderInfo))) {
                user.printAcProvidersInfo(s);
                return;
            }
        }
        System.out.println("AcProvider not found.");
    }

    /**
     * Users applications control interface.
     * @param s
     */

    public void waitingList (Storage s) {
        if (this.personalPinConfirmation()) {
            System.out.println();
            Scanner myScan = new Scanner(System.in);
            String temp = "aaa";
            if (customersWaitingList.isEmpty())
                System.out.println("There are no customer applications.\n");
            else {
                for (Customer a: customersWaitingList) {
                    a.printCustomerForManager(s);
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
                a.printAcProviderForManager(s);
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
