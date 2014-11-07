import java.util.*;

/**
 * Created by 浩阳 on 2014/11/5.
 */
public class Receiver {
    private int i;
    private Timer timer;
    public void action() {
         System.out.println("Please choose what you want to do: 1.start ; 2.quit");
         Scanner input =new Scanner(System.in);
         i  = input.nextInt();
         System.out.println("Please decide the time");
         Calendar calendar = Calendar.getInstance();
         int year = input.nextInt();
         int mon =input.nextInt();
         int day = input.nextInt();
         int hour = input.nextInt();
         int min  = input.nextInt();
         int sec = input.nextInt();
         calendar.set(year, mon-1,day,hour, min, sec);
         Date date = calendar.getTime();
         timer = new Timer();
         timer.schedule(new task(), date);

     }
    class task extends java.util.TimerTask {
        public void run() {
            switch(i) {
                case 1:
                    System.out.println("start");
                    timer.cancel();
                    break;
                case 2:
                    System.out.println("quit");
                    timer.cancel();
                    break;
            }
        }
    }
}
