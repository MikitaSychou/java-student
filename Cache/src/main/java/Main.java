
class A {
    int name;

    public A(int name) {
        this.name = name;
    }

    void name() {
        System.out.println("Hello");
    }
}


public class Main {


    String b = "5";

    public static void main(String[] args) {
            // todo
        Integer a = 200;
        Integer b = 200;
        b = null;
        System.out.println(b);
    }

    public void print() {
        A  a  = new A(5);
        a.name = 6;

        a.name();
    }

}
