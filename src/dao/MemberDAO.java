package dao;
import db.DBConnection;
import model.Member;
import java.sql.*;
import java.util.*;

public class MemberDAO {
 
    public void addMember(Member member) {
        String sql = "INSERT INTO members(name, age, membership_type, join_date) VALUES (?, ?, ?, CURDATE())";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, member.getName());
            ps.setInt(2, member.getAge());
            ps.setString(3, member.getMembershipType());
            ps.executeUpdate();
            System.out.println("✅ Member added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Member> getAllMembers() {
        List<Member> list = new ArrayList<>();
        String sql = "SELECT * FROM members";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Member(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getString("membership_type")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
