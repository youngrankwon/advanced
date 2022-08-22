package hello.advanced.utils;

import org.springframework.stereotype.Component;

@Component
public class Utils {
    public void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
