import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class ApplePicker implements Runnable {
    CountDownLatch latch;
    String name;
    int qtyApple;
    long workDuration;

    public static Map<String, ApplePicker> syncHashMap = Collections.synchronizedMap(new HashMap<>());

    public ApplePicker(String name, CountDownLatch latch, long workDuration, int qtyApple) {
        this.name = name;
        this.latch = latch;
        this.workDuration = workDuration;
        this.qtyApple = qtyApple;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(workDuration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        syncHashMap.put(name, this);
        latch.countDown();
    }
}
