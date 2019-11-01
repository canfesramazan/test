package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import lombok.Synchronized;
import org.junit.runners.Parameterized;
import org.junit.runners.model.RunnerScheduler;

import java.util.concurrent.*;

public class ParallelParameterized extends Parameterized {

    private static class ThreadPoolScheduler implements RunnerScheduler {
       // private ExecutorService executor;
        private ScheduledExecutorService pool;
        Semaphore semaphore = new Semaphore(2);

        public  ThreadPoolScheduler() {


           // String threads = System.getProperty("junit.parallel.threads", "10");
           // int numThreads = Integer.parseInt(threads);
           // executor = Executors.newWorkStealingPool(numThreads);
           // executor = Executors.newFixedThreadPool(numThreads);

            pool = Executors.newScheduledThreadPool(5);

        }

        @Override
        public  void finished() {
            pool.shutdown();
            //executor.shutdown();
            try {
               // executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
                pool.awaitTermination(Long.MAX_VALUE,TimeUnit.NANOSECONDS);
                // executor.awaitTermination(10, TimeUnit.MINUTES);
            } catch (InterruptedException exc) {
                throw new RuntimeException(exc);
            }
        }

        @Override
        public synchronized void  schedule(Runnable childStatement) {
               //Thread thread = new Thread();
               // executor.execute(childStatement);
               // pool.schedule(childStatement, 0, TimeUnit.SECONDS);
               try {
                   semaphore.acquire();
                   pool.schedule(childStatement, 1, TimeUnit.SECONDS);

                   semaphore.release();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           /* try {                   executor.submit(childStatement);

                executor.awaitTermination(6, TimeUnit.SECONDS);
            } catch (InterruptedException exc) {
                throw new RuntimeException(exc);
            }*/
             }
          }



    public  ParallelParameterized(Class<?> klass) throws Throwable {
        super(klass);
        setScheduler(new ThreadPoolScheduler());
    }
}