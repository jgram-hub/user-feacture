
# user-feacture

일반사용자랑 관리자유저가 있으며,
* 관리자 api는 관리자유저만 사용가능
* 나의정보는 로그인상태인 유저만 사용가능합니다
* 요구사항에 추가로 팍팍넣었습니다.
**메일(원격배포)만발송되고, SMS발송안됨!**
**사용자생성 및 수정시 SMS인증여부는 체크안하고 메일만체크**


## Feature
* 로그인
  - 로그인성공시 accessToken 발급
* 회원가입
  - 내부적으로 핸드폰, 전화번호 중복체크 및 인증확인여부 체크 후 등록
* 회원가입 핸드폰, 전화번호 발송 및 인증
* 회원가입 핸드폰, 전화번호 중복확인
* 나의 정보 조회
  - 본인정보만 확인가능 토큰전달시
* 나의 정보 수정
  - 본인정보만 수정가능 토큰전달시
  - 이메일, 핸드폰 변경시 인증여부 및 중복여부확인
* 나의 비밀번호 변경
* 나의정보 핸드폰, 전화번호 발송 및 인증
* 나의정보 핸드폰, 전화번호 중복확인
  - 본인 핸드폰, 전화번호 아닐시에만 중복체크
* 아이디 찾기 이메일, 전화번호 발송 및 인증
  - 발송후 인증번호, 인증이메일 또는 전화번호 받아서 아이디 조회
* 비밀번호 찾기 이메일, 전화번호 발송 및 인증
  - 발송후 인증번호, 인증이메일 또는 전화번호 받아서 인증키값 조회
* 비밀번호 찾기 후 비밀번호 재설정
  - 인증키 + 인증시 이메일 또는 전화번호 + 패스워드 + 유저아이디 등으로 변경가능
* 관리자 사용자 목록 및 단일 조회
* 관리자 핸드폰, 전화번호 중복확인
* 관리자 핸드폰, 전화번호 발송 및 인증
* 관리자 사용자 생성, 수정, 삭제
  - 관리자권한유저만 사용가능


## Skill
* Java11 : lts버전인 11버전 선택 등
* H2 : 인메모리 db사용
* Swagger : apidocs 필요로 인해 추가
* JPA : 도메인 성향및 flyway처럼 ddl 자동생성
* Hibernate - jpa 프레임워크
* Querydsl - 동적쿼리 타입세이프를 위해 사용
* Jwt - 무상태성 값내장형 토큰 사용
* Spring Data Jpa - jpql 쿼리 지원
* Spring Security - 보안적인 업그레이드로 
* Spring Boot
* Java Mail - 이메일인증시 필요
* Bean Validation - api 유효성
* Lombok - 보일러플레이드코드 제너레이터기능을 위해사용
* Jackson
* Heroku - 간단한 원격배포

## 주의사항
* 전화번호는 발송안됩니다, 이메일(원격배포)은 실제로 발송되고있습니다
* 기본적으로 들어간 계정정보입니다.<br>
  **관리자계정 - 아이디: 1000, 비번: admin
  일반계정 - 아이디: 1001, 비번: user**

## ERD

### USERS
USER_ID: 사용자아이디
PASSWORD: 패스워드
NICKNAME: 닉네임
NAME: 이름
EMAIL: 이메일
PHONE_NUMBER: 핸드폰번호
ROLE_TYPE: 역할유형
ENABLED: 활성여부
CREATED_AT: 등록일시
CREATED_BY: 등록자
UPDATED_AT: 갱신일시
UPDATED_BY: 갱신자

### VERIFY
VERIFY_ID: 인증아이디
VERIFY_USAGE: 인증용도
VERIFY_TYPE: 인증유형
VERIFY_TYPE_VALUE: 인증유형값
VERIFY_NUMBER: 인증번호
VERIFIED: 인증여부
CREATED_AT: 등록일시
UPDATED_AT: 갱신일시
  
* jwt 설정
* 이메일, 전화번호에 따른 전략패턴 도입
등등 
