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
### [HTTP 메서드](https://github.com/HWON0720/TIL/tree/main/HTTP_basic#http-%EB%A9%94%EC%84%9C%EB%93%9C-1)
- HTTP API를 만들어보자
- HTTP 메서드 - GET, POST
- HTTP 메서드 - PUT, PATCH, DELETE
- HTTP 메서드의 속성
### [HTTP 메서드 활용](https://github.com/HWON0720/TIL/tree/main/HTTP_basic#http-%EB%A9%94%EC%84%9C%EB%93%9C-%ED%99%9C%EC%9A%A9-1)
- 클라이언트에서 서버로 데이터 전송
- HTTP API 설계 예시
### [HTTP 상태코드](https://github.com/HWON0720/TIL/tree/main/HTTP_basic#http-%EC%83%81%ED%83%9C%EC%BD%94%EB%93%9C-1)
- HTTP 상태코드 소개
- 2xx - 성공
- 3xx - 리다이렉션1
- 3xx - 리다이렉션2
- 4xx - 클라이언트 오류, 5xx - 서버 오류
### [HTTP 헤더1 - 일반헤더](https://github.com/HWON0720/TIL/tree/main/HTTP_basic#http-%ED%97%A4%EB%8D%941---%EC%9D%BC%EB%B0%98-%ED%97%A4%EB%8D%94-1)
- HTTP 헤더 개요
- 표현
- 콘텐츠 협상
- 전송 방식
- 일반 정보
- 특별한 정보
- 인증
- 쿠키
### [HTTP 헤더2 - 캐시와 조건부 요청](https://github.com/HWON0720/TIL/tree/main/HTTP_basic#http-%ED%97%A4%EB%8D%942---%EC%BA%90%EC%8B%9C%EC%99%80-%EC%A1%B0%EA%B1%B4%EB%B6%80-%EC%9A%94%EC%B2%AD-1)
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
  - API URI 설계
  ```shell
  예)
  
  // 안  예
  회원 목록 조회 /read-member-list
  회원 조회 /read-member-by-id
  회원 등록 /create-member
  회원 수정 /create-member
  회원 삭제 /delete-member
  
  - 가장 중요한 것은 리소스! 여기서 리소스는 회원이라는 개념 자체이므로, 회원이라는 리소스만 식별하면 된다.
    -> 회원 리소스를 URI에 매핑
  
  // 개선된 예 (계층 구조상 상위를 컬렉션으로 보고 복수단어 사용 권장(member -> members))
  회원 목록 조회 /members
  회원 조회 /members/{id}
  회원 등록 /members/{id}
  회원 수정 /members/{id}
  회원 삭제 /members/{id}

  - 단 위의 예시처럼 API 설계 시, 기능별로 구분이 되지 않는다
  - URI는 리소스만 식별하므로, 리소스와 행위를 분리해줘야 한다.
    - 리소스(명사): 회원
    - 행위(동사): 조회, 등록, 삭제, 변경
  ```

- HTTP 메서드 - GET, POST
  - 주요 메서드
    - GET: 리소스 조회
    - POST: 요청 데이터 처리, 주로 등록에 사용
    - PUT: 리소스를 대체, 해당 리소스가 없으면 생성
    - PATCH: 리소스 부분 변경
    - DELETE: 리소스 삭제
  - 기타 메서드
    - HEAD: GET과 동일하지만 메시지 부분을 제외하고, 상태 줄과 헤더만 변환
    - OPTIONS: 대상 리소스에 대한 통신 가능 옵션(메서드)을 설명(주로 CORS에서 사용)
    - CONNECT: 대상 자원으로 식별되는 서버에 대한 터널을 설정
    - TRACE: 대상 리소스에 대한 경로를 따라 메시지 루프백 테스트를 수행
  - GET
    - 리소스 조회
    - 서버에 전달하고 싶은 데이터는 query(쿼리 파라미터, 쿼리 스트링)를 통해서 전달
    - 메시지 바디를 사용해서 데이터를 전달할 수 있지만, 지원하지 않는 곳이 많아서 권장하지 않음
    - 캐싱 이슈로 인해, 데이터 조회 시에는 post보다 get을 주로 사용
  - POST
    - 요청 데이터 처리
    - 메시지 바디를 통해 서버로 요청 데이터 전달
    - 서버는 요청 데이터를 처리
      - 메시지 바디를 통해 들어온 데이터를 처리하는 모든 기능을 수행한다
    - 주로 전달된 데이터로 신규 리소스 등록(생성), 프로세스 처리(요청 데이터 처리)에 사용
- HTTP 메서드 - PUT, PATCH, DELETE
  - PUT
    - 리소스를 대체 (= 덮어쓰기)
      - 리소스가 있으면 대체, 없으면 생성
    - **(중요!) 클라이언트가 리소스를 식별**
      - 클라이언트가 리소스 위치를 알고 URI 지정 (POST와의 차이점)
  - PATCH
    - 리소스 부분 변경
    - patch를 지원하지 않는 서버인 경우, post 사용 가능
  - DELETE
    - 리소스 제거
- HTTP 메서드의 속성
    - 안전 (Safe Methods)
      - 호출해도 리소스를 변경하지 않는다 (리소스만 고려)
    - 멱등 (Idempotent Methods)
      - f(f(x)) = f(x)
      - 똑같은 요청을 했을 때, 한 번 호출하든 두 번 호출하든 100번 호출하든 결과가 동일 (재요청 중간에 외부 요인으로 리소스가 변경되는 것은 고려 X)
      - 멱등 메서드
        - GET: 한 번 조회하든, 두 번 조회하든 같은 결과가 조회됨
        - PUT: 결과를 대체. 따라서, 같은 요청을 여러번 해도 최종 결과는 동일
        - DELETE: 결과를 삭제. 같은 요청을 여러번 해도 삭제된 결과는 동일
        - POST: **멱등 X!** 두 번 호출 시, 같은 결제가 중복해서 발생할 수 있음
    - 캐시가능 (Cacheable Methods)
      - 응답 결과 리소스를 캐시해서 사용해도 되는가?
      - GET, HEAD, POST, PATCH 캐시 가능
      - **BUT!** 실제로는 GET, HEAD 정도만 캐시로 사용
        - POST, PATCH는 본문 내용까지 캐시 키로 고려해야 하는데, 구현이 쉽지 않음

<br>

### HTTP 메서드 활용
- 클라이언트에서 서버로 데이터 전송 (2가지)
  - 쿼리 파라미터를 통한 데이터 전송
    - GET
    - 주로 정렬 필터(검색어)
  - 메시지 바디를 통한 데이터 전송
    - POST, PUT, PATCH
    - 회원 가입, 상품 주문, 리소스 등록, 리소스 변경
  - 예시 (4가지)
    - 정적 데이터 조회 : 쿼리 파라미터 미사용
      - 이미지, 정적 텍스트 문서
    - 동적 데이터 조회 : 쿼리 파라미터 사용
      - 주로 검색, 게시판 목록에서 정렬 필터(검색어)
    - HTML Form을 통한 데이터 전송 : POST 전송 - 저장 `method="post"`, multipart/form-data `enctype="multipart/form-data"`
      - submit 시 POST 전송 (예: 회원 가입, 상품 주문, 데이터 변경)
      - Content-Type: application/x-www-form-urlencoded 사용
        - form의 내용을 메시지 바디를 통해서 전송(key=value, 쿼리 파라미터 형식)
        - 전송 데이터를 url encoding 처리 (예: abc김 -> abc%EA%B9%80)
      - GET 전송도 가능
      - Content-Type: multipart/form-data
        - 파일 업로드 같은 바이너리 데이터 전송 시 사용
        - 다른 종류의 여러 파일과 폼의 내용 함께 전송 가능 (= multipart)
      - GET, POST만 지원
    - HTTP API를 통한 데이터 전송
      - 회원 가입, 상품 주문, 데이터 변경
      - 서버 to 서버
        - 백엔드 시스템 통신
      - 앱 클라이언트
        - 아이폰, 안드로이드
      - 웹 클라이언트(Ajax)
        - HTML에서 Form 전송 대신 자바 스크립트를 통한 통신에 사용(AJAX)
        - 예) React, VueJs 같은 웹 클라이언트와 API 통신
      - POST, PUT, PATCH: 메시지 바디를 통해 데이터 전송
      - GET: 조회, 쿼리 파라미터로 데이터 전달
      - Content-Type: application/json을 주로 사용 (사실상 표준)
        - TEXT, XML, JSON 등
- HTTP API 설계 예시
  - HTTP API - 컬렉션 : POST 기반 등록 (ex. 회원 관리 API 제공)
    - 컬렉션(Collection)
      - 서버가 관리하는 리소스 디렉토리
      - 서버가 리소스의 URI를 생성하고 관리
      - 여기서 컬렉션은 /members
    - 클라이언트는 등록될 리소스의 URI를 모름
    - 서버가 새로 등록된 리소스 URI를 생성
    ```shell
    회원 관리 시스템
    API 설계 - POST 기반 등록

    회원 목록 /members -> GET
    회원 등록 /members -> POST
    회원 조회 /members/{id} -> GET
    회원 수정 /members/{id} -> PATCH, PUT, POST
    회원 삭제 /members/{id} -> DELETE
    ```
  - HTTP API - 스토어 : PUT 기반 등록 (ex. 정적 컨텐츠 관리, 원격 파일 관리)
    - 스토어(Store)
      - 클라이언트가 관리하는 리소스 저장소
      - 클라이언트가 리소스의 URI를 알고 관리
      - 여기서 스토어는 /files
    - 클라이언트가 리소스 URI를 알고 있어야 함
    - 클라이언트가 직접 리소스의 URI를 지정
    ```shell
    파일 관리 시스템
    API 설계 - PUT 기반 등록

    파일 목록 /files -> GET
    파일 조회 /files/{filename} -> GET
    파일 등록 /files/{filename} -> PUT
    파일 삭제 /files/{filename} -> DELETE
    파일 대량 등록 /files -> POST
    ```
  - HTML FORM 사용 (순수 HTML + HTML Form 用)
    - 웹 페이지 회원 관리
    - GET, POST 만 지원
    - AJAX 같은 기술을 사용해서 해결 가능
    - 여기서는 순수 HTML, HTML FORM 이야기
    - 컨트롤 URI
      - POST의 /new, /edit, /delete 등
      - GET, POST만 지원하므로 제약 有
      - 이런 제약을 해결하기 위해 동사로 된 리소스 경로 사용
      - HTTP 메서드로 해결하기 애매한 경우 사용(HTTP API 포함)
    ```shell
    회원 목록 /members -> GET
    회원 등록 폼 /memebrs/new -> GET
    회원 등록 /members/new, /members -> POST
    회원 조회 /members/{id} -> GET
    회원 수정 폼 /members/{id}/edit -> GET
    회원 수정 /members/{id}/edit, /members/{id} -> POST
    회원 삭제 /members/{id}/delete -> POST
    ```

  + 참고하면 좋은 URI 설계 개념
  - 문서(document)
    - 단일 개념(파일 하나, 객체 인스턴스, 데이터베이스 row)
    - ex. /members/100, /files/star.jpg
  - 컬렉션(colleciton)
    - 서버가 관리하는 리소스 디렉터리
    - 서버가 리소스의 URI를 생성하고 관리
    - ex. /members
  - 스토어(store)
    - 클라이언트가 관리하는 자원 저장소
    - 클라이언트가 리소스의 URI를 알고 관리
    - ex. /files
  - 컨트롤러(controller), 컨트롤 URI
    - 문서, 컬렉션, 스토어로 해결하기 어려운 추가 프로세스 실행
    - 동사를 직접 사용
    - ex. /members/{id}/delete

<br>

### HTTP 상태코드
- HTTP 상태코드 소개
  - 상태코드란? 클라이언트가 보낸 요청의 처리 상태를 응답에서 알려주는 기능
    - `1xx (Informational)`: 요청이 수신되어 처리 중 (거의 사용 X)
    - `2xx (Successful)`: 요청 정상 처리
    - `3xx (Redirection)`: 요청을 완료하려면 추가 행동이 필요
    - `4xx (Client Error)`: 클라이언트 오류, 잘못된 문법 등으로 서버가 요청을 수행할 수 없음
    - `5xx (Server Error)`: 서버 오류, 서버가 정상 요청을 처리하지 못함
- `2xx` - 성공
  - `200` OK: 요청 성공
  - `201` Created: 요청 성공해서 새로운 리소스가 생성됨
  - `202` Accepted: 요청이 접수되었으나 처리가 완료되지 않았음
  - `204` No Content: 서버가 요청을 성공적으로 수행했지만, 응답 페이로드 본문에 보낼 데이터가 없음
- `3xx` - 리다이렉션
  - 리다이렉트란? 웹 브라우저가 3xx 응답의 결과에 Location 헤더가 있으면, Location 위치로 자동 이동하는 것
  - `300` Multiple Choices: 거의 사용 X
  - `301` Moved Permanently: 리다이렉트 시, 요청 메서드가 GET으로 변하고, 본문이 제거될 수 있음 (MAY)
  - `302` Found: 리다이렉트 시, 요청 메서드가 GET으로 변하고, 본문이 제거될 수 있음 (MAY)
  - `303` See Other: 리다이렉트 시, 요청 메서드가 GET으로 변경 ≒ `302`와 기능은 같음
  - `304` Not Modified: 응답에 메시지 바디를 포함하면 안 됨 (로컬 캐시를 사용해야 하므로)
  - `307` Temporary Redirect: 리다이렉트 시, 요청 메서드와 본문 유지(요청 메서드를 변경하면 안 됨. MUST NOT) ≒ `302`
  - `308` Permanent Redirect: 리다이렉트 시, 요청 메서드와 본문 유지(처음 POST를 보내면 리다이렉트도 유지) ≒ `301`
  - 영구 리다이렉션 `301`, `308`
    - 리소스의 URI가 영구적으로 이동
    - 원래의 URL를 사용 X, 검색 엔진 등에서도 변경 인지
  - 일시적인 리다이렉션 `302`, `307`, `303`
    - 리소스의 URI가 일시적으로 변경
    - 따라서 검색 엔진 등에서 URL을 변경하면 안 됨
  - 기타 리다이렉션 `300`, `304`
    - 캐시를 목적으로 사용
    - 클라이언트에게 리소스가 수정되지 않았음을 알려줌. 따라서, 클라이언트는 로컬 PC에 저장된 캐시를 재사용 (캐시로 리다이렉트한다)
    - 조건부 GET, HEAD 요청 시 사용
- `4xx` - 클라이언트 오류, 5xx - 서버 오류
  - `400` Bad Request: 클라이언트가 잘못된 요청을 해서 서버가 요청을 처리할 수 없음
    - 요청 구문, 메시지 등등 오류
    - 클라이언트는 요청 내용을 다시 검토하고, 보내야 함
    - 예) 요청 파라미터가 잘못되거나, API 스펙이 맞지 않을 때
  - `401` Unauthorized: 클라이언트가 해당 리소스에 대한 인증이 필요함
    - 인증(Authentication)되지 않음
    - 401 오류 발생 시, 응답에 WWW-Authenticate 헤더와 함께 인증 방법을 설명
    - 참고
      - 인증(Authentication): 본인이 누구인지 확인 (로그인)
      - 인가(Authorization): 권한부여 (ADMIN 권한처럼 특정 리소스에 접근할 수 있는 권한, 인증이 있어야 인가가 있음)
  - `403` Forbidden: 서버가 요청을 이해했지만 승인을 거부함
    - 주로 인증 자격 증명은 있지만, 접근 권한이 불충분한 경우
    - 예) ADMIN 등급이 아닌 사용자가 로그인은 했지만, ADMIN 등급의 리소스에 접근하는 경우
  - `404` Not Found: 요청 리소스를 찾을 수 없음
    - 요청 리소스가 서버에 없음
    - 또는 클라이언트가 권한이 부족한 리소스에 접근할 때 해당 리소스를 숨기고 싶을 때
  - 클라이언트 오류 `4xx`
    - 클라이언트의 요청에 잘못된 문법 등으로 서버가 요청을 수행할 수 없음
    - **오류의 원인이 클라이언트에 있음**
    - **중요!** 클라이언트가 이미 잘못된 요청(= 데이터)을 보내고 있기 때문에, 똑같은 재시도가 실패함
  - `500` Internal Server Error: 서버 문제로 오류 발생
    - 서버 내부 문제로 오류 발생
    - 애매하면 500 오류
  - `503` Service Unavailable: 서비스 이용 불가
    - 서버가 일시적인 과부하 또는 예정된 작업으로 잠시 요청을 처리할 수 없음
    - Retry-After 헤더 필드로 얼마 뒤에 복구되는지 보낼 수도 있음
  - 서버 오류 `5xx`
    - 서버 문제로 오류 발생
    - 서버에 문제가 있기 때문에 재시도하면 성공할 수도 있음 (복구가 되는 등)

<br>

### HTTP 헤더1 - 일반 헤더
- HTTP 헤더 개요
  - 용도
    - HTTP 전송에 필요한 모든 부가정보 (ex. 메시지 바디의 내용/크기, 압축, 인증, 요청 클라이언트, 서버 정보, 캐시 관리 정보 등)
    - 필요 시 임의의 헤더 추가 가능 (ex. hellowrld: hihi)
  - HTTP BODY : message body
    - 1999년 RFC2616
      - message body는 entity body를 전달하는데 사용
      - Entity body는 요청이나 응답에서 전달할 실제 데이터 (`<html><body>...</body></html>`)
      - 엔티티 헤더는 엔티티 본문의 데이터를 해석할 수 있는 정보\[데이터 유형(html, json), 데이터 길이, 압축 정보 등] 제공
    - 2014년 RFC7230~7235
      - 엔티티(Entity) -> 표현(Representation)
      - 표현 = 표현 메타데이터 + 표현 데이터 (Representation = representation Metadata + Representation Data)
      - message body(payload)를 통해 표현 데이터 전달
      - **표현**은 요청이나 응답에서 전달할 실제 데이터
      - **표현 헤더는 표현 데이터**를 해석핧 수 있는 정보\[데이터 유형(html, json), 데이터 길이, 압축 정보 등] 제공
- 표현
  - 표현 헤더는 전송, 응답 둘 다 用
  - Content-Type: 표현 데이터의 형식 (ex. text/html;charset=utf-8, application/json, image/png)
    - 미디어 타입, 문자 인코딩
  - Content-Encoding: 표현 데이터의 압축 방식 (ex. gzip, deflate, identity)
    - 표현 데이터를 압축하기 위해 사용
    - 데이터를 전달하는 곳에서 압축 후 인코딩 헤더 추가
    - 데이터를 읽는 쪽에서 인코딩 헤더의 정보로 압축 해제
  - Content-Language: 표현 데이터의 자연 언어 (ex. ko, en, en-US)
    - 표현 데이터의 자연 언어를 표현
  - Content-Length: 표현 데이터의 길이
    - byte 단위
    - Transfer-Encoding(전송 코딩)을 사용하면 Content-Length를 사용하면 안 됨
- 콘텐츠 협상
  - 클라이언트가 선호하는 표현 요청
  - 협상 헤더는 요청 시에만 사용
  - Accept: 클라이언트가 선호하는 미디어 타입 전달
  - Accept-Charset: 클라이언트가 선호하는 문자 인코딩
  - Accept-Encoding: 클라이언트가 선호하는 압축 인코딩
  - Accept-Language: 클라이언트가 선호하는 자연 언어
- 전송 방식
  - 단순 전송(Content-Length)
  - 압축 전송(Content-Encoding)
  - 분할 전송(Transfer-Encoding)
  - 범위 전송(Range, Content-Range): 범위를 지정해서 전송
- 일반 정보
  - From: 유저 에이전트의 이메일 정보
    - 일반적으로 잘 사용되지 않음
    - 검색 엔진 같은 곳에서, 주로 사용
    - 요청에서 사용
  - Referer: 이전 웹 페이지 주소
    - 현재 요청된 페이지의 이전 웹 페이지 주소
    - A -> B로 이동하는 경우 B를 요청할 때 Referer: A를 포함해서 요청
    - Referer를 사용해서 유입 경로 분석 가능
    - 요청에서 사용
  - User-Agent: 유저 에이전트 애플리케이션 정보
    - 클라이언트의 애플리케이션 정보(웹 브라우저 정보 등)
    - 통계 정보
    - 어떤 종류의 브라우저에서 장애가 발생하는지 파악 가능
    - 요청에서 사용
  - Server: 요청을 처리하는 ORIGIN 서버의 소프트웨어 정보
    - server: nginx
    - 응답에서 사용
  - Date: 메시지가 생성된 날짜
    - 응답에서 사용
- 특별한 정보
  - Host: 요청한 호스트 정보(도메인)
    - 요청에서 사용
    - 필수 값
    - 하나의 서버가 여러 도메인을 처리해야 할 때
    - 하나의 IP 주소에 여러 도메인이 적용되어 있을 때
  - Location: 페이지 리다이렉션
    - [상태 코드 설명 참조](https://github.com/HWON0720/TIL/tree/main/HTTP_basic#http-%EC%83%81%ED%83%9C%EC%BD%94%EB%93%9C-1)
  - Allow: 허용 가능한 HTTP 메서드
    - 405(Method Not Allowed)에서 응답에 포함해야 함
    - Allow: GET, HEAD, PUT
  - Retry-After: 유저 에이전트가 다음 요청을 하기까지 기다려야 하는 시간
    - 503(Service Unavailable): 서비스가 언제까지 불능인지 알려줄 수 있음
- 인증
  - Authorization: 클라이언트 인증 정보를 서버에 전달
  - WWW-Authenticate: 리소스 접근 시 필요한 인증 방법 정의 (401 Unauthorized 응답과 함께 用)
- 쿠키
  - Set-Cookie: 서버에서 클라이언트로 쿠키 전달(응답)
  - Cookie: 클라이언트가 서버에서 받은 쿠키를 저장하고, HTTP 요청 시 서버로 전달
  - 사용처
    - 사용자 로그인 세션 관리
    - 광고 정보 트래킹
  - 쿠키 정보는 항상 서버에 전송됨
    - 네트워크 트래픽 추가 유발
    - 최소한의 정보만 사용(세션 id, 인증 토큰)
    - 서버에 전송하지 않고, 웹 브라우저 내부에 데이터를 저장하고 싶으면 웹 스토리지(localStorage, sessionStorage) 참고
  - **주의!**
    - 보안에 민감한 데이터는 저장하면 안 됨 (ex. 주민번호, 신용카드 번호 등)
  - 생명주기: Expires, max-age
    - `Set-Cookie: expires= 날짜 입력`: 만료일이 되면 쿠키 삭제
    - `Set-Cookie: max-age= 초 단위 숫자 입력`: 0이나 음수를 지정하면 쿠키 삭제
    - 세션 쿠키: 만료 날짜를 생략하면 브라우저 종료 시까지만 유지
    - 영속 쿠키: 만료 날짜를 입력하면 해당 날짜까지 유지
  - 도메인 (domain=example.org)
    - 명시: 명시한 문서 기준 도메인 + 서브 도메인 포함
    ```shell
    domain=example.org를 지정해서 쿠키 생성
      - example.org와 dev.example.org 모두 쿠키 접근 可
    ```
    - 생략: 현재 문서 기준 도메인만 적용
    ```shell
    example.org에서 쿠키를 생성하고, domain 지정을 생략
      - example.org에서만 쿠키 접근 可
      - dev.example.org에서는 쿠키 접근 不可
    ```
  - 경로 (path=/home)
    - 이 경로를 포함한 하위 경로 페이지만 쿠키 접근
    - 일반적으로 `path=/` 루트로 지정
  - 보안
    - Secure
      - 쿠키는 http, https를 구분하지 않고 전송
      - 적용 시, https인 경우에만 전송
    - HttpOnly
      - XSS 공격 방지
      - 자바스크립트에서 접근 불가(document.cookie)
      - HTTP 전송에만 用
    - SameSite
      - XSRF 공격 방지
      - 요청 도메인과 쿠키에 설정된 도메인이 같은 경우만 쿠키 전송

<br>

### HTTP 헤더2 - 캐시와 조건부 요청
- 캐시 기본 동작
  - 캐시 적용
    - 캐시 가능 시간 동안 네트웜크를 사용하지 않아도 됨
    - 네트워크 사용량을 줄일 수 있음 (= 비용 감소)
    - 브라우저 로딩 속도 향상
    - 빠른 사용자 경험
  - 캐시 시간 초과
    - 캐시 유효 시간 초과 시, 서버를 통해 데이터를 재조회하고, 캐시를 갱신
    - 이 때, 다시 네트워크 다운로드 발생
- 검증 헤더와 조건부 요청1
    - 캐시 시간 초과로 서버에 재요청 시, 2가지 상황 발생
      - 서버에서 기존 데이터를 변경
      - 서버에서 기존 데이터를 변경 x
      - 데이터를 처음부터 끝까지 다시 전송하는 대신, 저장해두었던 캐시를 재사용하기 위해 검증헤더와 조건부 요청 用
      - 단, 클라이언트의 데이터와 서버의 데이터가 같다는 사실을 확인할 수 있는 방법 필요
    - 정리
      - 캐시 유효 시간이 초과해도, 서버의 데이터가 갱신되지 않으면 `304` Not Modified + 헤더 메타 정보만 응담 (바디 X)
      - 클라이언트는 서버가 보낸 응답 헤더 정보로 캐시의 메타 정보를 갱신
      - 클라이언트는 캐시에 저장되어 있는 데이터 재활용
      - 결과적으로 네트워크 다운로드가 발생하지만 용량이 적은 헤더 정보만 다운로드
      - 매우 실용적인 해결책
- 검증 헤더와 조건부 요청2
  - 검증 헤더
    - 캐시 데이터와 서버 데이터가 같은지 검증하는 데이터
    - Last-Modified, ETag
  - 조건부 요청 헤더
    - 검증 헤더로 조건에 따른 분기
    - If-Modified-Since: Last-Modified 사용
    - If-None-Match: ETag 사용
    - 조건이 만족하면 `200` OK
    - 조건이 만족하지 않으면 `304` Not Modified
  - Last-Modified, If-Modified-Since 단점
    - 1초 미만(0.x초) 단위로 캐시 조정 불가능
    - 날짜 기반의 정해진 로직 사용
    - 같은 데이터를 수정해서 날짜는 다르지만 데이터 결과가 똑같은 경우에도 전체 데이터를 다시 다운로드함
    - 서버에서 별도의 캐시 로직을 관리하고 싶은 경우에도 완전하게 컨트롤할 수 없음
  - ETag(Entity Tag), If-None-Match
    - 캐시용 데이터에 임의의 고유한 버전 이름을 달아둠 (`ETag: `)
    - 데이터가 변경되면 이 이름을 바꾸어서 변경함 (Hash를 다시 생성)
    - 이를 통해, Last-Modified, If-Modified-Since의 단점 보완 가능 -> **캐시 제어 로직을 서버에서 완전히 관리**
    - ETag만 서버에 보내서 같으면 유지, 다르면 다시 받는다
- 캐시와 조건부 요청 헤더
  - 캐시 제어 헤더
    - Cache-Control: 캐시 제어
      - Cache-Control: max-age
        - 캐시 유효 시간, 초 단위
      - Cache-Control: no-cache
        - 데이터는 캐시해도 되지만, 항상 원(origin) 서버에 검증하고 사용
      - Cache-Control: no-store
        - 데이터에 민감한 정보가 있으므로 저장하면 안 됨 (메모리에서 사용하고 최대한 빨리 삭제)
    - Pragma: 캐시 제어(하위 호환)
      - Pragma: no-cache
      - HTTP 1.0 하위 호환
    - Expires: 캐시 유효 기간(하위 호환)
      - expires: 날짜 임력
      - 캐시 만료일을 정확한 날짜로 지정
      - HTTP 1.0부터 사용
      - 더 유연한 Cache-Control: max-age를 권장 (Cache-Control: max-age 사용 시, Expires는 무시)
- 프록시 캐시
  - Cache-Control: public
    - 응답이 public 캐시에 저장되어도 됨
  - Cache-Control: private
    - 응답이 해당 사용자만을 위한 것이므로, private 캐시에 저장해야 함 (기본값)
  - Cache-Control: s-maxage
    - 프록시 캐시에만 적용되는 max-age
  - Age: 60 (HTTP 헤더)
    - ORIGIN 서버에서 응답 후 프록시 캐시 내에 머문 시간(초)
- 캐시 무효화 (확실한 캐시 무효화 응답)
  - Cache-Control: no-cache
    - 데이터는 캐시해도 되지만, 항상 **ORIGIN 서버에 검증**하고 사용 (이름에 주의!)
  - Cache-Control: no-store
    - 데이터에 민감한 정보가 있으므로 저장하면 안 됨 (메모리에서 사용하고 최대한 빨리 삭제)
  - Cache-Control: must-revalidate
    - 캐시 만료 후 최초 조회 시 **ORIGIN 서버에 검증**해야 함
    - ORIGIN 서버 접근 실패 시 반드시 오류가 발생해야 함 -> `504` Gateway Timeout
    - must-revalidate는 캐시 유효 시간이라면 캐시를 사용함
  - Pragma: no-cache
    - HTTP 1.0 하위 호환
