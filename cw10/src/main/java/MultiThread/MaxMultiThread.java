package MultiThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MaxMultiThread {
    private ExecutorService executorService = Executors.newCachedThreadPool();
    public <T> Future<T> execute(Callable<T> callable){
        return executorService.submit(callable);
    }
    public void end(){
        executorService.shutdown();
    }
}
