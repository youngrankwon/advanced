package hello.advanced.trace.threadlocal.code;

import hello.advanced.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class FieldService {
    private String nameStore;

    private Utils utils = new Utils();

    public String logic(String name) {
        log.info("저장 name={} -> nameStore={}", name, nameStore);
        nameStore = name;
        utils.sleep(1000);
        log.info("조회 nameStore={}", nameStore);
        return nameStore;
    }

//    private void sleep(int millis) {
//        try {
//            Thread.sleep(millis);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }


}
