public class FunctionExample {
    public static void main(String[] args) {
        sayHello();
        sayHelloTo("Chicken");
        printSum(1, 2);
        int result = sum(1, 2); // sum이라는 메서드가 값을 반환하기 때문에, 이 값을 어떠한 변수로 받아줘야 한다.
        System.out.println(result);

        int[] sumAndProduct = addAndMultiply(1, 2);
        System.out.println("sum: " + sumAndProduct[0]);
        System.out.println("product: " + sumAndProduct[1]);

        sayHola("자바");
        sayHola("바보");
    }

    // 1 + 2 = 3 의 형태로 덧셈을 출력
    public static void printSum(int a, int b) {
        System.out.println(a + " + " + b + " = " + (a + b));
//        System.out.println(a + " + " + b + " = " + sum(a, b));    // (a + b) 자리를 sum 메서드로 대체 가능
    }

    // 두 정수를 더한 값을 반환
    public static int sum(int a, int b) {
        return a + b;    // return 뒤에 명시하는 값 = 메서드의 반환 값
    }

    // 두 정수를 더한 값과 곱한 값을 반환
    public static int[] addAndMultiply(int a, int b) {
        int sum = a + b;
        int product = a * b;

        int[] result = {sum, product};

        return result;
    }

    public static void sayHelloTo(String name) {
        System.out.println("Hello, " + name + ".");
    }

    public static void sayHello() {
        System.out.println("Hello.");
    }

    public static void sayHola(String name) {
        if (name.equals("바보")) {
            System.out.println("바르고 고운 말을 사용해주세요.");
        } else {
            System.out.println(name + "님, 안녕하세요?");
        }
    }
}
