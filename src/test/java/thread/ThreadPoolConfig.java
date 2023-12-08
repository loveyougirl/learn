package thread;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableAsync
public class ThreadPoolConfig implements AsyncConfigurer {
    /**
     * 核心线程池大小
     */
    private static final int CORE_POOL_SIZE = 3;

    /**
     * 最大可创建的线程数
     */
    private static final int MAX_POOL_SIZE = 10;

    /**
     * 队列最大长度
     */
    private static final int QUEUE_CAPACITY = 10;

    /**
     * 线程池维护线程所允许的空闲时间
     */
    private static final int KEEP_ALIVE_SECONDS = 300;

    /**
     * 异步执行方法线程池
     *
     * @return
     */
    @Override
    @Bean
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //最大线程数，线程池允许创建的最大线程数量，当添加一个任务时，核心线程数已满，线程池还没达到最大线程数，并且没有空闲线程，工作队列已满的情况下，
        //创建一个新线程，然后从工作队列的头部取出一个任务交由新线程来处理，而将刚提交的任务放入工作队列尾部
        executor.setMaxPoolSize(MAX_POOL_SIZE);
        //corePoolSize 核心线程数，线程池维护的最小线程数量，默认情况下核心线程创建后不会被回收（设置allowCoreThreadTimeout=true后，空闲的核心线程超过存活时间也会被回收）
        executor.setCorePoolSize(CORE_POOL_SIZE);
        executor.setQueueCapacity(QUEUE_CAPACITY);
        //如果一个可以被回收的线程的空闲时间大于keepAliveTime，那么这个线程就会被回收：
        //设置allowCoreThreadTimeout=true的核心线程
        //大于核心线程数的线程（费核心线程）
        executor.setKeepAliveSeconds(KEEP_ALIVE_SECONDS);
        executor.setThreadNamePrefix("LiMingTest");
        // 线程池对拒绝任务(无线程可用)的处理策略
        //
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }
}
