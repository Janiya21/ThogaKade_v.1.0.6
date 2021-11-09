package controller;

import db.DbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Customer;
import views.tm.CustomerTM;

import java.sql.*;
import java.util.ArrayList;

public class CustomerSelectAllFormController {
    public TableView<CustomerTM> tblCustomer;
    public TableColumn colCustomerId;
    public TableColumn colCustomerName;
    public TableColumn colCustomerAddress;
    public TableColumn colCustomerSalary;

    public void initialize() {
        try {

            colCustomerId.setCellValueFactory(new PropertyValueFactory<>("id"));
            colCustomerName.setCellValueFactory(new PropertyValueFactory<>("name"));
            colCustomerAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
            colCustomerSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));

            setCustomersToTable(new CustomerController().getAllCustomers());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void setCustomersToTable(ArrayList<Customer> customers) {
        ObservableList<CustomerTM> obList = FXCollections.observableArrayList();
        customers.forEach(e->{
            obList.add(
                    new CustomerTM(e.getId(),e.getName(),e.getAddress(),e.getSalary()));
        });
        tblCustomer.setItems(obList);
    }

}
