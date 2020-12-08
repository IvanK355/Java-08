import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) {

        CountDownLatch latch = new CountDownLatch(5);
        long timeHavest;
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            timeHavest = (long) (2600 * Math.random() + 900);
            threads[i] = new Thread( new ApplePicker("ApplePicker"+i, latch, timeHavest));
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
        System.out.println(ApplePicker.syncHashMap);
    }
}
