import java.util.Random;
import java.util.Scanner;

public class UpAndDownWithMethod {

    public static int randomNumber;
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Random random = new Random();
        randomNumber = random.nextInt(256);

        int attempt = 0;    // 시도 횟수

        while (attempt < 8) {   // 시도 횟수가 8보다 작은 경우 아래 코드 실행
            boolean isCorrect = play(); //사용자로부터 숫자를 입력받고, 숫자가 RandomNumber와 일치하는지 여부에 따라 적절한 메시지를 출력해주면서, 반환값으로 사용자가 입력한 숫자가 RandomNumber와 일치하는 경우 true, 그렇지 않은 경우 false를 반환하도록 한다.

            if (isCorrect) {    // 반환받은 isCorrect 변수가 true라면,
                break;  // 게임을 종료
            }

            attempt = attempt + 1;
            System.out.println(attempt + "회 시도하였습니다.");
        }

        System.out.println("게임을 종료합니다.");
    }

    public static boolean play() {
        System.out.println("숫자를 입력하세요.");
        int input = scanner.nextInt();  // 사용자로부터 숫자를 입력받고,

        if (input == randomNumber) {    //  이 숫자가 RandomNumber와 일치하는 경우,
            System.out.println("짝짝짝. 정답입니다.");
            return true;    // 반환값으로 사용자가 입력한 숫자가 RandomNumber와 일치하는 경우 true
        } else if (input > randomNumber) {
            System.out.println("더 작게요.");
        } else {
            System.out.println("더 크게요.");
        }

        return false;   // else if나 else 같이 일치하지 않은 경우 false 반환
    }
}
