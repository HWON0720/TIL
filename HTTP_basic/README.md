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
### [HTTP 기본](https://github.com/HWON0720/TIL/blob/main/HTTP_basic/README.md#http-%EA%B8%B0%EB%B3%B8-1)
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
    - 전체 문법: `scheme://[userinfo@]host[:port][/path][?query][#fragment]`
      - (예: <dummy-tag>https://<dummy-tag>www<dummy-tag>.google.com:443/search?q=hello&hl=ko)
- 웹 브라우저 요청 흐름
  - 1. 웹 브라우저가 HTTP 메시지 생성
  - 2. SOCKET 라이브러리를 통해 전달
    - A : TCP/IP 연결(IP, PORT)
    - B : 데이터 전달
  - 3. TCP/IP 패킷 생성, HTTP 메시지 포함
  - 4. 패킷 정보 인터넷으로 전송

<br>

### HTTP 기본
- 모든 것이 HTTP (HyperText Transfer Protocol)
  - HTML, TEXT
  - IMAGE, 음성, 영상, 파일
  - JSON, XML (API)
  - 거의 모든 형태의 데이터 전송 가능
  - 서버 간 데이터 주고 받을 때도 대부분 HTTP 사용
  - 특징
    - 클라이언트 서버 구조
    - 무상태 프로토콜(stateless), 비연결성
    - HTTP 메시지
    - 단순함, 확장 가능
- 클라이언트 서버 구조
  - Request Response 구조
  - 클라이언트는 서버에 요청을 보내고, 응답을 대기
  - 서버가 요청에 대한 결과를 만들어서 응답
- Stateful, Stateless
  - 상태 유지 (Statedul)
    - 항상 같은 서버가 유지되어야 한다
  - 무상태 프로토콜(Stateless)
    - 아무 서버나 호출해도 된다
    - 서버가 클라이언트의 상태를 보존 X
    - 장점: 서버 확장성 높음(스케일 아웃) (ex. 처음 요청 받은 서버1에 문제가 생겨도, 서버2에서 응답 가능)
    - 단점: 클라이언트가 추가 데이터 전송
    - 한계:  로그인 한 사용자의 경우 로그인 했다는 상태를 서버에 유지, 일반적으로 브라우저 쿠키와 서버 세션 등을 사용해서 상태 유지
- 비 연결성(connectionless)
  - HTTP는 기본이 연결을 유지하지 않는 모델
  - 일반적으로 초 단위 이하의 빠른 속도로 응답
  - 1시간 동안 수천명이 서비스를 사용해도 실제 서버에서 동시에 처리하는 요청은 수십개 이하로 매우 작음
    - 예) 웹 브라우저에서 계속 연속해서 검색 버튼을 누르지는 않는다
  - 서버 자원을 매우 효율적으로 사용할 수 있음
  - 장점: 서버 연결 유지하지 않음으로써, 최소한의 자원을 사용/유지한다
  - 한계와 극복
    - TCP/IP 연결을 새로 맺어야 함 -> 3 way handshake 시간 추가
    - 웹 브라우저로 사이트를 요청하면 HTML 뿐만 아니라 자바스크립트, css, 추가 이미지 등 수많은 자원이 함께 다운로드
    - 지금은 HTTP 지속 연결(Persistent Connections)로 문제 해결
    - HTTP/2, HTTP/3에서 더 많은 최적화
- HTTP 메시지
  |구조|내용|
  |--|--|
  |start-line 시작라인|요청 메시지 종류 - GET, POST, PUT, DELETE, ...|
  |header 헤더|HTTP 전송에 필요한 모든 부가정보 有|
  |empty line 공백라인 (CRLF)||
  |message body|실제 전송할 데이터 (HTML 문서, 이미지, 영상 JSON 등 byte로 표현할 수 있는 모든 데이터)|
  
  - 예시
  ```html  
  // HTTP 요청 메시지
  GET /search?q=hello&hl=ko HTTP/1.1
  Host: www.google.com
  
  // HTTP 응답 메시지
  HTTP/1.1 200 OK
  Content-Type: text/html;charset=UTF-8
  Content-Length: 3423
  
  <html>
    <body>...</body>
  </html>
  ```

<br>

### HTTP 메서드
- HTTP API를 만들어보자
- HTTP 메서드 - GET, POST
- HTTP 메서드 - PUT, PATCH, DELETE
- HTTP 메서드의 속성

<br>

### HTTP 메서드 활용
- 클라이언트에서 서버로 데이터 전송
- HTTP API 설계 예시

<br>

### HTTP 상태코드
- HTTP 상태코드 소개
- 2xx - 성공
- 3xx - 리다이렉션1
- 3xx - 리다이렉션2
- 4xx - 클라이언트 오류, 5xx - 서버 오류

<br>

### HTTP 헤더1 - 일반 헤더
- HTTP 헤더 개요
- 표현
- 콘텐츠 협상
- 전송 방식
- 일반 정보
- 특별한 정보
- 인증
- 쿠키

<br>

### HTTP 헤더2 - 캐시와 조건부 요청
- 캐시 기본 동작
- 검증 헤더와 조건부 요청1
- 검증 헤더와 조건부 요청2
- 캐시와 조건부 요청 헤더
- 프록시 캐시
- 캐시 무효화
