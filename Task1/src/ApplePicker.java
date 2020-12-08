import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class ApplePicker implements Runnable {
    final Object lock = new Object();
    CountDownLatch latch;
    String namePicker;
    int qtyApple;
    long workDuration;
    long timeout;
    long start;
    long finish;

    public static Map<String, ApplePicker> syncHashMap = Collections.synchronizedMap(new HashMap<>());

    public ApplePicker(String name, CountDownLatch latch, long timeout) {
        this.namePicker = name;
        this.latch = latch;
        this.timeout = timeout;
    }

    public ApplePicker(String namePicker, long workDuration, int qtyApple) {
        this.namePicker = namePicker;
        this.workDuration = workDuration;
        this.qtyApple = qtyApple;
    }

    @Override
    public void run() {

        synchronized (lock) {

            start = System.currentTimeMillis();
        }

        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (lock) {
            finish = System.currentTimeMillis();
            workDuration = finish-start;
            qtyApple = (int) (workDuration * 10 * Math.PI * (Math.random() * (1.5 - 0.8) + 0.8));
        }
        syncHashMap.put(namePicker, new ApplePicker(namePicker,workDuration,qtyApple));
        latch.countDown();
    }
}
