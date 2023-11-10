package jsonIntoMySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GetData {
    public static void main(String[] args) {
        try {
            // Connect to the MySQL database
            String dbUrl = "jdbc:mysql://localhost:3306/jsonToMySQL";
            String user = "root";
            String password = "root";

            Connection con = DriverManager.getConnection(dbUrl, user, password);

            // Retrieve data from the MySQL table
            String query = "SELECT * FROM joke_data";
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            // Print the retrieved data
            while (rs.next()) {
                System.out.println("id: " + rs.getInt("id"));
                System.out.println("lang: " + rs.getString("lang"));
                System.out.println("safe: " + rs.getBoolean("safe"));
                System.out.println("type: " + rs.getString("type"));
                System.out.println("error: " + rs.getBoolean("error"));
                System.out.println("nsfw: " + rs.getBoolean("nsfw"));
                System.out.println("racist: " + rs.getBoolean("racist"));
                System.out.println("sexist: " + rs.getBoolean("sexist"));
                System.out.println("explicit: " + rs.getBoolean("explicit"));
                System.out.println("political: " + rs.getBoolean("political"));
                System.out.println("religious: " + rs.getBoolean("religious"));
                System.out.println("setup: " + rs.getString("setup"));
                System.out.println("category: " + rs.getString("category"));
                System.out.println("delivery: " + rs.getString("delivery"));
            }

            // Close the connection
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
