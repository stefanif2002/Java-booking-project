/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybooking;

/**
 * The JavaProject class contains the main method, the user interface and
 * a Storage type object, named a, which links it with the program. <br>
 * @author Stefanos Ifoulis (AEM: 3998)
 */
public class JavaProject {

    /**
     * Main method, it contains the basic interface. <br>
     * In particular determines, according to the user's input, the passage of control. <br>
     * There are 3 main options: <br>
     *      1. Log-in (types of users that can log-in: Customer, Accommodation provider or Manager). <br>
     *      2. Sing-up (types of users that can sign-up: Customer or Accommodation provider). <br>
     *      3. Exit. <br>
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Storage a = new Storage ("Name", "Last Name", "Email@gmail.com", "username", "password", 2021);
        UserInterface project = new UserInterface (a);
        project.mainMenuInterface();
        
        }
        
    
    
}
