package app;
/*Создать собственную типизированную коллекцию с методами:
- int size() – возвращает размер коллекции +
- void add(E item) – добавить элемент в коллекцию +
- void remove(int index) – удаляет элемент по индексу +
- void remove(E item) – удаляет элемент +
- E get(int index) – получение элемента по индексу +
- void clear() – очищает коллекцию +
Необходимо создать реализацию на основе массива(+)*/


public class my_collection{
    public String[] items;
    int count;

    public  my_collection(int count){
        items = new String[count];
        this.count = 0;
    }

    public void add(String item){
        if (count >= items.length){
            increaseCollection();
        }
        items[count++] = item;
    }
    public void clear(){
        for (int i=0; i<items.length;i++){
            items[i] = null;
        }
        count = 0;
    }

    public void remove(String remove_item){
        int rem_index = 0;
        for (int i=0; i<items.length;i++){
            if(items[i]==remove_item){
                rem_index = i;
            }
        }
        items[rem_index] = null;
        for (int i=rem_index; i<items.length-1;i++){
            items[i] = items[i+1];
        }
        items[items.length-1]=null;
        count--;
    }
    //Две реализации, т.к. не уверена в точности формулировки задания
    public String get(int index){
        System.out.println(items[index]);
        return null;
    }
    public String get2(int index){
        return items[index];
    }

    private void increaseCollection(){
        String[] temp = new String[items.length + 2];
        System.arraycopy(items, 0, temp, 0, items.length);
        items = temp;
    }

    public int size(){
       /* int size = items.length;
        return size;*/
        return count;
    }

    public void remove(int index){
        for (int i=index; i< items.length-1;i++){
            items[i] = items[i+1];
        }
        items[items.length-1]=null;
        count--;
    }

    public void print(){
        for (String item: items) {
            System.out.println(item);
        }
    }

    public static void main(String[] args){
        my_collection mycoll = new my_collection(3);
        mycoll.add("Anna1");
        mycoll.add("Anna2");
        mycoll.add("Anna3");
        System.out.println(mycoll.size());
        mycoll.remove("Anna1");
        mycoll.print();
        System.out.println(mycoll.size());
        //String elem = mycoll.get2(1);
       // System.out.println(elem);
        /*mycoll.get(1);
        mycoll.clear();
        mycoll.print();*/
    }
}
