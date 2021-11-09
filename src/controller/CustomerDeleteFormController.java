package controller;
import db.DbConnection;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.Customer;

import java.sql.*;

public class CustomerDeleteFormController {
    public TextField txtId;
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtSalary;

    public void deleteCustomerOnAction(ActionEvent actionEvent) throws ClassNotFoundException, SQLException {
        if (new CustomerController().deleteCustomer(txtId.getText())){
            new Alert(Alert.AlertType.CONFIRMATION, "Deleted").show();
        }else{
            new Alert(Alert.AlertType.WARNING, "Try Again").show();
        }

    }

    public void searchCustomer(ActionEvent actionEvent) throws ClassNotFoundException, SQLException {
        String customerId = txtId.getText();

        Customer c1= new CustomerController().getCustomer(customerId);
        if (c1==null) {
            new Alert(Alert.AlertType.WARNING, "Empty Result Set").show();
        } else {
            setData(c1);
        }

    }

    void setData(Customer c){
        txtId.setText(c.getId());
        txtName.setText(c.getName());
        txtAddress.setText(c.getAddress());
        txtSalary.setText(String.valueOf(c.getSalary()));
    }
}
