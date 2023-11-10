package jsonIntoMySQL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

//https://chat.openai.com/share/b39242df-96b7-4f24-bf73-057049d65dc9
//get json from API and create the DATABASE and TAble
/*
#CREATE DATABASE jsonToMySQL;
USE jsonToMySQL;
/*
CREATE TABLE joke_data (
    id INT PRIMARY KEY,
    lang VARCHAR(2),
    safe TINYINT(1),
    type VARCHAR(20),
    error TINYINT(1),
    nsfw TINYINT(1),
    racist TINYINT(1),
    sexist TINYINT(1),
    explicit TINYINT(1),
    political TINYINT(1),
    religious TINYINT(1),
    setup VARCHAR(255),
    category VARCHAR(50),
    delivery VARCHAR(255)
);

#select * from json_data;
 */
//then update url and STring Query, plus database name and username and password

public class Main {
    public static void main(String[] args) {
        try {
            // Query the API and parse the JSON data
            URL apiUrl = new URL("https://v2.jokeapi.dev/joke/Any?safe-mode");
            HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            connection.disconnect();

            String jsonData = content.toString();

            // Connect to the MySQL database
            String dbUrl = "jdbc:mysql://localhost:3306/jsonToMySQL";
            String user = "root";
            String password = "root";

            Connection con = DriverManager.getConnection(dbUrl, user, password);

            // Insert the JSON data into the MySQL table
            String query = "INSERT INTO joke_data (id, lang, safe, type, error, nsfw, racist, sexist, explicit, political, religious, setup, category, delivery) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(query);
            // Parse the JSON data and set the values accordingly
            stmt.setInt(1, 1); // id
            stmt.setString(2, "en"); // lang
            stmt.setBoolean(3, true); // safe
            stmt.setString(4, "twopart"); // type
            stmt.setBoolean(5, false); // error
            stmt.setBoolean(6, false); // nsfw
            stmt.setBoolean(7, false); // racist
            stmt.setBoolean(8, false); // sexist
            stmt.setBoolean(9, false); // explicit
            stmt.setBoolean(10, false); // political
            stmt.setBoolean(11, false); // religious
            stmt.setString(12, "How many programmers does it take to screw in a light bulb?"); // setup
            stmt.setString(13, "Programming"); // category
            stmt.setString(14, "None. It's a hardware problem."); // delivery
            stmt.executeUpdate();

            // Close the connection
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
