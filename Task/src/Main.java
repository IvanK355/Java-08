public class Main {
    public static void main(String[] args) {

        System.out.println("Main thread started...");
        for(int i=1; i < 6; i++)
            new AppleHavister("JThread " + i).start();
        System.out.println("Main thread finished...");
    }
}
