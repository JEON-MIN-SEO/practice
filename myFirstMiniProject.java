//import java.util.Random;

public class myFirstMiniProject {
    public static void main(String[] args) {
        String[] name = {"名前１", "名前2", "名前3", "名前4", "名前5", "名前6", "名前7"};

        String selectName = pickName(name);

        System.out.println("当籤" + selectName);
    }

    private static String pickName(String[] name) {
        int randomIndex = (int)(Math.random() * name.length);
        // Random random = new Random();
        // int randomIndex = random.nextInt(name.length);
        return name[randomIndex];
    }
}