public class AutomaticTelephoneExchange implements Runnable {
    public static final int SLEEP_TIME = 1000;
    private CallCenter callCenter;
    private int numberOfCalls;

    public AutomaticTelephoneExchange(CallCenter callCenter, int numberOfCalls) {
        this.callCenter = callCenter;
        this.numberOfCalls = numberOfCalls;
    }

    @Override
    public void run() {
        for (int i = 0; i < numberOfCalls; i++) {
            System.out.println("Поступил звонок");
            callCenter.getQueue().add(i);
            try {
                Thread.sleep(SLEEP_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
        callCenter.setOpen(false);
        System.out.println("Поступило " + numberOfCalls + " входящих звонков");
    }
}
