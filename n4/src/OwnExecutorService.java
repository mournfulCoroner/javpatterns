import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class OwnExecutorService implements ExecutorService{
    public ExecutorService service;
    public OwnExecutorService(int count){
        service = Executors.newFixedThreadPool(count);
    }

    @Override
    public void shutdown() {
        service.shutdown();
    }

    @Override
    public List<Runnable> shutdownNow() {
        return service.shutdownNow();
    }

    @Override
    public boolean isShutdown() {
        return service.isShutdown();
    }

    @Override
    public boolean isTerminated() {
        return service.isTerminated();
    }

    @Override
    public boolean awaitTermination(long l, TimeUnit timeUnit) throws InterruptedException {
        return service.awaitTermination(l, timeUnit);
    }

    @Override
    public <T> Future<T> submit(Callable<T> callable) {
        return service.submit(callable);
    }

    @Override
    public <T> Future<T> submit(Runnable runnable, T t) {
        return service.submit(runnable, t);
    }

    @Override
    public Future<?> submit(Runnable runnable) {
        return service.submit(runnable);
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        return service.invokeAll(collection);
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long l, TimeUnit timeUnit) throws InterruptedException {
        return service.invokeAll(collection, l, timeUnit);
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        return (T)service.invokeAll(collection);
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long l, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return (T)service.invokeAll(collection, l, timeUnit);
    }

    @Override
    public void execute(Runnable runnable) {
        service.execute(runnable);
    }
}
