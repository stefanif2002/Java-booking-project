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
     * Users applications control interface.
     * @param s
     * @param i
     * @return 
     */

    public Customer waitingListCustomer (Storage s, int i) {
        return this.customersWaitingList.get(i);
    }
    
    public int waitingListCustomerSize () {
        return this.customersWaitingList.size();
    }
    
    public AcProvider waitingListProvider (Storage s, int i) {
        return this.AcProvidersWaitingList.get(i);
    }
    
    public int waitingListProviderSize () {
        return this.AcProvidersWaitingList.size();
    }
}
