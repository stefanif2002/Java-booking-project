/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybooking;

import java.io.*;
import static java.lang.constant.ConstantDescs.NULL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell i7
 */
public class Files {

private final HashMap <String,File> files;
private String nextline;
private String split[];
private final Storage myStorage;

    public Files (Storage temp) {
        myStorage = temp;
        files = new HashMap <> ();
        files.put("Customers", new File ("Customers.txt"));
        files.put("AcProviders", new File ("AcProviders.txt"));
        files.put("Accommodations", new File ("Accommodations.txt"));
        files.put("Bookings", new File ("Bookings.txt"));
    }
    
    private BufferedReader openBufferedReader (String type) {
        try {
            return new BufferedReader (new FileReader(files.get(type)));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Files.class.getName()).log(Level.SEVERE, null, ex);
            return (BufferedReader) NULL;
        }
    }
    
    private BufferedWriter openBufferedWriter (String type) throws IOException {
        try {
            return new BufferedWriter (new FileWriter(files.get(type)));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Files.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Huston we have a problem.");
            return (BufferedWriter) NULL;
        }
    }
    
    private Customer readCustomer (BufferedReader reader) throws IOException {
        ArrayList <String> list = new ArrayList <> ();
        ArrayList <String> newBookingslist = new ArrayList <> ();
        int id, pin, count;
        double balance;
        boolean access, checked;
                    
         for (int i =0; i<8; i++) {
            list.add(i, readString(reader));
        }
        
        id = readInteger(reader);
        balance = readDouble(reader);
        pin = readInteger(reader);
        access = readBoolean(reader);
        checked = readBoolean(reader);
        count = readInteger(reader);
            
        for (int i =0; i<count; i++) {
            nextline = reader.readLine();
            newBookingslist.add(i, nextline);
        }
        
        return new Customer(list.get(0), list.get(1), list.get(2) , list.get(3), list.get(6), list.get(7), list.get(4), list.get(5), id, balance, pin, access, checked, newBookingslist);
        
    }
    
    private void writeCustomer (BufferedWriter writer, int no, String name, String lastName, String address, String email, String username, String password, String phoneNumber, String dateOfBirth, int id, double balance, int pin, boolean access,  boolean checked, ArrayList <String> newBookingslist) throws IOException {
        writeString (writer, "Customer" + no);
        writeString (writer, "Name :" + name);
        writeString (writer, "Last Name :" + lastName);
        writeString (writer, "Address  :" + address);
        writeString (writer, "Email :" + email);
        writeString (writer, "Phone Number :" + phoneNumber);
        writeString (writer, "Date Of Birth :" + dateOfBirth);
        writeString (writer, "Username :" + username);
        writeString (writer, "Password :" + password);
        writeString (writer, "Id :" + id);
        writeString (writer, "Balance :" + balance);
        writeString (writer, "Pin :" + pin);
        writeString (writer, "Access :" + access);
        writeString (writer, "Checked :" + checked);
        writeString (writer, "My Bookings :" + newBookingslist.size());
        for (int i = 0; i<newBookingslist.size(); i++) {
            writeString (writer, newBookingslist.get(i));
        }
        writer.newLine();
    }
    
    private AcProvider readAcProvider (BufferedReader reader) throws IOException {
        ArrayList <String> list = new ArrayList <> ();
        ArrayList <String> newAccommodationslist = new ArrayList <> ();
        ArrayList <String> newBookingslist = new ArrayList <> ();
        int pin, count;
        boolean access, checked;
                
        for (int i =0; i<6; i++) {
            list.add(i, readString(reader));
        }
        
        pin = readInteger(reader);
        access = readBoolean(reader);
        checked = readBoolean(reader);
        count = readInteger(reader);
            
        for (int i =0; i<count; i++) {
            nextline = reader.readLine();
            newAccommodationslist.add(i, nextline);
        }
        
        count = readInteger(reader);
            
        for (int i =0; i<count; i++) {
            nextline = reader.readLine();
            newBookingslist.add(i, nextline);
        }
        
        return new AcProvider (list.get(0), list.get(1), list.get(2) , list.get(4), list.get(5), list.get(3), pin, access, checked, newAccommodationslist, newBookingslist);
        
    }
    
    private void writeAcProvider (BufferedWriter writer, int no, String name, String address, String email, String username, String password, String phoneNumber, int pin, boolean access,  boolean checked, ArrayList <String> newAccommodationslist, ArrayList <String> newBookingslist) throws IOException {
        writeString (writer, "Accommodation Provider" + no);
        writeString (writer, "Name :" + name);
        writeString (writer, "Address  :" + address);
        writeString (writer, "Email :" + email);
        writeString (writer, "Phone Number :" + phoneNumber);
        writeString (writer, "Username :" + username);
        writeString (writer, "Password :" + password);
        writeString (writer, "Pin :" + pin);
        writeString (writer, "Access :" + access);
        writeString (writer, "Checked :" + checked);
        writeString (writer, "My Accommodations :" + newAccommodationslist.size());
        for (int i = 0; i<newAccommodationslist.size(); i++) {
            writeString (writer, newAccommodationslist.get(i));
        }
        writeString (writer, "My Bookings :" + newBookingslist.size());
        for (int i = 0; i<newBookingslist.size(); i++) {
            writeString (writer, newBookingslist.get(i));
        }
        writer.newLine();
    }
    
    private Booking readBooking (BufferedReader reader) throws IOException {
        ArrayList <String> list = new ArrayList <> ();
        int beginning, ending, timeOfArrival;
        boolean paymentStatus, reservationStatus;
        double price;
                
        for (int i =0; i<3; i++) {
            list.add(i, readString(reader));
        }
        
        beginning = readInteger(reader);
        ending = readInteger(reader);
        timeOfArrival = readInteger(reader);
        price = readDouble(reader);
        paymentStatus = readBoolean(reader);
        reservationStatus = readBoolean(reader);
            
        return new Booking (list.get(0), list.get(1), list.get(2), beginning, ending, timeOfArrival, price, paymentStatus, reservationStatus,  myStorage);
        
    }
    
    private void writeBooking (BufferedWriter writer, int no, String name, String costumerName, String accommodation, int beginning, int ending, int timeOfArrival, double price, boolean paymentStatus, boolean reservationStatus) throws IOException {
        writeString (writer, "Accommodation Provider" + no);
        writeString (writer, "Name :" + name);
        writeString (writer, "Costumer Name  :" + costumerName);
        writeString (writer, "Accommodation :" + accommodation);
        writeString (writer, "Beginning :" + beginning);
        writeString (writer, "Ending :" + ending);
        writeString (writer, "Time Of Arrival :" + timeOfArrival);
        writeString (writer, "Price :" + price);
        writeString (writer, "Payment Status :" + paymentStatus);
        writeString (writer, "Reservation Status :" + reservationStatus);
        writer.newLine();
    }
    
    private Accommodation readAccommodation (BufferedReader reader) throws IOException {
        ArrayList <String> list = new ArrayList <> ();
        boolean servicesList[] = new boolean[5];
        int squareMeters, beds;
        boolean[] availability;
        availability = new boolean[30];
        double price;
                
        for (int i =0; i<2; i++) {
            list.add(i, readString(reader));
        }
        
        beds = readInteger(reader);
        price = readDouble(reader);
        squareMeters = readInteger(reader);
        
        nextline = reader.readLine();
        for (int i =0; i<30; i++) {
            availability[i] = readBoolean(reader);
        }

        nextline = reader.readLine();
            
        for (int i =0; i<5; i++) {
            servicesList[i] = readBoolean(reader);
        }
        
        return new Accommodation (list.get(0), list.get(1), beds, price, squareMeters, availability, servicesList);
        
    }
    
    private void writeAccommodation (BufferedWriter writer, int no, String name, String owner, int beds, double price, int squareMeters, boolean[] availability, boolean[] servicesList) throws IOException {
        writeString (writer, "Accommodation" + no);
        writeString (writer, "Name :" + name);
        writeString (writer, "Owners Name  :" + owner);
        writeString (writer, "Beds  :" + beds);
        writeString (writer, "Price :" + price);
        writeString (writer, "Square Meters :" + squareMeters);
        writeString (writer, "Reservation Status :");
        for (int i = 0; i<30; i++) {
            writeString (writer, i + ":" + availability[i]);
        }
        writeString (writer, "My Services List :");
        for (int i = 0; i<5; i++) {
            writeString (writer, i + ":" + servicesList[i]);
        }
        writer.newLine();
    }
    
    private String readString (BufferedReader reader) throws IOException {
        nextline = reader.readLine();
        if (nextline == null) {
            System.out.println("Huston we have a problem.");
        }
        split = nextline.split(":");
        return split[1];
    }
    
    private void writeString (BufferedWriter writer, String s) throws IOException {
        writer.write(s);
        writer.newLine();
    }
    
    private int readInteger (BufferedReader reader) throws IOException {
        nextline = reader.readLine();
        split = nextline.split(":");
        return Integer.parseInt(split[1]);
    }
    
    private double readDouble (BufferedReader reader) throws IOException {
        nextline = reader.readLine();
        split = nextline.split(":");
        return Double.parseDouble(split[1]);
    }
    
    private boolean readBoolean (BufferedReader reader) throws IOException {
        nextline = reader.readLine();
        split = nextline.split(":");
        return Boolean.parseBoolean(split[1]);
    }
    
    private void readCustomersFromFile () throws IOException {
        BufferedReader reader = this.openBufferedReader("Customers");
        nextline = reader.readLine();
        if (nextline == null) {
            reader.close();
            return;
        }
        while (true) {
            Customer temp = readCustomer(reader);
            myStorage.customers.add(temp);
            if (temp.statusReport1())
                myStorage.manager.customersWaitingList.add(temp);
            nextline = reader.readLine();
            nextline = reader.readLine();
            if (nextline == null) {
                reader.close();
                return;
            }
        }
    }
    
    private void writeCustomersToFile () throws IOException {
        try (BufferedWriter writer = this.openBufferedWriter("Customers")) {
            for (int i = 0; i<myStorage.customers.size(); i++) {
                Customer temp = myStorage.customers.get(i);
                writeCustomer(writer, i+1, temp.getName(), temp.getLastName(), temp.getAddress(), temp.getEmail(), temp.getUsername(), temp.getPassword(), temp.getPhoneNumber(), temp.getDateOfBirth(), temp.getId(), temp.getBalance(), temp.getPin(), temp.getAccess(), temp.getChecked(), temp.getMyBookings());
            }
        }
    }
        
    private void readAcProvidersFromFile () throws IOException {
        BufferedReader reader = this.openBufferedReader("AcProviders");
        nextline = reader.readLine();
        if (nextline == null) {
            reader.close();
            return;
        }
        while (true) {
            AcProvider temp = readAcProvider(reader);
            myStorage.AcProviders.add(temp);
            if (temp.statusReport1())
                myStorage.manager.AcProvidersWaitingList.add(temp);
            nextline = reader.readLine();
            nextline = reader.readLine();
            if (nextline == null) {
                reader.close();
                return;
            }
        }
    }
    
    private void writeAcProvidersToFile () throws IOException {
        try (BufferedWriter writer = this.openBufferedWriter("AcProviders")) {
            for (int i = 0; i<myStorage.AcProviders.size(); i++) {
                AcProvider temp = myStorage.AcProviders.get(i);
                writeAcProvider(writer, i+1, temp.getName(), temp.getAddress(), temp.getEmail(), temp.getUsername(), temp.getPassword(), temp.getPhoneNumber(), temp.getPin(), temp.getAccess(), temp.getChecked(), temp.getAccommodations(), temp.getMyBookings());
            }
        }
    }
    
    private void readBookingsFromFile () throws IOException {
        BufferedReader reader = this.openBufferedReader("Bookings");
        nextline = reader.readLine();
        if (nextline == null) {
            reader.close();
            return;
        }
        while (true) {
            Booking temp = readBooking(reader);
            myStorage.everyBooking.put(temp.bookingName, temp);
            nextline = reader.readLine();
            nextline = reader.readLine();
            if (nextline == null) {
                reader.close();
                return;
            }
        }
    }
    
    private void writeBookingsToFile () throws IOException {
        try (BufferedWriter writer = this.openBufferedWriter("Bookings")) {
            int i = 0;
            for (Booking temp: myStorage.everyBooking.values()) {
                writeBooking(writer, i+1, temp.bookingName, temp.costumerName, temp.accommodation, temp.beginning, temp.ending, temp.timeOfArrival, temp.getPrice(), temp.getPaymentStatus(), temp.getReservationStatus());
                i++;
            }
        }
    }
    
    private void readAccommodationsFromFile () throws IOException {
        BufferedReader reader = this.openBufferedReader("Accommodations");
        nextline = reader.readLine();
        if (nextline == null) {
            reader.close();
            return;
        }
        while (true) {
            Accommodation temp = readAccommodation(reader);
            myStorage.everyAccommodation.put(temp.getAcName(), temp);
            nextline = reader.readLine();
            nextline = reader.readLine();
            if (nextline == null) {
                reader.close();
                return;
            }
        }
    }
    
    private void writeAccommodationsToFile () throws IOException {
        try (BufferedWriter writer = this.openBufferedWriter("Accommodations")) {
            int i = 0;
            for (Accommodation temp: myStorage.everyAccommodation.values()) {
                writeAccommodation(writer, i+1, temp.getAcName(), temp.getOwnersName(), temp.getBeds(), temp.getPrice(), temp.getSquareMeters(), temp.getAvailability(), temp.getAcServicesList());
                i++;
            }
        }
    }
    
    public void readFromAllFiles () throws IOException {
        readCustomersFromFile ();
        readAcProvidersFromFile ();
        readAccommodationsFromFile ();
        readBookingsFromFile ();
    }
    
    public void writeToAllFiles () throws IOException {
        writeCustomersToFile();
        writeAcProvidersToFile();
        writeBookingsToFile();
        writeAccommodationsToFile();
    }
    
    //Writing starts.
    
    
}
