import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class myFirstMiniProject_V1 {
    public static void main(String[] args) {
        String[] name = {"名前１", "名前2", "名前3", "名前4", "名前5", "名前6", "名前7"};

        String firstPickMember = firstPick(name);
        System.out.println("当籤" + firstPickMember);

        List<String> remainMember = new ArrayList<>(Arrays.asList(name));
        remainMember.remove(firstPickMember);

        System.out.println("残り" + remainMember);

        Scanner scanner = new Scanner(System.in);
        System.out.print("除外したいメンバーを選んでください: ");
        int excludeIndex = scanner.nextInt();

        excludeMember(remainMember, excludeIndex);

        List<String> secondPicks = pick(remainMember);
        System.out.println(secondPicks);
        System.out.println("残り" + remainMember);

        List<String> thirdPicks = pick(remainMember);
        System.out.println(thirdPicks);
        System.out.println("残り" + remainMember);
    }

    private static String firstPick(String[] name) {
        int lobbyWork = (int)(Math.random() * name.length);
        return name[lobbyWork];
    }

    private static List<String> pick(List<String> remainMember) {
        Random r = new Random();
        List<String> pickedMembers = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            int index = r.nextInt(remainMember.size());
            pickedMembers.add(remainMember.get(index));
            remainMember.remove(index);
        }
        return pickedMembers;
    }

    private static void excludeMember(List<String> members, int index) {
        if (index >= 0 && index < members.size()) {
            members.remove(index);
        } else {
            System.out.println("無効なインデックスです");
        }
    }
}
