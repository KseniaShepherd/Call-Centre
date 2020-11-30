import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static final int NUMBER_OF_CALLS = 10;
    public static final int N_OPERATOR_THREADS = 4;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallCenter callCenter = new CallCenter();

        ExecutorService service = Executors.newFixedThreadPool(N_OPERATOR_THREADS);
        List<Future<?>> futures = new ArrayList<>();

        futures.add(service.submit(new AutomaticTelephoneExchange(callCenter, NUMBER_OF_CALLS)));

        for (int i = 0; i < N_OPERATOR_THREADS; i++) {

            Future<?> future = service.submit(new Operator(callCenter));
            futures.add(future);
        }
        for (Future<?> future : futures) {
            future.get();
        }
        service.shutdown();
    }
}
