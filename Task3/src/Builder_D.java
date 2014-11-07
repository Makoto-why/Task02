/**
 * Created by 浩阳 on 2014/11/7.
 */
public class Builder_D implements Builder {
    public void buildCase(int Case){
        System.out.println(Case);
        switch (Case) {
            case 1:
                System.out.println("Case-L");
                System.out.println("Monitor:DELL-L");
                break;
            case 2:
                System.out.println("Case-M");
                System.out.println("Monitor:DELL-M");
                break;
            case 3:
                System.out.println("Case-H");
                System.out.println("Monitor:DELL-H");
                break;
            default:
                System.out.println("Wrong input!");
        }
    }
}
