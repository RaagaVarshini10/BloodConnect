import java.sql.Connection;
import java.sql.PreparedStatement;

public class RegisterHandler {

    public static String registerDonor(Donor donor) {

        try {

            Connection con = Database.getConnection();

            String sql =
                "INSERT INTO donors(full_name, age, blood_group, phone, email, city, last_donation, availability) VALUES(?,?,?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, donor.getFullName());
            ps.setInt(2, donor.getAge());
            ps.setString(3, donor.getBloodGroup());
            ps.setString(4, donor.getPhone());
            ps.setString(5, donor.getEmail());
            ps.setString(6, donor.getCity());
            ps.setString(7, donor.getLastDonation());
            ps.setString(8, donor.getAvailability());

            int rows = ps.executeUpdate();

            con.close();

            if (rows > 0) {
                return "Donor Registered Successfully!";
            } else {
                return "Registration Failed!";
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "Database Error!";
        }
    }
}