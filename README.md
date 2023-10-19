# 프리온보딩 백엔드 인턴십 선발과제

## 개요

### 1 프로젝트 소개

- 원티드 프리온보딩 백엔드 인턴십 선발과제
- 채용공고 관리 및 지원에 대한 API CRUD 기능

### 2. 개발 환경

- JDK 11
- Framework : Spring Boot (2.x)
- Database : MySQL 8.0
- ORM : JPA

### 3. 디렉토리 구조

<details>
<summary>여기를 눌러주세요</summary>
<div markdown="1">   
  
![directory](https://github.com/yongbeomj/wanted-pre-onboarding-backend/assets/87436495/45f0d130-c726-48f1-9bfb-e6d3f3c28a65)


</div>
</details>

## ERD
<details>
<summary>여기를 눌러주세요</summary>
<div markdown="1">   
  
![erd](https://github.com/yongbeomj/wanted-pre-onboarding-backend/assets/87436495/5fb41179-e8a0-4df6-8e14-2be1ec950723)


</div>
</details>

## API 설계
- API URL을 공통으로 사용하고 HTTP Method로 기능을 파악할 수 있도록 설계
- 명세서 : https://documenter.getpostman.com/view/19637355/2s9YR85u5o

## 요구사항 분석 및 기능 구현

### 0. 사전 조건
- 회사, 사용자 등록 절차 생략 (DB에 데이터 임의 생성 후 진행)
- 사용자 인증 절차 생략

### 1. 채용공고 등록 API
  - validation 진행 (회사 데이터 존재여부 확인)
  - validation 통과 시 채용공고 테이블에 저장 및 성공 response return

### 2. 채용공고 수정 API
- 조건 :
  - 회사 ID 외 파라미터는 선택적으로 수정 가능
  - 수정 가능한 파라미터는 총 4개로 설정 (position, reward, content, skill)
- 구현과정 : 
    - path variable로 전달받은 채용공고 ID로 채용공고 검색
    - validation 진행 (채용공고 존재 여부 확인)
    - validation 통과 시 parameter를 체크하여 데이터를 다시 저장

### 3. 채용공고 삭제 API
- path variable로 전달받은 채용공고 ID로 채용공고 검색
- validation 진행 (채용공고 존재 여부 확인)
- validation 통과 시 해당 채용공고 삭제

### 4. 채용공고 전체 조회 API
- 조건 :
  - 전체 목록 조회 가능
  - 키워드 검색 시 다중 검색 가능 (적용 파라미터 : 회사명, 채용포지션, 사용기술)
- 구현과정 :
  - 키워드 입력 여부로 전체 조회와 키워드 검색 조회를 구분
  - 전체 조회 시 : findAll() 메소드로 검색 후 return
  - 키워드 검색 시 : JPQL로 조회하는 searchByKeyword() 메소드를 별도 생성하여 조건 검색 후 return 

### 5. 채용공고 상세 조회 API
- 조건 :
  - "채용내용"이 추가로 담겨있음
  - 회사가 올린 다른 채용공고 데이터 조회 데이터에 포함
- 구현과정 :
  - path variable로 전달받은 채용공고 ID로 채용공고 검색
  - validation 진행 (채용공고 존재 여부 확인)
  - validation 통과 시 해당 채용공고 회사 ID와 동일한 다른 채용공고 조회 후 return

### 6. 채용공고 지원 API
- 조건 : 유저는 1회만 지원 가능
- 구현과정 :
  - 입력받은 채용공고 ID, 유저 ID로 1차 validation 진행 (채용공고, 사용자 데이터 존재여부 확인)
  - 1차 validation 통과 시 2차 validation 진행 (유저 복수 지원 여부 확인)
  - 2차 validation 통과 시 입력 데이터 application table에 저장

### 7. 기타사항
- 공통 Response Format 구현
```
// 등록, 삭제 성공 return
{
  "code": "000",
  "message": "success"
}
```
```
// 수정, 조회 성공 return
{
    "code": "000",
    "message": "success",
    "data": {
        "jobId": 1,
        "position": "Spring 백엔드 개발자",
        ...
    }
}
```
```
// 에러 return
{
    "code": "999",
    "message": "Unable to find com.wanted.preonboarding.domain.JobOpening with id 9"
}
```
