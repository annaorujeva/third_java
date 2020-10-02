package app;

public class Orange extends Fruit{
    public int count;
    public Orange(int aCount){
        this.count=aCount;
    }

    @Override
    public float getWeight() {
        return 1.5f*count;
    }
}
