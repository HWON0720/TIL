import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileOutput02 {
    public static void main(String[] args) {
        FileWriter writer = null;
        try {
            writer = new FileWriter("src/output01.txt");    // ("src/output01.txt", true) 사용 시, 내용을 덮어쓰는 것이 아니라 본래 있던 내용에 추가로 덧붙여져서 계속 늘어난다.
        } catch (IOException e) {
//            e.printStackTrace();    // 오류 발생 시, 오류를 띄우는 역할.
            System.out.println("파일 생성에 실패했습니다.");   // 해당 예제에서는 오류가 났음을 띄우기만 하는 것이 아니라, 메시지를 띄운 후, 프로그램을 종료하도록 한다.
            System.exit(1); // 정상적으로 종료 시, "Process finished with exit code 0"이라고 뜨기 때문에, 정상적으로 종료되지 않았음을 표기하도록 한다.
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("종료하려면 입력 없이 엔터.");

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("")) {
                System.out.println("파일 입력을 종료합니다.");
                break;
            }

            try {
                writer.write(input + "\n");
            } catch (IOException e) {
                System.out.println("파일에 데이터를 쓰는 데에 실패했습니다.");
                System.exit(2);
            }
        }

        try {
            writer.close(); // 파일을 다 사용한 뒤에는 '반드시' close를 해주어야 한다. (= 이 파일을 다 사용했으니, 파일의 변경내용을 반영하고 파일을 닫겠다)
        } catch (IOException e) {
            System.out.println("파일 닫기에 실패했습니다.");
        }
    }
}