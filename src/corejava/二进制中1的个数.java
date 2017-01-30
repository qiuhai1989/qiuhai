package corejava;


/**
 * Created by Administrator on 2016/8/17.
 */
public class 二进制中1的个数 {

    public static void main(String[] args) {
        int n = 5;
        int n0 = 0;
        int n1 = 1;
        int N1 = -1;
        System.out.println("0="+Integer.toBinaryString(n0));
        System.out.println("1="+Integer.toBinaryString(n1));
        System.out.println("-1="+Integer.toBinaryString(N1));
        System.out.println(Integer.toBinaryString(n));
        System.out.println(NumberOf1_1(n));
        System.out.println(NumberOf1_2(n));
        System.out.println(NumberOf1_3(n));
        System.out.println("----------------------------");
        //8进制0开头
        System.out.println(012);
        //16进制0x开头
        System.out.println(0x12);
        //jdk7开始支持二进制表示0b开头
        System.out.println(0b1011);
        System.out.println("-5="+Integer.toBinaryString(-5));
        System.out.println(-5 >> 3);// 结果是-1 0b11111111111111111111111111111111
        System.out.println(-5 >>> 3);// 结果是536870911 0b00011111111111111111111111111111
        System.out.println(-5<<3);
        System.out.println(-5*8);
        System.out.println(64/8);
        System.out.println(64>>3);

        System.out.println(~7);//相当与 取反没加1
    }

    public static int NumberOf1_1(int n){
        int count = 0;
        while(n != 0){
            if((n & 1) != 0){
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    public static int NumberOf1_2(int n){
        int count = 0;
        int flag = 1;
        while(flag > 0){
            if((n & flag) != 0){
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    public static int NumberOf1_3(int n){
        int count = 0;
        while(n != 0){
            ++count;
            n = (n - 1) & n;
        }
        return count;
    }
}
