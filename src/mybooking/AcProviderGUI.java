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
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Dell i7
 */
public class AcProviderGUI extends GeneralGUI {
    

    
    public AcProviderGUI (Storage s, Files mF) {
        super(s,mF);
        addToProviderGUI();
        add(ProviderGUI.get("mainMenu"));
        add(ProviderGUI.get("createAccom"));
        add(ProviderGUI.get("searchAccom"));
        add(ProviderGUI.get("viewAccom"));
        add(ProviderGUI.get("deleteAccom"));
        add(ProviderGUI.get("changeInfo"));
    }
    
    protected void addToProviderGUI () {
        ProviderGUI.put("mainMenu", new JPanel ());
        createProviderGUIMainMenu ();
        ProviderGUI.put("createAccom", new JPanel ());
        createProviderGUICreateAccommodaion ();
        ProviderGUI.put("searchAccom", new JPanel ());
        createProviderGUISearchAccommodaion ();
        ProviderGUI.put("viewAccom", new JPanel ());
        createProviderGUIViewAccommodaion ();
        ProviderGUI.put("deleteAccom", new JPanel ());
        createProviderGUIDeleteAccommodaion ();
        ProviderGUI.put("changeInfo", new JPanel ());
        createProviderGUIInfo ();
    }
    
    protected void createProviderGUIMainMenu () {
        ProviderGUI.get("mainMenu").setBounds(0, 0, 400, 200);
        ProviderGUI.get("mainMenu").setLayout(null);
        ProviderGUI.get("mainMenu").setVisible(false); 
        
        
        JLabel title = new JLabel ("Welcome!");
        title.setBounds(150, 10, 100, 20);
        title.setFont(new Font("Arial", Font.PLAIN, 20));
        ProviderGUI.get("mainMenu").add(title);
        
        
        JButton add, search, info, logout;
        
        add = new JButton ("Add accommodation");
        add.setBounds(20,60,200,30);
        add.addActionListener((ActionEvent e) -> {
            x = 550;
            y = 400;
            setBounds((1920-x)/2, (1080-y)/2, x, y);
            ProviderGUI.get("mainMenu").setVisible(false);
            ProviderGUI.get("createAccom").setVisible(true);
        });
        ProviderGUI.get("mainMenu").add(add);
        
        search = new JButton ("Search accommodation");
        search.setBounds(20,110,200,30);
        search.addActionListener((ActionEvent e) -> {
            createProviderGUISearchAccommodaion ();
            x = 400;
            y = 200;
            setBounds((1920-x)/2, (1080-y)/2, x, y);
            ProviderGUI.get("mainMenu").setVisible(false);
            ProviderGUI.get("searchAccom").setVisible(true);
        });
        ProviderGUI.get("mainMenu").add(search);
        
        info = new JButton ("Info");
        info.setBounds(270,60,90,30);
        info.addActionListener((ActionEvent e) -> {
            createProviderGUIInfo ();
            x = 600;
            y = 300;
            setBounds((1920-x)/2, (1080-y)/2, x, y);
            ProviderGUI.get("mainMenu").setVisible(false);
            ProviderGUI.get("changeInfo").setVisible(true);
        });
        ProviderGUI.get("mainMenu").add(info);
        
        logout = new JButton ("Log-out");
        logout.setBounds(270,110,90,30);
        logout.addActionListener((ActionEvent e) -> {
            x = 500;
            y = 150;
            setBounds((1920-x)/2, (1080-y)/2, x, y);
            ProviderGUI.get("mainMenu").setVisible(false);
            opening.setVisible(true);
        });
        ProviderGUI.get("mainMenu").add(logout);
    }
    
    protected void createProviderGUICreateAccommodaion () {
        ProviderGUI.get("createAccom").setBounds(0, 0, 550, 400);
        ProviderGUI.get("createAccom").setLayout(null);
        ProviderGUI.get("createAccom").setVisible(false);
        
        JLabel title = new JLabel ("Create Accommodation");
        title.setBounds(180, 10, 250, 25);
        title.setFont(new Font("Arial", Font.PLAIN, 20));
        ProviderGUI.get("createAccom").add(title);
        
        
        
        JLabel name1, price1, sqruare1, rooms1;
        JTextField name, price, sqruare;
        
        name1 = new JLabel ("Name: ");
        name1.setBounds(10, 60, 80, 20);
        ProviderGUI.get("createAccom").add(name1);
        
        name = new JTextField ();
        name.setBounds(120, 60, 150, 20);
        ProviderGUI.get("createAccom").add(name);
        
        rooms1 = new JLabel ("Number of beds: ");
        rooms1.setBounds(330, 60, 100, 20);
        ProviderGUI.get("createAccom").add(rooms1);
        
        price1 = new JLabel ("Price: ");
        price1.setBounds(10, 110, 80, 20);
        ProviderGUI.get("createAccom").add(price1);
        
        price = new JTextField ();
        price.setBounds(120, 110, 150, 20);
        ProviderGUI.get("createAccom").add(price);
        
        sqruare1 = new JLabel ("Sqruare meters: ");
        sqruare1.setBounds(10, 160, 100, 20);
        ProviderGUI.get("createAccom").add(sqruare1);
        
        sqruare = new JTextField ();
        sqruare.setBounds(120, 160, 150, 20);
        ProviderGUI.get("createAccom").add(sqruare);
        
        
        
        JComboBox room = new JComboBox (beds);
        room.setBounds(450, 60, 50, 20);
        ProviderGUI.get("createAccom").add(room);
        
        
        
        JCheckBox view = new JCheckBox ("View");
        view.setBounds(330, 90, 100, 20);
        ProviderGUI.get("createAccom").add(view);
        
        JCheckBox parking = new JCheckBox ("Parking");
        parking.setBounds(330, 120, 100, 20);
        ProviderGUI.get("createAccom").add(parking);
        
        JCheckBox pool = new JCheckBox ("Pool");
        pool.setBounds(330, 150, 100, 20);
        ProviderGUI.get("createAccom").add(pool);
        
        JCheckBox wifi = new JCheckBox ("Wifi");
        wifi.setBounds(330, 180, 100, 20);
        ProviderGUI.get("createAccom").add(wifi);
        
        JCheckBox hour24 = new JCheckBox ("24-hour service");
        hour24.setBounds(330, 210, 150, 20);
        ProviderGUI.get("createAccom").add(hour24);
        
        
        
        JButton add, reset, exit;
        
        add = new JButton ("Add");
        add.setBounds(75,260,90,30);
        add.addActionListener((ActionEvent e) -> {
            String sname = name.getText();
            String sprice = price.getText();
            String ssqruare = sqruare.getText();
            int i = Integer.parseInt((String) room.getSelectedItem());
            boolean service[] = new boolean [5];
            service[0] = view.isSelected();
            service[1] = parking.isSelected();
            service[2] = pool.isSelected();
            service[3] = wifi.isSelected();
            service[4] = hour24.isSelected();
            myStorage.addAccom(sname, Double.parseDouble(sprice), Integer.parseInt(ssqruare), i, tempUser, service);
            Ac.addItem(sname);
            name.setText("");
            price.setText("");
            sqruare.setText("");
            room.setSelectedIndex(0);
            view.setSelected(false);
            parking.setSelected(false);
            pool.setSelected(false);
            wifi.setSelected(false);
            hour24.setSelected(false);
            succcess2.setVisible(true);
        });
        ProviderGUI.get("createAccom").add(add);
        
        reset = new JButton ("Reset");
        reset.setBounds(225,260,90,30);
        reset.addActionListener((ActionEvent e) -> {
            name.setText("");
            price.setText("");
            sqruare.setText("");
            room.setSelectedIndex(0);
            view.setSelected(false);
            parking.setSelected(false);
            pool.setSelected(false);
            wifi.setSelected(false);
            hour24.setSelected(false);
            succcess2.setVisible(false);
        });
        ProviderGUI.get("createAccom").add(reset);
        
        exit = new JButton ("Back");
        exit.setBounds(375,260,90,30);
        exit.addActionListener((ActionEvent e) -> {
            name.setText("");
            price.setText("");
            sqruare.setText("");
            room.setSelectedIndex(0);
            view.setSelected(false);
            parking.setSelected(false);
            pool.setSelected(false);
            wifi.setSelected(false);
            hour24.setSelected(false);
            succcess2.setVisible(false);
            x = 400;
            y = 200;
            setBounds((1920-x)/2, (1080-y)/2, x, y);
            ProviderGUI.get("createAccom").setVisible(false);
            ProviderGUI.get("mainMenu").setVisible(true);
        });
        ProviderGUI.get("createAccom").add(exit);
        
        succcess2 = new JLabel ("Accommodation added successfully!!!");
        succcess2.setBounds(150,310,250,30);
        succcess2.setFont(new Font("Arial", Font.PLAIN, 15));
        succcess2.setVisible(false);
        ProviderGUI.get("createAccom").add(succcess2);
        
    }
    
    
    protected void createProviderGUISearchAccommodaion () {
        ProviderGUI.get("searchAccom").removeAll();
        ProviderGUI.get("searchAccom").setBounds(0, 0, 400, 200);
        ProviderGUI.get("searchAccom").setLayout(null);
        ProviderGUI.get("searchAccom").setVisible(false);
        
        JLabel title = new JLabel ("Search Accommodation");
        title.setBounds(75, 10, 250, 20);
        title.setFont(new Font("Arial", Font.PLAIN, 20));
        ProviderGUI.get("searchAccom").add(title);
        
        if (tempUser==null)
            return;
        
        JLabel name1;
        
        name1 = new JLabel ("Name: ");
        name1.setBounds(10, 60, 50, 20);
        ProviderGUI.get("searchAccom").add(name1);
        
        Ac = new JComboBox ();
        if (myStorage.getAcProvider(tempUser).returnAcProvidersAccoms(myStorage)!=null) {
            for (Accommodation temp : myStorage.getAcProvider(tempUser).returnAcProvidersAccoms(myStorage)) {
                Ac.addItem(temp.getAcName());
            }
        }
        Ac.setEditable(true);
        Ac.setBounds(130, 60, 90, 20);
        ProviderGUI.get("searchAccom").add(Ac);
        
        
        
        JButton view, delete, exit;
        
        view = new JButton ("View");
        view.setBounds(10,110,90,30);
        view.addActionListener((ActionEvent e) -> {
            if (Ac.getSelectedItem()!=null) {
                ex = myStorage.everyAccommodation.get((String) Ac.getSelectedItem());
                x = 550;
                y = 400;
                setBounds((1920-x)/2, (1080-y)/2, x, y);
                createProviderGUIViewAccommodaion ();
                ProviderGUI.get("searchAccom").setVisible(false);
                ProviderGUI.get("viewAccom").setVisible(true);
            }
        });
        ProviderGUI.get("searchAccom").add(view);
        
        delete = new JButton ("Delete");
        delete.setBounds(130,110,90,30);
        delete.addActionListener((ActionEvent e) -> {
            ex = myStorage.everyAccommodation.get((String) Ac.getSelectedItem());
            y = 250;
            setBounds((1920-x)/2, (1080-y)/2, x, y);
            ProviderGUI.get("searchAccom").setVisible(false);
            ProviderGUI.get("deleteAccom").setVisible(true);
        });
        ProviderGUI.get("searchAccom").add(delete);
        
        exit = new JButton ("Back");
        exit.setBounds(250,110,90,30);
        exit.addActionListener((ActionEvent e) -> {
            ProviderGUI.get("searchAccom").setVisible(false);
            ProviderGUI.get("mainMenu").setVisible(true);
        });
        ProviderGUI.get("searchAccom").add(exit);
    }
    
    protected void createProviderGUIViewAccommodaion () {
        ProviderGUI.get("viewAccom").removeAll();
        ProviderGUI.get("viewAccom").setBounds(0, 0, 550, 400);
        ProviderGUI.get("viewAccom").setLayout(null);
        ProviderGUI.get("viewAccom").setVisible(false);
        
        JLabel title = new JLabel ("View Accommodation");
        title.setBounds(180, 10, 250, 20);
        title.setFont(new Font("Arial", Font.PLAIN, 20));
        ProviderGUI.get("viewAccom").add(title);
        
        if (ex == null)
            return;
        
        JLabel name1, price1, sqruare1, rooms1;
        JTextField price, sqruare;
        
        name1 = new JLabel ("Name: " + ex.getAcName());
        name1.setBounds(10, 60, 80, 20);
        ProviderGUI.get("viewAccom").add(name1);
        
        rooms1 = new JLabel ("Number of beds: ");
        rooms1.setBounds(330, 60, 100, 20);
        ProviderGUI.get("viewAccom").add(rooms1);
        
        price1 = new JLabel ("Price: ");
        price1.setBounds(10, 110, 80, 20);
        ProviderGUI.get("viewAccom").add(price1);
        
        price = new JTextField (Double.toString(ex.getPrice()));
        price.setBounds(120, 110, 150, 20);
        ProviderGUI.get("viewAccom").add(price);
        
        sqruare1 = new JLabel ("Sqruare meters: ");
        sqruare1.setBounds(10, 160, 100, 20);
        ProviderGUI.get("viewAccom").add(sqruare1);
        
        sqruare = new JTextField (Integer.toString(ex.getSquareMeters()));
        sqruare.setBounds(120, 160, 150, 20);
        ProviderGUI.get("viewAccom").add(sqruare);
        
        
        
        JComboBox room = new JComboBox (beds);
        room.setSelectedIndex(ex.getBeds()-1);
        room.setBounds(450, 60, 50, 20);
        ProviderGUI.get("viewAccom").add(room);
        
        
        boolean tt[] = ex.getAcServicesList();
        
        JCheckBox view = new JCheckBox ("View");
        view.setBounds(330, 90, 100, 20);
        if (tt[0])
            view.setSelected(true);
        ProviderGUI.get("viewAccom").add(view);
        
        JCheckBox parking = new JCheckBox ("Parking");
        parking.setBounds(330, 120, 100, 20);
        if (tt[1])
            parking.setSelected(true);
        ProviderGUI.get("viewAccom").add(parking);
        
        JCheckBox pool = new JCheckBox ("Pool");
        pool.setBounds(330, 150, 100, 20);
        if (tt[2])
            pool.setSelected(true);
        ProviderGUI.get("viewAccom").add(pool);
        
        JCheckBox wifi = new JCheckBox ("Wifi");
        wifi.setBounds(330, 180, 100, 20);
        if (tt[3])
            wifi.setSelected(true);
        ProviderGUI.get("viewAccom").add(wifi);
        
        JCheckBox hour24 = new JCheckBox ("24-hour service");
        hour24.setBounds(330, 210, 150, 20);
        if (tt[4])
            hour24.setSelected(true);
        ProviderGUI.get("viewAccom").add(hour24);
        
        
        
        JButton add, reset, exit;
        
        add = new JButton ("Change");
        add.setBounds(75,260,90,30);
        add.addActionListener((ActionEvent e) -> {
            String sprice = price.getText();
            String ssqruare = sqruare.getText();
            int i = Integer.parseInt((String) room.getSelectedItem());
            boolean service[] = new boolean [5];
            service[0] = view.isSelected();
            service[1] = parking.isSelected();
            service[2] = pool.isSelected();
            service[3] = wifi.isSelected();
            service[4] = hour24.isSelected();
            myStorage.changeAccom(ex.getAcName(), Double.parseDouble(sprice), Integer.parseInt(ssqruare), i, service);
            succcess4.setVisible(true);
        });
        ProviderGUI.get("viewAccom").add(add);
        
        reset = new JButton ("Reset");
        reset.setBounds(225,260,90,30);
        reset.addActionListener((ActionEvent e) -> {
            price.setText("");
            sqruare.setText("");
            room.setSelectedIndex(0);
            view.setSelected(false);
            parking.setSelected(false);
            pool.setSelected(false);
            wifi.setSelected(false);
            hour24.setSelected(false);
            succcess4.setVisible(false);
        });
        ProviderGUI.get("viewAccom").add(reset);
        
        exit = new JButton ("Back");
        exit.setBounds(375,260,90,30);
        exit.addActionListener((ActionEvent e) -> {
            price.setText("");
            sqruare.setText("");
            room.setSelectedIndex(0);
            view.setSelected(false);
            parking.setSelected(false);
            pool.setSelected(false);
            wifi.setSelected(false);
            hour24.setSelected(false);
            succcess4.setVisible(false);
            x = 400;
            y = 200;
            setBounds((1920-x)/2, (1080-y)/2, x, y);
            ProviderGUI.get("viewAccom").setVisible(false);
            ProviderGUI.get("mainMenu").setVisible(true);
        });
        ProviderGUI.get("viewAccom").add(exit);
        
        succcess4 = new JLabel ("Accommodation changed successfully!!!");
        succcess4.setBounds(135,310,280,30);
        succcess4.setFont(new Font("Arial", Font.PLAIN, 15));
        succcess4.setVisible(false);
        ProviderGUI.get("viewAccom").add(succcess4);
        
    }
    
    protected void createProviderGUIDeleteAccommodaion () {
        ProviderGUI.get("deleteAccom").setBounds(0, 0, 400, 250);
        ProviderGUI.get("deleteAccom").setLayout(null);
        ProviderGUI.get("deleteAccom").setVisible(false);
        
        JLabel title = new JLabel ("Delete Accommodation");
        title.setBounds(75, 10, 250, 20);
        title.setFont(new Font("Arial", Font.PLAIN, 20));
        ProviderGUI.get("deleteAccom").add(title);
        
        
        
        JLabel name1;
        JPasswordField name;
        
        name1 = new JLabel ("Pin: ");
        name1.setBounds(10, 60, 50, 20);
        ProviderGUI.get("deleteAccom").add(name1);
        
        name = new JPasswordField ();
        name.setBounds(110, 60, 150, 20);
        ProviderGUI.get("deleteAccom").add(name);
        
        
        
        JButton delete, reset, exit;
        
        delete = new JButton ("Delete");
        delete.setBounds(10,110,90,30);
        delete.addActionListener((ActionEvent e) -> {
            String s2 = new String (name.getPassword());
            if (myStorage.getAcProvider(tempUser).personalPinConfirmation(Integer.parseInt(s2))) {
                if (ex != null) {
                    Ac.removeItem(ex.getAcName());
                    myStorage.removeAccommodation(ex);
                    ex = null;
                    succcess3.setVisible(true);
                }
            }
        });
        ProviderGUI.get("deleteAccom").add(delete);
        
        reset = new JButton ("Reset");
        reset.setBounds(130,110,90,30);
        reset.addActionListener((ActionEvent e) -> {
            name.setText("");
            succcess3.setVisible(false);
        });
        ProviderGUI.get("deleteAccom").add(reset);
        
        exit = new JButton ("Back");
        exit.setBounds(250,110,90,30);
        exit.addActionListener((ActionEvent e) -> {
            name.setText("");
            succcess3.setVisible(false);
            y = 200;
            setBounds((1920-x)/2, (1080-y)/2, x, y);
            ProviderGUI.get("deleteAccom").setVisible(false);
            ProviderGUI.get("mainMenu").setVisible(true);
        });
        ProviderGUI.get("deleteAccom").add(exit);
        
        succcess3 = new JLabel ("Accommodation deleted successfully.");
        succcess3.setBounds(75,160,250,30);
        succcess3.setFont(new Font("Arial", Font.PLAIN, 15));
        succcess3.setVisible(false);
        ProviderGUI.get("deleteAccom").add(succcess3);
    }
    
    protected void createProviderGUIInfo () {
        ProviderGUI.get("changeInfo").setBounds(0, 0, 600, 250);
        ProviderGUI.get("changeInfo").setLayout(null);
        ProviderGUI.get("changeInfo").setVisible(false);
        
        JLabel title = new JLabel ("Change personal info");
        title.setBounds(200, 10, 200, 20);
        title.setFont(new Font("Arial", Font.PLAIN, 20));
        ProviderGUI.get("changeInfo").add(title);
        
        if (tempUser == null)
            return;
        
        JTextField address, email, phone;
        JLabel name1, address1, email1, phone1;
                
        name1 = new JLabel ("Name: " + myStorage.getAcProvider(tempUser).getName());
        name1.setBounds(10, 60, 150, 20);
        ProviderGUI.get("changeInfo").add(name1);
        
        address1 = new JLabel ("Address: ");
        address1.setBounds(300, 60, 80, 20);
        ProviderGUI.get("changeInfo").add(address1);
        
        address = new JTextField (myStorage.getAcProvider(tempUser).getAddress());
        address.setBounds(410, 60, 150, 20);
        ProviderGUI.get("changeInfo").add(address);
        
        email1 = new JLabel ("Email: ");
        email1.setBounds(10, 110, 80, 20);
        ProviderGUI.get("changeInfo").add(email1);
        
        email = new JTextField (myStorage.getAcProvider(tempUser).getEmail());
        email.setBounds(120, 110, 150, 20);
        ProviderGUI.get("changeInfo").add(email);
        
        phone1 = new JLabel ("Phone number: ");
        phone1.setBounds(300, 110, 100, 20);
        ProviderGUI.get("changeInfo").add(phone1);
        
        phone = new JTextField (myStorage.getAcProvider(tempUser).getPhoneNumber());
        phone.setBounds(410, 110, 150, 20);
        ProviderGUI.get("changeInfo").add(phone);
        
        
        
        JButton add, reset, exit;
        
        add = new JButton ("Change");
        add.setBounds(95,160,90,30);
        add.addActionListener((ActionEvent e) -> {
            myStorage.changeAcProvider(myStorage.getAcProvider(tempUser).getName(), address.getText(), email.getText(), phone.getText());
            succcess5.setVisible(true);
        });
        ProviderGUI.get("changeInfo").add(add);
        
        reset = new JButton ("Reset");
        reset.setBounds(245,160,90,30);
        reset.addActionListener((ActionEvent e) -> {
            address.setText("");
            email.setText("");
            phone.setText("");
            succcess5.setVisible(false);
        });
        ProviderGUI.get("changeInfo").add(reset);
        
        exit = new JButton ("Back");
        exit.setBounds(395,160,90,30);
        exit.addActionListener((ActionEvent e) -> {
            succcess5.setVisible(false);
            x = 400;
            y = 200;
            setBounds((1920-x)/2, (1080-y)/2, x, y);
            ProviderGUI.get("changeInfo").setVisible(false);
            ProviderGUI.get("mainMenu").setVisible(true);
        });
        ProviderGUI.get("changeInfo").add(exit);
        
        succcess5 = new JLabel ("Info changed successfully!!!");
        succcess5.setBounds(200,210,200,30);
        succcess5.setFont(new Font("Arial", Font.PLAIN, 15));
        succcess5.setVisible(false);
        ProviderGUI.get("changeInfo").add(succcess5);
    }
}
