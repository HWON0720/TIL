import java.io.*;
import java.util.Scanner;

public class Notepad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("원하는 작업 번호를 입력해주세요.");
            System.out.println("1. 메모 읽기");
            System.out.println("2. 새 메모");
            System.out.println("3. 종료");

            int taskNum;// 사용자로부터 입력받은 작업 번호를 저장할 변수 선언하기

            try {   // 사용자의 입력을 받아, 입력값을 정수로 변환해 taskNum에 대입하기
                String input = scanner.nextLine();
                taskNum = Integer.parseInt(input);
            } catch (NumberFormatException e) { // 정수 변환에 실패한 경우
                System.out.println("잘못된 입력입니다.");
                continue;   // 제대로 된 값을 입력할 때까지 반복문의 처음으로 되돌아간다
            }

            // 사용자가 올바른 taskNum을 입력한 경우
            if (taskNum == 1) {
                System.out.println("메모 파일명을 입력하세요.");

                String fileName = scanner.nextLine();

                FileInputStream inputStream = null;

                try {
                    inputStream = new FileInputStream(fileName); // 파일 내용 입력하기 위한 변수 생성
                } catch (FileNotFoundException e) {
                    System.out.println("파일이 존재하지 않습니다.");
                    continue;
                }

                System.out.println(fileName + "의 내용을 출력합니다.");

                Scanner reader = new Scanner(inputStream);  // 입력받은 파일 읽기 위한 변수 생성

                while (reader.hasNextLine()) {
                    System.out.println(reader.nextLine());
                }
                System.out.println("\n");

                reader.close();

            } else if (taskNum == 2) {
                System.out.println("저장할 메모 파일명을 입력하세요.");

                String fileName = scanner.nextLine();

                FileWriter writer = null;

                try {
                    writer = new FileWriter(fileName);
                } catch (IOException e) {
                    System.out.println("파일 생성에 실패했습니다.");
                    continue;
                }

                System.out.println("메모할 문자열을 입력하세요.");
                System.out.println("종료: 빈 줄에서 엔터 입력");

                while (true) {
                    String input = scanner.nextLine();

                    if (input.equals("")) {
                        break;
                    }

                    try {
                        writer.write(input);
                        writer.write("\n");
                    } catch (IOException e) {
                        System.out.println("파일에 문자열을 쓰지 못했습니다.");
                    }
                }

                try {
                    writer.close();
                } catch (IOException e) {
                    System.out.println("파일을 닫는 데 실패했습니다.");
                }

            } else if (taskNum == 3) {
                System.out.println("프로그램을 종료합니다.");
                break;

            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }
}
