package concurrent.demo1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class TestThread extends Thread{

	private ThreadPoolExecutor threadPoolExecutor =
		    new ThreadPoolExecutor(0, 10, 5, TimeUnit.SECONDS,
		        new LinkedBlockingQueue<Runnable>(),new ThreadPoolExecutor.CallerRunsPolicy());
	
	@Override
	public void run() {
		ThreadLocal th = new ThreadLocal<>();
		DivideFuture df = new DivideFuture();
		final Future future = threadPoolExecutor.submit(df);
		try {
			 //5秒后在超时，
            //给子线程5秒的时间打印 变量isC1,isC2,isC3的值
			System.out.println("1"+future.get(5, TimeUnit.SECONDS));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			System.out.println("超时啦");
			
		}finally{
			df.cancel();
			future.cancel(true);
		}
	}

	
}
