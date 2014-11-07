/**
 * Created by 浩阳 on 2014/11/6.
 */
public class Decorator implements Component{
    public Decorator(Component component)
    {
        this.component = component;
    }

    public void operation()
    {
        component.operation();
    }

    private Component component;
}
