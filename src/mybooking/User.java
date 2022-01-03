/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybooking;

import java.util.Scanner;

/**
 *
 * @author Dell i7
 */
public class User {
    
protected String name;
protected String email;
protected String username;
protected String password;
protected final int personalPin;

    public User (String name, String email, String username, String password, int personalPin) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.personalPin = personalPin;
    }
    
    /**
     * Refactors Users name.
     * @param n Users name.
     */

    public void setName (String n) {
        name = n;
    }

    /**
     * @return Users name.
     */
    
    public String getName () {
        return name;
    }
    
    /**
     * Refactors Users email.
     * @param e Users email.
     */
    
    public void setEmail (String e) {
        email = e;
    }

    /**
     * @return Users email.
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
     * @return Users username.
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
     * Verifies the user through his username and password.
     * @param user The given username.
     * @param pass The given password.
     * @return True if the given username and password match with the providers username and password.
     */
    
    public boolean checkLogInInfo (String user, String pass) {
        return user.equals(username) && pass.equals(password);
    }
    
    /**
     * Prints customers information.
     */

    public void printUsersInfo () {
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
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
    
}
