import java.util.Scanner;

public class turtle {

    private static final int SIZE = 5;
    private static char[][] map = new char[SIZE][SIZE];

    private static int curX, curY;
    private static int currentDir = 0;

    private static final char[] ICONS = {'^', '>', 'v', '<'};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        setupGame();

        System.out.println("- Команда для черепахи -");
        System.out.println("Доступно: move, turn left, turn right, print, quit");
        showMap();

        while (true) {
            System.out.print("Напишите команду: ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("quit")) {
                System.out.println("Выход из игры...");
                break;
            }

            handleAction(input);
        }
    }

    private static void setupGame() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = '.';
            }
        }

        curX = (int) (Math.random() * SIZE);
        curY = (int) (Math.random() * SIZE);
        currentDir = 0;
        refreshTurtle();
    }

    private static void handleAction(String cmd) {
        switch (cmd) {
            case "move":
                stepForward();
                break;
            case "turn left":
                rotate(-1);
                break;
            case "turn right":
                rotate(1);
                break;
            case "print":
                showMap();
                break;
            default:
                System.out.println("Команда не распознана.");
                return;
        }
        if (!cmd.equals("print")) showMap();
    }

    private static void stepForward() {
        map[curY][curX] = '.';

        int nextX = curX;
        int nextY = curY;

        switch (currentDir) {
            case 0 -> nextY--;
            case 1 -> nextX++;
            case 2 -> nextY++;
            case 3 -> nextX--;
        }

        if (nextX >= 0 && nextX < SIZE && nextY >= 0 && nextY < SIZE) {
            curX = nextX;
            curY = nextY;
        } else {
            System.out.println("Впереди препятствие (край поля)!");
        }

        refreshTurtle();
    }

    private static void rotate(int side) {
        currentDir = (currentDir + side + 4) % 4;
        refreshTurtle();
    }

    private static void refreshTurtle() {
        map[curY][curX] = ICONS[currentDir];
    }

    private static void showMap() {
        System.out.println("---------");
        for (char[] row : map) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}