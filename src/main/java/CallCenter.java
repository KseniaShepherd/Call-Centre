import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class CallCenter {
    private Queue<Integer> queue;
    private boolean isOpen;

    public CallCenter() {
        this.queue = new ConcurrentLinkedQueue<>();
        this.isOpen = true;
    }

    public Queue<Integer> getQueue() {
        return queue;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

}
