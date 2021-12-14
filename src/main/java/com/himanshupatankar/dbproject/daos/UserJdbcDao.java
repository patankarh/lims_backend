package com.himanshupatankar.dbproject.daos;

import com.himanshupatankar.dbproject.models.Scientist;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class UserJdbcDao {
    static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String HOST = "localhost:3306";
    static final String SCHEMA = "db_design_project";
    static final String CONFIG = "serverTimezone=UTC";
    static final String URL =
            "jdbc:mysql://"+HOST+"/"+SCHEMA+"?"+CONFIG;
    static final String USERNAME = "root";
    static final String PASSWORD = "password";
    
    static Connection connection = null;
    static PreparedStatement statement = null;
    String CREATE_USER = "INSERT INTO scientists VALUES (null, ?, ?, ?, ?, ?, ?, ?)";
    String FIND_ALL_USERS = "SELECT * FROM scientists";
    String FIND_USER_BY_ID = "SELECT * FROM scientists WHERE id=?";
    String DELETE_USER = "DELETE FROM scientists WHERE id=?";
    String UPDATE_USER = "UPDATE scientists SET first_name=?, last_name=?, username=?, password=?, email=?, date_of_birth=?, role=? WHERE id=?";
    
    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
    
    private void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }
    
    public Scientist findUserById(Integer id) throws SQLException, ClassNotFoundException {
        Scientist scientist = null;
        connection = getConnection();
        statement = connection.prepareStatement(FIND_USER_BY_ID);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()) {
            scientist = new Scientist(
                resultSet.getString("first_name"),
                resultSet.getString("last_name"),
                resultSet.getString("username"),
                resultSet.getString("password"),
                resultSet.getString("email"),
                resultSet.getDate("date_of_birth"),
                resultSet.getString("role")
            );
        }
        closeConnection(connection);
        return scientist;
    }
    
    public Integer deleteUser(Integer userId) throws SQLException, ClassNotFoundException {
        Integer rowsDeleted = 0;
        connection = getConnection();
        statement = connection.prepareStatement(DELETE_USER);
        statement.setInt(1, userId);
        rowsDeleted = statement.executeUpdate();
        closeConnection(connection);
        return rowsDeleted;

    }

    public Integer updateUser(Integer userId, Scientist scientist) throws SQLException, ClassNotFoundException {
        Integer rowsUpdated = 0;
        connection = getConnection();
        statement = connection.prepareStatement(UPDATE_USER);
        statement.setString(1, scientist.getFirstName());
        statement.setString(2, scientist.getLastName());
        statement.setString(3, scientist.getUsername());
        statement.setString(4, scientist.getPassword());
        statement.setString(5, scientist.getEmail());
        statement.setDate(6, scientist.getDateOfBirth());
        statement.setString(7, scientist.getRole());
        statement.setInt(8, userId);
        rowsUpdated = statement.executeUpdate();
        closeConnection(connection);
        return rowsUpdated;


    }


    
    public List<Scientist> findAllUsers() throws ClassNotFoundException, SQLException {
        List<Scientist> scientists = new ArrayList<Scientist>();
        connection = getConnection();
        statement = connection.prepareStatement(FIND_ALL_USERS);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Scientist scientist = new Scientist(
                resultSet.getString("first_name"),
                resultSet.getString("last_name"),
                resultSet.getString("username"),
                resultSet.getString("password"),
                resultSet.getString("email"),
                resultSet.getDate("date_of_birth"),
                resultSet.getString("role")
            );
            scientists.add(scientist);
        }
        closeConnection(connection);
        return scientists;

    }

    public Integer createUser(Scientist scientist)
            throws ClassNotFoundException, SQLException {

        // do your work here
        Integer rowsInserted = 0;
        connection = getConnection();
        statement = connection.prepareStatement(CREATE_USER);
        statement.setString(1, scientist.getFirstName());
        statement.setString(2, scientist.getLastName());
        statement.setString(3, scientist.getUsername());
        statement.setString(4, scientist.getPassword());
        statement.setString(5, scientist.getEmail());
        statement.setDate(6, scientist.getDateOfBirth());
        statement.setString(7, scientist.getRole());

        rowsInserted = statement.executeUpdate();
        closeConnection(connection);
        return rowsInserted;

    }


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserJdbcDao dao = new UserJdbcDao();

        // do your work here
        /*
        User adam =
            new User("Adam", "Smith", "adams",
                "invisiblehand", "http://bbc.in/30gXhI4");

        User thomas =
            new User("Thomas", "Sowell", "thomas",
                "polymath", "http://www.tsowell.com/");

        User catherine =
            new User("Catherine", "Wood", "cathie",
                "bitcoinisbig", "https://ark-invest.com/");
        dao.createUser(adam);
        dao.createUser(thomas);
        dao.createUser(catherine);


        List<User> users = dao.findAllUsers();
        for (User user : users) {
            System.out.println(user.getUsername());
        }


        User user = dao.findUserById(1);
        System.out.println(user.getUsername());


        dao.deleteUser(1);
        List<User> users = dao.findAllUsers();
        for(User user: users) {
            System.out.println(user.getUsername());
        }


        User newTom = new User(
            "Tom",
            "Sowell",
            "tom",
            "knowitall",
            thomas.getProfilePicture());

        dao.updateUser(2, newTom);
        User tom = dao.findUserById(2);
        System.out.println(tom.getUsername());

         */

        Scientist dub = new Scientist("dub", "Winger", "jwinger", "Community!@","jwinger@gmail.com", Date.valueOf("1994-12-10"),
            "Research Associate");






        List<Scientist> users = dao.findAllUsers();
         for(Scientist user: users) {
             System.out.println(user.getUsername());
         }





    }


}

