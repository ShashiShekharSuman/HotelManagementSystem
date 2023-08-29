/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.sql.SQLException;
import java.text.ParseException ;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import java.lang.Object;
import java.time.LocalDate;
import java.time.Duration;

import java.text.SimpleDateFormat;

public class CustomerController {

    private final Sql sql;
    
    public CustomerController() {
        this.sql = Sql.getInstance();
    }
    
    public void registerCustomer(int id, String customerName, long mobile, String nationality, String gender,String email, String idProof, String idNumber,  String address) {
        Map<String, Object> customer = new HashMap<>();
        customer.put("customer_name", (Object) customerName);
        customer.put("mobile_number", (Object) mobile);
        customer.put("nationality", (Object) nationality);
        customer.put("gender", (Object) gender);
        
         customer.put("email", (Object) email);
         
       customer.put("id_proof", (Object) idProof);
       customer.put("id_number", (Object) idNumber);
       customer.put("address", (Object) address);      
        try {
             sql.insertInto("customers", customer);
            JOptionPane.showMessageDialog(null, "Customer created successfully");
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    public void customerCheckIn(int customerID,int roomNo,String checkIN, String checkOUT, int price) throws ParseException{
    LocalDate checkINDate = LocalDate.parse(checkIN);
    LocalDate checkOUTDate = LocalDate.parse(checkOUT);
    Duration diff = Duration.between(checkINDate, checkOUTDate);
    long diffDays = diff.toDays();
    int stayPeriod= (int) diffDays;//put logic to calculate in days
    int totalAmount = stayPeriod * price; //by default pass through 
     Map<String, Object> booking = new HashMap<>();
        booking.put("customer_id", (Object) customerID);
        booking.put("check_in", (Object) checkIN);
        booking.put("check_out", (Object) checkOUT);
        booking.put("room_no", (Object) roomNo );
        booking.put("stay_period", (Object)stayPeriod);
        booking.put("total_amount", (Object) totalAmount);
          
        try {
             sql.insertInto("bookings", booking);
            JOptionPane.showMessageDialog(null, "Booking done successfully");
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
