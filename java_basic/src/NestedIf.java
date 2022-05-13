public class NestedIf {
    public static void main(String[] args) {
        int age = 15;

// 첫번째 방법
//        if (age >= 10) {
//            if (age < 20) {
//                System.out.println("10대");
//            } else {
//                System.out.println("10대 아님");
//            }
//        } else {
//            System.out.println("10대 아님");
//        }

// 두번째 방법 : '&&' 사용. 둘 중 하나라도 false인 경우 false 값 반환
//        if (age >= 10 && age < 20) {
//            System.out.println("10대");
//        } else {
//            System.out.println("10대 아님");
//        }

// 세번째 방법 : '||' 사용. 둘 중 하나라도 true인 경우 true 값 반환
        if (age < 10 || age >= 20) {
            System.out.println("10대 아님");
        } else {
            System.out.println("10대");
        }
    }
}
