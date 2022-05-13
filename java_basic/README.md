# java_basic
## 초간단 자바 - 비전공자를 위한 자바 프로그래밍 입문

<br>

02. 숫자와 문자 그리고 주석 (NumberExample, StringExample, Comment)
- 숫자
- 문자와 문자열
    - 문자 = 'A'
    - 문자열 = "ABC"
- 특수문자와 이스케이프
    - 문자 앞에 `\` 사용
- 주석
    - `Ctrl` + `/`

<br>

03. 변수 (Variable, MartEvent)
- 변수의 선언
    - 변수 : 어떤 값을 가리키는 이름
    - 예약어 = 자바에서 따로 사용하기 위해 미리 정의된 단어
    - `type name = value;` (데이터 종류  변수의 이름 = 입력 값)
- 변수에 값 할당하기
- 변수의 값 변경하기
- 변수의 필요성
- 좋은 변수명과 나쁜 변수명
    - 첫 글자는 반드시 영문 대소문자나 언더스코어(_), 또는 $
    - CamelCase 표기법 권장
    - 예약어(reserved words)는 변수명으로 사용 불가

<br>

04. 연산자를 이용해 값 조작하기 (Operator)
- 산술 연산자
- 산술 연산자의 우선순위
- 대입 연산자
- 서로 다른 숫자 타입의 연산과 형 변환
- 비교 연산자

<br>

05. 데이터의 형태, 자료형 (Number, StringExample2, BooleanExample)
- 정수형 (byte, short, int, long)
- 실수형 (float, double)
- 문자형 (char)
- 문자열
    - `stringName.length();` : 문자열의 글자 수 세기
    - `stringName.replaceAll("바꿀 문자열, "새 문자열");` : 문자열 일부 바꾸기
    - `stringName.substring(시작 위치, 끝 위치(생략 가능));` : 문자열 자르기
- 논리형
    - boolean (true, false)
- 래퍼 타입
    - 원시(primitive) 자료형 : 문자열을 제외한 순수하게 상수 형태로 표현할 수 있는 자료형으로, 자료의 크기에 대한 제약이 있으며, 추가적인 기능 제공 x

<br>

06. 사용자 입력과 예외 처리 (Input, Scanner)
- 키보드로부터 한 줄 입력받기
    - Scanner 사용
    - `scanner.nextLine();`
      ```java
      // 예시
      Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(input);
      ```
- 숫자나 문자처럼 직접적으로 표현할 수 없는 자료형의 값을 생성하기 위한 문법
    - new TypeName(), new TypeName(parameter)
- 키보드로부터 띄어쓰기 단위로 입력받기
    - `String stringName = scanner.next();`
- 키보드로부터 입력받은 숫자 사용하기
    - `Integer.parseInt();` : 숫자로 구성된 문자열을 인자로 받아 정수형으로 값을 되돌려 준다 (문자형 숫자 -> 정수형 숫자)
      ```java
      // 예시
      int number = Integer.parseInt(intString);
      ```
- 예외
    - `try-catch` 구문
      ```java
      try {
        예외 발생 가능성이 있는 코드
      } catch (Exception e) {
        예외가 발생했을 때 실행될 코드
      }
      ```

<br>

07. 조건문을 이용해 다르게 동작하기 (Hungry, NestedIf, SwitchCase, StringCompare, Price)
- if
  ```java
  if (조건이 참이라면) {
    명령을 실행한다
  }
  ```
- else
  ```java
  if (조건이 참이라면) {
    명령을 실행한다
  } else {
    명령2를 실행한다
  }
  ```
- else if
  ```java
  if (조건이 참이라면) {
    명령을 실행한다
  } else if (조건2가 참이라면) {
    명령2를 실행한다
  } else {
    명령3을 실행한다
  }
  ```
- 두 조건을 동시에 만족할 때 실행하기
    - 논리곱: && 사용
- 두 조건 중 일부만 만족해도 실행하기
    - 논리합: || 사용
- switch-case 구문
  ```java
  switch (value) {
    case 값1:
      value의 값이 값1일 경우 실행될 코드
      break;
    default:
      일치하는 값이 없을 때 실행될 코드
  }
  ```
- 문자열 비교하기
    - `a == b`
    - `a.equals(b)`
- 사용자와 상호작용하기

<br>

08. 배열과 반복문 (ForExample, WhileExample, WhileExample02, ContinueExample, ArrayExample, ArrayToString, TwoDimensional Array, RandomInteger, Threadsleep, UpAndDownGame)
- 반복문이 필요한 이유
    - 반복되는 코드들을 특정 규칙에 의해 자동으로 반복시킬 수 있도록 만듦
- for : 정해진 횟수만큼 반복
  ```java
  for (초기값; 종료조건(실행조건); 증가) {
    실행할 코드
  }
  ```
- 중첩 for
- while : 조건식이 true일 경우에 계속해서 반복 (false가 되면 반복 행위를 멈추고 while문 종료)
  ```java
  while (조건) {
    실행할 코드
  }
  ```
- do-while : 조건에 따라 반복을 계속할지를 결정할 때 사용
    - while문에서의 중복된 코드를 깔끔하게 정리 가능
    - 단, 무조건 중괄호 {} 블럭을 한 번 실행하고, 조건을 검사하여 반복을 결정한다
  ```java
  do {
    실행할 코드
  } while (조건);
  ```
- break
    - 반복문 탈출
- continue
    - 반복문의 처음으로 되돌아가 다음 반복을 실행
- 배열
    - 배열 선언 문법 : Type[] array = {value1, value2, ..., valueN};
      ```java
      // 예시
      String[] days = {"월", "화", "수", "목", "금", "토", "일"}
      ```
    - 배열 요소 접근 : array[i]
      ```java
      // 예시
      System.out.println(days[0]));
      ```
    - 배열 길이 알아내기 : array.length;
      ```java
      // 예시
      int lengthOfDays = days.length;
      ```
    - for-each 구문
      ```java
      for (Type element : array) {
        실행할 코드
      }
      
      // 예시
      for (String day : days) {
      System.out.println(day + "요일");
      }
      ```    
    - 배열 값 복제 : Type[] array = Arrays.copyOf(복제해올 배열, 복제될 배열이 가질 요소 길이)
      ```java
      String[] days2 = Arrays.copyOf(days, 8));
      ```
    - 배열 통으로 출력 : Arrays.toString(array)
      ```java
      Arrays.toString(days)
      ```
    - 2차원 배열
      ```java
      Type[][] array = {
          {value1, value2, ..., valueN},
          {value1, value2, ..., valueN},
          {value1, value2, ..., valueN},
       };
       ```
- 숫자 맞추기 게임 만들기

<br>

09. 파일 읽고 쓰기 (chicken.txt, FileInput, acronym.txt, Notepad)
- 텍스트 파일의 내용 출력하기
    - `FileInputStream("경로/파일명")` : 파일의 내용을 읽을 때 사용되는 읽기 도구
- 여러 줄로 된 텍스트 파일의 내용 출력하기
    - `hasNextLine()` : 입력 소스의 다음 줄이 존재하는지 여부 판단 (있는 경우 true 반환, 없는 경우 false 반환)
- 텍스트 파일로 저장하기
    - `FileWriter("경로/파일명", true)` : 파일에 쉽게 값을 저장하기 위해 사용되는 쓰기 도구. 뒤에 true 추가 시, 파일 내용을 덮어쓰는 대신 추가로 덧붙여진다.
    - `.write("내용")` : 내용 입력
        - `.close()` : 파일 변경 내용 반영 후 닫겠다는 의미
- 키보드 입력을 텍스트 파일로 저장하기
    - `System.exit()` : 프로그램을 강제로 종료하기 위한 명령
- 간단 메모장 만들어보기

<br>

10. 메소드를 이용해 반복되는 코드 줄이기 (FunctionExample, UpAndDownWithMethod)
- main 메소드
- 메소드의 문법
    - `void` : 메소드가 아무 값도 되돌려주지 않을 때 사용
- 메소드 정의와 메소드 호출
- 매개변수
- 여러 개의 매개변수
- 반환값
- 여러 개의 반환값
- return의 또다른 용도
- 메소드 안에서 메소드 호출
- 전역변수(멤버변수)와 지역변수

<br>

11. 배열보다 유용한 컬렉션 (ListExample, SetExample, CollectionLoopExample)
- 배열보다 편리한 List
    - `List<Type> list = new ArrayList<>();`
        - List는 그저 껍데기에 불과하기 때문에, ArrayList<>()를 사용해서 리스트를 생성해준다
- List에 데이터 추가/제거하기
    - `list.add();`
    - `list.remove();`
- List의 특정 위치의 값 변경하기
    - `list.set(변경 위치, 변경값);`
- List에서 데이터 가져오기
    - `list.get(가져올 위치);`
- List에 특정 데이터가 있는지 확인하기
    - `list.equals(value)`
    - `list.contains(value)`
      ```java
      // 예시
      boolean containsValue = list.contains(value);
      ```
- List 정렬하기
  ```java
  Collections.sort(array);  // 오름차순
  Collections.reverse(array); // 순서 뒤집기
  ```
- List 순서 섞기
  ```java
  Collections.shuffle(array); // 순서 랜덤으로 뒤섞기
  ```
- 배열을 List로 변환하기
    - `Arrays.asList(value1, value2, ..., valueN);`
- 중복 값을 허용하지 않는 Set
    - `Set<Type> set = new HashSet<>();`
- Set 사용하기
- 반복문에서 컬렉션 이용하기
- 컬렉션이 비어있는지 확인하기
    - `.size()` : List나 Set이 가지고 있는 요소의 개수를 반환하는 메서드 (ex. if foods.size() == 0 { ... )
    - `.isEmpty()`
- List와 Set 비교
    - List, ArrayList : 중복 혀용 o, 순서 보장 o, 특정 위치의 요소에 접근 o
    - Set, HashSet : 중복 허용 x, 순서 보장 x, 특정 위치의 요소에 접근 x

<br>

12. 데이터의 연결고리 Map (MapExample)
- Map이란
    - 키-값 쌍의 목록을 표현하는 자료형
    - `Map<키의 Type, 값의 Type> map = new HashMap<>();`
- Map에 데이터 추가하기
    - `put(key, value)`
- Map에서 데이터 가져오기
    - `get(key)`
    - `.keySet();` : key 값만 가져오기 (ex. Collection<String> keys = dictionary.keySet();)
    - `.values();` : value 값만 가져오기 (ex. Collection<String> values = dictionary.values();
    - `entrySet();` : Map에서 가지고 있는 key, value 값 쌍을 가져오기 (ex. Set<Map.Entry<String, String>> entries = dictionary.entrySet();)
        - `entry.getKey()` : key 값만 가져오기
        - `entry.getValue()` : value 값만 가져오기
- Map에서 데이터 제거하기
    - `remove(key);`
- Map의 크기 확인하기
- 반복문에서 Map 이용하기