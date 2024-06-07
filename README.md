1. Lombok
- 자바 보일러 플레이트 코드 줄여주는 라이브러리
- @Setter @Getter : Java Bean 규약에 있는 setter, getter 자동생성
- @ToString : Object에 기본 구현된 ToStirng 대신 객체의 데이터를 보여주는 ToString 자동 생성
- @NoArgsConstructor @AllArgsConstructor @RequiredArgsConstructor : 객체 생성자를 자동으로 생성
- @Data : Getter, Setter, ToString, Equals, hashCode 등 다양한 기능 모두 제공
- @Builder : 빌더 패턴 자동 생성해 제공
- @Slf4j : 해당 클래스의 logger 자동생성
- @UtilityClass : static method만 제공하는 유틸리티 성격의 클래스들의 생성자를 private로 만들어서 객체 생성 막음
2. HTTP Protocol
- HTTP (Hyper Text Transfer Protocol)
- 하이퍼 텍스트(다른 내용에대한 링크를 갖는 문자열)을 전송하기 위한 프로토콜(약속된 덩의)
- HTTP Resuet
1 요청라인 HTTP 메서드  
2 ~ 줄바꿈 : Header  
줄바꿈 ~ : Request Body   
- HTTP Response
1 상태라인 200, 500 등  
2 ~ 줄바꿈 : Header  
줄바꿈 ~ : Request Body  
3. H2 DB
- 간단히 활용해 볼 수 있는 메모리.파일 관례형 DB이며 가볍고 빠르기 때문에 개발 단계에 활용하거나 테스트코드에 자주 활용
4. 트랜잭션 개념
- ACID
- Atomic 원자성 : All or nothig, 모든 작업이 실행되거나 혹은 모두 실행되지 않아야한다.
- Consistency 일관성 : 모든 트랜잭션이 종료된 후에는 DB의 제약조건을 모 지키고 있는 상태가 되어야한다
- Isolation 격리성 : 트랜잭션은 다른 트랜잭션과 독리적으로 동작해야한다, A 트랜잭션이 하는 일을 B 트랜잭션은 모르게 해야한다  
-> 성능과 안전성의 트레이드 오프 관계에 있는 부분, 성능이 떨어지고 격리성이 증가함  
- Durability 지속성 : commit을 하게되면 지속(저장)이 꼭 된다, DB 저장이 실패하더라도 모든 로그룰 모두 남겨 DB에 순차적으로 모두 반영 되도록함
5. Embedded Redis 실행
- 업무용으로는 별도 서버의 redis를 많이 활용, 실습의 용이성위해 사용
- 사용 목적 : SpinLock 활용한 동시성 제어 / 동시성 제어에 AOP를 활용해 실습하는데 활용되는 인프라
- 실행설정 : SpringBoot가 기동하면서 Bean을 등록할때 레디스를 실행하고 종료 되면서 Bean을 삭제할때 레디스를 종료하도록 설정
6. 테스트
- JUnit 
- xUnit이라는 유닛테스트 프레임워크의 일환으로 Java용으로 개발된 프레임워크
- 단위테스트를 실행하고 결과를 검증해 전체 결과를 리포트해주는 프레임워크
- 사용자가 직접 동작시킬 수도 있으며 Gradle이나 Maven등 통해 빌드하면서 테스트 가능
- spring-boot-starter-test에 기본적으로 JUnit5 포함됨
- Mokito
- Mock을 만들어주는 라이브러리
- 해결하고자하는점 : 테스트 하고자하는 클래스가 의존하는 클래스를 모두 만들기어려움 -> 모든 클래스가 동작하면 어떤 부분이 문제인지 알기 어려움 => 가짜 Mock을 만들어 원하는 방식으로 동작하게함
- Controller 테스트 방법
- @SpringBootTest + @AutoConigureMockMvc : 전체 Bean 모두 생성한 후 mockMvc 통해 http 요청과 검증진행
- @WebMnvTest : 필요로하는 MVC 관련 Bean 들만 생성 : Service등 Controller에서 의존하는 하위 레이어의 기능은 @MockBean을 통해 모킹해서 웜하는 동작 하도록함(Mockito와 유사) -> 많이 사용
- Service 테스트 방법
- 실제 로직을 처리하는 Service는 다양한 테스트 기법이 필요
- verify : 의존하고있는 Mock이 해당되는 동작을 수행했는지 확인하는 검증
- ArgumentCaptor : 의존하고 있는 Mock에 전달된 데이터가 내가 의도하는 데이터가 맞는지 검증
- assertions : 다양한 assertion 방법들
- assertThrows : 

