package corejava;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2016/8/17.
 */
public class PatternDemo {

    public static void main(String[] args) {
        String reg = "([a-z]+)(\\d+)";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher= pattern.matcher("aaa2223bb");
        System.out.println(matcher.find());
        System.out.println(matcher.groupCount());
        System.out.println(matcher.start());
        System.out.println(matcher.start(1));
        System.out.println(matcher.start(2));
        System.out.println(matcher.end());
        System.out.println(matcher.end(1));
        System.out.println(matcher.end(2));
        System.out.println(matcher.group());

        matcher.reset();
        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }

}
