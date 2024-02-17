abstract class Human{
   //Overridden Method
   abstract public void walk();
}

interface waik1 {
    void walk();
}

class Demo extends Human implements waik1{
   //Overriding Method
   public void walk(){
       System.out.println("Boy walks");
   }
}
public class waik {
public static void main( String args[]) {
       Demo d = new Demo();
       d.walk();
   }
}