abstract class Unit2{
    int x,y;
    abstract void move(int x, int y);
    void stop() {System.out.println("멈춥니다 ");}
    Fightable getFightable(){
        Fight f = new Fight();
        return f;
    }
}

interface Fightable { //인터페이스의 모든 메서드는 public abstract가 생략되어있음 (예외 없음)
    public void move(int x, int y); //public abstract 생략
    public void attack(Fightable f); 
}

class Fight extends Unit2 implements Fightable{
    public void move(int x, int y){
        System.out.println(x+","+y);
    }
    public void attack(Fightable f){
        System.out.println(f+"를 공격합니다.");
    }
    Fightable getFightable(){
        Fight f = new Fight();
        return f;
    }
    
}   

public class Ex7_1 {
    public static void main(String[] args) {
        Fight f = new Fight();
        f.move(1, 2);
    }
}
