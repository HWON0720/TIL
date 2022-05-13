import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ListExample02 {
    public static void main(String[] args) {
        System.out.println("저장할 음식 이름 입력. (종료: 0)");
        List<String> foods = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String food = scanner.nextLine();

            if (food.equals("0")) {
                break;
            }

            if (foods.contains(food)) {
                System.out.println("이미 목록에 있습니다.");
            } else {
                foods.add(food);
            }
        }

        // 리스트 정렬하기
        Collections.sort(foods);    // 오름차순(ㄱ, ㄴ, ㄷ) 정렬
        Collections.reverse(foods);    // 내림차순 정렬
        Collections.shuffle(foods); // 랜덤하게 섞기

        System.out.println(foods);
    }
}
