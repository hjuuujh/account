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
