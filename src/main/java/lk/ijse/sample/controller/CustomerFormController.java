package lk.ijse.sample.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import lk.ijse.sample.model.Customer;
import lk.ijse.sample.repository.CustomerRepository;
import lk.ijse.sample.service.CustomerService;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CustomerFormController implements Initializable {
    public JFXComboBox comboBox;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtName;

    CustomerService customerService = new CustomerService();
    CustomerRepository customerRepository = new CustomerRepository();
    Customer customer = new Customer();

   /* CustomerFormController(){
        txtName.setText("yyyyy");
    }*/

    @FXML
    void deleteOnAction(ActionEvent event) {

    }

    @FXML
    void saveOnAction(ActionEvent event) {
        customer = new Customer(txtName.getText(), txtAddress.getText());
        customerService.createCustomer(customer);
    }
    @FXML
    void updateOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        ObservableList<Customer> list = FXCollections.observableArrayList(customerRepository.getAllCustomer());
        ComboBox<Customer>stringComboBox = new ComboBox<>(list);
//        comboBox.setCellFactory(param -> new ListCell<Customer>() {
//            @Override
//            public void updateItem(Customer item, boolean empty) {
//                super.updateItem(item, empty);
//                setText(item.getId() + " - " +item.getName());
//            }
//        });
//        comboBox.getSelectionModel().select(0);
        comboBox.setItems(list);
//        comboBox.getEditor().setText();
//        comboBox.setValue(stringComboBox);*/
    }
}
