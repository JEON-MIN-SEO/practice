import java.util.Random;
import java.util.Scanner;

public class TurnBasedGameWithCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 초기 병력 설정
        int initialForces = 300;
        int[] forcesA = new int[3];
        int[] forcesB = new int[3];
        int[] cardsA = new int[3];  // 0: 공격, 1: 방어
        int[] cardsB = new int[3];  // 0: 공격, 1: 방어

        // 플레이어 A의 초기 배치와 카드 배치
        System.out.println("플레이어 A의 차례");
        distributeForcesAndCards(forcesA, cardsA, scanner);

        // 플레이어 B의 초기 배치와 카드 배치
        System.out.println("플레이어 B의 차례");
        distributeForcesAndCards(forcesB, cardsB, scanner);

        // 게임 루프
        while (true) {
            // 플레이어 A의 차례
            System.out.println("플레이어 A의 차례");
            playTurn(forcesA, forcesB, cardsA, scanner);

            // 플레이어 B의 차례
            System.out.println("플레이어 B의 차례");
            playTurn(forcesB, forcesA, cardsB, scanner);

            // 전투 후 각 전선의 병력 출력
            printForces(forcesA, forcesB);

            // 패배 조건 확인
            if (checkDefeat(forcesA) || checkDefeat(forcesB)) {
                System.out.println("게임 종료!");
                break;
            }
        }

        scanner.close();
    }

    // 전선 병력과 카드 배치 메서드
    private static void distributeForcesAndCards(int[] forces, int[] cards, Scanner scanner) {
        while (true) {
            int totalForces = 0;
            for (int i = 0; i < forces.length; i++) {
                System.out.print("전선 " + (i + 1) + "에 배치할 병력 수 입력: ");
                int inputForces = scanner.nextInt();
                forces[i] = inputForces;
                totalForces += inputForces;
            }

            if (totalForces >= 300) {
                break;
            } else {
                System.out.println("전체 병력이 300명 이상이어야 합니다. 다시 입력해주세요.");
            }
        }

        for (int i = 0; i < cards.length; i++) {
            System.out.print("전선 " + (i + 1) + "에 배치할 카드 선택 (0: 공격, 1: 방어): ");
            cards[i] = scanner.nextInt();
        }
    }

    // 턴 진행 메서드
    private static void playTurn(int[] attackingForces, int[] defendingForces, int[] cards, Scanner scanner) {
        Random random = new Random();

        for (int i = 0; i < attackingForces.length; i++) {
            // 전투 진행
            System.out.println("전선 " + (i + 1) + " 전투 시작!");

            // 공격과 방어의 확률 조건
            if (cards[i] == 0) { // 공격 카드
                if (random.nextDouble() < 0.5) { // 50% 확률
                    int damage = calculateDamage(attackingForces[i], defendingForces[i]);
                    defendingForces[i] -= damage;
                    System.out.println("전투에서 " + damage + "명의 병력을 감소시켰습니다.");
                } else {
                    System.out.println("공격 카드로 아무런 효과가 없습니다.");
                }
            } else { // 방어 카드
                if (random.nextDouble() < 0.6) { // 60% 확률 (방어의 우위)
                    int damage = calculateDamage(defendingForces[i], attackingForces[i]);
                    attackingForces[i] -= damage;
                    System.out.println("방어에서 " + damage + "명의 병력을 감소시켰습니다.");
                } else {
                    System.out.println("방어 카드로 아무런 효과가 없습니다.");
                }
            }
        }
    }

    // 전투에서 입히는 데미지 계산 메서드
    private static int calculateDamage(int attackingForces, int defendingForces) {
        // 병력이 동일한 경우 50%의 확률로 승패 결정
        if (attackingForces == defendingForces) {
            return (Math.random() < 0.5) ? (int) (0.2 * attackingForces) : (int) (0.4 * defendingForces);
        }

        // 공격과 방어의 차이에 따라 데미지 계산
        int difference = Math.abs(attackingForces - defendingForces);
        double winProbability = (attackingForces > defendingForces) ? 0.6 : 0.4;
        return (int) (difference * winProbability);
    }

    // 전선 병력 출력 메서드
    private static void printForces(int[] forcesA, int[] forcesB) {
        System.out.println("플레이어 A: " + java.util.Arrays.toString(forcesA));
        System.out.println("플레이어 B: " + java.util.Arrays.toString(forcesB));
    }

    // 패배 조건 확인 메서드
    private static boolean checkDefeat(int[] forces) {
        for (int force : forces) {
            if (force <= 30) {
                System.out.println("병력이 30명 이하인 전선이 있어 패배했습니다.");
                return true;
            }
        }
        return false;
    }
}
