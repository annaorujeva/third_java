package app;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit>{
    ArrayList<T> box = new ArrayList<>();

    public Box(T...fruits){
        box = new ArrayList<>(Arrays.asList(fruits));
    }

    public ArrayList<T> getBox(){
        return box;
    }

    public void addFruit(T fruit){
        box.add(fruit);
    }

    public double getWeight(){
        double totalw = 0.0d;
        for (T i: box){
            totalw+=i.getWeight();
        }
        return totalw;
    }
    //Внутри класса Box сделать метод Compare, который позволяет сравнить текущую коробку с той, которую подадут в Compare в качестве параметра.

    public boolean Compare(Box boxwithsmth){
        if (this.getWeight() == boxwithsmth.getWeight()){
            return true;
        }
        return false;
    }
    //Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
    //Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
    //Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;
    public void replacefruit(Box<T> anotherbox){
        anotherbox.box.addAll(this.box);
        this.box.clear();
    }


}
