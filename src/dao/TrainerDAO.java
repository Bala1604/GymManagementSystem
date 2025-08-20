package dao;
import db.DBConnection;
import model.Trainer;
import java.sql.*;
import java.util.*;

public class TrainerDAO {
    
    public void addTrainer(Trainer trainer) {
        String sql = "INSERT INTO trainers(name, specialization) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, trainer.getName());
            ps.setString(2, trainer.getSpecialization());
            ps.executeUpdate();
            System.out.println("✅ Trainer added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Trainer> getAllTrainers() {
        List<Trainer> list = new ArrayList<>();
        String sql = "SELECT * FROM trainers";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Trainer(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("specialization")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
