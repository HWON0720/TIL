package wumpusGame;

import java.util.Arrays;
import java.util.Scanner;

public class RoomsInCave {
    public static void main(String[] args) {
        int[] rooms = {0, 1, 2, 3}; // 4개의 방

        int[][] links = {{1, 2, 3}, {2, 3, 0}, {3, 0, 1}, {0, 1, 2}};   // 4개의 방 모두가 각각 이어진 3개의 통로. {0번 방 기준 3개 통로를 통해 이어진 방 1, 2, 3}, {1번 방 기준}, ...

        int currentRoom = 0;    // 현재 몇 번 방에 위치해 있는지를 표기할 변수 초기값 = 0 설정

        Scanner scanner = new Scanner(System.in);

        // 현재 위치에서 이동할 수 있는 방들 목록 조회 후, 방 번호 입력 받고, 입력 받은 번호의 방으로 이동하기
        while (true) {
            System.out.println("지금 " + currentRoom + "번 방에 있습니다.");
            System.out.println("다음 번호 중에서 이동할 방 번호를 입력해주세요.");

            System.out.println(Arrays.toString(links[currentRoom]));    // 현재 방에서 이동해 갈 수 있는 방들의 목록 출력. currentRoom = 0 기준, links의 0번째 값인 {1, 2, 3}

            int roomNumber = scanner.nextInt(); // 사용자로부터 정수 입력 받기

            currentRoom = roomNumber;   // currentRoom의 값을 입력받은 정수로 변경
        }
    }
}
