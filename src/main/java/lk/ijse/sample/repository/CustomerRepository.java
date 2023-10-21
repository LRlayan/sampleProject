package lk.ijse.sample.repository;

import javafx.scene.control.Alert;
import lk.ijse.sample.db.DbConnection;
import lk.ijse.sample.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {


    public List<Customer> getAllCustomer(){
        try{
            List<Customer> customerList= new ArrayList<>();

            Connection connection = DbConnection.getInstance().getConnection();
            String sql = "SELECT * FROM CUSTOMER";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Customer customer = new Customer();

                customer.setId(resultSet.getInt("id"));
                customer.setName(resultSet.getString("name"));
                customer.setAddress(resultSet.getString("address"));
                customerList.add(customer);
            }

        return customerList;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean createCustomer(Customer customer) {
        try {
            Connection connection = DbConnection.getInstance().getConnection();
            String sql = "INSERT INTO CUSTOMER VALUES(?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, null);
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setString(3, customer.getAddress());

            int affectedRow = preparedStatement.executeUpdate();
            if (affectedRow > 0) {
                new Alert(Alert.AlertType.CONFIRMATION, "Save Successfully!").show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean updateCustomer(Customer customer) {
    return true;
    }
}
