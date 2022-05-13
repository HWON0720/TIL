import java.util.Scanner;

public class BreakExample {
    public static void main(String[] args) {
        String password = "abc123";
        Scanner scanner = new Scanner(System.in);

        while (true) {  // while 조건을 true로 설정함으로써, 아래 코드가 무한으로 반복된다.
            System.out.println("비밀번호를 입력해주세요.");
            String input = scanner.nextLine();

            if (input.equals(password)) {
                System.out.println("비밀번호가 일치합니다.");
                break;  // break을 통해 while문의 무한반복을 벗어난다.
            }

            System.out.println("비밀번호가 일치하지 않습니다.");
        }
    }
}
