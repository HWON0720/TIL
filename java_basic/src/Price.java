import java.util.Scanner;

public class Price {
    public static void main(String[] args) {
        System.out.println("음식 이름을 입력하세요.");
        System.out.println("1. 치킨");
        System.out.println("2. 순대국");
        System.out.println("3. 스테이크");

        Scanner scanner = new Scanner(System.in);
        int menuNumber;

        try {
            menuNumber = scanner.nextInt();
        } catch (java.lang.Exception e) {
            menuNumber = -1;
        }

        switch (menuNumber) {
            case 1:
                System.out.println("치킨은 500원입니다.");
                break;
            case 2:
                System.out.println("순대국은 8,000원입니다.");
            case 3:
                System.out.println("스테이크는 5,000원입니다.");
                break;
            default:
                System.out.println("올바른 메뉴 번호를 입력해주세요.");
        }
    }
}
