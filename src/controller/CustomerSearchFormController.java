package controller;

import com.sun.xml.internal.ws.org.objectweb.asm.ClassAdapter;
import db.DbConnection;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.Customer;

import java.sql.*;

public class CustomerSearchFormController {
    public TextField txtCustomerId;
    public TextField txtCustomerName;
    public TextField txtCustomerAddress;
    public TextField txtCustomerSalary;

    public void btnSearchButtonOnAction(ActionEvent actionEvent) throws ClassNotFoundException, SQLException {

        String customerId = txtCustomerId.getText();

        Customer c1= new CustomerController().getCustomer(customerId);
        if (c1==null) {
            new Alert(Alert.AlertType.WARNING, "Empty Result Set").show();
        } else {
            setData(c1);
        }
    }

    void setData(Customer c){
        txtCustomerId.setText(c.getId());
        txtCustomerName.setText(c.getName());
        txtCustomerAddress.setText(c.getAddress());
        txtCustomerSalary.setText(String.valueOf(c.getSalary()));
    }

}
