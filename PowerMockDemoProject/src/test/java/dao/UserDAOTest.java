package dao;
import domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import util.IDGenerator;
import static org.junit.Assert.*;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(IDGenerator.class)
public class UserDAOTest {
    @Test
    public void create() {
    UserDAO userDAO = new UserDAO();
    mockStatic(IDGenerator.class);
    when(IDGenerator.generateID()).thenReturn(1);
    int result = userDAO.create(new User());
    assertEquals(1, result);
    }
}