package wumpusGame;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class HazardInRooms {

    public static void main(String[] args) {
        int[] rooms = {0, 1, 2, 3};

        String BAT = "Bat";
        String PIT = "Pit";
        String WUMPUS = "Wumpus";
        String NOTHING = "Nothing";

        String[] hazards = {NOTHING, BAT, PIT, WUMPUS}; // 각 방에 배치된 위험요소를 표현하기 위해, 방과 동일한 크기의 배열 필요 {4개}

        HashMap<String, String> hazardMessages = new HashMap<>();

        hazardMessages.put(WUMPUS, "\"어디선가 끔찍한 냄새가 난다.\"");
        hazardMessages.put(BAT, "\"어디선가 부스럭거리는 소리가 들린다.\"");
        hazardMessages.put(PIT, "\"바람이 부는 소리가 들리는 것 같다.\"");
        hazardMessages.put(NOTHING, "\"저 방에는 아무것도 없는 것 같다.\"");

        int[][] links = {{1, 2, 3}, {2, 3, 0}, {3, 0, 1}, {0, 1, 2}};

        int currentRoom = 0;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("지금 " + currentRoom + "번 방에 있습니다.");

            // 현재 방에서 갈 수 있는 방들의 목록
            int[] nextRooms = links[currentRoom];

            // 반복문을 통해 연결된 방들을 순회
            for (int nextRoom : nextRooms) {
                //방 번호에 해당하는 위험요소 가져오기
                String hazard = hazards[nextRoom];
                // 위험요소에 해당하는 대사 가져오기
                String message = hazardMessages.get(hazard);
                // 대사 출력
                System.out.println(message);
            }

            System.out.println("다음 번호 중에서 이동할 방 번호를 입력해주세요.");
            System.out.println(Arrays.toString(nextRooms));

            int roomNumber = scanner.nextInt();

            currentRoom = roomNumber;
        }
    }
}
