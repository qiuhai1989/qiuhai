package concurrent.demo2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Future01 {
	 public static void main(String[] args) {  
	        ExecutorService eService = Executors.newFixedThreadPool(5);  
	        Future<?> future= eService.submit(new RunFuture());  
	        try {  
	            Thread.sleep(1000);  
	            System.out.println("future取消结果："+future.cancel(true));  
	            System.out.println("haha---------------"); 
	            System.out.println("++++"+future.isCancelled());
	            eService.shutdown();
	        } catch (InterruptedException e) {  
	            // TODO Auto-generated catch block  
	            e.printStackTrace();  
	        }  
	  
	    }  
	      
	      
	  
	}  
	class RunFuture implements Callable{  
	    int i=0;  
		@Override
		public Object call() {
	        while (i<50&&!Thread.currentThread().isInterrupted()) { 
	        	System.out.println("i++:"+i); 
	        	System.out.println("child isInterrupted:"+Thread.currentThread().isInterrupted());
	        	try {
					TimeUnit.MILLISECONDS.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					System.out.println("捕获异常");
					/**
					 * 貌似虽然在主线程中通过future.cancel(true)来间接调用子线程的interrupt来改变线程状态，但是当子线程中有类似sleep方法时捕获到线程中断状态会重置子线程状态为未中断
					 * ，故在此处需再次修改线程状态为中断状态?
					 * sleep方法抛出这个异常之后会清除中断状态，所以需要重新设置中断状态
					 */
					Thread.currentThread().interrupt();
				}
	            i++;  
	        }
			return i;  
		}  
	      
	}  
