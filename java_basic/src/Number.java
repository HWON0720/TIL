public class Number {
    public static void main(String[] args) {
        byte byteInteger = 10;  // 127까지의 숫자 표현 가능
        short shortInteger = 20;
        int intInteger = 30;
        long longInteger = 40;

        System.out.println(byteInteger);
        System.out.println(shortInteger);
        System.out.println(intInteger);
        System.out.println(longInteger);

        int sum = byteInteger + shortInteger;   // 결과: Integer
        int sum2 = shortInteger + intInteger;   // 결과: Integer
        long sum3 = intInteger + longInteger;    // long이 포함된 정수형의 연산은 long 타입의 결과를 출력
        long sum4 = byteInteger + longInteger;

//      <실수형>
        float floatNumber = 1.2f;
        double doubleNumber = 4.3;
        float floatSum = 0.001f + 0.001f + 0.0001f;

        System.out.println(floatNumber);
        System.out.println(doubleNumber);
        System.out.println(floatSum); // 출력 시 0.0021000002 => 자바에서 실수 연산 시, 아주 정확한 값을 세밀하게 계산하지 못함
    }
}
