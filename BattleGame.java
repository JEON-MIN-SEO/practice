import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BattleGame {
    private static final int WIDTH = 5;
    private static final int HEIGHT = 5;

    private static String[][] map = new String[WIDTH][HEIGHT];
    private static Player playerA = new Player("A");
    private static Player playerB = new Player("B");
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeGame();

        while (true) {
            playTurn(playerA, playerB);
            printMap();

            playTurn(playerB, playerA);
            printMap();
        }
    }

    private static void initializeGame() {
        // 초기화: 빈 공간으로 설정
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                map[i][j] = "[ ]";
            }
        }

        // 플레이어의 유닛 초기 위치 설정
        initializePlayerUnits(playerA);
        initializePlayerUnits(playerB);

        // 지도 출력
        printMap();
    }

    private static void initializePlayerUnits(Player player) {
        for (int i = 0; i < 5; i++) {
            int x = (int) (Math.random() * WIDTH);
            int y = (int) (Math.random() * HEIGHT);

            // 중복 체크
            while (!map[x][y].equals("[ ]")) {
                x = (int) (Math.random() * WIDTH);
                y = (int) (Math.random() * HEIGHT);
            }

            map[x][y] = "[" + player.getSymbol() + "]";
            player.addUnit(new Unit(x, y));
        }
    }

    private static void playTurn(Player currentPlayer, Player opponentPlayer) {
        System.out.println("Player " + currentPlayer.getName() + "'s turn:");

        // 유닛 이동
        for (Unit unit : currentPlayer.getUnits()) {
            moveUnit(unit);
        }

        // 상대 유닛 발견
        for (Unit unit : currentPlayer.getUnits()) {
            discoverOpponent(unit, opponentPlayer);
        }
    }

    private static void moveUnit(Unit unit) {
        int x = unit.getX();
        int y = unit.getY();

        // 이동 가능 여부 확인
        int newX = x + (int) (Math.random() * 3) - 1; // -1, 0, 1 중 하나
        int newY = y + (int) (Math.random() * 3) - 1; // -1, 0, 1 중 하나

        if (isValidMove(newX, newY)) {
            // 이동 전 위치 비우기
            map[x][y] = "[ ]";
            // 이동 후 위치에 유닛 표시
            map[newX][newY] = "[" + unit.getPlayer().getSymbol() + "]";
            // 유닛 위치 업데이트
            unit.setX(newX);
            unit.setY(newY);
        }
    }

    private static boolean isValidMove(int x, int y) {
        return x >= 0 && x < WIDTH && y >= 0 && y < HEIGHT && map[x][y].equals("[ ]");
    }

    private static void discoverOpponent(Unit unit, Player opponentPlayer) {
        int x = unit.getX();
        int y = unit.getY();

        // 주변 1칸 안에 있는 상대 유닛 확인
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i >= 0 && i < WIDTH && j >= 0 && j < HEIGHT) {
                    if (!map[i][j].equals("[ ]") && !map[i][j].equals("[" + unit.getPlayer().getSymbol() + "]")) {
                        System.out.println("Player " + unit.getPlayer().getName() +
                                "'s unit at (" + x + ", " + y + ") discovered enemy unit at (" + i + ", " + j + ")");
                    }
                }
            }
        }
    }

    private static void printMap() {
        for (int j = 0; j < HEIGHT; j++) {
            for (int i = 0; i < WIDTH; i++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}

class Player {
    private String name;
    private String symbol;
    private List<Unit> units;

    public Player(String name) {
        this.name = name;
        this.symbol = name.substring(0, 1);
        this.units = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public List<Unit> getUnits() {
        return units;
    }

    public void addUnit(Unit unit) {
        units.add(unit);
    }
}

class Unit {
    private int x;
    private int y;
    private Player player;

    public Unit(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
