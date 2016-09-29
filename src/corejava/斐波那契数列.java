package corejava;


/**
 * Created by Administrator on 2016/8/17.
 */
public class 斐波那契数列 {

    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        System.out.println(getFibonacci_0(400));//55
        long t2 = System.currentTimeMillis();
        System.out.println("用时："+(t2-t1));
        System.out.println(getFibonacci_1(40));
        long t3 = System.currentTimeMillis();
        System.out.println("用时："+(t3-t2));
    }

    private static int  getFibonacci_0(int n){
        if(n==0){
            return 0;
        }else if(n == 1){
            return 1;
        }else {
            return getFibonacci_0(n-1)+getFibonacci_0(n-2);
        }
    }


    private static int getFibonacci_1(int n){
        if(n==0){
            return 0;
        }else if(n == 1){
            return 1;
        }
        int fibOne = 0;
        int fibTwo = 1;
        int fibN = 0;
        for(int i = 2 ; i <= n ; ++i){
            fibN = fibOne + fibTwo;
            fibOne = fibTwo;
            fibTwo = fibN;
        }
        return fibN;
    }

}
