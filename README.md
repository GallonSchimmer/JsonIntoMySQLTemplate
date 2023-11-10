# JsonIntoMySQLTemplate


### Java Code Overview

#### DeleteDataThenPersist.java

This Java class connects to the MySQL database, deletes existing data from the 'joke_data' table, retrieves JSON data from the [JokeAPI](https://v2.jokeapi.dev/joke/Any?safe-mode), and persists the parsed data into the 'joke_data' table.

#### GetData.java

This Java class connects to the MySQL database and retrieves the data from the 'joke_data' table. It then prints the retrieved data to the console.

### Dependencies

- JDK: The Java Development Kit is required to compile and run the Java code.
- MySQL Connector/J: The JDBC driver for MySQL, which allows Java applications to connect to a MySQL database.
- JSON: A library for processing JSON data in Java, used for parsing and manipulating JSON data.

### MySQL Script

The following MySQL script is needed to create the table for storing the JSON data:

```sql
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
```

Make sure to execute this script in your MySQL database to create the necessary 'joke_data' table before running the Java code.

### API Used

The Java code interacts with the [JokeAPI](https://v2.jokeapi.dev/joke/Any?safe-mode) to retrieve JSON data. This API provides various types of jokes, and the Java code specifically fetches a random joke from the API.

Ensure that you have an active internet connection and the API is accessible from your network.

### Notes

- Replace the placeholders for database URL, username, and password with your own MySQL database credentials.
- Make sure to have the necessary dependencies in your Java project, including the MySQL Connector/J and the JSON library.

### Running the Java Code

You can run the Java code by executing the main methods in the respective classes using any Java IDE or the command line. Make sure to have the MySQL server running and the necessary dependencies configured in your Java project.
