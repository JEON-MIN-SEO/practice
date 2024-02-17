public class pre {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.r=30;
        System.out.println(circle.r);
        System.out.println(circle.x);
        System.out.println(circle.z);

    }   
}

class Circle extends Point{
    acc a = new acc();
    int z;
    int x =10;
    int y= 20;
    int r;
    aot();
    acc.sot();
}

class Point{
    int x;
    int y;

    void aot(){
         System.out.println("aaa");
    }
}

class acc{
    int z;

    void sot(){
        System.out.println("aa");
    }
}