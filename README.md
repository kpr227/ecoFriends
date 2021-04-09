<h1 align="center" >eco Friend - 친환경 쇼핑몰 </h1>

<p align="center">
 <img src="https://user-images.githubusercontent.com/79494725/114126441-64e45700-9933-11eb-9083-5446ab3c8bf9.png" width="50%" height="50%">
</p>

 ***
### 주제선정 이유
* 환경오염 문제 / 폐기물 처리문제
* 친환경 제품 사용률 저하
* 친환경 제품 사용율을 높여 환경오염을 최소화

### 프로젝트 설명
*  친환경 제품을 판매하는 쇼핑몰
*  게임적 요소를 통한 제품 판매 촉진과 친환경활동(나무심기) 추진

### 프로젝트 기간
* 2021-02-22~2021-03-19 (25일)

### 학습목표
* 교육과정 내용 활용
* 현업에서 사용하는 기술 경험
* 다양한 시행착오를 통한 스터디

### 개발환경
* Java jdk 1.8
* Mybaris 3.5 mybatis-spring
* BootStrap 4
* React
* spring Rest API -ajax
* servlet / JSP Servlet 4.0
* Spring Framwork(AOP, MVC) v5.2.13
  * Spring tx
  * Spring security
* Amazon Web Services
  * Oracle DataBase 12c 기준
  * SQL - 저장공간 구성
* crawling

### 구성인원(5인)
* 김푸름 / 이지윤 / 신동우 / 정은경 / 이정연

### 사용언어
* Java
* JavaScript
* jQuery
* HTML
* CSS
* php

### ERD설계도
<img src="https://user-images.githubusercontent.com/79494725/114125840-34e88400-9932-11eb-8b5a-188c9f72fc44.jpg" width="50%" height="50%">

***

### 본인역할
* 로그인 
* 회원가입 
* 내정보
* 관리자(회원관리)

<details>
  <summary>로그인</summary>
  <div markdown="1">
  <img src="https://user-images.githubusercontent.com/79494725/114142268-b8639e80-994d-11eb-93bc-ad2709157a88.png" width="50%" height="60%">   
  </div>
</details>

* [security 라이브러리](https://github.com/kpr227/ecoFriends/blob/main/pom.xml) 사용
* [로그인 성공 Handler](https://github.com/kpr227/ecoFriends/blob/main/src/main/java/com/goott/eco/security/CustomLoginSuccessHandler.java) 구성 - 이전페이지로 이동
* [로그인 실패 Handler](https://github.com/kpr227/ecoFriends/blob/main/src/main/java/com/goott/eco/security/CustLoginFailHandler.java) 구성 - 실패에따른 메세지 호출
* [로그인 페이지](https://github.com/kpr227/ecoFriends/blob/main/src/main/java/com/goott/eco/config/SecurityConfig.java) - 인증되지 않은 사용자만 가능

```
/* Authentication */
@Override
public void configure(HttpSecurity http) throws Exception{
  http.authorizeRequests()
      .antMatchers("/home/login").anonymous();
```

<details>
<summary>회원가입</summary>
  <div markdown="1">
  <img src="https://user-images.githubusercontent.com/79494725/114146197-43df2e80-9952-11eb-8353-ec1ef1406f2a.png" width="60%" height="70%">   
  </div>
</details>

* 회원가입 페이지 - 인증되지 않은 사용자만 가능 [security 이동](https://github.com/kpr227/ecoFriends/blob/main/src/main/java/com/goott/eco/config/SecurityConfig.java)

```
/* Authentication */
@Override
public void configure(HttpSecurity http) throws Exception{
  http.authorizeRequests()
      .antMatchers("/home/register").anonymous();
```

* 일반 사용자 와 업체로 나뉨 
  * 업체일경우 하단에 "사업장 이름"과 "사업장 번호" 추가
* Ajax를 이용하여 id중복검사 / 비밀번호 확인 / 핸드폰 번호 유효성 검사를 실행했을 시 3가지 모두 완료되면 버튼 활성화
* 카카오 우편주소 API 사용
* [링크이동](https://github.com/kpr227/ecoFriends/blob/main/src/main/webapp/WEB-INF/views/home/register.jsp)
  * 업체 항복(company) / 유효성검사 api / 업체 선택


<details>
<summary>내정보</summary>
  <div markdown="1">
  <img src="https://user-images.githubusercontent.com/79494725/114149676-214f1480-9956-11eb-8300-c79d3ad703da.png" alt="text" width="50%"><br/>
   ※ 왼쪽 상단의 네비게이터 ( 사용자 / 업체 / 관리자 ) 
   
  | 사용자 | 업체 | 관리자 |
  |--------|------|-------|
  |  <img src="https://user-images.githubusercontent.com/79494725/114152379-30839180-9959-11eb-8dbb-c81d5a63d4cd.png"> | <img src="https://user-images.githubusercontent.com/79494725/114152396-37120900-9959-11eb-8053-bd251be42b85.png"> | <img src="https://user-images.githubusercontent.com/79494725/114152507-590b8b80-9959-11eb-9ec6-8cf36117dd78.png">
  
   ※ 내정보( 사용자 / 업체 ) 
   
  | 사용자 / 관리자 |      업체      |
  |----------------|----------------|
  |  <img src="https://user-images.githubusercontent.com/79494725/114149243-a980ea00-9955-11eb-9651-41b97d3aba87.png"> | <img src="https://user-images.githubusercontent.com/79494725/114149322-bd2c5080-9955-11eb-8102-3b87739af231.png"> |
   
  </div>
</details>


* 내정보 페이지 - 인증된 사용자만 가능 [security 이동](https://github.com/kpr227/ecoFriends/blob/main/src/main/java/com/goott/eco/config/SecurityConfig.java)
```
/* Authentication */
@Override
public void configure(HttpSecurity http) throws Exception{
  http.authorizeRequests()
      .antMatchers("/cust/my-account").authenticated();
```
* 내정보 선택시 비밀번호 확인 후 Ajax를 사용하여 자신의 정보 출력
* 사용자의 권한에 따라 왼쪽상단의 네비게이터 및 사용기능이 다름
```
 <sec:authorize access="hasAuthority('ROLE_COMPANY')">
    <a class="nav-link" id="payment-nav" data-toggle="pill" href="#payment-tab" role="tab"><i class="fa fa-credit-card"></i> 배송정보입력(업체)</a>
 </sec:authorize>
    <a class="nav-link active" id="orders-nav" data-toggle="pill" href="#orders-tab" role="tab"><i class="fa fa-shopping-bag"></i> 주문정보</a>
 <sec:authorize access="hasAuthority('ROLE_COMPANY')">
    <a class="nav-link" id="goods-ins-nav" data-toggle="pill" href="#goods-ins-tab" role="tab"><i class="fa fa-shopping-bag"></i>상품등록</a>
 </sec:authorize>
    <a class="nav-link" id="account-nav" data-toggle="pill" href="#account-tab" role="tab"><i class="fa fa-user"></i> 내정보</a>
 <sec:authorize access="hasAuthority('ROLE_ADMIN')">
    <a class="nav-link" href="http://172.16.5.1:3000/" ><i class="fa fa-map-marker-alt"></i> 차트보기</a>
    <a class="nav-link" id="member-nav" data-toggle="pill" href="#member-tab" role="tab"><i class="fa fa-user"></i> 사용자 관리 </a>
 </sec:authorize>
 <a class="nav-link logoutBtn"><i class="fa fa-sign-out-alt"></i>Logout</a>
 <form action="/sample/logout", method="post" class="logoutForm">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
 </form>
```
* 비밀번호 변경하지 않을 경우 공백으로 남겨두면 수정될 정보들만 Ajax를 사용하여 수정


<details>
<summary>관리자 (회원관리)</summary>
  <div markdown="1">

  | 사용자  | 업체 | 관리자 |
  |--------|------|--------|
  |  <img src="https://user-images.githubusercontent.com/79494725/114156640-c15c6c00-995d-11eb-8fa8-a6c838ad17ec.png"> | <img src="https://user-images.githubusercontent.com/79494725/114156652-c4575c80-995d-11eb-9964-94a90b5bef57.png"> | <img src="https://user-images.githubusercontent.com/79494725/114156666-c6b9b680-995d-11eb-81cd-c0881e98c8a5.png"> |
  | <img src="https://user-images.githubusercontent.com/79494725/114156877-fec0f980-995d-11eb-9b70-5a9d7977ca3c.png"> | <img src="https://user-images.githubusercontent.com/79494725/114156894-02548080-995e-11eb-8c63-eb5727bf70d8.png"> | <img src="https://user-images.githubusercontent.com/79494725/114156898-0385ad80-995e-11eb-9034-9c011c38261b.png">|
  </div>
</details>

* 관리자 페이지 - 관리자권한이 있는 사용자만 가능
```
 <sec:authorize access="hasAuthority('ROLE_ADMIN')">
    <a class="nav-link" href="http://172.16.5.1:3000/" ><i class="fa fa-map-marker-alt"></i> 차트보기</a>
    <a class="nav-link" id="member-nav" data-toggle="pill" href="#member-tab" role="tab"><i class="fa fa-user"></i> 사용자 관리 </a>
 </sec:authorize>
```
* 사용자 / 업체 / 관리자 선택시 Ajax를 이용한 데이터 출력 및 수정
* [inner join을 통해 resultMap으로 관리자가 원하는 정보를 한번에 출력](https://github.com/kpr227/ecoFriends/blob/main/src/main/resources/com/goott/eco/mapper/AdminMapper.xml)
* 사용자 선택
   * 상세보기 - 사용자 정보 확인 및 일반 사용자가 수정불가한 항목 수정 가능
   * 관리자 등업 - 등업 선택시 레벨3 신입 관리자로 권한 부여
* 업체 선택
   * 상세보기 - 업체 정보 확인 및 업체가 수정불가한 항목 수정 가능
   * 승인 - 업체승인시 업체 권한 부여
* 관리자 선택
   * 상세보기 - 관리자 정보 확인 및 사용자가 수정 불가한 항목 수정 가능
   * 관리자 레벨 - 레벨1 / 레벨2/ 레벨3 으로 수정가능
