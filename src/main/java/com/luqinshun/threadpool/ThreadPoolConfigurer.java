package com.luqinshun.threadpool;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author:luqinshun
 * @Description:
 * @Date: Created in 2019/9/5 17:42
 * @Modified By:
 */
@Configuration
@Slf4j
public class ThreadPoolConfigurer  implements AsyncConfigurer {

    @Bean
    public ThreadPoolTaskExectorWrapper getThreadPool(){
        ThreadPoolTaskExectorWrapper threadPoolTaskExector = new ThreadPoolTaskExectorWrapper();
        threadPoolTaskExector.setCorePoolSize(Runtime.getRuntime().availableProcessors()*5);
        threadPoolTaskExector.setMaxPoolSize(Runtime.getRuntime().availableProcessors()*5);
        threadPoolTaskExector.setQueueCapacity(Runtime.getRuntime().availableProcessors()*5);

        // 设置优雅的线程池关闭策略
        threadPoolTaskExector.setWaitForTasksToCompleteOnShutdown(false);
        //关闭等待超时时间，不能一直等待下去
        threadPoolTaskExector.setAwaitTerminationSeconds(60);
        threadPoolTaskExector.setThreadNamePrefix("sync-job-");
        //拒绝策略
        threadPoolTaskExector.setRejectedExecutionHandler(getRejectExecutionHandler());
        threadPoolTaskExector.initialize();
        return threadPoolTaskExector;
    }

    //设置线程池拒绝策略

    private MyRejectExecutionHandler getRejectExecutionHandler(){
        return new MyRejectExecutionHandler();
    }

    /**
     * 线程池拒绝执行器
     */
    class MyRejectExecutionHandler implements RejectedExecutionHandler {

        /**
         * Method that may be invoked by a {@link ThreadPoolExecutor} when
         * {@link ThreadPoolExecutor#execute execute} cannot accept a
         * task.  This may occur when no more threads or queue slots are
         * available because their bounds would be exceeded, or upon
         * shutdown of the Executor.
         *
         * <p>In the absence of other alternatives, the method may throw
         * an unchecked {@link RejectedExecutionException}, which will be
         * propagated to the caller of {@code execute}.
         *
         * @param r        the runnable task requested to be executed
         * @param executor the executor attempting to execute this task
         * @throws RejectedExecutionException if there is no remedy
         */
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            log.info("线程是已满");
        }
    }
}
