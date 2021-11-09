package controller;

import db.DbConnection;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.Customer;

import java.sql.*;

public class CustomerSaveFormController {

    public TextField txtId;
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtSalary;

    public void SaveCustomerOnAction(ActionEvent actionEvent) throws ClassNotFoundException, SQLException {
        Customer c1 = new Customer(
                txtId.getText(),txtName.getText(),
                txtAddress.getText(),Double.parseDouble(txtSalary.getText())
        );

        if(new CustomerController().saveCustomer(c1))
            new Alert(Alert.AlertType.CONFIRMATION, "Saved..").show();
        else
            new Alert(Alert.AlertType.WARNING, "Try Again..").show();
    }

}
