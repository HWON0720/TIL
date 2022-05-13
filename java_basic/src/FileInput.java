import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileInput {
    public static void main(String[] args) {
        FileInputStream inputStream = null;

        try {
            inputStream = new FileInputStream("src/acronym.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(inputStream);

        while (scanner.hasNextLine()) { // 다음 줄이 있는지 판단,
            String line = scanner.nextLine();   // 다음 줄이 있는 경우, 값을 가져온다
            System.out.println(line);   // 가져온 값을 출력
        }
    }
}
