package hello.advanced.app.v0;

import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryV0 {
    public void save(String itemId) {
        if (itemId.equals("ex")) {
            throw new IllegalStateException("μμΈλ°μ");
        }
        sleep(1000);
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
