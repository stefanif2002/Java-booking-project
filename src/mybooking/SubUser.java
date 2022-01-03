/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybooking;

/**
 *
 * @author Dell i7
 */
public class SubUser extends User {
    
protected final String address;
protected String phoneNumber;
protected boolean access;
protected boolean checked;

    public SubUser (String name, String email, String username, String password, int personalPin, String address, String phoneNumber) {
        super(name, email, username, password, personalPin);
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.checked = false;
        this.access = false;
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
    
@Override
    public void printUsersInfo () {
        super.printUsersInfo();
        System.out.println("Address: " + address);
        System.out.println("Phone number: " + phoneNumber);
    }
    
}
