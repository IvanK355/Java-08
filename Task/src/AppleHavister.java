public class AppleHavister extends Thread {

    AppleHavister(String name) {
        super(name);
    }

    public void run() {
        long upperTime = 3500;
        long lowerTime = 900;
        System.out.printf("%s started... \n", Thread.currentThread().getName());

        long timeHavest = (long) (Math.random() * ((upperTime - lowerTime)+lowerTime));
        try {
            Thread.sleep(timeHavest);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        int qtyApple = (int) (timeHavest * 10 * Math.PI * (Math.random() * (1.5 - 0.8) + 0.8));
        System.out.println(qtyApple);
        System.out.printf("%s fiished... \n", Thread.currentThread().getName());
    }

    public void getSalary(int qtyApple){
        int salaryHavister = qtyApple * 7;
        System.out.println("Next week - next salary: " + salaryHavister);
    }
}
