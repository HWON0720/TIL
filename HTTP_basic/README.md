# 인프런 강의 : 모든 개발자를 위한 HTTP 웹 기본 지식 by 김영한

## 목차
### [인터넷 네트워크](https://github.com/HWON0720/TIL/blob/main/HTTP_basic/README.md#%EC%9D%B8%ED%84%B0%EB%84%B7-%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC-1)
- 인터넷 통신
- IP(인터넷 프로토콜)
- TCP, UDP
- PORT
- DNS
### [URI와 웹 브라우저 요청 흐름](https://github.com/HWON0720/TIL/blob/main/HTTP_basic/README.md#uri%EC%99%80-%EC%9B%B9-%EB%B8%8C%EB%9D%BC%EC%9A%B0%EC%A0%80-%EC%9A%94%EC%B2%AD-%ED%9D%90%EB%A6%84-1)
- URI
- 웹 브라우저 요청 흐름
### HTTP 기본
- 모든 것이 HTTP
- 클라이언트 서버 구조
- Stateful, Stateless
- 비 연결성(connectionless)
- HTTP 메시지
### HTTP 메서드
- HTTP API를 만들어보자
- HTTP 메서드 - GET, POST
- HTTP 메서드 - PUT, PATCH, DELETE
- HTTP 메서드의 속성
### HTTP 메서드 활용
- 클라이언트에서 서버로 데이터 전송
- HTTP API 설계 예시
### HTTP 상태코드
- HTTP 상태코드 소개
- 2xx - 성공
- 3xx - 리다이렉션1
- 3xx - 리다이렉션2
- 4xx - 클라이언트 오류, 5xx - 서버 오류
### HTTP 헤더1 - 일반 헤더
- HTTP 헤더 개요
- 표현
- 콘텐츠 협상
- 전송 방식
- 일반 정보
- 특별한 정보
- 인증
- 쿠키
### HTTP 헤더2 - 캐시와 조건부 요청
- 캐시 기본 동작
- 검증 헤더와 조건부 요청1
- 검증 헤더와 조건부 요청2
- 캐시와 조건부 요청 헤더
- 프록시 캐시
- 캐시 무효화

---

### 인터넷 네트워크
- 인터넷 통신
  - 클라이언트 -- 인터넷 -- 서버
- IP(인터넷 프로토콜)
  - 지정한 IP 주소에, 패킷(이라는 통신 단위)으로 데이터 전달
  - IP 프로토콜의 한계: 비연결성, 비신뢰성, 프로그램 구분
- TCP, UDP
  - 인터넷 프로토콜 스택의 4계층
    - 애플리케이션 계층 - HTTP, FTP
    - 전송 계층 - TCP, UDP
    - 인터넷 계층 - IP
    - 네트워크 인터페이스 계층
  - TCP(Transmission Control Protocol, 전송 제어 프로토콜) 특징
    - 연결지향 - TCP 3 way handshake (가상 연결)
      - 1. 클라이언트 -- SYN --> 서버
      - 2. 서버 -- SYN + ACK --> 클라이언트
      - 3. 클라이언트 -- ACK --> 서버 => 데이터 전송
    - 데이터 전달 보증
    - 순서 보장
    - 신뢰할 수 있는 프로토콜
  - UDP(User Datagram Protocol, 사용자 데이터그램 프로토콜) 특징
    - 연결지향- TCP 3 way handshake X
    - 데이터 전달 보증 X
    - 순서 보장 X
    - 데이터 전달 및 순서가 보장되지 않지만, 단순하고 빠름
    - IP와 유사. +PORT +체크섬 정도만 추가
    - 애플리케이션에서 추가 작업 필요
- PORT
  - 클라이언트에서 서버에 요청 시, 같은 IP 내에서 프로세스 구분
  - 예: IP = 아파트, PORT = 동 호수
- DNS (Domain Name System)
  - 전화번호부
  - 도메인 명을 IP 주소로 변환

<br>

### URI와 웹 브라우저 요청 흐름
- URI (Uniform Resource Identifier)
  - Uniform : 리소스 식별하는 통일된 방식
  - Resource : 자원, URI로 식별할 수 있는 모든 것
  - Identifier : 다른 항목과 구분하는데 필요한 정보
  - URI는 로케이터(Locator), 이름(Name) 또는 둘 다 추가로 분류될 수 있다 (URL, URN)
    - URL - Locator: 리소스가 있는 위치를 지정 (≒ 앞으로 URI와 같은 의미로 언급하겠음)
    - URN - Name: 리소스에 이름을 부여
    - 전체 문법: `scheme://[userinfo@]host[:port][/path][?query][#fragment]` (예: https://www.google.com:443/search?q=hello&hl=ko)
- 웹 브라우저 요청 흐름
  - 1. 웹 브라우저가 HTTP 메시지 생성
  - 2. SOCKET 라이브러리를 통해 전달
    - A : TCP/IP 연결(IP, PORT)
    - B : 데이터 전달
  - 3. TCP/IP 패킷 생성, HTTP 메시지 포함
  - 4. 패킷 정보 인터넷으로 전송

<br>

### HTTP 기본
- 모든 것이 HTTP
- 클라이언트 서버 구조
- Stateful, Stateless
- 비 연결성(connectionless)
- HTTP 메시지
