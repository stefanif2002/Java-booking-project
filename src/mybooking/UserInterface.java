/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybooking;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Dell i7
 */
public class UserInterface {
    
public final Storage a;
private final Scanner myScan;

    
    /**
     * Constructor initializes myScan and a.
     * @param a The storage.
     */

    public UserInterface(Storage a) {
        this.myScan = new Scanner(System.in);
        this.a = a;
    }
    
    public void mainMenuInterface() {
        String type = "aaa";
        System.out.println("\nWelcome!\n");
        while (!type.equals("exit")) {
            System.out.print("Do you wish to log-in, to sign up or exit (type log, sign or exit): ");
            type = myScan.nextLine();
            switch (type) {
                case "log" -> {
                    System.out.print("Please choose your log-in type, customer, Accommodation provider or Manager (type customer, provider or manager): ");
                    type = myScan.nextLine();
                    switch (type) {
                        case "customer" -> customerLogIn();
                        case "provider" -> AcProviderLogIn();
                        case "manager" -> ManagerLogIn();
                    }
                }
                case "sign" -> {
                    System.out.print("Please choose your sign up type, customer or Accommodation provider (type customer or provider): ");
                    type = myScan.nextLine();
                    if (type.equals("customer")) {
                        Customer t = createCustomer();
                        a.manager.customersWaitingList.add(t);
                        System.out.println("Your application has successfully placed, after the managers approval you will be able to log in.\n");
                    }
                    else if (type.equals("provider")) {
                        AcProvider t = createAcProvider();
                        a.manager.AcProvidersWaitingList.add(t);
                        System.out.println("Your application has successfully placed, after the managers approval you will be able to log in.\n");
                    }
                }
                case "exit" -> System.out.print("");
                default -> System.out.println("Wrong input. Please try again.");
            }
            System.out.println();
        }
    }
    
    /**
     * Customer sign-up interface.
     * @return The new customer.
     */
    
    public Customer createCustomer () {
        Scanner myScan = new Scanner(System.in);
        String name, lastName, address, email, username, password, dateOfBirth, passwordCheck;
        String phoneNumber;
        int id, pin;
        double balance;
        boolean b = true;
        password = "aaa";
        passwordCheck = "ooo";
        username = "iii";
        System.out.print("Please insert your name: ");
        name = myScan.nextLine();
        System.out.print("Please insert your last name: ");
        lastName = myScan.nextLine();
        System.out.print("Please insert your email: ");
        email = myScan.nextLine();
        System.out.print("Please insert your address: ");
        address = myScan.nextLine();
        System.out.print("Please insert your phoneNumber: ");
        phoneNumber = myScan.nextLine();
        System.out.print("Please insert your id: ");
        id = myScan.nextInt();
        myScan.nextLine();
        System.out.print("Please insert your date of birth: ");
        dateOfBirth = myScan.nextLine();
        while (b) {
            System.out.print("Please insert your preferred username: ");
            username = myScan.nextLine();
            b = a.usernameExists("provider",username) ;
        }
        while (!password.equals(passwordCheck)) {
            System.out.print("Please insert your preferred password: ");
            password = myScan.nextLine();
            System.out.print("Please insert your preferred password again: ");
            passwordCheck = myScan.nextLine();
            if (!password.equals(passwordCheck))
                System.out.println("Passwords don't match, try again");
        }
        System.out.print("Please insert your bank account balance: ");
        balance = myScan.nextDouble();
        System.out.print("Please insert your personal payment confirmation pin: ");
        pin = myScan.nextInt();
        Customer newC = new Customer (name, lastName, address, email, username, password, phoneNumber, dateOfBirth, id, balance, pin, false, false);
        a.addCustomer(newC);
        return newC;
    }

    /**
     * Accommodation provider sign-up interface.
     * @return The new accommodation provider.
     */
    
    public AcProvider createAcProvider () {
        Scanner myScan = new Scanner(System.in);
        String name, base, email, username, password, passwordCheck;
        String phoneNumber;
        boolean b = true;
        password = "aaa";
        passwordCheck = "ooo";
        username = "iii";
        int pin;
        System.out.print("Please insert the name of your business: ");
        name = myScan.nextLine();
        System.out.print("Please insert the address of your business: ");
        base = myScan.nextLine();
        System.out.print("Please insert your email: ");
        email = myScan.nextLine();
        System.out.print("Please insert your phoneNumber: ");
        phoneNumber = myScan.nextLine();
        while (b) {
            System.out.print("Please insert your preferred username: ");
            username = myScan.nextLine();
            b = a.usernameExists("provider",username) ;
        }
        while (!password.equals(passwordCheck)) {
            System.out.print("Please insert your preferred password: ");
            password = myScan.nextLine();
            System.out.print("Please insert your preferred password again: ");
            passwordCheck = myScan.nextLine();
            if (!password.equals(passwordCheck))
                System.out.println("Passwords don't match, try again");
        }
        System.out.print("Please insert your personal confirmation pin: ");
        pin = myScan.nextInt();
        AcProvider newAc = new AcProvider (name, base, email, username, password, phoneNumber, pin, false, false);
        a.addProvider(newAc);
        return newAc;
    }
    
    /**
     * The customer interface after the user logs-in. <br>
     * There are 7 main options: <br>
     *      1. Search for an accommodation. <br>
     *      2. Place a booking. <br>
     *      3. Cancel a booking. <br>
     *      4. Change user's personal info. <br>
     *      5. Print user's bookings. <br>
     *      6. Print user's balance and if he wishes increasement of balance. <br>
     *      7. Log-out<br>
     * @param p The customer that is currently logged-in. <br>
     */

    public void customerInterface (Customer p) {
        String type = "aaa";
        while (!type.equals("log")) {
            System.out.println();
            System.out.println("Main menu: ");
            System.out.println("1st: Search an accommodation (type search).");
            System.out.println("2nd: Place a booking (type place).");
            System.out.println("3rd: Cancel a booking(type cancel).");
            System.out.println("4rth: Change your personal info (type info).");
            System.out.println("5th: Print my bookings (type bookings).");
            System.out.println("6th: Financial (type balance).");
            System.out.println("7th: Log-out (type log).");
            System.out.print("Write your choice: ");
            type = myScan.nextLine();
            System.out.println();
            switch (type) {
                case "place" -> {
                    String name;
                    int beg, end, time;
                    System.out.print("Accommodation name: ");
                    name = myScan.nextLine();
                    System.out.print("Day of arrival: ");
                    beg = myScan.nextInt();
                    System.out.print("Day of departure: ");
                    end = myScan.nextInt();
                    System.out.print("Time of arrival: ");
                    time = myScan.nextInt();
                    myScan.nextLine();
                    if (a.AcSearch(name)) {
                        if (p.placeBooking(a.AcReturn(name), (beg-1), (end-1), time, this.a)) 
                            System.out.println("Booking successfully placed.");
                    }
                    else
                        System.out.println("Accommodation not found.");
                    }

                case "bookings" -> {
                    while (!p.printMyBookings(a))
                        System.out.println();
                    System.out.println("Press enter to continue...");
                    myScan.nextLine();
                }

                case "balance" ->           {
                    String n;
                    System.out.println("Your current balance is: " + p.getBalance());
                    System.out.print("Would you like to increase your balance: ");
                    n = myScan.nextLine();
                    if (n.equals("yes")) {
                        double bal;
                        System.out.print("Write the amount you want to add: ");
                        bal = myScan.nextDouble();
                        p.changeBalance(bal);
                        myScan.nextLine();
                    }
                }
                    
                case "cancel" -> {
                    String name;
                    System.out.print("Which booking you want to cancel: ");
                    name = myScan.nextLine();
                    if (p.bookingExist(name, a)) {
                        p.cancelBooking(p.returnBooking(name, a) , a);
                        System.out.println("Booking successfully canceled.");
                    }
                    else
                        System.out.println("Something went wrong.");
                }
                case "search" -> this.searchC();
                case "info" -> this.infoAc(p);
                case "log" -> System.out.print("");
                default -> System.out.println("Wrong input. Please try again.");
            }
        }
    }

    /**
     * The accommodation provider interface after the user logs-in. <br>
     * There are 6 main options: <br>
     *      1. Add an accommodation. <br>
     *      2. Delete an accommodation. <br>
     *      3. Search an accommodation. <br>
     *      4. Change user's personal info. <br>
     *      5. Print user's reservations. <br>
     *      6. Log-out
     * @param p The accommodation provider that is currently logged-in.
     */
    
    public void AcProviderInterface (AcProvider p) {
        String type = "aaa";
        while (!type.equals("log")) {
            System.out.println();
            System.out.println("Main menu: ");
            System.out.println("1st: Add an accommodation (type add).");
            System.out.println("2nd: Delete an accommodation (type delete).");
            System.out.println("3rd: Search an accommodation (type search).");
            System.out.println("4rth: Change your personal info (type info).");
            System.out.println("5th: Print all the reservations (type reservations).");
            System.out.println("6th: Log-out (type log).");
            System.out.print("Write your choice: ");
            type = myScan.nextLine();
            System.out.println();
            switch (type) {
                case "add" -> p.accomCreate(a);
                case "delete" -> p.accomDelete(a);
                case "search" -> this.searchAc(p);
                case "info" -> this.infoAc(p);
                case "reservations" -> p.printAllReservations(a);
                case "log" -> System.out.print("");
                default -> System.out.println("Wrong input. Please try again.");
            }
        }
    }

    /**
     * The manager interface after the user logs-in. <br>
     * There are 5 main options: <br>
     *      1. Search a user. <br>
     *      2. Search a booking. <br>
     *      3. Check applications. <br>
     *      4. Message a user (will be created during the second part of the assignment) <br>
     *      5. Log-out
     */
    
    public void ManagerInterface () {
        String type = "aaa";
        while (!type.equals("log")) {
            System.out.println();
            System.out.println("Main menu: ");
            System.out.println("1st: Search a user (type user).");
            System.out.println("2nd: Search a booking (type booking).");
            System.out.println("3rd: Check applications (type applications).");
            System.out.println("4th: Message a user(type message).");
            System.out.println("5th: Log-out (type log).");
            System.out.print("Write your choice: ");
            type = myScan.nextLine();
            System.out.println();
            switch (type) {
                case "user" -> {
                    System.out.print("Which type of user would you like to see info for (type customer or provider): ");
                    type = myScan.nextLine();
                    switch (type) {
                        case "customer" -> {
                            if (a.printAllUsers("customer")) {
                                System.out.print("Which customer would you like to see info for: ");
                                type = myScan.nextLine();
                                a.manager.findCustomer(a.getCostumers(), type, a);
                                System.out.println("Press enter to continue...");
                                myScan.nextLine();
                            }
                        }
                        case "provider" -> {
                            if (a.printAllUsers("provider")) {
                                System.out.print("Which accommodation provider would you like to see info for: ");
                                type = myScan.nextLine();
                                a.manager.findAcProvider(a.getAcProviders(), type, a);
                                System.out.println("Press enter to continue...");
                                myScan.nextLine();
                            }
                        }
                        default -> System.out.println("Wrong input.");
                    }
                }
                case "booking" -> {
                    if (a.printAllBookings()) {
                        System.out.print("Which booking would you like to see info for: ");
                        type = myScan.nextLine();
                        a.manager.findBooking(a, type);
                        System.out.println("Press enter to continue...");
                        myScan.nextLine();
                    }
                }
                case "applications" -> a.manager.waitingList(a);
                case "message" -> System.out.println(); //Will be created during the second part of the assignment
                case "log" -> System.out.print("");
                default -> System.out.println("Wrong input. Please try again.");
            }
        }
    }

    /**
     * Implements the customer's log-in interface and check.
     */

    public void customerLogIn () {
        String username, password;
        System.out.print("Please insert your username: ");
        username = myScan.nextLine();
        System.out.print("Please insert your password: ");
        password = myScan.nextLine();
        for (Customer temp : a.getCostumers()) {
            if (temp.checkLogInInfo(username, password)) {
                int i = temp.statusReport();
                switch (i) {
                    case 0 -> this.customerInterface(temp);
                    case 1 -> this.customerDelete(temp);
                    default -> {}
                }
                return;
            }
        }
        System.out.println("Wrong log-in information.\n");
    }

    /**
     * Customer's delete in case of application denial from the manager.
     * @param temp The customer that gets deleted.
     */
    
    private void customerDelete (Customer temp) {
        a.removeCustomer(temp);
    }

    /**
     * Implements the accommodation provider's log-in interface and check.
     */

    public void AcProviderLogIn () {
        String username, password;
        System.out.print("Please insert your username: ");
        username = myScan.nextLine();
        System.out.print("Please insert your password: ");
        password = myScan.nextLine();
        for (AcProvider temp : a.getAcProviders()) {
            if (temp.checkLogInInfo(username, password)) {
                int i = temp.statusReport();
                switch (i) {
                    case 0 -> this.AcProviderInterface(temp);
                    case 1 -> this.AcProviderDelete(temp);
                    default -> {}
                }
                return;
            }
        }
        System.out.println("Wrong log-in information.\n");
    }

    /**
     * Accommodation provider's delete in case of application denial from the manager.
     * @param temp The accommodation provider that gets deleted.
     */
    
     private void AcProviderDelete (AcProvider temp) {
        a.removeAcProvider(temp);
    }

    /**
     * Implements the manager's log-in interface and check.
     */
     
     public void ManagerLogIn () {
        String username, password;
        System.out.print("Please insert your username: ");
        username = myScan.nextLine();
        System.out.print("Please insert your password: ");
        password = myScan.nextLine();
        if (a.manager.checkLogInInfo(username, password)) 
            this.ManagerInterface();
        else
            System.out.println("Wrong log-in information.\n");
    }

    /**
     * Accommodation's search interface for the provider.
     * @param temp The provider.
     */
    
    private void searchAc (AcProvider temp) {
        Accommodation t;
        String b;
        temp.printForAcProvider(a);
        System.out.println();
        System.out.print("Please insert the name of the accommodation: ");
        b = myScan.nextLine();
        if (temp.accomExist(b,a)) {
            t = temp.accomFind(b,a);
            t.printFullDescription();
            System.out.print("Do you wish to add more services to the accommodation (yes or no): ");
            b = myScan.nextLine();
            if (b.equals("yes"))
                temp.addAccServices(t);
        }
        else
            System.out.println("There is no accommodation with the given name.");
    }

    /**
     * Accommodation's search interface for the customer. <br>
     * There are 2 main options: <br>
     *      1. With criteria. <br>
     *      2. Without criteria. <br>
     */
    
    private void searchC() {
        String t;
        System.out.println();
        System.out.print("Do you wish to search with criteria (type yes or no): ");
        t = myScan.nextLine();
        if (t.equals("yes")) {
            ArrayList <String> b = new ArrayList <> ();
            int total;
            System.out.print("Please insert the total number of the criteria you demand from an accommodation: ");
            total = myScan.nextInt();
            myScan.nextLine();
            System.out.println();
            System.out.print("Please insert the criteria (divided by enter): ");
            for (int i=0; i<total; i++) {
                b.add(myScan.nextLine());
            }
            a.AcSearch(b);
        }
        else {
            a.AcSearch();
        }
        System.out.println("Press enter to continue...");
        myScan.nextLine();
    }

    /**
     * Personal information refactor for the accommodation provider. <br>
     * There are 5 main options: <br>
     *      1. Change name. <br>
     *      2. Change base. <br>
     *      3. Change phone number. <br>
     *      4. Change email. <br>
     *      5. Change username-password.
     * @param temp The provider.
     */
    
    private void infoAc (AcProvider temp) {
        String choice, n;
        System.out.println();
        System.out.println("Options: ");
        System.out.println("1st: Change your name (type name).");
        System.out.println("2nd: Change your phone number (type phone).");
        System.out.println("3rd: Change your email (type email).");
        System.out.println("4th: Change your username-password (type username or password or both).");
        System.out.print("Write your choice: ");
        choice = myScan.nextLine();
        if ("both".equals(choice)) {
            String username, password;
            System.out.print("Please insert your username: ");
            username = myScan.nextLine();
            System.out.print("Please insert your password: ");
            password = myScan.nextLine();
            if (temp.checkLogInInfo(username, password)) {
                String n2;
                System.out.print("Write your new username: ");
                n = myScan.nextLine();
                System.out.print("Write your new password: ");
                n2 = myScan.nextLine();
                temp.changeLoginInfo("both", n, n2);
            }
        }
        else {
            System.out.print("Write your new " + choice + ": ");
            n = myScan.nextLine();
            switch (choice) {
                case "name" -> temp.setName(n);
                case "email" -> temp.setEmail(n);
                case "phone" -> temp.setPhoneNumber(n);
                case "username" -> {
                    String username, password;
                    System.out.print("Please insert your username: ");
                    username = myScan.nextLine();
                    System.out.print("Please insert your password: ");
                    password = myScan.nextLine();
                    if (temp.checkLogInInfo(username, password))
                        temp.changeLoginInfo("username", n);
                }
                case "password" -> {
                    String username, password;
                    System.out.print("Please insert your username: ");
                    username = myScan.nextLine();
                    System.out.print("Please insert your password: ");
                    password = myScan.nextLine();
                    if (temp.checkLogInInfo(username, password))
                        temp.changeLoginInfo("password", n);
                }
                default -> {
                }
            }
        }

    }

    /**
     * Personal information refactor for the customer. <br>
     * There are 7 main options: <br>
     *      1. Change name. <br>
     *      2. Change last name. <br>
     *      3. Change phone number. <br>
     *      4. Change email. <br>
     *      5. Change date of birth. <br>
     *      6. Change id. <br>
     *      7. Change username-password.
     * @param temp The customer.
     */
    
    private void infoAc (Customer temp) {
        String choice, n;
        System.out.println();
        System.out.println("Options: ");
        System.out.println("1st: Change your name (type name).");
        System.out.println("2nd: Change your last name (type last).");
        System.out.println("3rd: Change your phone number (type phone).");
        System.out.println("4th: Change your email (type email).");
        System.out.println("5th: Change your date of birth (type birth).");
        System.out.println("6th: Change your id (type id).");
        System.out.println("7th: Change your username-password (type username or password or both).");
        System.out.print("Write your choice: ");
        choice = myScan.nextLine();
        switch (choice) {
            case "both" ->             {
                String username, password;
                System.out.print("Please insert your username: ");
                username = myScan.nextLine();
                System.out.print("Please insert your password: ");
                password = myScan.nextLine();
                if (temp.checkLogInInfo(username, password)) {
                    String n2;
                    System.out.print("Write your new username: ");
                    n = myScan.nextLine();
                    System.out.print("Write your new password: ");
                    n2 = myScan.nextLine();
                    temp.changeLoginInfo("both", n, n2);
                }
            }

            case "id" ->                {
                int id;
                System.out.print("Write your new id number: ");
                id = myScan.nextInt();
                temp.setId(id);
            }
            default -> {
                System.out.print("Write your new " + choice + ": ");
                n = myScan.nextLine();
                switch (choice) {
                    case "name" -> temp.setName(n);
                    case "last" -> temp.setLastName(n);
                    case "email" -> temp.setEmail(n);
                    case "birth" -> temp.setDateOfBirth(n);
                    case "phone" -> temp.setPhoneNumber(n);
                    case "username" -> {
                        String username, password;
                        System.out.print("Please insert your username: ");
                        username = myScan.nextLine();
                        System.out.print("Please insert your password: ");
                        password = myScan.nextLine();
                        if (temp.checkLogInInfo(username, password))
                            temp.changeLoginInfo("username", n);
                    }
                    case "password" -> {
                        String username, password;
                        System.out.print("Please insert your username: ");
                        username = myScan.nextLine();
                        System.out.print("Please insert your password: ");
                        password = myScan.nextLine();
                        if (temp.checkLogInInfo(username, password))
                            temp.changeLoginInfo("password", n);
                    }
                    default -> {}
                }
            }
        }

    }
}
