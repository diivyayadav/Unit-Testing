package DAO;

import domain.Order;

import java.sql.SQLException;

public interface OrderDAO {

    //create an order
    int create(Order order) throws SQLException;

    //reads an order
    Order read(int id) throws SQLException;

    //update an order and returns no. of updated order
    int update(Order order) throws SQLException;

    //delete order
    int delete(int id)throws SQLException;

}
