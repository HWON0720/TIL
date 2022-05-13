public class SwitchCase {
    public static void main(String[] args) {
        int month = 0;

        switch (month) {
            case 1:
                System.out.println("January");
                break;
            case 2:
                System.out.println("February");
                break;
            case 5:
                System.out.println("May");
                break;
            default:
                System.out.println("일치하는 값 없음.");
        }
    }
}
