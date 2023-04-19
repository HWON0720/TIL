// 문제 설명
// 정수 배열 numbers가 매개변수로 주어집니다. numbers의 각 원소에 두배한 원소를 가진 배열을 return하도록 solution 함수를 완성해주세요.

// 제한사항
// -10,000 ≤ numbers의 원소 ≤ 10,000
// 1 ≤ numbers의 길이 ≤ 1,000

// 풀이
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length]; // numbers 배열과 같은 길이의 result 배열을 선언
        
        for(int i = 0; i < numbers.length; i++){
            answer[i] = numbers[i] * 2; // answer 배열에 저
        }
        
        return answer;
    }
}

// 풀이 2   (반환타입이 바뀌어버려서 참고만)
import java.util.*;

class Solution {
    public ArrayList solution(int[] numbers) {
        ArrayList<Integer> answer = new ArrayList<>();

        for(int num : numbers){
            answer.add(num * 2);
        }

        return answer;
    }
}

// 풀이 3   (성능 이슈 우려됨)
import java.util.Arrays;

class Solution {
    public int[] solution(int[] numbers) {
        return Arrays.stream(numbers).map(i -> i * 2).toArray();
    }
}
