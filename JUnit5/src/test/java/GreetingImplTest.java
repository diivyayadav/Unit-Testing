
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
class GreetingImplTest {

    GreetingImpl greeting;

    @BeforeEach
    void setUp() {
        greeting = new GreetingImpl();
    }

    @Test
    void greet() {
        String result = "Hello World";
        //introduced in junit5
        Assertions.assertEquals(result, greeting.greet("World"));
    }

    @Test
    void greetNullExceptionCheck(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            greeting.greet(null);
        });
    }
}