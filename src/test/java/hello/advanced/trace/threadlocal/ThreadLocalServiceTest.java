package hello.advanced.trace.threadlocal;

import hello.advanced.trace.threadlocal.code.FieldService;
import hello.advanced.trace.threadlocal.code.ThreadLocalService;
import hello.advanced.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ThreadLocalServiceTest {
    private ThreadLocalService service = new ThreadLocalService();

    private Utils utils = new Utils();

    @Test
    void threadLocal() {
        log.info("main start");

        Runnable userA = () -> {
            service.logic("userA");
        };

        Runnable userB = () -> {
            service.logic("userB");
        };

        Thread threadA = new Thread(userA);
        threadA.setName("thread-A");
        Thread threadB = new Thread(userB);
        threadB.setName("thread-B");

        threadA.start();    // A실행
//        utils.sleep(2000);  // 동시성 문제 발생 X
         utils.sleep(100);  // 동시성 문제 발생 O

        threadB.start();    // B실행
        utils.sleep(3000);  // 메인 쓰레드 종료 대기
        log.info("main exit");
    }
}
