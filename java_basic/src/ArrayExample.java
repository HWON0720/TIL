import java.util.Arrays;

public class ArrayExample {
    public static void main(String[] args) {
        String[] days = {"월", "화", "수", "목", "금", "토", "일"};

        // 배열의 특정 위치의 요소를 가져오기
        System.out.println(days[0]);
        System.out.println(days[6]);

        // 배열 길이 알아내기
        int lengthOfDays = days.length;
        System.out.println(lengthOfDays);

        // 배열을 반복문에 사용하기
        for (int i = 0; i < days.length; i = i + 1) {
            System.out.println(days[i] + "요일");
        }

        // 배열의 특정 요소 바꾸기
        days[0] = "일";

        for (int i = 0; i < days.length; i = i + 1) {
            System.out.println(days[i] + "요일");
        }

        // for-each문 사용
        for (String day : days) {
            System.out.println(day + "요일");
        }

        // 배열에 값 추가하기
        String[] days2 = Arrays.copyOf(days, 8);

        days2[7] = "일";

        for (String s : days2) {
            System.out.println(s);
        }
    }
}
