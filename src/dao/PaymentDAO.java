package dao;
import db.DBConnection;
import model.Payment;
import java.sql.*;
import java.util.*;

public class PaymentDAO {
    
    public void addPayment(Payment payment) {
        String sql = "INSERT INTO payments(member_id, amount, payment_date) VALUES (?, ?, CURDATE())";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, payment.getMemberId());
            ps.setDouble(2, payment.getAmount());
            ps.executeUpdate();
            System.out.println("✅ Payment recorded successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Payment> getAllPayments() {
        List<Payment> list = new ArrayList<>();
        String sql = "SELECT * FROM payments";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Payment(
                    rs.getInt("id"),
                    rs.getInt("member_id"),
                    rs.getDouble("amount")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
