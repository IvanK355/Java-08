import java.awt.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Report implements Runnable{
    HashMap hashMap;
    public Report(HashMap hashMap) {
        this.hashMap = hashMap;
    }

    @Override
    public void run() {
        StringBuffer sb = new StringBuffer(20);
        String paws = ", ";
        for (Object value : hashMap.values()) {
            sb.append(value).append(paws);
        }
        System.out.println(sb.toString());
    }
}
