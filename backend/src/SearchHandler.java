import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SearchHandler {

    public static String searchDonors(String bloodGroup, String city) {

        StringBuilder result = new StringBuilder();

        try {

            Connection con = Database.getConnection();

            String sql = "SELECT * FROM donors WHERE blood_group=? AND city=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, bloodGroup);
            ps.setString(2, city);

            ResultSet rs = ps.executeQuery();

            result.append("<html>");
            result.append("<head>");
            result.append("<title>Search Results</title>");
            result.append("</head>");
            result.append("<body style='font-family:Arial;background:#f5f5f5;'>");

            result.append("<h1 style='text-align:center;color:red;'>");
            result.append("🩸 Blood Donors");
            result.append("</h1>");

            boolean found = false;

            while (rs.next()) {

                found = true;

                result.append("<div style='width:500px;margin:20px auto;");
                result.append("background:white;padding:20px;");
                result.append("border-radius:10px;");
                result.append("box-shadow:0 0 10px gray;'>");

                result.append("<h2 style='color:red;'>");
                result.append(rs.getString("full_name"));
                result.append("</h2>");

                result.append("<p><b>Blood Group :</b> ");
                result.append(rs.getString("blood_group"));
                result.append("</p>");

                result.append("<p><b>Age :</b> ");
                result.append(rs.getInt("age"));
                result.append("</p>");

                result.append("<p><b>Phone :</b> ");
                result.append(rs.getString("phone"));
                result.append("</p>");

                result.append("<p><b>Email :</b> ");
                result.append(rs.getString("email"));
                result.append("</p>");

                result.append("<p><b>City :</b> ");
                result.append(rs.getString("city"));
                result.append("</p>");

                result.append("<p><b>Last Donation :</b> ");
                result.append(rs.getString("last_donation"));
                result.append("</p>");

                result.append("<p style='color:green;'>");
                result.append("<b>");
                result.append(rs.getString("availability"));
                result.append("</b>");
                result.append("</p>");

                result.append("</div>");
            }

            if (!found) {

                result.append("<h2 style='text-align:center;color:red;'>");
                result.append("No Donors Found!");
                result.append("</h2>");

            }

            result.append("</body>");
            result.append("</html>");

            rs.close();
            ps.close();
            con.close();

            return result.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return "<h2>Database Error!</h2>";
        }
    }
}