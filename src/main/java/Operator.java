public class Operator implements Runnable {
    public static final int SLEEP_TIME = 3000;
    private CallCenter callCenter;


    public Operator(CallCenter callCenter) {
        this.callCenter = callCenter;
    }

    @Override
    public void run() {

        while (callCenter.isOpen() || callCenter.getQueue().size() > 0) {
            Integer result = callCenter.getQueue().poll();
            if (result != null) {
                System.out.println("Оператор ответил на звонок");
                try {
                    Thread.sleep(SLEEP_TIME);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Оператор завершил звонок");
            }
        }
    }
}
