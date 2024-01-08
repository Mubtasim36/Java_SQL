import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Appointment {
    String driver = "com.mysql.cj.jdbc.Driver";
    String dblink = "jdbc:mysql://localhost:3306/appointment";
    String username = "root";
    String PASS = "";
    String QUERY = "SELECT * FROM doctor";

    public static void main(String[] args) {
        Appointment appointment = new Appointment();
        appointment.showqueryresult();
    }

    public void showqueryresult() {
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(dblink, username, PASS);
            System.out.println("Connection Established");

            Statement state = conn.createStatement();
            ResultSet res = state.executeQuery(QUERY);

            while (res.next()) {
                System.out.print("D_ID: " + res.getInt(1));
                System.out.print(", D_NAME: " + res.getString(2));
                System.out.print(", D_num: " + res.getString(3));
                System.out.println(", SCHEDULE: " + res.getString(4));
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
