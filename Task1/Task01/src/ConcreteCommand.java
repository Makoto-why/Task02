/**
 * Created by 浩阳 on 2014/11/5.
 */
public class ConcreteCommand implements Command {

    private Receiver receiver = null;
    private String state;

    public ConcreteCommand(Receiver receiver){
        this.receiver = receiver;
    }
    public void execute() {
        receiver.action();
    }
}