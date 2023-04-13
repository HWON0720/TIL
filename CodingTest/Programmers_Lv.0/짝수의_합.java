// 문제 설명
// 정수 n이 주어질 때, n이하의 짝수를 모두 더한 값을 return 하도록 solution 함수를 작성해주세요.

// 제한사항
//   - 0 < n ≤ 1000
  
// 풀이 1
class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i = 0; i <= n; i++){
            if(i % 2 == 0){
                answer += i;
            }
        }
        return answer;
    }
}
 

// 풀이 2
class Solution {
    public int solution(int n) {
        int answer = 0;

        for(int i=2; i<=n; i+=2){
            answer+=i;
        }

        return answer;
    }
}
 

// 시간초과로 실패한 풀이...ㅠ
class Solution {
    public int solution(int n) {
        int answer = 0;
        
        while(0 < n && n <= 1000){
            for(int i = 0; i <= n; i++){
                if(i % 2 == 0){
                    answer += i;
                }
            }
        }
        return answer;
    }
}
