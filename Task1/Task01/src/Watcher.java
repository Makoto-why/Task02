import java.util.Observable;
import java.util.Observer;

/**
 * Created by 浩阳 on 2014/11/6.
 */
public class Watcher implements Observer {
    public void update(Observable observable, Object o) {
        System.out.println("现在Unix时间是：" + ((Watched) observable).getTime());
    }
    public Watcher(Observable observable){
        observable.addObserver(this);
    }

}

