package wumpusGame;

import java.util.Arrays;
import java.util.Scanner;

public class MoveAndSituation {
    public static int[] rooms = {0, 1, 2, 3};

    public static int[][] links = {{1, 2, 3}, {2, 3, 0}, {3, 0, 1}, {0, 1, 2}};

    public static String BAT = "Bat";
    public static String PIT = "Pit";
    public static String WUMPUS = "Wumpus";
    public static String NOTHING = "Nothing";

    public static String[] hazards = {NOTHING, BAT, PIT, WUMPUS};

    public static int currentRoom = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("지금 " + currentRoom + "번 방에 있습니다.");

            int[] nextRooms = links[currentRoom];

            System.out.println("다음 번호 중에서 이동할 방 번호를 입력해주세요.");
            System.out.println(Arrays.toString(nextRooms));

            int roomNumber = scanner.nextInt();

            move(roomNumber);
        }
    }

    /*

     */
}
