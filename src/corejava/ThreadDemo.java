package corejava;

public class ThreadDemo {

	private int n;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadDemo demo = new ThreadDemo();
		demo.run();
	}
	
	public void run(){
		new AddTread().start();
		new SubTread().start();
		new PrintTread().start();
	}

	/**
	 * +1线程
	 * 
	 * @author Administrator
	 *
	 */
	class AddTread extends Thread {

		@Override
		public void run() {
			// TODO Auto-generated method stub

			while (true) {
				++n;
				System.out.println("执行加一操作");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	/**
	 * -1线程
	 * 
	 * @author Administrator
	 *
	 */
	class SubTread extends Thread {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (true) {
				--n;
				System.out.println("执行减一操作");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 打印线程
	 * 
	 * @author Administrator
	 *
	 */
	class PrintTread extends Thread {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (true) {
				System.out.println("n="+n);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
