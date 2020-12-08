import java.util.HashMap;

public class Report implements Runnable {
    private final HashMap <String, ApplePicker> reportHashMap;

    public Report(HashMap <String, ApplePicker> hashMap) {

        this.reportHashMap = hashMap;
    }

    @Override
    public void run() {
        StringBuilder sb = new StringBuilder();
        String paws = ", ";

        for (Object value : reportHashMap.values()) {
            ApplePicker applePicker = (ApplePicker) value;

            sb.append(applePicker.qtyApple / applePicker.workDuration).append(paws);
        }
        System.out.println(sb.toString());
    }
}
