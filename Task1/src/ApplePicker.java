import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class ApplePicker implements Runnable{
    Object lock = new Object();
    int qtyApple;
    CountDownLatch latch;
    long workDuration;
    String name;
    public static Map<String, Integer> syncHashMap = Collections.synchronizedMap(new HashMap<>());

    public ApplePicker(String name, CountDownLatch latch, long workDuration){
        this.name= name;
        this.latch = latch;
        this.workDuration = workDuration;
    }

    @Override
    public void run() {


        synchronized(lock) {
            System.out.printf("%s started... \n", name);
            System.out.println(workDuration);
            //qtyApple = (int) (timeHavest * 10 * Math.PI * (Math.random() * (1.5 - 0.8) + 0.8));
            qtyApple = (int) (workDuration * 10);
        }
        try {
            Thread.sleep(workDuration);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.printf("%s finished... \n", name);
        //Put require no synchronization
        syncHashMap.put(name, qtyApple);

        //Iterator<String> itr = syncHashMap.keySet().iterator();

        //Using synchronized block is advisable
      // synchronized (syncHashMap)
       // {
      //      while(itr.hasNext()) {
   //             System.out.println(syncHashMap.get(itr.next()));
    //        }
   //     }

       // System.out.println(qtyApple);

        latch.countDown();
    }
}
