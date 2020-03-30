package com.executerframework;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class ExecutedFramework {

    public static void main1(String[] args) {
        for (int i=0 ; i<10 ; i++)
        {
            Thread thread = new Thread(() -> System.out.println("Current thread name : "+Thread.currentThread().getName()));
            thread.start();
        }
    }

    public static void main2(String[] args) {
        //Creating thread pool with 10 threads
        ExecutorService service = Executors.newFixedThreadPool(10);
        service.execute(() -> {
             //Assigning each new task to each thread.
            for (int i=0; i<5; i++)
                System.out.println("Current Thread Name : "+Thread.currentThread().getName());
        });

        /* So there are total 5 task in for loop and assigning to that task to each thread.
        * All task has been pushed into blocking queue which is thread safe. So each thread will take each task
        * from that queue and execute it. Then after execution it will again come back and pick another task.
        * */
        System.out.println("Main Thread : "+Thread.currentThread().getName());
        service.shutdownNow();      //shutdown executer service
    }

    public static void main3(String[] args) {
        int coreCount = Runtime.getRuntime().availableProcessors();
        System.out.println("Number of cores in processor : "+coreCount);
        ExecutorService service = Executors.newFixedThreadPool(coreCount);
        service.execute(() -> {
            for (int i=0; i<5; i++)
                System.out.println("Current Thread Name : "+Thread.currentThread().getName());
        });
        service.shutdownNow();
    }

    public static void main4(String[] args) {
        /* CachedThreadPool will take one task and assign to new thread and after that it will
        * take another task and check if there are any other thread which is free,
        * if it is free then assign task to that thread and if there is no free thread
        * then it will create new thread and assign task to that newly created thread.
        * It will also kill those threads which is idle for 60 seconds.
        */
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(() -> {
            for (int i=0; i<5; i++)
                System.out.println("Current Thread Name : "+Thread.currentThread().getName());
        });
        service.shutdownNow();
    }

    public static void main5(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
        service.schedule(
                () -> System.out.println("Current Thread Name : "+Thread.currentThread().getName()),
                10, TimeUnit.SECONDS);
        service.scheduleAtFixedRate(() -> System.out.println("Current Thread Name : "+Thread.currentThread().getName()),
                1, 2,TimeUnit.SECONDS);
        service.scheduleWithFixedDelay(() -> System.out.println("Current Thread Name : "+Thread.currentThread().getName()),
                1, 2,TimeUnit.SECONDS);
        service.shutdownNow();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(10);

        List<Future> futures = new ArrayList<>();
        for (int i=0; i<100; i++) {
            Future<Integer> future = service.submit(new Task());
            futures.add(future);
        }
        System.out.println("Task has been completed..");
        System.out.println("Some Random tasks...");
        futures.forEach(future -> {
            try {
                System.out.println("Result : "+future.get(1,TimeUnit.SECONDS));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                System.out.println("Couldn't complete task before timeout");
            }
        });
        System.out.println("All futures has been completed..");
        service.shutdownNow();
    }

    static class Task implements Callable<Integer>{
        @Override
        public Integer call() throws Exception {
            Thread.sleep(5000);
            return new Random().nextInt();
        }
    }
}

