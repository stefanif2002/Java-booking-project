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
public class ClientGUI extends AcProviderGUI {
    private String dates[]
        = { "1", "2", "3", "4", "5",

            "6", "7", "8", "9", "10",

            "11", "12", "13", "14", "15",

            "16", "17", "18", "19", "20",

            "21", "22", "23", "24", "25",

            "26", "27", "28", "29", "30",

            "31" };
    
    private String hours[]
        = { "00", "01", "02", "03", "04",

            "05", "06", "07", "08", "09",

            "10", "11", "12", "13", "14",

            "15", "16", "17", "18", "19",

            "20", "21", "22", "23"};
    
    public ClientGUI (Storage s, Files mF) {
        super(s,mF);
        addToClientGUI ();
        add(ClientGUI.get("mainMenu"));
        add(ClientGUI.get("searchAccom"));
        add(ClientGUI.get("viewAccom"));
        add(ClientGUI.get("placeBooking"));
        add(ClientGUI.get("viewBookings"));
        add(ClientGUI.get("viewBooking"));
        add(ClientGUI.get("deleteBooking"));
        add(ClientGUI.get("changeInfo"));
    }
    
    protected void addToClientGUI () {
        ClientGUI.put("mainMenu", new JPanel ());
        createClientGUIMainMenu ();
        ClientGUI.put("viewBookings", new JPanel ());
        createClientGUIViewMyBookings ();
        ClientGUI.put("viewBooking", new JPanel ());
        createClientGUIViewBooking ();
        ClientGUI.put("searchAccom", new JPanel ());
        createClientGUISearchAccommodaion ();
        ClientGUI.put("viewAccom", new JPanel ());
        createClientGUIViewAccommodaion ();
        ClientGUI.put("deleteBooking", new JPanel ());
        createClientGUIDeleteBooking ();
        ClientGUI.put("changeInfo", new JPanel ());
        createCustomerGUIInfo ();
        ClientGUI.put("placeBooking", new JPanel ());
        createClientGUIPlaceBooking ();
    }
    
    protected void createClientGUIMainMenu () {
        ClientGUI.get("mainMenu").setBounds(0, 0, 400, 200);
        ClientGUI.get("mainMenu").setLayout(null);
        ClientGUI.get("mainMenu").setVisible(false); 
        
        JLabel title = new JLabel ("Welcome!");
        title.setBounds(150, 10, 100, 20);
        title.setFont(new Font("Arial", Font.PLAIN, 20));
        ClientGUI.get("mainMenu").add(title);
        
        
        JButton book, search, info, logout;
        
        search = new JButton ("Search accommodation");
        search.setBounds(20,60,200,30);
        search.addActionListener((ActionEvent e) -> {
            createClientGUIViewMyBookings ();
            x = 400;
            y = 370;
            setBounds((1920-x)/2, (1080-y)/2, x, y);
            ClientGUI.get("mainMenu").setVisible(false);
            ClientGUI.get("searchAccom").setVisible(true);
        });
        ClientGUI.get("mainMenu").add(search);
        
        book = new JButton ("My Bookings");
        book.setBounds(20,110,200,30);
        book.addActionListener((ActionEvent e) -> {
            createClientGUIViewMyBookings ();
            x = 250;
            setBounds((1920-x)/2, (1080-y)/2, x, y);
            ClientGUI.get("mainMenu").setVisible(false);
            ClientGUI.get("viewBookings").setVisible(true);
        });
        ClientGUI.get("mainMenu").add(book);
        
        info = new JButton ("Info");
        info.setBounds(270,60,90,30);
        info.addActionListener((ActionEvent e) -> {
            createCustomerGUIInfo ();
            x = 600;
            y = 300;
            setBounds((1920-x)/2, (1080-y)/2, x, y);
            ClientGUI.get("mainMenu").setVisible(false);
            ClientGUI.get("changeInfo").setVisible(true);
        });
        ClientGUI.get("mainMenu").add(info);
        
        logout = new JButton ("Log-out");
        logout.setBounds(270,110,90,30);
        logout.addActionListener((ActionEvent e) -> {
            x = 500;
            y = 150;
            setBounds((1920-x)/2, (1080-y)/2, x, y);
            ClientGUI.get("mainMenu").setVisible(false);
            opening.setVisible(true);
        });
        ClientGUI.get("mainMenu").add(logout);
    }
    
    protected void createClientGUISearchAccommodaion () {
        ClientGUI.get("searchAccom").setBounds(0, 0, 400, 370);
        ClientGUI.get("searchAccom").setLayout(null);
        ClientGUI.get("searchAccom").setVisible(false);
        
        JLabel title = new JLabel ("Search Accommodation");
        title.setBounds(90, 10, 220, 20);
        title.setFont(new Font("Arial", Font.PLAIN, 20));
        ClientGUI.get("searchAccom").add(title);
        
        
        
        JCheckBox view = new JCheckBox ("View");
        view.setBounds(10, 60, 100, 20);
        ClientGUI.get("searchAccom").add(view);
        
        JCheckBox parking = new JCheckBox ("Parking");
        parking.setBounds(10, 90, 100, 20);
        ClientGUI.get("searchAccom").add(parking);
        
        JCheckBox pool = new JCheckBox ("Pool");
        pool.setBounds(10, 120, 100, 20);
        ClientGUI.get("searchAccom").add(pool);
        
        JCheckBox wifi = new JCheckBox ("Wifi");
        wifi.setBounds(10, 150, 100, 20);
        ClientGUI.get("searchAccom").add(wifi);
        
        JCheckBox hour24 = new JCheckBox ("24-hour service");
        hour24.setBounds(10, 180, 150, 20);
        ClientGUI.get("searchAccom").add(hour24);
        
        
        
        
        DefaultListModel model = new DefaultListModel();
        JList<String> list = new JList<>(model);  
        list.setBounds(200,60, 150,150); 
        ClientGUI.get("searchAccom").add(list);
        
        
        
        JButton watch;
        JTextField acc;
        
        acc = new JTextField ();
        acc.setBounds(55, 230, 150, 20);
        ClientGUI.get("searchAccom").add(acc);
        
        watch = new JButton ("Watch");
        watch.setBounds(255,225,90,30);
        watch.addActionListener((ActionEvent e) -> {
            String s1 = acc.getText();
            ex = myStorage.everyAccommodation.get(s1);
            x = 500;
            y = 350;
            createClientGUIViewAccommodaion ();
            setBounds((1920-x)/2, (1080-y)/2, x, y);
            ClientGUI.get("searchAccom").setVisible(false);
            ClientGUI.get("viewAccom").setVisible(true);
        });
        ClientGUI.get("searchAccom").add(watch);
        
        
        
        JButton search, reset, exit;
        
        search = new JButton ("Search");
        search.setBounds(30,280,90,30);
        search.addActionListener((ActionEvent e) -> {
            boolean service[] = new boolean[5];
            service[0] = view.isSelected();
            service[1] = parking.isSelected();
            service[2] = pool.isSelected();
            service[3] = wifi.isSelected();
            service[4] = hour24.isSelected();
            model.removeAllElements();
            if (service[0] || service[1] || service[2] || service[3] || service[4]) {
                
                for (String a : myStorage.everyAccommodation.keySet()){
                    boolean tt[] = myStorage.everyAccommodation.get(a).getAcServicesList();
                    for (int i = 0; i<5; i++) {
                        if (tt[i] != service[i] && service[i])
                            break;
                        if (i==4)
                            model.addElement(a);
                    }
                }
                
            }
            else {
                
                for (String a : myStorage.everyAccommodation.keySet())
                    model.addElement(a);
                
            }
        });
        ClientGUI.get("searchAccom").add(search);
        
        reset = new JButton ("Reset");
        reset.setBounds(150,280,90,30);
        reset.addActionListener((ActionEvent e) -> {
            acc.setText("");
            list.removeAll();
            view.setSelected(false);
            parking.setSelected(false);
            pool.setSelected(false);
            wifi.setSelected(false);
            hour24.setSelected(false);
        });
        ClientGUI.get("searchAccom").add(reset);
        
        exit = new JButton ("Back");
        exit.setBounds(270,280,90,30);
        exit.addActionListener((ActionEvent e) -> {
            x = 400;
            y = 200;
            setBounds((1920-x)/2, (1080-y)/2, x, y);
            ClientGUI.get("searchAccom").setVisible(false);
            ClientGUI.get("mainMenu").setVisible(true);
        });
        ClientGUI.get("searchAccom").add(exit);
    }
    
    protected void createClientGUIViewAccommodaion () {
        ClientGUI.get("viewAccom").removeAll();
        ClientGUI.get("viewAccom").setBounds(0, 0, 500, 350);
        ClientGUI.get("viewAccom").setLayout(null);
        ClientGUI.get("viewAccom").setVisible(false);
        
        JLabel title = new JLabel ("View Accommodation");
        title.setBounds(150, 10, 200, 20);
        title.setFont(new Font("Arial", Font.PLAIN, 20));
        ClientGUI.get("viewAccom").add(title);
        
        if (ex == null)
            return;
        
        JLabel name1, price1, sqruare1, rooms1, servicesList;
        
        name1 = new JLabel ("Name: " + ex.getAcName());
        name1.setBounds(10, 60, 150, 20);
        ClientGUI.get("viewAccom").add(name1);
        
        price1 = new JLabel ("Price: " + Double.toString(ex.getPrice()));
        price1.setBounds(10, 110, 150, 20);
        ClientGUI.get("viewAccom").add(price1);

        sqruare1 = new JLabel ("Sqruare meters: " + Integer.toString(ex.getSquareMeters()));
        sqruare1.setBounds(10, 160, 150, 20);
        ClientGUI.get("viewAccom").add(sqruare1);
        
        rooms1 = new JLabel ("Number of beds: " + (ex.getBeds()));
        rooms1.setBounds(10, 210, 150, 20);
        ClientGUI.get("viewAccom").add(rooms1);
        
        servicesList = new JLabel ("Services List: ");
        servicesList.setBounds(200, 60, 100, 20);
        ClientGUI.get("viewAccom").add(servicesList);
        
        boolean tt[] = ex.getAcServicesList();
        
        
        DefaultListModel<String> l1 = new DefaultListModel<>();  
        if (tt[0])
            l1.addElement("View");
        if (tt[1])
            l1.addElement("Parking");  
        if (tt[2])
            l1.addElement("Pool");  
        if (tt[3])
            l1.addElement("Wifi");  
        if (tt[4])
            l1.addElement("24-hour service"); 
        JList<String> list = new JList<>(l1);  
        list.setBounds(300,60, 100,150);  
        ClientGUI.get("viewAccom").add(list);
        
        
        
        JButton book, exit;
        
        book = new JButton ("Book");
        book.setBounds(130,260,90,30);
        book.addActionListener((ActionEvent e) -> {
            x = 450;
            y = 400;
            setBounds((1920-x)/2, (1080-y)/2, x, y);
            ClientGUI.get("viewAccom").setVisible(false);
            ClientGUI.get("placeBooking").setVisible(true);
        });
        ClientGUI.get("viewAccom").add(book);
        
        exit = new JButton ("Back");
        exit.setBounds(280,260,90,30);
        exit.addActionListener((ActionEvent e) -> {
            x = 400;
            y = 200;
            setBounds((1920-x)/2, (1080-y)/2, x, y);
            ClientGUI.get("viewAccom").setVisible(false);
            ClientGUI.get("mainMenu").setVisible(true);
        });
        ClientGUI.get("viewAccom").add(exit);
        
    }
    
    protected void createClientGUIPlaceBooking () {
        ClientGUI.get("placeBooking").setBounds(0, 0, 450, 400);
        ClientGUI.get("placeBooking").setLayout(null);
        ClientGUI.get("placeBooking").setVisible(false);
        
        JLabel title = new JLabel ("Place Booking");
        title.setBounds(160, 10, 130, 20);
        title.setFont(new Font("Arial", Font.PLAIN, 20));
        ClientGUI.get("placeBooking").add(title);
        
        
        JLabel begining, ending, time, pin1;
        JPasswordField pin;
        
        begining = new JLabel ("Begining: ");
        begining.setBounds(10, 60, 100, 20);
        ClientGUI.get("placeBooking").add(begining);
        
        ending = new JLabel ("Ending: ");
        ending.setBounds(10, 110, 100, 20);
        ClientGUI.get("placeBooking").add(ending);

        time = new JLabel ("Time of arrival: ");
        time.setBounds(10, 160, 150, 20);
        ClientGUI.get("placeBooking").add(time);
        
        JComboBox dateB = new JComboBox (dates);
        dateB.setBounds(120, 60, 60, 20);
        ClientGUI.get("placeBooking").add(dateB);
        
        JComboBox dateE = new JComboBox (dates);
        dateE.setBounds(120, 110, 60, 20);
        ClientGUI.get("placeBooking").add(dateE);
        
        JComboBox times = new JComboBox (hours);
        times.setBounds(120, 160, 60, 20);
        ClientGUI.get("placeBooking").add(times);
        
        pin1 = new JLabel ("Pin: ");
        pin1.setBounds(10, 210, 50, 20);
       ClientGUI.get("placeBooking").add(pin1);
        
        pin = new JPasswordField ();
        pin.setBounds(110, 210, 150, 20);
        ClientGUI.get("placeBooking").add(pin);
        
        
        
        JButton place, reset, exit;
        
        place = new JButton ("Place");
        place.setBounds(55,260,90,30);
        place.addActionListener((ActionEvent e) -> {
            String s2 = new String (pin.getPassword());
            if (myStorage.getCustomer(tempUser).personalPinConfirmation(Integer.parseInt(s2)) && Integer.parseInt((String) dateE.getSelectedItem()) > Integer.parseInt((String) dateB.getSelectedItem())) {
                if (ex != null) {
                    myStorage.addBooking(ex.getAcName(), Integer.parseInt((String) dateB.getSelectedItem()) , Integer.parseInt((String) dateE.getSelectedItem()), Integer.parseInt((String) times.getSelectedItem()), tempUser);
                    Book.addItem(ex.getAcName() + " - " + tempUser);
                    manBook.addItem(ex.getAcName() + " - " + tempUser);
                    tryAgain2.setVisible(false);
                    success7.setVisible(true);
                }
            }
            else {
                success7.setVisible(false);
                tryAgain2.setVisible(true);
            }
        });
        ClientGUI.get("placeBooking").add(place);
        
        reset = new JButton ("Reset");
        reset.setBounds(175,260,90,30);
        reset.addActionListener((ActionEvent e) -> {
            pin.setText("");
            dateB.setSelectedIndex(0);
            dateE.setSelectedIndex(0);
            times.setSelectedIndex(0);
            success7.setVisible(false);
        });
        ClientGUI.get("placeBooking").add(reset);
        
        exit = new JButton ("Back");
        exit.setBounds(295,260,90,30);
        exit.addActionListener((ActionEvent e) -> {
            pin.setText("");
            success7.setVisible(false);
            x = 400;
            y = 200;
            setBounds((1920-x)/2, (1080-y)/2, x, y);
            ClientGUI.get("placeBooking").setVisible(false);
            ClientGUI.get("mainMenu").setVisible(true);
        });
        ClientGUI.get("placeBooking").add(exit);
        
        success7 = new JLabel ("Booking placed successfully!!!");
        success7.setBounds(120,310,230,30);
        success7.setFont(new Font("Arial", Font.PLAIN, 15));
        success7.setVisible(false);
        ClientGUI.get("placeBooking").add(success7);
        
        tryAgain2 = new JLabel ("Wrong pin or ending date is smaller or equal to the begging date.");
        tryAgain2.setBounds(10,310,430,30);
        tryAgain2.setFont(new Font("Arial", Font.PLAIN, 15));
        tryAgain2.setVisible(false);
        ClientGUI.get("placeBooking").add(tryAgain2);
    }
    
    protected void createClientGUIViewMyBookings () {
        ClientGUI.get("viewBookings").removeAll();
        ClientGUI.get("viewBookings").setBounds(0, 0, 250, 200);
        ClientGUI.get("viewBookings").setLayout(null);
        ClientGUI.get("viewBookings").setVisible(false);
        
        if (tempUser==null)
            return;
        
        JLabel title = new JLabel ("Reservations");
        title.setBounds(65, 10, 120, 20);
        title.setFont(new Font("Arial", Font.PLAIN, 20));
        ClientGUI.get("viewBookings").add(title);
        
        
        JLabel name1;
        
        name1 = new JLabel ("Name: ");
        name1.setBounds(10, 60, 50, 20);
        ClientGUI.get("viewBookings").add(name1);
        
        Book = new JComboBox ();
        if (myStorage.getCustomer(tempUser).returnMyBookings(myStorage)!=null) {
            for (Booking temp : myStorage.getCustomer(tempUser).returnMyBookings(myStorage)) {
                Book.addItem(temp.bookingName);
            }
        }
        Book.setEditable(true);
        Book.setBounds(90, 60, 65, 20);
        ClientGUI.get("viewBookings").add(Book);
        
        
        
        JButton view, exit;
        
        view = new JButton ("View");
        view.setBounds(25,110,90,30);
        view.addActionListener((ActionEvent e) -> {
            if (Book.getSelectedItem()!=null) {
                ex2 = myStorage.everyBooking.get((String) Book.getSelectedItem());
                x = 400;
                y = 300;
                setBounds((1920-x)/2, (1080-y)/2, x, y);
                createClientGUIViewBooking ();
                ClientGUI.get("viewBookings").setVisible(false);
                ClientGUI.get("viewBooking").setVisible(true);
            }
        });
        ClientGUI.get("viewBookings").add(view);
        
        exit = new JButton ("Back");
        exit.setBounds(125,110,90,30);
        exit.addActionListener((ActionEvent e) -> {
             x = 400;
             y = 200;
             setBounds((1920-x)/2, (1080-y)/2, x, y);
            ClientGUI.get("viewBookings").setVisible(false);
            ClientGUI.get("mainMenu").setVisible(true);
        });
        ClientGUI.get("viewBookings").add(exit);
    }    
    
    protected void createClientGUIViewBooking () {
        ClientGUI.get("viewBooking").removeAll();
        ClientGUI.get("viewBooking").setBounds(0, 0, 400, 300);
        ClientGUI.get("viewBooking").setLayout(null);
        ClientGUI.get("viewBooking").setVisible(false);
        
        if (ex2==null)
            return;
        
        JLabel title = new JLabel ("Reservation Info");
        title.setBounds(110, 10, 150, 20);
        title.setFont(new Font("Arial", Font.PLAIN, 20));
        ClientGUI.get("viewBooking").add(title);
        
        
        JLabel name, Accom, price, beg, end, time;
        
        name = new JLabel ("Name: " + ex2.bookingName);
        name.setBounds(10, 60, 150, 20);
        ClientGUI.get("viewBooking").add(name);
        
        Accom = new JLabel ("Ac. name: " + ex2.accommodation);
        Accom.setBounds(10, 110, 150, 20);
        ClientGUI.get("viewBooking").add(Accom);
        
        price = new JLabel ("price: " + ex2.getPrice());
        price.setBounds(10, 160, 150, 20);
        ClientGUI.get("viewBooking").add(price);
        
        beg = new JLabel ("beg: " + ex2.beginning);
        beg.setBounds(210, 60, 150, 20);
        ClientGUI.get("viewBooking").add(beg);
        
        end = new JLabel ("end: " + ex2.ending);
        end.setBounds(210, 110, 150, 20);
        ClientGUI.get("viewBooking").add(end);
        
        time = new JLabel ("time: " + ex2.timeOfArrival);
        time.setBounds(210, 160, 150, 20);
        ClientGUI.get("viewBooking").add(time);
        
        JButton view, delete;
        
        view = new JButton ("Okay");
        view.setBounds(85,210,90,30);
        view.addActionListener((ActionEvent e) -> {
            if (Book.getSelectedItem()!=null) {
                x = 250;
                y = 200;
                setBounds((1920-x)/2, (1080-y)/2, x, y);
                ClientGUI.get("viewBooking").setVisible(false);
                ClientGUI.get("viewBookings").setVisible(true);
            }
        });
        ClientGUI.get("viewBooking").add(view);
        
        delete = new JButton ("Delete");
        delete.setBounds(185,210,90,30);
        delete.addActionListener((ActionEvent e) -> {
            x = 400;
            y = 250;
            setBounds((1920-x)/2, (1080-y)/2, x, y);
            ClientGUI.get("viewBooking").setVisible(false);
            ClientGUI.get("deleteBooking").setVisible(true);
        });
        ClientGUI.get("viewBooking").add(delete);
    }
    
    protected void createClientGUIDeleteBooking () {
        ClientGUI.get("deleteBooking").setBounds(0, 0, 400, 250);
        ClientGUI.get("deleteBooking").setLayout(null);
        ClientGUI.get("deleteBooking").setVisible(false);
        
        JLabel title = new JLabel ("Delete Booking");
        title.setBounds(125, 10, 250, 25);
        title.setFont(new Font("Arial", Font.PLAIN, 20));
        ClientGUI.get("deleteBooking").add(title);
        
        
        
        JLabel name1;
        JPasswordField name;
        
        name1 = new JLabel ("Pin: ");
        name1.setBounds(10, 60, 50, 20);
       ClientGUI.get("deleteBooking").add(name1);
        
        name = new JPasswordField ();
        name.setBounds(110, 60, 150, 20);
        ClientGUI.get("deleteBooking").add(name);
        
        
        
        JButton delete, reset, exit;
        
        delete = new JButton ("Delete");
        delete.setBounds(25,110,90,30);
        delete.addActionListener((ActionEvent e) -> {
            String s2 = new String (name.getPassword());
            if (!s2.equals("")){
                if (myStorage.getCustomer(tempUser).personalPinConfirmation(Integer.parseInt(s2))) {
                    if (ex2 != null) {
                        Book.removeItem(ex2.bookingName);
                        manBook.removeItem(ex2.bookingName);
                        myStorage.removeBooking(ex2);
                        ex2 = null;
                        success6.setVisible(true);
                    } 
                }   
                else {
                    tryAgain5.setVisible(true);
                    success6.setVisible(false);
                }
            }
            else {
                    tryAgain5.setVisible(true);
                    success6.setVisible(false);
                    
            }
        });
        ClientGUI.get("deleteBooking").add(delete);
        
        reset = new JButton ("Reset");
        reset.setBounds(145,110,90,30);
        reset.addActionListener((ActionEvent e) -> {
            name.setText("");
            success6.setVisible(false);
            tryAgain5.setVisible(false);
        });
        ClientGUI.get("deleteBooking").add(reset);
        
        exit = new JButton ("Back");
        exit.setBounds(265,110,90,30);
        exit.addActionListener((ActionEvent e) -> {
            name.setText("");
            success6.setVisible(false);
            y = 200;
            setBounds((1920-x)/2, (1080-y)/2, x, y);
            ClientGUI.get("deleteBooking").setVisible(false);
            ClientGUI.get("mainMenu").setVisible(true);
        });
        ClientGUI.get("deleteBooking").add(exit);
        
        success6 = new JLabel ("Booking deleted successfully.");
        success6.setBounds(75,160,250,30);
        success6.setFont(new Font("Arial", Font.PLAIN, 15));
        success6.setVisible(false);
        ClientGUI.get("deleteBooking").add(success6);
        
       tryAgain5 = new JLabel ("Wrong confirmation pin. Please try again...");
        tryAgain5.setBounds(10,160,300,30);
        tryAgain5.setFont(new Font("Arial", Font.PLAIN, 15));
        tryAgain5.setVisible(false);
        ClientGUI.get("deleteBooking").add(tryAgain5);
    }
    
    protected void createCustomerGUIInfo () {
        ClientGUI.get("changeInfo").setBounds(0, 0, 600, 250);
        ClientGUI.get("changeInfo").setLayout(null);
        ClientGUI.get("changeInfo").setVisible(false);
        
        JLabel title = new JLabel ("Change personal info");
        title.setBounds(200, 10, 200, 20);
        title.setFont(new Font("Arial", Font.PLAIN, 20));
        ClientGUI.get("changeInfo").add(title);
        
        if (tempUser == null)
            return;
        
        JTextField address, email, phone;
        JLabel name1, address1, email1, phone1;
                
        name1 = new JLabel ("Name: " + myStorage.getCustomer(tempUser).getName());
        name1.setBounds(10, 60, 150, 20);
        ClientGUI.get("changeInfo").add(name1);
        
        address1 = new JLabel ("Address: ");
        address1.setBounds(300, 60, 80, 20);
        ClientGUI.get("changeInfo").add(address1);
        
        address = new JTextField (myStorage.getCustomer(tempUser).getAddress());
        address.setBounds(410, 60, 150, 20);
        ClientGUI.get("changeInfo").add(address);
        
        email1 = new JLabel ("Email: ");
        email1.setBounds(10, 110, 80, 20);
        ClientGUI.get("changeInfo").add(email1);
        
        email = new JTextField (myStorage.getCustomer(tempUser).getEmail());
        email.setBounds(120, 110, 150, 20);
        ClientGUI.get("changeInfo").add(email);
        
        phone1 = new JLabel ("Phone number: ");
        phone1.setBounds(300, 110, 100, 20);
        ClientGUI.get("changeInfo").add(phone1);
        
        phone = new JTextField (myStorage.getCustomer(tempUser).getPhoneNumber());
        phone.setBounds(410, 110, 150, 20);
        ClientGUI.get("changeInfo").add(phone);
        
        
        
        JButton add, reset, exit;
        
        add = new JButton ("Change");
        add.setBounds(95,160,90,30);
        add.addActionListener((ActionEvent e) -> {
            myStorage.changeCustomer(myStorage.getCustomer(tempUser).getName(), address.getText(), email.getText(), phone.getText());
            success8.setVisible(true);
        });
        ClientGUI.get("changeInfo").add(add);
        
        reset = new JButton ("Reset");
        reset.setBounds(245,160,90,30);
        reset.addActionListener((ActionEvent e) -> {
            address.setText("");
            email.setText("");
            phone.setText("");
            success8.setVisible(false);
        });
        ClientGUI.get("changeInfo").add(reset);
        
        exit = new JButton ("Back");
        exit.setBounds(395,160,90,30);
        exit.addActionListener((ActionEvent e) -> {
            success8.setVisible(false);
            x = 400;
            y = 200;
            setBounds((1920-x)/2, (1080-y)/2, x, y);
            ClientGUI.get("changeInfo").setVisible(false);
            ClientGUI.get("mainMenu").setVisible(true);
        });
        ClientGUI.get("changeInfo").add(exit);
        
        success8 = new JLabel ("Info changed successfully!!!");
        success8.setBounds(200,210,200,30);
        success8.setFont(new Font("Arial", Font.PLAIN, 15));
        success8.setVisible(false);
        ClientGUI.get("changeInfo").add(success8);
    }
}
