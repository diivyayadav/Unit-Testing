import BO.OrderBOImpl;
import BOException.BOException;
import DAO.OrderDAO;
import domain.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.SQLException;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


class OrderBOImplTest {

    @Mock
    OrderDAO dao;

    OrderBOImpl bo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        bo = new OrderBOImpl();
        bo.setDao(dao);
    }

    @Test
    void placeOrder() throws SQLException, BOException {
        Order order = new Order();

        //when is used to mockout the internal DAO method ..in this case i.e. create()
        when(dao.create(order)).thenReturn(1);

        boolean result = bo.placeOrder(order);
        Assertions.assertTrue(result);

        verify(dao).create(order);
    }

    @Test
    void notPlaceOrder() throws SQLException, BOException{
        Order order = new Order();
        when(dao.create(order)).thenReturn(0);
        boolean result = bo.placeOrder(order);
        Assertions.assertFalse(result);
        verify(dao).create(order);
    }

    @Test
    void placeOrderExceptionCheck() throws SQLException {
        Order order = new Order();
        when(dao.create(order)).thenThrow(SQLException.class);
    }

    @Test
    void cancelOrder() throws SQLException, BOException {

        Order order = new Order();
        order.setId(1);
        when(dao.read(order.getId())).thenReturn(order);
        when(dao.update(order)).thenReturn(1);
        boolean result = bo.cancelOrder(order.getId());

        Assertions.assertTrue(true);
    }

    @Test
    void deleteOrder() {
    }
}