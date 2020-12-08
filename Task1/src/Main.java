import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(5);
        long workDuration;
        int qtyApple;
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            workDuration = (long) (2600 * Math.random() + 900);
            qtyApple = (int) (workDuration * 10 * Math.PI * (Math.random() * (1.5 - 0.8) + 0.8));
            ApplePicker applePicker = new ApplePicker("ApplePicker" + i, latch, workDuration, qtyApple);
            threads[i] = new Thread(applePicker);
            threads[i].start();

        }
        System.out.println("waiting for Children processes to complete....");
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        HashMap map = new HashMap(ApplePicker.syncHashMap);

        Thread report = new Thread(new Report(map));
        report.start();
        report.join();

        for (Object value : map.values()) {
            ApplePicker applePicker = (ApplePicker) value;
            int salary = applePicker.qtyApple * 7;
            String name = applePicker.name;
            System.out.println("Ура ," + name + " получил зарплату " + salary + " тугриков");
        }
    }
}
