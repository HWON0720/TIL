public class Operator {
    public static void main(String[] args) {
        System.out.println(2 + 3);
        System.out.println(5 - 2);
        System.out.println(2 * 3);
        System.out.println(6 / 3);  // 정수 / 정수의 경우, 나머지 값은 버리고 정수만 출력
        System.out.println(7 % 3);

        System.out.println((2 - 4) / 2);

        int number = 5;
        number = (int) 1.2; // 앞에 (변환할 타입) 를 추가하여 형변환 할 수 있다
        System.out.println(number);

        System.out.println(1 + 1.2);    // 정수 + 실수 = 실수
        System.out.println(7 / 2);      // 정수 / 정수 = 정수
        System.out.println(7 / 2.0);    // 정수 / 실수 = 실수

        System.out.println(2 < 3);  // true
        System.out.println(2 <= 3); // true
        System.out.println(2 > 3); // false
        System.out.println(3 >= 3); // true
        System.out.println(5 == 3); // false
        System.out.println(5 == 5); // true
        System.out.println(5 != 5); // false
        System.out.println(3 != 5); // true
    }
}
