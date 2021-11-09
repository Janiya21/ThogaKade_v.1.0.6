package controller;

import db.DbConnection;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.Customer;

import java.sql.*;

public class CustomerUpdateFormController {
    public TextField txtId;
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtSalary;

    public void selectCustomerOnAction(ActionEvent actionEvent) throws ClassNotFoundException, SQLException {
        String customerId = txtId.getText();

        Customer c1= new CustomerController().getCustomer(customerId);
        if (c1==null) {
            new Alert(Alert.AlertType.WARNING, "Empty Result Set").show();
        } else {
            setData(c1);
        }

    }

    public void updateCustomerOnAction(ActionEvent actionEvent) throws ClassNotFoundException, SQLException {
        Customer c1= new Customer(
                txtId.getText(),txtName.getText(),
                txtAddress.getText(),
                Double.parseDouble(txtSalary.getText())
        );


        if (new CustomerController().updateCustomer(c1))
            new Alert(Alert.AlertType.CONFIRMATION,"Updated..").show();
        else
            new Alert(Alert.AlertType.WARNING,"Try Again").show();


    }

    void setData(Customer c){
        txtId.setText(c.getId());
        txtName.setText(c.getName());
        txtAddress.setText(c.getAddress());
        txtSalary.setText(String.valueOf(c.getSalary()));
    }

}
