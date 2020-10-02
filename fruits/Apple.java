package app;

public class Apple extends Fruit {
    public int count;
    public Apple(int aCount){
        this.count=aCount;
    }
    @Override
    public float getWeight() {
        return 1.0f*count;
    }
}
