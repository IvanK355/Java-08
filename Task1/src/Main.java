import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(5);
        long timeout;
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            timeout = (long) (2600 * Math.random() + 900);
            ApplePicker applePicker = new ApplePicker("ApplePicker" + i, latch, timeout);
            threads[i] = new Thread(applePicker);
            threads[i].start();

        }
        System.out.println("waiting for Children processes to complete....");
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        HashMap <String, ApplePicker> map = new HashMap<>(ApplePicker.syncHashMap);

        Thread report = new Thread(new Report(map));
        report.start();
        report.join();

        for (Object value : map.values()) {
            ApplePicker applePicker = (ApplePicker) value;
            int salary = applePicker.qtyApple * 7;
            String name = applePicker.namePicker;
            System.out.println("Ура ," + name + " получил зарплату " + salary + " тугриков");
        }
    }
}
