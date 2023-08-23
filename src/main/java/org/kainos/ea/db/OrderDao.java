package org.kainos.ea.db;

import org.kainos.ea.cli.Order;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class OrderDao {
    private DatabaseConnector databaseConnector = new DatabaseConnector();
    public List<Order> getAllOrders() throws SQLException {
        Connection c = databaseConnector.getConnection();
        Statement st = c.createStatement();

        ResultSet rs = st.executeQuery("SELECT OrderID, CustomerID, OrderDate FROM `Orders`;");

        List<Order> orderList = new ArrayList<>();

        while (rs.next()){
            Order order = new Order(
                    rs.getInt("OrderID"),
                    rs.getInt("CustomerID"),
                    rs.getDate("OrderDate")
            );
            orderList.add(order);
        }

        return orderList;
    }

    public Order getOrderById(int id) throws SQLException {
        Connection c = databaseConnector.getConnection();
        Statement st = c.createStatement();

        ResultSet rs = st.executeQuery("SELECT OrderID, CustomerID, OrderDate" +
                " FROM `Orders` where OrderID=" + id);

        while (rs.next()) {
            return new Order(
                    rs.getInt("OrderID"),
                    rs.getInt("CustomerID"),
                    rs.getDate("OrderDate")
            );
        }

        return null;
    }

}
