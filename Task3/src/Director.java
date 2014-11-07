/**
 * Created by 浩阳 on 2014/11/7.
 */
public class Director {
    private Builder builder;

    public Director(Builder builder){
        this.builder = builder;
    }
    public void construct(int Case){

        builder.buildCase(Case);
    }
}
