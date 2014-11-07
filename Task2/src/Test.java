/**
 * Created by 浩阳 on 2014/11/6.
 */

public class Test {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        Decorator decorator = new ConcreteDecorator(component);
        decorator.operation();
    }
}
