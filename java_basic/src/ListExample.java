import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        // 리스트 값 추가
        list.add("치킨");
        list.add("피자");
        list.add("치킨");

        // 리스트 값 제거
//        list.remove("치킨");  // 첫번째 방법
        list.remove(0); // 두번째 방법

        // 리스트 값 변경
        list.set(1, "햄버거");

        System.out.println(list);

        // 리스트에서 요소 1개만 가져오기
        System.out.println(list.get(0));

        // 리스트에 특정 값이 있는지 확인
        boolean containsBurger = list.contains("햄버거");
        System.out.println(containsBurger);

        // 배열을 리스트로 전환하는 경우, asList() 사용
        List<String> names = Arrays.asList("정동원", "장민호", "임영웅", "이찬원");
        System.out.println(names);
    }
}
