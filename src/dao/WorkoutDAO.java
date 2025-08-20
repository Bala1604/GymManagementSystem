package dao;
import db.DBConnection;
import model.Workout;
import java.sql.*;
import java.util.*;

public class WorkoutDAO {
    
    public void addWorkout(Workout workout) {
        String sql = "INSERT INTO workouts(member_id, workout_plan) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, workout.getMemberId());
            ps.setString(2, workout.getWorkoutPlan());
            ps.executeUpdate();
            System.out.println("✅ Workout plan added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Workout> getAllWorkouts() {
        List<Workout> list = new ArrayList<>();
        String sql = "SELECT * FROM workouts";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Workout(
                    rs.getInt("id"),
                    rs.getInt("member_id"),
                    rs.getString("workout_plan")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
