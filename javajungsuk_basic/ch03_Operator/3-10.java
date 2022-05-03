public class Ex3_10 {
    public static void main(String[] args) {
        long a = 1_000_000 * 1_000_000;
        long b = 1_000_000 * 1_000_000L;

        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}

// 결과
// a = -727379968
// b = 1000000000000
