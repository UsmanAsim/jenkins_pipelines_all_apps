package hello;

import org.joda.time.LocalTime;

public class HelloWorld {
    public static void main(String[] args) {
        LocalTime currentTime = new LocalTime();
        System.out.println(getCurrentTimeMessage(currentTime));

        Greeter greeter = new Greeter();
        System.out.println(greeter.sayHello());
    }

    public static String getCurrentTimeMessage(LocalTime currentTime) {
        return "The current local time is: " + currentTime;
    }
}
