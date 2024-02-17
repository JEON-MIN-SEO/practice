class par {
    public String toString() { return "parents"; }
}

class ch {
    public String toString() { return "child"; }
}

class buyer {
    void buy(par p){
        System.out.println(p + "을/를 구입하셨습니다.");
    }
    
}

public class tete {
    public static void main(String[] args) {
        buyer b = new buyer();

        
        b.buy();
        System.out.println(b);
    }
}
