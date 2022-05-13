import java.util.HashSet;
import java.util.Set;

public class SetExample {
    public static void main(String[] args) {
        // Set의 경우, 중복 값을 허용하지 않는다는 점 외에는 List와 유사
        Set<String> myFavoriteFoods = new HashSet<>();

        myFavoriteFoods.add("치킨");
        myFavoriteFoods.add("피자");
        myFavoriteFoods.add("치킨");

        // 중복된 값 제거 시, 애초에 중복을 허용하지 않았으므로 입력된 값이 삭제된다
        myFavoriteFoods.remove("치킨");

        System.out.println(myFavoriteFoods);
    }
}
