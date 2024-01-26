import static org.junit.Assert.assertEquals;
import org.joda.time.LocalTime;
import org.junit.Test;
import hello.Greeter;
import hello.HelloWorld;


public class HelloWorldTest {
    @Test

    public void testCurrentTimeMessage() {
        // Create a fixed time for testing purposes
        LocalTime fixedTime = new LocalTime(12, 0, 0);
        String expected = "The current local time is: 12:00:00.000";
        String actual = HelloWorld.getCurrentTimeMessage(fixedTime);
        assertEquals(expected, actual);
    }

    @Test
    public void testGreeter() {
        Greeter greeter = new Greeter();
        String expected = "DevOps Project for Systems Limited";
        String actual = greeter.sayHello();
        assertEquals(expected, actual);
    }

    @Test
    public void testMainMethod() {
        // To cover the main method (just for coverage purposes)
        HelloWorld.main(null);
    }
}
