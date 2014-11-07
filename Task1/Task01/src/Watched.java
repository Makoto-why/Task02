import java.util.Observable;
/**
 * Created by 浩阳 on 2014/11/6.
 */
public class Watched extends Observable {
    private long time;
    public  int sta;
    public void setTime(int sta) {
        if (time!= sta) {
           time = sta;
           setChanged();
        }
        notifyObservers();
    }

    public long getTime() {
        return sta;
    }
}


