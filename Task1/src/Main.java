import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) {

        CountDownLatch latch = new CountDownLatch(5);
        long timeHavest;
        Thread[] threads = new Thread[5];
        ApplePicker[] applePickers = new ApplePicker[5];
        for (int i = 0; i < threads.length; i++) {
            timeHavest = (long) (2600 * Math.random() + 900);
            applePickers[i] = new ApplePicker("ApplePicker"+i, latch, timeHavest);
            threads[i] = new Thread(applePickers[i]);
            threads[i].start();

        }
        System.out.println("waiting for Children processes to complete....");
        try {
            //current thread will get notified if all chidren's are done
            // and thread will resume from wait() mode.
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        HashMap map = new HashMap(ApplePicker.syncHashMap);
        System.out.println(map);

        Thread report = new Thread(new Report(map));
        report.start();

        for (Object value : hashMap.values()) {
            sb.append(value).append(paws);
        }

    }
}
