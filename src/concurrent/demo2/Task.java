package concurrent.demo2;

import java.util.concurrent.Callable;

public class Task implements Callable {

	@Override
	public Object call() throws Exception {
		// TODO Auto-generated method stub
		while (true) {
			System.out.printf("Task: Test\n");
			Thread.sleep(100);
		}

	}

}
