package controllers;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class RoomController {
    private final Sql sql;
    
    public RoomController() {
        this.sql = Sql.getInstance();
    }
    
    public void registerUser(Integer roomNo, String sharing, String roomType, Double price,  String status) {
        Map<String, Object> room = new HashMap<>();
        room.put("room_no", (Object) roomNo);
        room.put("sharing", (Object) sharing);
        room.put("room_type", (Object) roomType);
        room.put("price", (Object) price);
        room.put("status", (Object) status);

        try {
            sql.insertInto("users", room);
            JOptionPane.showMessageDialog(null, "Room added successfully");
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
}
