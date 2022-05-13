import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
        Scanner scanner;
        scanner =  new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(input);

//      <키보드로부터 띄어쓰기 단위로 입력받기>
        System.out.println("영어 단어와 한글 단어를 하나씩 입력해보세요.");
        Scanner scanner1 = new Scanner(System.in);

        String englishWord = scanner1.next();
        String koreanWord = scanner1.next();

        System.out.println("입력된 영단어: " + englishWord);
        System.out.println("입력된 한글 단어: " + koreanWord);

//      <키보드로부터 입력받은 숫자 사용하기>
        System.out.println("숫자를 입력하세요.");
        Scanner scanner2 = new Scanner(System.in);
        String intInput = scanner2.nextLine();
        int intValue = Integer.parseInt(intInput);
        System.out.println(intValue + 1);   // parseInt로 형변환 하지 않으면, 문자로 인식되어 100 입력 시 101이 아닌 1001로 출력된다.
    }
}
