package corejava;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
/**
 * 不能，实际上调用的是线程的interrupt方法 中断是通过调用Thread.interrupt()方法来做的. 
 * 这个方法通过修改了被调用线程的中断状态来告知那个线程, 说它被中断了. 对于非阻塞中的线程, 只是改变了中断状态, 即Thread.isInterrupted()将返回true; 
 * 对于可取消的阻塞状态中的线程, 比如等待在这些函数上的线程, Thread.sleep(), Object.wait(), Thread.join(), 这个线程收到中断信号后, 
 * 会抛出InterruptedException, 同时会把中断状态置回为false.但调用Thread.interrupted()会对中断状态进行复位。
 * @author Administrator
 *
 */
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
					System.out.println("child isInterrupted after InterruptedException:"+Thread.currentThread().isInterrupted());
					/**
					 * 貌似虽然在主线程中通过future.cancel(true)来间接调用子线程的interrupt来改变线程状态，但是当子线程中有类似sleep方法时捕获到线程中断状态会重置子线程状态为未中断
					 * ，故在此处需再次修改线程状态为中断状态?
					 */
					Thread.currentThread().interrupt();
					System.out.println("child isInterrupted after interrupt():"+Thread.currentThread().isInterrupted());
				}
	            i++;  
	        }
			return i;  
		}  
	      
	}  
