package hello.advanced.trace.threadlocal.code;

import hello.advanced.utils.Utils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadLocalService {

    private ThreadLocal<String> nameStore = new ThreadLocal<>();
    private Utils utils = new Utils();

    public String logic(String name) {
        log.info("์ ์ฅ name={} => nameStore={}", name, nameStore.get());
        nameStore.set(name);
        utils.sleep(1000);
        log.info("์กฐํ nameStore={}", nameStore.get());
        return nameStore.get();
    }
}
