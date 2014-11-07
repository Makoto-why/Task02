/**
 * Created by 浩阳 on 2014/11/6.
 */
import java.util.Scanner;

public class ConcreteComponent implements Component {
    public static String string;
    public void operation()
    {
        System.out.println("Please input some words and I'm going to turn it to capital letters");
        Scanner scan = new Scanner(System.in);
        string = scan.next();
    }
}
