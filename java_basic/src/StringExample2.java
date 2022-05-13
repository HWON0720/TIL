public class StringExample2 {
    public static void main(String[] args) {
        String chicken = "치킨은 살 안 쪄요.";
        String me = "살은 내가 쪄요.";

        System.out.println(chicken);
        System.out.println(me);

//      <문자열 연결하기>
        String chickenAndMe = chicken + me;
        System.out.println(chickenAndMe);

//      <문자열의 글자 수 세기>
//        System.out.println(chickenAndMe.length());    // 방법 1
        int length = chickenAndMe.length(); // 방법 2
        System.out.println(length);

//      <문자열 일부 바꾸기>
//        System.out.println(me.replaceAll("내가", "치킨이")); // 방법 1
        String replaced = me.replaceAll("내가", "치킨이");   // 방법 2
        System.out.println(replaced);

//      <문자열 자르기> : stringName.substring(시작위치, 끝위치(미포함));
        String birthday = "1970/01/01";
        String year = birthday.substring(0, 4);
        String day = birthday.substring(8);
        System.out.println(year);
        System.out.println(day);
    }
}
