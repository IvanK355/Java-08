public class Report implements Runnable{

    public void run()

    {
        StringBuilder builder = new StringBuilder();
        builder.append(1); // можно добавить один символ
        builder.append(2); // а можно добавить готовую строку
        String completedString = builder.toString(); // результирующая строка
    }
}
