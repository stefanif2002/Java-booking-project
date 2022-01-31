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
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
/**
 *
 * @author Dell i7
 */
public class GeneralGUI extends JFrame implements ActionListener{

protected Storage myStorage;
protected Files myFiles;
protected JPanel opening, login, mediator, registrationClient, registrationProvider;
protected HashMap <String, JPanel> ClientGUI;
protected HashMap <String, JPanel> ProviderGUI;
protected HashMap <String, JPanel> ManagerGUI;
protected JLabel tryAgain, tryAgain2, tryAgain3, tryAgain4, tryAgain5, success, success1, succcess2, succcess3, succcess4, succcess5, success6, success7, success8, declined, appNone, notSeen;
protected String beds[] = {"1", "2", "3", "4"};
protected String tempUser, userApl;
protected Accommodation ex;
protected Booking ex2;
protected AcProvider ex3;
protected Customer ex4;
protected JComboBox Ac, Ac2, Book, manBook, cust, pro;
protected int x, y, count;
    
    public GeneralGUI (Storage s, Files mF) {
        myStorage = s;
        myFiles = mF;
        ClientGUI = new HashMap <> ();
        ProviderGUI = new HashMap <> ();
        ManagerGUI = new HashMap <> ();
        createOpening();
        createMediator();
        createLogIn();
        createRegistrationProvider();
        createRegistrationClient ();
        add(opening);
        add(mediator);
        add(login);
        add(registrationProvider);
        add(registrationClient);
        
    }

    
    
    
    

    protected void createOpening () {
        x = 500;
        y = 150;
        
        opening = new JPanel ();
        opening.setBounds(0, 0, 500, 150);
        opening.setLayout(null);
        opening.setVisible(true); 
        
        JLabel title = new JLabel ("Welcome to booking.steve!");
        title.setBounds((x-250)/2, 10, 250, 25);
        title.setFont(new Font("Arial", Font.PLAIN, 20));
        opening.add(title);
        
        JButton log, sign, exit;
        
        log = new JButton ("Log-in");
        log.setBounds((x-400)/2,60,90,30);
        log.addActionListener((ActionEvent e) -> {
            x = 450;
            y = 350;
            setBounds((1920-x)/2, (1080-y)/2, x, y);
            opening.setVisible(false);
            login.setVisible(true);
        });
        opening.add(log);
        
        sign = new JButton ("Sign-up");
        sign.setBounds((x-400)/2+150,60,90,30);
        sign.addActionListener((ActionEvent e) -> {
            opening.setVisible(false);
            mediator.setVisible(true);
        });
        opening.add(sign);
        
        exit = new JButton ("Exit");
        exit.setBounds((x-400)/2+300,60,90,30);
        exit.addActionListener((ActionEvent e) -> {
            try {
                myFiles.writeToAllFiles();
            } catch (IOException ex1) {
                Logger.getLogger(GeneralGUI.class.getName()).log(Level.SEVERE, null, ex1);
            }
            System.exit(0);
        });
        opening.add(exit);
    }
    
    protected void createMediator () {
        mediator = new JPanel ();
        mediator.setBounds(0, 0, 500, 150);
        mediator.setLayout(null);
        mediator.setVisible(false); 
        
        JLabel title = new JLabel ("Please choose your type:");
        title.setBounds(10, 10, 250, 25);
        title.setFont(new Font("Arial", Font.PLAIN, 15));
        mediator.add(title);
        
        JButton log, sign, back;
        
        log = new JButton ("Client");
        log.setBounds(55,60,90,30);
        log.addActionListener((ActionEvent e) -> {
            x = 750;
            y = 600;
            setBounds((1920-x)/2, (1080-y)/2, x, y);
            mediator.setVisible(false);
            registrationClient.setVisible(true);
        });
        mediator.add(log);
        
        sign = new JButton ("Provider");
        sign.setBounds(205,60,90,30);
        sign.addActionListener((ActionEvent e) -> {
            x = 700;
            y = 450;
            setBounds((1920-x)/2, (1080-y)/2, x, y);
            mediator.setVisible(false);
            registrationProvider.setVisible(true);
        });
        mediator.add(sign);
        
        back = new JButton ("Back");
        back.setBounds(355,60,90,30);
        back.addActionListener((ActionEvent e) -> {
            mediator.setVisible(false);
            opening.setVisible(true);
        });
        mediator.add(back);
    }
    
    protected void createLogIn () {
        login = new JPanel ();
        login.setBounds(0, 0, 450, 300);
        login.setLayout(null);
        login.setVisible(false); 
        
        JLabel title = new JLabel ("Login Form");
        title.setBounds((x-150)/2, 10, 150, 25);
        title.setFont(new Font("Arial", Font.PLAIN, 20));
        login.add(title);
        
        
        
        JTextField user;
        JPasswordField pass;
        JLabel username, password;
        
        username = new JLabel ("Username: ");
        username.setBounds(10, 60, 80, 20);
        login.add(username);
        
        user = new JTextField ();
        user.setBounds(120, 60, 150, 20);
        login.add(user);
        
        password = new JLabel ("Password: ");
        password.setBounds(10, 110, 80, 20);
        login.add(password);
        
        pass = new JPasswordField ();
        pass.setBounds(120, 110, 150, 20);
        login.add(pass);
        
        
        
        JLabel type;
        JRadioButton manager, provider, client;
        ButtonGroup userGroup;
        
        type = new JLabel ("Type: ");
        type.setBounds(10, 160, 50, 20);
        login.add(type);
        
        manager = new JRadioButton ("Manager");
        manager.setBounds(90, 160, 80, 20);
        manager.setSelected(true);
        login.add(manager);
        
        provider = new JRadioButton ("Provider");
        provider.setBounds(200, 160, 80, 20);
        provider.setSelected(false);
        login.add(provider);
        
        client = new JRadioButton ("Client");
        client.setBounds(310, 160, 80, 20);
        client.setSelected(false);
        login.add(client);
        
        userGroup = new ButtonGroup ();
        userGroup.add(manager);
        userGroup.add(provider);
        userGroup.add(client);
        
        
        
        JButton log, reset, back;
        
        log = new JButton ("Log-in");
        log.setBounds(20,210,90,30);
        log.addActionListener((ActionEvent e) -> {
            String s1 = user.getText();
            String s2 = new String (pass.getPassword());
            user.setText("");
            pass.setText("");
            
                if (manager.isSelected()) {
                    if (myStorage.checkUserPass("manager", s1, s2)) {
                        tempUser = myStorage.manager.getName();
                        tryAgain.setVisible(false);
                        notSeen.setVisible(false);
                        declined.setVisible(false);
                        x = 450;
                        y = 200;
                        setBounds((1920-x)/2, (1080-y)/2, x, y);
                        login.setVisible(false);
                        ManagerGUI.get("mainMenu").setVisible(true);
                    }
                    else {
                        tryAgain.setVisible(true);
                        notSeen.setVisible(false);
                        declined.setVisible(false);
                    }
                    
                } 
                else if (provider.isSelected()) {
                    if (myStorage.checkUserPass("provider", s1, s2)) {
                        tempUser = myStorage.getAcProviderByUsername(s1).getName();
                        switch (myStorage.getAcProvider(tempUser).statusReport()) {
                            case 0 -> {
                                tryAgain.setVisible(false);
                                declined.setVisible(false);
                                notSeen.setVisible(false);
                                x = 400;
                                y = 200;
                                setBounds((1920-x)/2, (1080-y)/2, x, y);
                                login.setVisible(false);
                                ProviderGUI.get("mainMenu").setVisible(true);
                            }
                            case 1 -> {
                                myStorage.removeAcProvider(myStorage.getAcProvider(tempUser));
                                tryAgain.setVisible(false);
                                notSeen.setVisible(false);
                                declined.setVisible(true);
                            }
                            default -> {
                                tryAgain.setVisible(false);
                                notSeen.setVisible(true);
                                declined.setVisible(false);
                            }
                        }
                    }
                    else {
                        tryAgain.setVisible(true);
                        notSeen.setVisible(false);
                        declined.setVisible(false);
                    }
                }
                else {
                    if (myStorage.checkUserPass("client", s1, s2)) {
                        tempUser = myStorage.getCustomerByUsername(s1).getName();
                        switch (myStorage.getCustomer(tempUser).statusReport()) {
                            case 0 -> {
                                tryAgain.setVisible(false);
                                declined.setVisible(false);
                                notSeen.setVisible(false);
                                x = 400;
                                y = 200;
                                setBounds((1920-x)/2, (1080-y)/2, x, y);
                                login.setVisible(false);
                                ClientGUI.get("mainMenu").setVisible(true);
                            }
                            case 1 -> {
                                myStorage.removeCustomer(myStorage.getCustomer(tempUser));
                                tryAgain.setVisible(false);
                                notSeen.setVisible(false);
                                declined.setVisible(true);
                            }
                            default -> {
                                tryAgain.setVisible(false);
                                notSeen.setVisible(true);
                                declined.setVisible(false);
                            }
                        }
                    }
                    else {
                        tryAgain.setVisible(true);
                        notSeen.setVisible(false);
                        declined.setVisible(false);
                    }
                    
                }
            manager.setSelected(true);
            provider.setSelected(false);
            client.setSelected(false);
        });
        login.add(log);
        
        reset = new JButton ("Reset");
        reset.setBounds(170,210,90,30);
        reset.addActionListener((ActionEvent e) -> {
            user.setText("");
            pass.setText("");
            tryAgain.setVisible(false);
            declined.setVisible(false);
            notSeen.setVisible(false);
            manager.setSelected(true);
            provider.setSelected(false);
            client.setSelected(false);
        });
        login.add(reset);
        
        back = new JButton ("Cancel");
        back.setBounds(320,210,90,30);
        back.addActionListener((ActionEvent e) -> {
            user.setText("");
            pass.setText("");
            tryAgain.setVisible(false);
            declined.setVisible(false);
            notSeen.setVisible(false);
            manager.setSelected(true);
            provider.setSelected(false);
            client.setSelected(false);
            x = 500;
            y = 150;
            setBounds((1920-x)/2, (1080-y)/2, x, y);
            login.setVisible(false);
            opening.setVisible(true);
        });
        login.add(back);
        
        tryAgain = new JLabel ("Wrong Username or Password. Please try again...");
        tryAgain.setBounds(10,260,300,30);
        tryAgain.setVisible(false);
        login.add(tryAgain);
        
        declined = new JLabel ("Unfortunatly your application has been declined.");
        declined.setBounds(10,260,300,30);
        declined.setVisible(false);
        login.add(declined);
        
        notSeen = new JLabel ("Unfortunatly your application hasn't been checked yet.");
        notSeen.setBounds(10,260,300,30);
        notSeen.setVisible(false);
        login.add(notSeen);
        
    }
    
    protected void createRegistrationClient () {
        registrationClient = new JPanel ();
        registrationClient.setBounds(0, 0, 750, 600);
        registrationClient.setLayout(null);
        registrationClient.setVisible(false); 
        
        JLabel title = new JLabel ("Client Registration Form");
        title.setBounds(240, 10, 250, 25);
        title.setFont(new Font("Arial", Font.PLAIN, 20));
        registrationClient.add(title);
        
        
        //Texts and Labels
        JTextField name, lastName, address, balance, email, id, dob, phone, user, pin, password, passwordCheck;
        JLabel name1, lastName1,address1, balance1, email1, id1, dob1, phone1, user1, pin1, password1, passwordCheck1;
        
        
        name1 = new JLabel ("Name: ");
        name1.setBounds(10, 60, 80, 20);
        registrationClient.add(name1);
        
        name = new JTextField ();
        name.setBounds(120, 60, 150, 20);
        registrationClient.add(name);
        
        user1 = new JLabel ("Username: ");
        user1.setBounds(330, 60, 80, 20);
        registrationClient.add(user1);
        
        user = new JTextField ();
        user.setBounds(500, 60, 150, 20);
        registrationClient.add(user);
        
        lastName1 = new JLabel ("Last Name: ");
        lastName1.setBounds(10, 110, 80, 20);
        registrationClient.add(lastName1);
        
        lastName = new JTextField ();
        lastName.setBounds(120, 110, 150, 20);
        registrationClient.add(lastName);
        
        password1 = new JLabel ("Password: ");
        password1.setBounds(330, 110, 80, 20);
        registrationClient.add(password1);
        
        password = new JTextField ();
        password.setBounds(500, 110, 150, 20);
        registrationClient.add(password);
        
        email1 = new JLabel ("Email: ");
        email1.setBounds(10, 160, 80, 20);
        registrationClient.add(email1);
        
        email = new JTextField ();
        email.setBounds(120, 160, 150, 20);
        registrationClient.add(email);
        
        passwordCheck1 = new JLabel ("Password check: ");
        passwordCheck1.setBounds(330, 160, 120, 20);
        registrationClient.add(passwordCheck1);
        
        passwordCheck = new JTextField ();
        passwordCheck.setBounds(500, 160, 150, 20);
        registrationClient.add(passwordCheck);
        
        phone1 = new JLabel ("Phone number: ");
        phone1.setBounds(10, 210, 100, 20);
        registrationClient.add(phone1);
        
        phone = new JTextField ();
        phone.setBounds(120, 210, 150, 20);
        registrationClient.add(phone);
        
        balance1 = new JLabel ("Account Balance: ");
        balance1.setBounds(330, 210, 150, 20);
        registrationClient.add(balance1);
        
        balance = new JTextField ();
        balance.setBounds(500, 210, 150, 20);
        registrationClient.add(balance);
        
        address1 = new JLabel ("Address: ");
        address1.setBounds(10, 260, 100, 20);
        registrationClient.add(address1);
        
        address = new JTextField ();
        address.setBounds(120, 260, 150, 20);
        registrationClient.add(address);
        
        pin1 = new JLabel ("Confirmation pin (4-digit): ");
        pin1.setBounds(330, 260, 150, 20);
        registrationClient.add(pin1);
        
        pin = new JTextField ();
        pin.setBounds(500, 260, 150, 20);
        registrationClient.add(pin);
        
        id1 = new JLabel ("Id (6-digit): ");
        id1.setBounds(10, 310, 100, 20);
        registrationClient.add(id1);
        
        id = new JTextField ();
        id.setBounds(120, 310, 150, 20);
        registrationClient.add(id);
        
        dob1 = new JLabel ("Address: ");
        dob1.setBounds(10, 360, 100, 20);
        registrationClient.add(dob1);
        
        dob = new JTextField ();
        dob.setBounds(120, 360, 150, 20);
        registrationClient.add(dob);
        
        
        //Check Box
        JCheckBox terms = new JCheckBox ("Accept Terms and Conditions.");
        terms.setBounds(225, 410, 200, 20);
        registrationClient.add(terms);
        
        
        //Buttons
        JButton log, reset, back;
        
        log = new JButton ("Submit");
        log.setBounds(180,460,90,30);
        log.addActionListener((ActionEvent e) -> {
            if (password.getText().equals(passwordCheck.getText()) && !myStorage.usernameExists("customer", user.getText())) {
                myStorage.addCustomer(name.getText(), lastName.getText(), address.getText(), email.getText(), user.getText(), password.getText(), phone.getText(), dob.getText(), Integer.parseInt(id.getText()), Double.parseDouble(balance.getText()), Integer.parseInt(pin.getText()), false, false);
                tryAgain3.setVisible(false);
                success1.setVisible(true);
            }
            else
                tryAgain3.setVisible(true);
            
            name.setText("");
            address.setText("");
            email.setText("");
            phone.setText("");
            user.setText("");
            pin.setText("");
            password.setText("");
            lastName.setText("");
            balance.setText("");
            id.setText("");
            dob.setText("");
            passwordCheck.setText("");
            terms.setSelected(false);
        });
        registrationClient.add(log);
        
        reset = new JButton ("Reset");
        reset.setBounds(330,460,90,30);
        reset.addActionListener((ActionEvent e) -> {
            name.setText("");
            address.setText("");
            email.setText("");
            phone.setText("");
            user.setText("");
            pin.setText("");
            password.setText("");
            lastName.setText("");
            balance.setText("");
            id.setText("");
            dob.setText("");
            passwordCheck.setText("");
            terms.setSelected(false);
            success1.setVisible(false);
            tryAgain3.setVisible(false);
        });
        registrationClient.add(reset);
        
        back = new JButton ("Back");
        back.setBounds(480,460,90,30);
        back.addActionListener((ActionEvent e) -> {
            name.setText("");
            address.setText("");
            email.setText("");
            phone.setText("");
            user.setText("");
            pin.setText("");
            password.setText("");
            lastName.setText("");
            balance.setText("");
            id.setText("");
            dob.setText("");
            passwordCheck.setText("");
            terms.setSelected(false);
            success1.setVisible(false);
            tryAgain3.setVisible(false);
            x = 500;
            y = 150;
            setBounds((1920-x)/2, (1080-y)/2, x, y);
            registrationClient.setVisible(false);
            opening.setVisible(true);
        });
        registrationClient.add(back);
        
        success1 = new JLabel ("Registration was successfull!!!");
        success1.setBounds(270,510,230,30);
        success1.setFont(new Font("Arial", Font.PLAIN, 15));
        success1.setVisible(false);
        registrationClient.add(success1);
        
        tryAgain3 = new JLabel ("Passwords don't mach or username exists.");
        tryAgain3.setBounds(270,510,230,30);
        tryAgain3.setFont(new Font("Arial", Font.PLAIN, 15));
        tryAgain3.setVisible(false);
        registrationClient.add(tryAgain3);
        
    }
    
    protected void createRegistrationProvider () {
        registrationProvider = new JPanel ();
        registrationProvider.setBounds(0, 0, 700, 450);
        registrationProvider.setLayout(null);
        registrationProvider.setVisible(false); 
        
        JLabel title = new JLabel ("Provider Registration Form");
        title.setBounds(240, 10, 250, 25);
        title.setFont(new Font("Arial", Font.PLAIN, 20));
        registrationProvider.add(title);
        
        
        //Texts and Labels
        JTextField name, address, email, phone, user, pin, password, passwordCheck;
        JLabel name1, address1, email1, phone1, user1, pin1, password1, passwordCheck1;
        
        
        name1 = new JLabel ("Name: ");
        name1.setBounds(10, 60, 80, 20);
        registrationProvider.add(name1);
        
        name = new JTextField ();
        name.setBounds(120, 60, 150, 20);
        registrationProvider.add(name);
        
        user1 = new JLabel ("Username: ");
        user1.setBounds(330, 60, 80, 20);
        registrationProvider.add(user1);
        
        user = new JTextField ();
        user.setBounds(500, 60, 150, 20);
        registrationProvider.add(user);
        
        address1 = new JLabel ("Address: ");
        address1.setBounds(10, 110, 80, 20);
        registrationProvider.add(address1);
        
        address = new JTextField ();
        address.setBounds(120, 110, 150, 20);
        registrationProvider.add(address);
        
        password1 = new JLabel ("Password: ");
        password1.setBounds(330, 110, 80, 20);
        registrationProvider.add(password1);
        
        password = new JTextField ();
        password.setBounds(500, 110, 150, 20);
        registrationProvider.add(password);
        
        email1 = new JLabel ("Email: ");
        email1.setBounds(10, 160, 80, 20);
        registrationProvider.add(email1);
        
        email = new JTextField ();
        email.setBounds(120, 160, 150, 20);
        registrationProvider.add(email);
        
        passwordCheck1 = new JLabel ("Password check: ");
        passwordCheck1.setBounds(330, 160, 120, 20);
        registrationProvider.add(passwordCheck1);
        
        passwordCheck = new JTextField ();
        passwordCheck.setBounds(500, 160, 150, 20);
        registrationProvider.add(passwordCheck);
        
        phone1 = new JLabel ("Phone number: ");
        phone1.setBounds(10, 210, 100, 20);
        registrationProvider.add(phone1);
        
        phone = new JTextField ();
        phone.setBounds(120, 210, 150, 20);
        registrationProvider.add(phone);
        
        pin1 = new JLabel ("Confirmation pin (4-digit): ");
        pin1.setBounds(330, 210, 150, 20);
        registrationProvider.add(pin1);
        
        pin = new JTextField ();
        pin.setBounds(500, 210, 150, 20);
        registrationProvider.add(pin);
        
        
        //Check Box
        JCheckBox terms = new JCheckBox ("Accept Terms and Conditions.");
        terms.setBounds(240, 260, 200, 20);
        registrationProvider.add(terms);
        
        
        //Buttons
        JButton log, reset, back;
        
        log = new JButton ("Submit");
        log.setBounds(150,310,90,30);
        log.addActionListener((ActionEvent e) -> {
            if (password.getText().equals(passwordCheck.getText()) && !myStorage.usernameExists("provider", user.getText())) {
                myStorage.addProvider(name.getText(), address.getText(), email.getText(), user.getText(), password.getText(), phone.getText(), Integer.parseInt(pin.getText()), false, false);
                success.setVisible(true);
                tryAgain4.setVisible(false);
            }
            else
                tryAgain4.setVisible(true);
            name.setText("");
            address.setText("");
            email.setText("");
            phone.setText("");
            user.setText("");
            pin.setText("");
            password.setText("");
            passwordCheck.setText("");
            terms.setSelected(false);
        });
        registrationProvider.add(log);
        
        reset = new JButton ("Reset");
        reset.setBounds(300,310,90,30);
        reset.addActionListener((ActionEvent e) -> {
            name.setText("");
            address.setText("");
            email.setText("");
            phone.setText("");
            user.setText("");
            pin.setText("");
            password.setText("");
            passwordCheck.setText("");
            terms.setSelected(false);
            success.setVisible(false);
            tryAgain4.setVisible(false);
        });
        registrationProvider.add(reset);
        
        back = new JButton ("Back");
        back.setBounds(450,310,90,30);
        back.addActionListener((ActionEvent e) -> {
            name.setText("");
            address.setText("");
            email.setText("");
            phone.setText("");
            user.setText("");
            pin.setText("");
            password.setText("");
            passwordCheck.setText("");
            terms.setSelected(false);
            success.setVisible(false);
            tryAgain4.setVisible(false);
            x = 500;
            y = 150;
            setBounds((1920-x)/2, (1080-y)/2, x, y);
            registrationProvider.setVisible(false);
            opening.setVisible(true);
        });
        registrationProvider.add(back);
        
        success = new JLabel ("Registration was successfull!!!");
        success.setBounds(270,360,230,30);
        success.setFont(new Font("Arial", Font.PLAIN, 15));
        success.setVisible(false);
        registrationProvider.add(success);
        
        tryAgain4 = new JLabel ("Passwords don't mach or username exists.");
        tryAgain4.setBounds(270,360,230,30);
        tryAgain4.setFont(new Font("Arial", Font.PLAIN, 15));
        tryAgain4.setVisible(false);
        registrationProvider.add(tryAgain4);
    }
    
    public void makeVisible () {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds((1920-x)/2, (1080-y)/2, x, y);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
