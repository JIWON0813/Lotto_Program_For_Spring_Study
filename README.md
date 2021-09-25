#TDD 및 스프링 구조를 학습하기 위한 로또번호 생성 프로그램

목표
1) TDD(테스트 주도 개발) 방식 이해 및 적용
2) 스프링 구조(내부 구현) 이해
3) JPA 동작 방식, 개념 

<br><br><br>
<h1>1. gettest컨트롤러 만들어 연결되는지 테스트</h1>
<h2>개발 목적</h2>
컨트롤러 생성 <br>
SpringBootApplication 이해<br>

<h2>구현 목록</h2>
1.TestController 생성
<h2>에러 내역</h2>
Error creating bean with name 'inMemoryDatabaseShutdownExecutor'<br>
<h2>이유</h2>
DataSource를 따로 설정해두지 않았는데 자동으로 빈을 등록하려고 해서 생기는 문제<br>
<h2>해결</h2>
@SpringBootApplication에 (exclude = DataSourceAutoConfiguration.class) 추가 (자동 설정 제거)<br>
<br>
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)

<h2>결과</h2>

![1](./image/1.jpg)

<h1>2. DB연결 </h1>
<h2>개발 목적</h2>
JDBC , JPA 이해

<h2>구현 목록</h2>
1. application.properties DB연결
2. Entity(LOTTO_NUMBER) 생성
3. LottoNumberRepository 생성 + Test Class 생성
4. UpdateNewLottoNumberService 생성 
5. LottoNumberRepositorytest <br>
5-1)testConnection() 구현 (문제 없음)<br>
5-2)getMaxRound() 구현 (null 에러일때 문제해결 처리해야함)

<h2>에러 내역</h2>
@Query의 결과가 null 일때 
<h2>이유</h2>
Database의 값이 없어 null로 결과 출력
<h2>해결</h2>
추후 해결예정
<h2>결과</h2>

<h1>2. test컨트롤러 lotto 최신회차 스크래핑 테스트</h1>
<h2>개발 목적</h2>
1)Jsoup를 이용해 스크래핑이 잘 되는지 테스트
2)TDD 익숙해지기위한 test개발

<h2>구현 목록</h2>
1. getTestLatestNumber() 메서드 생성

![2-1](./image/2-1.JPG)

<h2>에러 내역</h2>
켰을 때 LOTTO_NUMBER 엔티티를 못찾는 에러가 발생
<h2>이유</h2>
인텔리제이 문제라하는데 정확한 이유 아직 못찾음
<h2>해결</h2>
껐다 켜보니 됐다 인텔리제이에서 자주 발생하는듯
<h2>느낀점</h2>
assertThat의 테스트값을 맞추는데 익숙하지 않았음

<h2>결과</h2>
현재 최신회차가 975회차기 때문에 테스트로 975를 맞춰줌<br>
스크래핑이 잘 되는지 테스트기 때문에 최신회차 값은 따로 하드코딩

![2-2](./image/2-2.JPG)

<h1>3. StringBuilderPool 생성</h1>
<h2>개발 목적</h2>
1)StringBuilder를 사용하는데 메모리관리 위해 Pool로 만들어서 생성

<h2>구현 목록</h2>
1. StringBuilderPool 생성 (src -> java -> Core)

<h2>느낀점</h2>
C#에서 되는 문법들이 자바에서 안되는 경우가 많아 내부 구현 로직을 많이 찾아봄<br>
만들고 나니 제대로 만들었는지 추후 검토 필요<br>
공용 참조기 때문에 동기화를 해야함 mutex 사용을 더 알아보고 나중에 수정

<h2>결과</h2>
StringBuilder를 각 다른서비스에서 사용하려니<br>
"Duplicated code fragment" 해당 warning 뜨는 중<br>
이유를 자세히 알아보고 정확하게 수정해야할듯 효용성이 없는 Pool을 만들었을 수도 있음

<h1>4. Exception AOP 생성</h1>
<h2>개발 목적</h2>
1)AOP에 대한 이해<br>
2)모든 서비스 공통 try catch 처리 및 에러로그 구현

<h2>구현 목록</h2>
1. CheckExceptionAop구현

<h2>느낀점</h2>
AOP에 대한 개념 이해를 위해 공부하고 적용하려는데 배우고 나니까 아주 중요한 부분이라는걸 깨달음<br>
각 스크래핑에 대해 일일이 try catch를 적용했는데 그럴 필요 없이 AOP로 만들어서 적용하면 되는거였음<br>
일하는 곳이 자바, 스프링을 사용하지않아 이 부분은 크게 차이를 느낌

<h1>5. 확장메서드 구현</h1>
<h2>개발 목적</h2>
1)C# 처럼 확장메서드 구현<br>
2)자바 자체 확장메서드 구현 기능이 없어 manifold 플러그인 사용

<h2>구현 목록</h2>
1. StringExtension

<h2>현재 상황</h2>
현재 manifold 플러그인이 인텔리제이 최신버전과 호환이 되지않아 호환 될 때 까지 기다려야하는 상황<br>
확장메서드 구현은 여러모로 편해서 이번 프로젝트에서도 구현하려고 했지만 현재 구현 불가능


<h1>6. 서버 시작할 때 자동 스크래핑 생성</h1>
<h2>개발 목적</h2>
1)서버가 시작할 때 DB의 데이터보다 최신 데이터가 있으면 데이터값 자동 DB 저장<br>

<h2>구현 목록</h2>
1. lotto.application.UpdateNewLottoNumberService - autoUpdateNewRound 메서드 구현


<h2>에러 내역</h2>

1.에러1
![5-error1](./image/5-error1.JPG)

<h2>이유</h2>
레포지토리 빈을 못찾아서 나는 문제
<h2>해결</h2>
메인Application에 @EnableJpaRepositories 어노테이션 추가
![5-jpa](./image/5-jpa.JPG)

2.
![5-error2](./image/5-error2.JPG)

<h2>이유</h2>
EntityManagerFactory를 못찾는 문제
<h2>해결</h2>
여러 원일들을 


<h2>느낀점</h2>
assertThat의 테스트값을 맞추는데 익숙하지 않았음


<h2>느낀점</h2>