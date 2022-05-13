import java.util.*;

public class MapExample {
    public static void main(String[] args) {
        Map<String, String> dictionary = new HashMap<>();

        // 값 입력
        dictionary.put("chicken", "닭");
        dictionary.put("hippo", "하마");

        System.out.println(dictionary.size() + " 개의 단어가 있습니다.");

        System.out.println(dictionary);

        // 값 가져오기
        System.out.println(dictionary.get("chicken"));

        // 값 제거하기
        dictionary.remove("chicken");

        // 한-영 사전 기능 구현
//        Scanner scanner = new Scanner(System.in);
//
//        String english = scanner.nextLine();
//        String korean = dictionary.get(english);    // 사용자가 입력한 단어(english)를 "키"로 사용해, 한글 단어 가져오기
//
//        if (korean == null) {
//            System.out.println("사전에 존재하지 않는 단어입니다.");
//        } else {
//            System.out.println(english + "는 " + korean + "입니다. ");
//        }

        // 값이 비어있는지 확인 후, 상황에 따라 다른 메시지 출력하기
        if (dictionary.isEmpty()) {
            System.out.println("단어가 하나도 없습니다");
            System.exit(0);
        } else {
            System.out.println(dictionary.size() + " 개의 단어가 있습니다.");
        }

        // 반복문을 사용한 Map 예제
        // dictionary.keySet()  // key의 목록만 가져가는 방법
        // dictionary.values()  // 값의 목록만 가져가는 방법

        // key를 통해 값 가져오기
        Collection<String> keys = dictionary.keySet();

        for (String english : keys) {
            System.out.println(english);

            // 한글 단어 출력
            String korean = dictionary.get(english);
            System.out.println(korean);
        }

        // 값을 통해 가져오기
        Collection<String> values = dictionary.values();

        for (String korean : values) {
            System.out.println(korean);
        }

        // entrySet()을 통해 키-값 쌍 하나를 가져오기
        Set<Map.Entry<String, String>> entries = dictionary.entrySet();

        for (Map.Entry<String, String> entry : entries) {
            String english = entry.getKey();
            String korean = entry.getValue();

            System.out.println(english + ": " + korean);
        }
    }
}
