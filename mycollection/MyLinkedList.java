package app;
/*Создать собственную типизированную коллекцию с методами:
- int size() – возвращает размер коллекции +
- void add(E item) – добавить элемент в коллекцию +
- void remove(int index) – удаляет элемент по индексу -
- void remove(E item) – удаляет элемент
- E get(int index) – получение элемента по индексу +
- void clear() – очищает коллекцию +
Необходимо создать реализацию на основе связанного списка*/
public class MyLinkedList {
    int count;
    private StringNode head;

    public MyLinkedList() {
        this.head = null;
        count = 0;
    }

    public void remove(MyLinkedList list, String item){
        StringNode remnode = list.head, prev = null;
        if(remnode!=null && remnode.value==item){
            list.head=remnode.next;
                count--;
        }
        else {
            while(remnode.next!=null && remnode.value!=item){
                prev = remnode;
                remnode = remnode.next;
            }
            if (remnode!=null){
                prev.next = remnode.next;
            }
                count--;
        }
        if (remnode==null){
            System.out.println("Нельзя удалить несуществующий в списке элемент");
        }

    }

    public void remove (MyLinkedList list, int index){
        StringNode remnode, prev = null;
        remnode = list.head;
        if (index<size(list)){
            if (index==0){
                list.head=remnode.next;
                count--;
            }
            else{
                for(int i=0;i!=index;i++) {
                    if (remnode.next != null) {
                        prev = remnode;
                        remnode = remnode.next;
                    }
                }
                if (remnode!=null){
                    prev.next = remnode.next;
                }
                count--;
            }

        }
        else{
            System.out.println("Нельзя удалить несуществующий в списке элемент");
        }
    }

    public void add(MyLinkedList list, String item) {
        StringNode new_node = new StringNode(item);
        new_node.next = null;
        if (list.head == null) {  //если связанный список пустой, то новый узел будет головой
            list.head = new_node;
        } else {
            StringNode last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_node;
        }
        count++;
    }

    public StringNode get(MyLinkedList list, int index) {
        StringNode node;
        if (index <= size(list)) {
            node = list.head;
            for (int i = 0; i != index; i++) {
                node = node.next;
            }
            return node;
        } else {
            System.out.println("Элемент не существует");
            return null;
        }
    }

    public int size(MyLinkedList list) {
        return count;
    }

    public void clear(MyLinkedList list) {
        StringNode node = list.head;
        for (int i=0; i<size(list);i++) {
            node.value = null;
            node = node.next;
        }
        count = 0;
    }

    public void printList(MyLinkedList list) {
        StringNode currNode = list.head;
        System.out.println("LinkedList: ");
        while (currNode != null) {
            System.out.println(currNode.value + " ");
            currNode = currNode.next;
        }
    }

    public static void main(String[] args) {
        MyLinkedList mylist = new MyLinkedList();
        mylist.add(mylist, "Anna1");
        mylist.add(mylist, "Anna2");
        mylist.add(mylist, "Anna3");
        System.out.println(" ----- Creating ----- ");
        mylist.printList(mylist);
        /*System.out.println(" ------ Remove item ------ ");
        mylist.remove(mylist,"Anna3");
        mylist.printList(mylist);*/
        System.out.println(" ------ Remove index ------ ");
        mylist.remove(mylist,2);
        mylist.printList(mylist);
        mylist.clear(mylist);
        System.out.println(" ----- Clear ----- ");
        mylist.printList(mylist);
        System.out.println("----- Count: " + mylist.count +" -----");
    }
}
