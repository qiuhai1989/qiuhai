package corejava;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * Created by Administrator on 2016/8/17.
 */
public class 生成图片 {

    // 验证码字符集
    private static final char[] chars = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
            'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    // 字符数量
    private static final int SIZE = 4;
    // 干扰线数量
    private static final int LINES = 5;
    // 宽度
    private static final int WIDTH = 80;
    // 高度
    private static final int HEIGHT = 40;
    // 字体大小
    private static final int FONT_SIZE = 30;

    public static Object[] createImage(){
        StringBuffer sb = new StringBuffer();
        //1、创建空白图片
        BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
        //2、获取图片画笔
        Graphics graphic = image.getGraphics();
        //3、设置画笔颜色
        graphic.setColor(Color.LIGHT_GRAY);
        //4、绘制句型背景
        graphic.fillRect(0,0,WIDTH,HEIGHT);
        //5、画随机字符
        Random random = new Random();
        for(int i=0;i<SIZE;i++){
            //取随机字符索引
            int n = random.nextInt(chars.length);
            //设置随机颜色
            graphic.setColor(getRandomColor());
            //设置字体大小
            graphic.setFont(new Font(null, Font.BOLD + Font.ITALIC,FONT_SIZE));
            //画字符
            graphic.drawString(chars[n]+"",i*WIDTH/SIZE,HEIGHT/2);
            //记录字符
            sb.append(chars[n]);

        }
        //6、画干扰线
        for(int i=0;i<LINES;i++){
            //设置随机颜色
            graphic.setColor(getRandomColor());
            //随机画线
            graphic.drawLine(random.nextInt(WIDTH),random.nextInt(HEIGHT),random.nextInt(WIDTH),random.nextInt(HEIGHT));
        }
        //7、返回验证码和图片
        return new Object[]{sb.toString(),image};
    }

    public static Color getRandomColor(){
        Random ran = new Random();
        Color color = new Color(ran.nextInt(255),ran.nextInt(255),ran.nextInt(255));
        return color;
    }

    public static void main(String[] args) throws IOException {
        Object[]objects = createImage();
        BufferedImage image = (BufferedImage) objects[1];
        //图片格式可以自定义，java对png图片显示更清楚，输出路径可自定义
        OutputStream os = new FileOutputStream("d:/x.png");
        //注意图片格式与创建格式匹配
        ImageIO.write(image,"png",os);
        os.close();
    }

}
