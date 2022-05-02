# 목차
#### [CH02 변수](https://github.com/HWON0720/TIL/blob/main/javajungsuk_basic/README.md#ch02-%EB%B3%80%EC%88%98-1)
#### CH03 연산자
#### CH04 조건문과 반복문
#### CH05 배열
#### CH06 객체지향 프로그래밍 I
#### CH07 객체지향 프로그래밍 II
#### CH08 예외처리
#### CH09 java.lang 패키지와 유용한 클래스
#### CH10 날짜와 시간 & 형식화
#### CH11 컬렉션 프레임웍
#### CH12 지네릭스, 열거형, 애너테이션
#### CH13 쓰레드
#### CH14 람다와 스트림
#### CH15 입출력
#### CH16 네트워킹
---

### CH02 변수
#### 01. 화면에 글자 출력하기 - print()와 println() `2-1`, `2-2`
- 화면에 글자를 출력할 때는 `System.out.print()`을 사용한다. 괄호() 안에 출력하고자 하는 내용을 넣으면 된다.
- `System.out.print()`: 괄호 안의 내용을 출력하고 줄바꿈을 하지 않는다.
- `System.out.println()`: 괄호 안의 내용을 출력하고 줄바꿈을 한다.

#### 02. 덧셈 뺄셈 계산하기 `2-3`
- 덧셈(+), 뺄셈(-), 곱셈(\*), 나눗셈(/)
- 정수 / 정수 = 정수이다.

#### 03. 변수의 선언과 저장 `2-4`, `2-5`
- 변수란? 하나의 값을 저장할 수 있는 저장공간
- 변수 선언 방법: `변수타입 변수이름`
  ```java
  int x;  // 정수(integer)를 저장하기 위한 변수 x 선언 = x라는 저장공간(변수) 생성
  x = 5;  // 변수 x에 5 저장
  int x = 5;  // 한번에 선언 및 저장 가능
  ```
- 변수 장점
  - 아래와 같이 값을 변경해줘야 할 때, 일일히 바꿔주는 대신 저장하는 값(대입값)만 바꿔주면 된다.
  ```java
  // 변수 사용 x
  System.out.println(5+3);
  System.out.println(5-3);
  System.out.println(5*3);
  System.out.println(5/3);
  
  // 변수 사용 o
  int x = 5;  // 변수에 다른 값을 저장하기만 하면 된다.
  int y = 3;  // 변수에 다른 값을 저장하기만 하면 된다.
  System.out.println(x+y);
  System.out.println(x-y);
  System.out.println(x*y);
  System.out.println(x/y);
  ```

#### 04. 변수의 타입 `2-6`
- 변수 선언 시, 변수에 저장할 값의 종류에 맞는 변수 타입 선택
- 변수의 타입:
![image](https://user-images.githubusercontent.com/90819869/166177100-dbc4135e-f990-4c2c-9a0f-006ea93ff5f9.png)
  - **int**, long: 정수(integer)를 저장하기 위한 타입(20억이 넘을 땐 long)
  - float, **double**: 실수(floating-point number)를 저장하기 위한 타입 (float는 오차없이 7차리, double은 15자리)
  - char: 문자(character)를 저장하기 위한 타입
  - String: 여러 문자(문자열, string)를 저장하기 위한 타입
  ```java
  // 대표 4가지
  int x = 100;        // 정수(integer)를 저장할 변수의 타입은 int로 한다.
  double pi = 3.14;   // 실수를 저장할 변수의 타입은 double로 한다.
  char ch = 'a';      // 문자(1개)를 저장할 변수의 타입은 char로 한다.
  String str = "abc"; // 여러 문자(0~n개)를 저장할 변수의 타입은 String으로 한다.
  ```

#### 05. 상수와 리터럴

#### 06. 리터럴의 타입과 접미사

#### 07. 문자 리터럴과 문자열 리터럴

#### 08. 문자열 결합

#### 09. 두 변수의 값 바꾸기

#### 10. 기본형과 참조형

#### 11. 기본형의 종류와 범위

#### 12. printf를 이용한 출력

#### 13. printf를 이용한 출력 예제

#### 14. 화면으로부터 입력받기

#### 15. 정수형의 오버플로우

#### 16. 부호있는 정수의 오버플로우

#### 17. 타입 간의 변환방법
