package mybooking;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * The Storage class contains all the customers, accommodation providers, the manager
 * and every booking that has been placed (the ones that have been canceled are excluded).
 * Additionally it hosts the sign-up interface for both the customers and the accommodation providers.
 * Finally it includes the accommodation search algorithms.
 * @author @author Stefanos Ifoulis (AEM: 3998)
 */

public class Storage {

public ArrayList <Customer> customers;
public ArrayList <AcProvider> AcProviders;
public Manager manager;
public HashMap <String, Booking> everyBooking;
public HashMap <String, Accommodation> everyAccommodation;

    /**
     * Constructor that initializes the ArrayLists customers, AcProviders, everyBooking and the variable manager.
     * @param name The name of the manager.
     * @param lastName The last name of the manager.
     * @param email The email of the manager.
     * @param user The username of the manager.
     * @param pass The password of the manager.
     * @param pin The personal confirmation pin of the manager.
     */

    public Storage (String name, String lastName, String email, String user, String pass, int pin) {
        customers = new ArrayList <> ();
        AcProviders = new ArrayList<>();
        everyBooking = new HashMap<>();
        everyAccommodation = new HashMap<>();
        manager = new Manager(name, lastName, email, user, pass, pin);
    }

    /**
     * Initializes the ArrayLists customers, AcProviders, everyBooking and the variable manager.
     * @param c List of customers.
     * @param a List of accommodation providers.
     * @param m The manager.
     */

    public Storage (ArrayList <Customer> c, ArrayList <AcProvider> a, Manager m) {
        customers = c;
        AcProviders = a;
        everyBooking = new HashMap<>();
        everyAccommodation = new HashMap<>();
        manager = m;
    }
    
    public void addCustomer (Customer a) {
        customers.add(a);
    }
    
     public void addCustomer (String name, String lastName, String address, String email, String username, String password, String phoneNumber, String d, int i, double pay, int personalPin, boolean access, boolean checked) {
        Customer e = new Customer (name, lastName, address, email, username, password, phoneNumber, d, i, pay, personalPin, access, checked);
        customers.add(e);
        manager.customersWaitingList.add(e);
     }
    
    public void addProvider (AcProvider a) {
        AcProviders.add(a);
    } 
    
    public void addProvider (String name, String address, String email, String username, String password, String phoneNumber, int personalPin, boolean access, boolean checked) {
        AcProvider e = new AcProvider(name, address, email, username, password, phoneNumber, personalPin, access, checked);
        AcProviders.add(e);
        manager.AcProvidersWaitingList.add(e);
    }
    
    public void addAccom (String a, double b, int c, int bed, String o, boolean[] list) {
        this.getAcProvider(o).addAccom(a, b, c, bed, o, list, this);
    }
    
    public void addBooking (String AcName, int beg, int end, int time, String customer) {
        this.getCustomer(customer).placeBooking(everyAccommodation.get(AcName), beg, end, time, this);
    }
    
    public void changeAccom (String ex, double price, int sqm, int bed, boolean services[]) {
        everyAccommodation.get(ex).setPrice(price);
        everyAccommodation.get(ex).setSquareMeters(sqm);
        everyAccommodation.get(ex).setBeds(bed);
        everyAccommodation.get(ex).setAcServicesList(services);
    }
    
    public void changeAcProvider (String name, String address, String email, String phone) {
        this.getAcProvider(name).setAddress(address);
        this.getAcProvider(name).setEmail(email);
        this.getAcProvider(name).setPhoneNumber(phone);
    }
    
    public void changeCustomer (String name, String address, String email, String phone) {
        this.getCustomer(name).setAddress(address);
        this.getCustomer(name).setEmail(email);
        this.getCustomer(name).setPhoneNumber(phone);
    }

    /**
     * Removes the given customer form the customers list.
     * @param temp The customer that is going to be deleted.
     */

    public void removeCustomer (Customer temp) {
        customers.remove(temp);
    }

    /**
     * Removes the given accommodation provider form the customers list.
     * @param temp The accommodation provider that is going to be deleted.
     */

    public void removeAcProvider (AcProvider temp) {
        AcProviders.remove(temp);
    }
    
    public void removeAccommodation (Accommodation tt) {
        tt.getAcProvider(this).accomDelete(this, tt.getAcName());
    }
    
    public void removeBooking (Booking tt) {
        tt.getCustomer(this).cancelBooking(tt, this);
    }
    
    /**
     * Checks whether the given username exists or not.
     * @param type The type of user for which check is needed (customer or provider).
     * @param name The given username.
     * @return True if the username exists otherwise returns false.
     */

    public boolean usernameExists(String type, String name) {
        if (type.equals("customer")) {
            for (Customer a : customers) {
                if (a.getUsername().equals(name)) {
                    return true;
                }
            }
        }
        else if (type.equals("provider")) {
            for (AcProvider a : AcProviders) {
                if (a.getUsername().equals(name)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean checkUserPass (String temp, String user, String pass) {
    switch (temp) {
        case "manager" -> {
            if (manager.checkLogInInfo(user, pass))
                return true;
        }
        case "provider" -> {
            for (AcProvider aa : AcProviders) {
                if (aa.checkLogInInfo(user, pass))
                    return true;
            }
        }
        case "client" -> {
            for (Customer aa : customers) {
                if (aa.checkLogInInfo(user, pass))
                    return true;
            }
        }
        default -> {
        }
    }
        return false;
    }

    /**
     * Checks whether any accommodations exist.
     * @return True if at least 1 accommodation exists and false if there is none.
     */

    private boolean checkAccom () {
        for (AcProvider a : AcProviders) {
            if (!a.accomIsEmpty())
                return true;
        }
        return false;
    }

    /**
     * Checks whether an accommodation exists with the given name.
     * @param name The name of the accommodation.
     * @return True if there is an accommodation with the given name otherwise returns false.
     */

    public boolean AcSearch (String name) {
        return this.everyAccommodation.containsKey(name);
    }

    
    public AcProvider getAcProvider (String name) {
        for (AcProvider temp : AcProviders) {
            if (temp.getName().equals(name))
                return temp;
        }
        return null;
    } 
    
    public Customer getCustomer (String name) {
        for (Customer temp : customers) {
            if (temp.getName().equals(name))
                return temp;
        }
        return null;
    } 
    
    public AcProvider getAcProviderByUsername (String name) {
        for (AcProvider temp : AcProviders) {
            if (temp.getUsername().equals(name))
                return temp;
        }
        return null;
    } 
    
    public Customer getCustomerByUsername (String name) {
        for (Customer temp : customers) {
            if (temp.getUsername().equals(name))
                return temp;
        }
        return null;
    } 



}
