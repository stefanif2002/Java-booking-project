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
import java.awt.event.ActionEvent;
import javax.swing.*;

/**
 *
 * @author Dell i7
 */
public class ManagerGUI extends ClientGUI {
    
    public ManagerGUI (Storage s, Files mF) {
        super(s,mF);
        addToManagerGUI ();
        add(ManagerGUI.get("mainMenu"));
        add(ManagerGUI.get("mediator"));
        add(ManagerGUI.get("viewProviders"));
        add(ManagerGUI.get("viewCustomers"));
        add(ManagerGUI.get("viewBookings"));
        add(ManagerGUI.get("viewBooking"));
        add(ManagerGUI.get("mediator2"));
        add(ManagerGUI.get("viewProviders2"));
        add(ManagerGUI.get("viewCustomers2"));
        add(ManagerGUI.get("viewProvider"));
        add(ManagerGUI.get("viewCustomer"));
    }
    
    protected void addToManagerGUI () {
        ManagerGUI.put("mainMenu", new JPanel ());
        createManagerGUIMainMenu ();
        ManagerGUI.put("viewProvider", new JPanel ());
        createManagerGUIViewProvider ();
        ManagerGUI.put("viewCustomer", new JPanel ());
        createManagerGUIViewCustomer ();
        ManagerGUI.put("viewProviders", new JPanel ());
        createManagerGUIViewProviders ();
        ManagerGUI.put("viewCustomers", new JPanel ());
        createManagerGUIViewCustomers ();
        ManagerGUI.put("mediator", new JPanel ());
        createManagerGUIMediator ();
        ManagerGUI.put("viewBookings", new JPanel ());
        createManagerGUIViewBookings ();
        ManagerGUI.put("viewBooking", new JPanel ());
        createManagerGUIViewBooking ();
        ManagerGUI.put("mediator2", new JPanel ());
        createManagerGUIMediator2 ();
        ManagerGUI.put("viewProviders2", new JPanel ());
        createManagerGUIViewProviders2 ();
        ManagerGUI.put("viewCustomers2", new JPanel ());
        createManagerGUIViewCustomers2 ();
    }
    
    protected void createManagerGUIMainMenu () {
        ManagerGUI.get("mainMenu").setBounds(0, 0, 450, 200);
        ManagerGUI.get("mainMenu").setLayout(null);
        ManagerGUI.get("mainMenu").setVisible(false); 
        
        JLabel title = new JLabel ("Welcome!");
        title.setBounds(175, 10, 100, 20);
        title.setFont(new Font("Arial", Font.PLAIN, 20));
        ManagerGUI.get("mainMenu").add(title);
        
        
        JButton book, search, info, logout;
        
        search = new JButton ("View Users");
        search.setBounds(20,60,200,30);
        search.addActionListener((ActionEvent e) -> {
            x = 500;
            y = 200;
            setBounds((1920-x)/2, (1080-y)/2, x, y);
            ManagerGUI.get("mainMenu").setVisible(false);
            ManagerGUI.get("mediator2").setVisible(true);
        });
        ManagerGUI.get("mainMenu").add(search);
        
        book = new JButton ("View Bookings");
        book.setBounds(20,110,200,30);
        book.addActionListener((ActionEvent e) -> {
            x = 250;
            y = 200;
            setBounds((1920-x)/2, (1080-y)/2, x, y);
            ManagerGUI.get("mainMenu").setVisible(false);
            ManagerGUI.get("viewBookings").setVisible(true);
        });
        ManagerGUI.get("mainMenu").add(book);
        
        info = new JButton ("View Applications");
        info.setBounds(270,60,150,30);
        info.addActionListener((ActionEvent e) -> {
            x = 500;
            y = 200;
            setBounds((1920-x)/2, (1080-y)/2, x, y);
            ManagerGUI.get("mainMenu").setVisible(false);
            ManagerGUI.get("mediator").setVisible(true);
        });
        ManagerGUI.get("mainMenu").add(info);
        
        logout = new JButton ("Log-out");
        logout.setBounds(270,110,150,30);
        logout.addActionListener((ActionEvent e) -> {
            x = 500;
            y = 150;
            setBounds((1920-x)/2, (1080-y)/2, x, y);
            ManagerGUI.get("mainMenu").setVisible(false);
            opening.setVisible(true);
        });
        ManagerGUI.get("mainMenu").add(logout);
    }
    
    protected void createManagerGUIMediator () {
        ManagerGUI.get("mediator").setBounds(0, 0, 500, 200);
        ManagerGUI.get("mediator").setLayout(null);
        ManagerGUI.get("mediator").setVisible(false); 
        
        JLabel title = new JLabel ("Please choose your type:");
        title.setBounds(10, 10, 250, 25);
        title.setFont(new Font("Arial", Font.PLAIN, 15));
        ManagerGUI.get("mediator").add(title);
        
        JButton log, sign, back;
        
        log = new JButton ("Client");
        log.setBounds(55,60,90,30);
        log.addActionListener((ActionEvent e) -> {
            count = myStorage.manager.waitingListCustomerSize();
            if (count>0) {
                appNone.setVisible(false);
                createManagerGUIViewCustomers ();
                x = 500;
                y = 300;
                setBounds((1920-x)/2, (1080-y)/2, x, y);
                ManagerGUI.get("mediator").setVisible(false);
                ManagerGUI.get("viewCustomers").setVisible(true);
            }
            else 
                appNone.setVisible(true);
        });
        ManagerGUI.get("mediator").add(log);
        
        sign = new JButton ("Provider");
        sign.setBounds(205,60,90,30);
        sign.addActionListener((ActionEvent e) -> {
            count = myStorage.manager.waitingListProviderSize();
            if (count>0) {
                appNone.setVisible(false);
                createManagerGUIViewProviders ();
                x = 500;
                y = 250;
                setBounds((1920-x)/2, (1080-y)/2, x, y);
                ManagerGUI.get("mediator").setVisible(false);
                ManagerGUI.get("viewProviders").setVisible(true);
            }
            else 
                appNone.setVisible(true);
        });
        ManagerGUI.get("mediator").add(sign);
        
        back = new JButton ("Back");
        back.setBounds(355,60,90,30);
        back.addActionListener((ActionEvent e) -> {
            appNone.setVisible(false);
            x = 450;
            y = 200;
            setBounds((1920-x)/2, (1080-y)/2, x, y);
            ManagerGUI.get("mediator").setVisible(false);
            ManagerGUI.get("mainMenu").setVisible(true);
        });
        ManagerGUI.get("mediator").add(back);
        
        appNone = new JLabel ("There no applications of that user type for now.");
        appNone.setBounds(10,110,350,30);
        appNone.setFont(new Font("Arial", Font.PLAIN, 15));
        appNone.setVisible(false);
        ManagerGUI.get("mediator").add(appNone);
    }
    
    protected void createManagerGUIViewProviders () {
        ManagerGUI.get("viewProviders").removeAll();
        ManagerGUI.get("viewProviders").setBounds(0, 0, 500, 250);
        ManagerGUI.get("viewProviders").setLayout(null);
        ManagerGUI.get("viewProviders").setVisible(false); 
        
        JLabel title = new JLabel ("Provider applications");
        title.setBounds(10, 10, 250, 25);
        title.setFont(new Font("Arial", Font.PLAIN, 15));
        ManagerGUI.get("viewProviders").add(title);
        
        if (count<=0)
            return;
        
        
        JLabel name , email, address, phone;
        
        name = new JLabel ("Name: " + myStorage.manager.waitingListProvider(myStorage, count-1).getName());
        name.setBounds(10, 60, 150, 25);
        ManagerGUI.get("viewProviders").add(name);
        
        email = new JLabel ("Email: " + myStorage.manager.waitingListProvider(myStorage, count-1).getEmail());
        email.setBounds(210, 60, 150, 25);
        ManagerGUI.get("viewProviders").add(email);
        
        address = new JLabel ("Address: " + myStorage.manager.waitingListProvider(myStorage, count-1).getAddress());
        address.setBounds(10, 110, 150, 25);
        ManagerGUI.get("viewProviders").add(address);
        
        phone = new JLabel ("Phone: " + myStorage.manager.waitingListProvider(myStorage, count-1).getPhoneNumber());
        phone.setBounds(210, 110, 150, 25);
        ManagerGUI.get("viewProviders").add(phone);
        
        
        JButton accept, decline;
        
        accept = new JButton ("Accept");
        accept.setBounds(55,160,90,30);
        accept.addActionListener((ActionEvent e) -> {
            myStorage.getAcProvider(myStorage.manager.waitingListProvider(myStorage, count-1).getName()).application(true);
            myStorage.manager.AcProvidersWaitingList.remove(myStorage.getAcProvider(myStorage.manager.waitingListProvider(myStorage, count-1).getName()));
            pro.addItem(myStorage.manager.waitingListProvider(myStorage, count-1).getName());
            count--;
            if (count>0) {
                createManagerGUIViewProviders ();
            }
            else {
                x = 450;
                y = 200;
                setBounds((1920-x)/2, (1080-y)/2, x, y);
                ManagerGUI.get("viewProviders").setVisible(false);
                ManagerGUI.get("mainMenu").setVisible(true);
            }
        });
        ManagerGUI.get("viewProviders").add(accept);
        
        decline = new JButton ("Decline");
        decline.setBounds(205,160,90,30);
        decline.addActionListener((ActionEvent e) -> {
            myStorage.getAcProvider(myStorage.manager.waitingListProvider(myStorage, count-1).getName()).application(false);
            myStorage.manager.AcProvidersWaitingList.remove(myStorage.getAcProvider(myStorage.manager.waitingListProvider(myStorage, count-1).getName()));
            count--;
            if (count>0) {
                createManagerGUIViewProviders ();
            }
            else {
                x = 450;
                y = 200;
                setBounds((1920-x)/2, (1080-y)/2, x, y);
                ManagerGUI.get("viewProviders").setVisible(false);
                ManagerGUI.get("mainMenu").setVisible(true);
            }
        });
        ManagerGUI.get("viewProviders").add(decline);

    }
    
    protected void createManagerGUIViewCustomers () {
        ManagerGUI.get("viewCustomers").removeAll();
        ManagerGUI.get("viewCustomers").setBounds(0, 0, 500, 300);
        ManagerGUI.get("viewCustomers").setLayout(null);
        ManagerGUI.get("viewCustomers").setVisible(false); 
        
        JLabel title = new JLabel ("Customers applications");
        title.setBounds(10, 10, 250, 25);
        title.setFont(new Font("Arial", Font.PLAIN, 15));
        ManagerGUI.get("viewCustomers").add(title);
        
        
        if (count<=0)
            return;
        
        JLabel name , lastName, email, address, phone, balance;
        
        name = new JLabel ("Name: " + myStorage.manager.waitingListCustomer(myStorage, count-1).getName());
        name.setBounds(10, 60, 150, 25);
        ManagerGUI.get("viewCustomers").add(name);
        
        lastName = new JLabel ("Last name: " + myStorage.manager.waitingListCustomer(myStorage, count-1).getLastName());
        lastName.setBounds(210, 60, 150, 25);
        ManagerGUI.get("viewCustomers").add(lastName);
        
        email = new JLabel ("Email: " + myStorage.manager.waitingListCustomer(myStorage, count-1).getEmail());
        email.setBounds(10, 110, 150, 25);
        ManagerGUI.get("viewCustomers").add(email);
        
        address = new JLabel ("Address: " + myStorage.manager.waitingListCustomer(myStorage, count-1).getAddress());
        address.setBounds(210, 110, 150, 25);
        ManagerGUI.get("viewCustomers").add(address);
        
        phone = new JLabel ("Phone: " + myStorage.manager.waitingListCustomer(myStorage, count-1).getPhoneNumber());
        phone.setBounds(10, 160, 150, 25);
        ManagerGUI.get("viewCustomers").add(phone);
        
        balance = new JLabel ("Balance: " + myStorage.manager.waitingListCustomer(myStorage, count-1).getBalance());
        balance.setBounds(210, 160, 150, 25);
        ManagerGUI.get("viewCustomers").add(balance);
        
        
        JButton accept, decline;
        
        accept = new JButton ("Accept");
        accept.setBounds(55,210,90,30);
        accept.addActionListener((ActionEvent e) -> {
            myStorage.getCustomer(myStorage.manager.waitingListCustomer(myStorage, count-1).getName()).application(true);
            myStorage.manager.customersWaitingList.remove(myStorage.getCustomer(myStorage.manager.waitingListCustomer(myStorage, count-1).getName()));
            pro.addItem(myStorage.manager.waitingListCustomer(myStorage, count-1).getName());
            count--;
            if (count>0) {
                createManagerGUIViewCustomers ();
            }
            else {
                x = 450;
                y = 200;
                setBounds((1920-x)/2, (1080-y)/2, x, y);
                ManagerGUI.get("viewCustomers").setVisible(false);
                ManagerGUI.get("mainMenu").setVisible(true);
            }
        });
        ManagerGUI.get("viewCustomers").add(accept);
        
        decline = new JButton ("Decline");
        decline.setBounds(205,210,90,30);
        decline.addActionListener((ActionEvent e) -> {
            myStorage.getCustomer(myStorage.manager.waitingListCustomer(myStorage, count-1).getName()).application(false);
            myStorage.manager.customersWaitingList.remove(myStorage.getCustomer(myStorage.manager.waitingListCustomer(myStorage, count-1).getName()));
            count--;
            if (count>0) {
                createManagerGUIViewCustomers ();
            }
            else {
                x = 450;
                y = 200;
                setBounds((1920-x)/2, (1080-y)/2, x, y);
                ManagerGUI.get("viewCustomers").setVisible(false);
                ManagerGUI.get("mainMenu").setVisible(true);
            }
        });
        ManagerGUI.get("viewCustomers").add(decline);

    }
    
    public void createManagerGUIViewBookings () {
        ManagerGUI.get("viewBookings").setBounds(0, 0, 250, 200);
        ManagerGUI.get("viewBookings").setLayout(null);
        ManagerGUI.get("viewBookings").setVisible(false);
        
        JLabel title = new JLabel ("Search Bookings");
        title.setBounds(10, 10, 250, 20);
        title.setFont(new Font("Arial", Font.PLAIN, 20));
        ManagerGUI.get("viewBookings").add(title);
        
        
        JLabel name1;
        
        name1 = new JLabel ("Name: ");
        name1.setBounds(10, 60, 50, 20);
        ManagerGUI.get("viewBookings").add(name1);
        
        manBook = new JComboBox ();
        if (!myStorage.everyBooking.isEmpty()) {
            for (Booking temp : myStorage.everyBooking.values()) {
                manBook.addItem(temp.bookingName);
            }
        }
        manBook.setEditable(true);
        manBook.setBounds(70, 60, 65, 20);
        ManagerGUI.get("viewBookings").add(manBook);
        
        
        JButton view, exit;
        
        view = new JButton ("View");
        view.setBounds(25,110,90,30);
        view.addActionListener((ActionEvent e) -> {
            if (manBook.getSelectedItem()!=null) {
                ex2 = myStorage.everyBooking.get((String) manBook.getSelectedItem());
                x = 400;
                y = 300;
                setBounds((1920-x)/2, (1080-y)/2, x, y);
                createManagerGUIViewBooking ();
                ManagerGUI.get("viewBookings").setVisible(false);
                ManagerGUI.get("viewBooking").setVisible(true);
            }
        });
        ManagerGUI.get("viewBookings").add(view);
        
        exit = new JButton ("Back");
        exit.setBounds(125,110,90,30);
        exit.addActionListener((ActionEvent e) -> {
             x = 450;
             y = 200;
             setBounds((1920-x)/2, (1080-y)/2, x, y);
            ManagerGUI.get("viewBookings").setVisible(false);
            ManagerGUI.get("mainMenu").setVisible(true);
        });
        ManagerGUI.get("viewBookings").add(exit);
        
    }
    
    public void createManagerGUIViewBooking () {
        ManagerGUI.get("viewBooking").removeAll();
        ManagerGUI.get("viewBooking").setBounds(0, 0, 400, 300);
        ManagerGUI.get("viewBooking").setLayout(null);
        ManagerGUI.get("viewBooking").setVisible(false);
        
        if (ex2==null)
            return;
        
        JLabel title = new JLabel ("Reservation Info");
        title.setBounds(110, 10, 150, 20);
        title.setFont(new Font("Arial", Font.PLAIN, 20));
        ManagerGUI.get("viewBooking").add(title);
        
        
        JLabel name, Accom, price, beg, end, time;
        
        name = new JLabel ("Name: " + ex2.bookingName);
        name.setBounds(10, 60, 150, 20);
        ManagerGUI.get("viewBooking").add(name);
        
        Accom = new JLabel ("Ac. name: " + ex2.accommodation);
        Accom.setBounds(10, 110, 150, 20);
        ManagerGUI.get("viewBooking").add(Accom);
        
        price = new JLabel ("price: " + ex2.getPrice());
        price.setBounds(10, 160, 150, 20);
        ManagerGUI.get("viewBooking").add(price);
        
        beg = new JLabel ("beg: " + ex2.beginning);
        beg.setBounds(210, 60, 150, 20);
        ManagerGUI.get("viewBooking").add(beg);
        
        end = new JLabel ("end: " + ex2.ending);
        end.setBounds(210, 110, 150, 20);
        ManagerGUI.get("viewBooking").add(end);
        
        time = new JLabel ("time: " + ex2.timeOfArrival);
        time.setBounds(210, 160, 150, 20);
        ManagerGUI.get("viewBooking").add(time);
        
        
        JButton view;
        
        view = new JButton ("Okay");
        view.setBounds(155,210,90,30);
        view.addActionListener((ActionEvent e) -> {
                x = 250;
                y = 200;
                setBounds((1920-x)/2, (1080-y)/2, x, y);
                ManagerGUI.get("viewBooking").setVisible(false);
                ManagerGUI.get("viewBookings").setVisible(true);
        });
        ManagerGUI.get("viewBooking").add(view);
    }
    
    
    protected void createManagerGUIMediator2 () {
        ManagerGUI.get("mediator2").setBounds(0, 0, 500, 200);
        ManagerGUI.get("mediator2").setLayout(null);
        ManagerGUI.get("mediator2").setVisible(false); 
        
        JLabel title = new JLabel ("Please choose your type:");
        title.setBounds(10, 10, 250, 25);
        title.setFont(new Font("Arial", Font.PLAIN, 15));
        ManagerGUI.get("mediator2").add(title);
        
        JButton log, sign, back;
        
        log = new JButton ("Customer");
        log.setBounds(55,60,90,30);
        log.addActionListener((ActionEvent e) -> {
            if (!myStorage.customers.isEmpty()) {
                appNone.setVisible(false);
                x = 250;
                y = 200;
                setBounds((1920-x)/2, (1080-y)/2, x, y);
                ManagerGUI.get("mediator2").setVisible(false);
                ManagerGUI.get("viewCustomers2").setVisible(true);
            }
            else 
                appNone.setVisible(true);
        });
        ManagerGUI.get("mediator2").add(log);
        
        sign = new JButton ("Provider");
        sign.setBounds(205,60,90,30);
        sign.addActionListener((ActionEvent e) -> {
            if (!myStorage.AcProviders.isEmpty()) {
                appNone.setVisible(false);
                x = 250;
                y = 200;
                setBounds((1920-x)/2, (1080-y)/2, x, y);
                ManagerGUI.get("mediator2").setVisible(false);
                ManagerGUI.get("viewProviders2").setVisible(true);
            }
            else 
                appNone.setVisible(true);
        });
        ManagerGUI.get("mediator2").add(sign);
        
        back = new JButton ("Back");
        back.setBounds(355,60,90,30);
        back.addActionListener((ActionEvent e) -> {
            appNone.setVisible(false);
            x = 450;
            y = 200;
            setBounds((1920-x)/2, (1080-y)/2, x, y);
            ManagerGUI.get("mediator2").setVisible(false);
            ManagerGUI.get("mainMenu").setVisible(true);
        });
        ManagerGUI.get("mediator2").add(back);
        
        appNone = new JLabel ("There no users of that user type for now.");
        appNone.setBounds(10,110,350,30);
        appNone.setFont(new Font("Arial", Font.PLAIN, 15));
        appNone.setVisible(false);
        ManagerGUI.get("mediator2").add(appNone);
    }
    
    public void createManagerGUIViewProviders2 () {
        ManagerGUI.get("viewProviders2").setBounds(0, 0, 250, 200);
        ManagerGUI.get("viewProviders2").setLayout(null);
        ManagerGUI.get("viewProviders2").setVisible(false);
        
        JLabel title = new JLabel ("Search Providers");
        title.setBounds(10, 10, 250, 20);
        title.setFont(new Font("Arial", Font.PLAIN, 20));
        ManagerGUI.get("viewProviders2").add(title);
        
        
        JLabel name1;
        
        name1 = new JLabel ("Name: ");
        name1.setBounds(10, 60, 50, 20);
        ManagerGUI.get("viewProviders2").add(name1);
        
        pro = new JComboBox ();
        if (!myStorage.AcProviders.isEmpty()) {
            for (AcProvider temp : myStorage.AcProviders) {
                pro.addItem(temp.getName());
            }
        }
        pro.setEditable(true);
        pro.setBounds(70, 60, 65, 20);
        ManagerGUI.get("viewProviders2").add(pro);
        
        
        JButton view, exit;
        
        view = new JButton ("View");
        view.setBounds(25,110,90,30);
        view.addActionListener((ActionEvent e) -> {
            if (pro.getSelectedItem()!=null) {
                ex3 = myStorage.getAcProvider((String) pro.getSelectedItem());
                x = 500;
                y = 250;
                setBounds((1920-x)/2, (1080-y)/2, x, y);
                createManagerGUIViewProvider ();
                ManagerGUI.get("viewProviders2").setVisible(false);
                ManagerGUI.get("viewProvider").setVisible(true);
            }
        });
        ManagerGUI.get("viewProviders2").add(view);
        
        exit = new JButton ("Back");
        exit.setBounds(125,110,90,30);
        exit.addActionListener((ActionEvent e) -> {
             x = 450;
             y = 200;
             setBounds((1920-x)/2, (1080-y)/2, x, y);
            ManagerGUI.get("viewProviders2").setVisible(false);
            ManagerGUI.get("mainMenu").setVisible(true);
        });
        ManagerGUI.get("viewProviders2").add(exit);
    }
    
    public void createManagerGUIViewCustomers2 () {
        ManagerGUI.get("viewCustomers2").setBounds(0, 0, 250, 200);
        ManagerGUI.get("viewCustomers2").setLayout(null);
        ManagerGUI.get("viewCustomers2").setVisible(false);
        
        JLabel title = new JLabel ("Search Customers");
        title.setBounds(10, 10, 250, 20);
        title.setFont(new Font("Arial", Font.PLAIN, 20));
        ManagerGUI.get("viewCustomers2").add(title);
        
        
        JLabel name1;
        
        name1 = new JLabel ("Name: ");
        name1.setBounds(10, 60, 50, 20);
        ManagerGUI.get("viewCustomers2").add(name1);
        
        cust = new JComboBox ();
        if (!myStorage.customers.isEmpty()) {
            for (Customer temp : myStorage.customers) {
                cust.addItem(temp.getName());
            }
        }
        cust.setEditable(true);
        cust.setBounds(70, 60, 65, 20);
        ManagerGUI.get("viewCustomers2").add(cust);
        
        
        JButton view, exit;
        
        view = new JButton ("View");
        view.setBounds(25,110,90,30);
        view.addActionListener((ActionEvent e) -> {
            if (cust.getSelectedItem()!=null) {
                ex4 = myStorage.getCustomer((String) cust.getSelectedItem());
                x = 500;
                y = 300;
                setBounds((1920-x)/2, (1080-y)/2, x, y);
                createManagerGUIViewCustomer ();
                ManagerGUI.get("viewCustomers2").setVisible(false);
                ManagerGUI.get("viewCustomer").setVisible(true);
            }
        });
        ManagerGUI.get("viewCustomers2").add(view);
        
        exit = new JButton ("Back");
        exit.setBounds(125,110,90,30);
        exit.addActionListener((ActionEvent e) -> {
             x = 450;
             y = 200;
             setBounds((1920-x)/2, (1080-y)/2, x, y);
            ManagerGUI.get("viewCustomers2").setVisible(false);
            ManagerGUI.get("mainMenu").setVisible(true);
        });
        ManagerGUI.get("viewCustomers2").add(exit);
    }
    
    protected void createManagerGUIViewCustomer () {
        ManagerGUI.get("viewCustomer").removeAll();
        ManagerGUI.get("viewCustomer").setBounds(0, 0, 500, 300);
        ManagerGUI.get("viewCustomer").setLayout(null);
        ManagerGUI.get("viewCustomer").setVisible(false); 
        
        JLabel title = new JLabel ("Customer");
        title.setBounds(190, 10, 120, 25);
        title.setFont(new Font("Arial", Font.PLAIN, 25));
        ManagerGUI.get("viewCustomer").add(title);
        
        
        if (ex4==null)
            return;
        
        JLabel name , lastName, email, address, phone, balance;
        
        name = new JLabel ("Name: " + ex4.getName());
        name.setBounds(10, 60, 200, 25);
        ManagerGUI.get("viewCustomer").add(name);
        
        lastName = new JLabel ("Last name: " + ex4.getLastName());
        lastName.setBounds(260, 60, 200, 25);
        ManagerGUI.get("viewCustomer").add(lastName);
        
        email = new JLabel ("Email: " + ex4.getEmail());
        email.setBounds(10, 110, 200, 25);
        ManagerGUI.get("viewCustomer").add(email);
        
        address = new JLabel ("Address: " + ex4.getAddress());
        address.setBounds(260, 110, 200, 25);
        ManagerGUI.get("viewCustomer").add(address);
        
        phone = new JLabel ("Phone: " + ex4.getPhoneNumber());
        phone.setBounds(10, 160, 200, 25);
        ManagerGUI.get("viewCustomer").add(phone);
        
        balance = new JLabel ("Balance: " + ex4.getBalance());
        balance.setBounds(260, 160, 200, 25);
        ManagerGUI.get("viewCustomer").add(balance);
        
        
        JButton accept;
        
        accept = new JButton ("Okay");
        accept.setBounds(195,210,90,30);
        accept.addActionListener((ActionEvent e) -> {
            x = 250;
            y = 200;
            setBounds((1920-x)/2, (1080-y)/2, x, y);
            ManagerGUI.get("viewCustomer").setVisible(false);
            ManagerGUI.get("viewCustomers2").setVisible(true);
        });
        ManagerGUI.get("viewCustomer").add(accept);
        
    }
    
    protected void createManagerGUIViewProvider () {
        ManagerGUI.get("viewProvider").removeAll();
        ManagerGUI.get("viewProvider").setBounds(0, 0, 500, 250);
        ManagerGUI.get("viewProvider").setLayout(null);
        ManagerGUI.get("viewProvider").setVisible(false); 
        
        JLabel title = new JLabel ("Provider");
        title.setBounds(190, 10, 120, 25);
        title.setFont(new Font("Arial", Font.PLAIN, 25));
        ManagerGUI.get("viewProvider").add(title);
        
        
        if (ex3==null)
            return;
        
        JLabel name , email, address, phone;
        
        name = new JLabel ("Name: " + ex3.getName());
        name.setBounds(10, 60, 200, 25);
        ManagerGUI.get("viewProvider").add(name);
        
        email = new JLabel ("Email: " + ex3.getEmail());
        email.setBounds(260, 60, 200, 25);
        ManagerGUI.get("viewProvider").add(email);
        
        address = new JLabel ("Address: " + ex3.getAddress());
        address.setBounds(10, 110, 200, 25);
        ManagerGUI.get("viewProvider").add(address);
        
        phone = new JLabel ("Phone: " + ex3.getPhoneNumber());
        phone.setBounds(260, 110, 200, 25);
        ManagerGUI.get("viewProvider").add(phone);
        
        
        JButton accept;
        
        accept = new JButton ("Okay");
        accept.setBounds(195,160,90,30);
        accept.addActionListener((ActionEvent e) -> {
            x = 250;
            y = 200;
            setBounds((1920-x)/2, (1080-y)/2, x, y);
            ManagerGUI.get("viewProvider").setVisible(false);
            ManagerGUI.get("viewProviders2").setVisible(true);
        });
        ManagerGUI.get("viewProvider").add(accept);

    }
}