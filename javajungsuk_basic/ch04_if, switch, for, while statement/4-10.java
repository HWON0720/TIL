class Ex4_10 {
    public static void main(String[] args) {
        int sum = 0;    // 합계를 저장하기 위한 변수

        for (int i = 1; i <= 5; i++) {
            sum += 1;   // sum = sum + 1;
            System.out.printf("1부터 %2d 까지의 합: %2d%n", i, sum);
        }
    }
}

// 결과
// 1부터  1 까지의 합:  1
// 1부터  2 까지의 합:  2
// 1부터  3 까지의 합:  3
// 1부터  4 까지의 합:  4
// 1부터  5 까지의 합:  5
