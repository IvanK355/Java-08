import java.util.HashMap;

public class Report implements Runnable {
    private final HashMap hashMap;

    public Report(HashMap hashMap) {
        this.hashMap = hashMap;
    }

    @Override
    public void run() {
        StringBuffer sb = new StringBuffer();
        String paws = ", ";

        for (Object value : hashMap.values()) {
            ApplePicker applePicker = (ApplePicker) value;

            sb.append(applePicker.qtyApple / applePicker.workDuration).append(paws);
        }
        System.out.println(sb.toString());
    }
}
