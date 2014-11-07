/**
 * Created by 浩阳 on 2014/11/5.
 */
public class Invoker {
    private Command command = null;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void runCommand() {
        command.execute();
    }
}