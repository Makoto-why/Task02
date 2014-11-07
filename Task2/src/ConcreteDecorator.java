/**
 * Created by 浩阳 on 2014/11/6.
 */
/**
 * 添加附加责任
 * @author gjy
 */
public class ConcreteDecorator extends Decorator {

    public ConcreteDecorator(Component component) {
        super(component);
    }

    public void operation() {
        super.operation();
        String Upstr = ConcreteComponent.string.toUpperCase();
        System.out.println(Upstr);
    }
}