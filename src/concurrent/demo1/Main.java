package concurrent.demo1;

import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *  通过线程池 开启一个线程去处理
 *  模拟请求来时，开启一个线程处理请求的场景
 * @author H-QIU
 *
 */
public class Main {
	public static void main(String[] args) throws IOException {
		 ThreadPoolExecutor exec = new ThreadPoolExecutor(0, 10,
		            5, TimeUnit.SECONDS,
		            new LinkedBlockingQueue<Runnable>(),new ThreadPoolExecutor.CallerRunsPolicy());
		 
		        TestThread tt = new TestThread();
		        exec.submit( tt );
		 
		//保持主线程存货， console端观察结果
		System.in.read();
	}
}
