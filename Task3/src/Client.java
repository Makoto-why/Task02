import java.util.Scanner;

/**
 * Created by 浩阳 on 2014/11/7.
 */
public class Client {

    public static void main(String[] args) {
        System.out.println("Please set the level and Brand");
        Scanner scanner=new Scanner(System.in);
        int Case=scanner.nextInt();
        int monitor=scanner.nextInt();
        Builder builder_s=new Builder_S();
        Builder builder_d=new Builder_D();
        if(monitor==1) {
            Builder builder = builder_d;
            Director director=new Director(builder);
            director.construct(Case);
        }
        else if(monitor==2) {
            Builder builder=builder_s;
            Director director=new Director(builder);
            director.construct(Case);
        }
    }
}