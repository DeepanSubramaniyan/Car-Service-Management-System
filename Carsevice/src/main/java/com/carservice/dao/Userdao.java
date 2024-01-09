package com.carservice.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.carservice.model.User;

public class Userdao {
    private String jdbcURL = "jdbc:mysql://localhost:3306/car";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";

    private static final String INSERT_USERS_SQL = "INSERT INTO `user`(`name`, `vehicle_number`, `vehicle_model`, `phone`, `date`, `pickup_date`, `service_type`) VALUES (?,?,?,?,?,?,?)";

    private static final String SELECT_USER_BY_ID = "SELECT id, name, vehicle_number, vehicle_model, phone, date, pickup_date, service_type FROM user WHERE id=?";
    private static final String SELECT_ALL_USERS = "SELECT * FROM user";
    private static final String DELETE_USERS_SQL = "DELETE FROM user WHERE id=?";
    private static final String UPDATE_USERS_SQL = "UPDATE user SET name=?, vehicle_number=?, vehicle_model=?, phone=?, date=?, pickup_date=?, service_type=? WHERE id=?";

    public Userdao() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void insertUser(User user) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getVehicleNumber());
            preparedStatement.setString(3, user.getVehicleModel());
            preparedStatement.setString(4, user.getPhone());
            preparedStatement.setString(5, user.getDate());
            preparedStatement.setString(6, user.getPickUpDate());
            preparedStatement.setString(7, user.getServiceType());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public User selectUser(int id) {
        User user = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID)) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String vehiclenumber = rs.getString("vehicle_number");
                String vehiclemodel = rs.getString("vehicle_model");
                String phone = rs.getString("phone");
                String date = rs.getString("date");
                String pickUpDate = rs.getString("pickup_date");
                String serviceType = rs.getString("service_type");
                user = new User(id, name, vehiclenumber, vehiclemodel, phone, date, pickUpDate, serviceType);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    public List<User> selectAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String vehiclenumber = rs.getString("vehicle_number");
                String vehiclemodel = rs.getString("vehicle_model");
                String phone = rs.getString("phone");
                String date = rs.getString("date");
                String pickUpDate = rs.getString("pickup_date");
                String serviceType = rs.getString("service_type");
                users.add(new User(id, name, vehiclenumber, vehiclemodel, phone, date, pickUpDate, serviceType));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }

    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL)) {
            System.out.println("Updated User: " + statement);
            statement.setString(1, user.getName());
            statement.setString(2, user.getVehicleNumber());
            statement.setString(3, user.getVehicleModel());
            statement.setString(4, user.getPhone());
            statement.setString(5, user.getDate());
            statement.setString(6, user.getPickUpDate());
            statement.setString(7, user.getServiceType());
            statement.setInt(8, user.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
