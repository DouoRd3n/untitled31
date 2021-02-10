import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedListTest<String> listTest = new LinkedListTest<>();
        listTest.add("sdfsdf");
        listTest.add("345345345");
        listTest.add("fdgdgdfg");
        listTest.add(1, "fgdfgdfgd");
        System.out.println(listTest.get(2));
listTest.remove(2);
        System.out.println(listTest.get(2));

    }
}
