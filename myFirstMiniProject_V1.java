//import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class myFirstMiniProject_V1 {
    public static void main(String[] args) {
        String[] name = {"名前１", "名前2", "名前3", "名前4", "名前5", "名前6", "名前7"};

        String firstPickMember = firstPick(name);
        
        System.out.println("当籤" + firstPickMember);

        List<String> remainMember = new ArrayList<>();
    }

    private static String firstPick(String[] name) {
        int lobbyWork = (int)(Math.random() * name.length);
        return name[lobbyWork];
    }

}