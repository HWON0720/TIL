import java.util.ArrayList;
import java.util.List;

public class CollectionLoopExample {
    public static void main(String[] args) {
        List<String> foods = new ArrayList<>();
//        Set<String> foods = new HashSet<>();  // 중복값 없는 경우, Set도 사용 가능

        foods.add("치킨");
        foods.add("피자");
        foods.add("고구마 말랭이");

        for (String food : foods) {
            System.out.println(food + " 맛있어요.");
        }

        // 목록이 비었는지 확인
//        if (foods.isEmpty()) {    // 내용이 비어있는지 여부 확인은 isEmpty 사용 가능
        if (foods.size() == 0) {   // size() : List나 Set이 가지고 있는 요소의 개수를 반환하는 메서드
            System.out.println("목록이 있습니다.");
        } else {
            System.out.println("총 " + foods.size() + "개의 음식 목록이 있습니다.");
        }
    }
}
