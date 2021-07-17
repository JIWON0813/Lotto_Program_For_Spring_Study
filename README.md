#TDD 및 스프링 구조를 학습하기 위한 로또번호 생성 프로그램

목표
1) TDD(테스트 주도 개발) 방식 이해 및 적용
2) 스프링 구조(내부 구현) 이해
3) JPA 동작 방식, 개념 

<br><br><br>
><h1>1. gettest컨트롤러 만들어 연결되는지 테스트</h1>
<h2>개발 목적</h2>
컨트롤러 생성 <br>
SpringBootApplication 이해<br>

<h2>에러 내역</h2>
Error creating bean with name 'inMemoryDatabaseShutdownExecutor'<br>
<h2>이유</h2>
DataSource를 따로 설정해두지 않았는데 자동으로 빈을 등록하려고 해서 생기는 문제<br>
<h2>해결</h2>
@SpringBootApplication에 (exclude = DataSourceAutoConfiguration.class) 추가 (자동 설정 제거)<br>
<br>
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)

<h2>결과</h2>

![1](./image/1.JPG)
