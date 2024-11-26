# 미션 - 크리스마스 프로모션

## 🔍 진행 방식

- 미션은 **기능 요구 사항, 프로그래밍 요구 사항, 과제 진행 요구 사항** 세 가지로 구성되어 있다.
- 세 개의 요구 사항을 만족하기 위해 노력한다. 특히 기능을 구현하기 전에 기능 목록을 만들고, 기능 단위로 커밋 하는 방식으로 진행한다.
- 기능 요구 사항에 기재되지 않은 내용은 스스로 판단하여 구현한다.

## 📮 미션 제출 방법

- 미션 구현을 완료한 후 GitHub을 통해 제출해야 한다.
    - GitHub을 활용한 제출 방법은 [프리코스 과제 제출](https://docs.google.com/document/d/1cmg0VpPkuvdaetxwp4hnyyFC_G-1f2Gr8nIDYIWcKC8/edit?usp=sharing) 문서를 참고해
      제출한다.
- GitHub에 미션을 제출한 후 [우아한테크코스 지원](https://apply.techcourse.co.kr) 사이트에 접속하여 프리코스 과제를 제출한다.
    - 자세한 방법은 [제출 가이드](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse#제출-가이드) 참고
    - **지원 플랫폼을 통해 과제를 제출하지 않으면 최종 제출되지 않은 것으로 처리되므로 주의한다.**

## 🚨 과제 제출 전 체크 리스트 - 0점 방지

- 기능 구현을 모두 정상적으로 했더라도 **요구 사항에 명시된 출력값 형식을 지키지 않을 경우 0점으로 처리**한다.
- 기능 구현을 완료한 뒤 아래 가이드에 따라 테스트를 실행했을 때 모든 테스트가 성공하는지 확인한다.
- **테스트가 실패할 경우 0점으로 처리**되므로, 반드시 확인 후 제출한다.

### 테스트 실행 가이드

- 터미널에서 `java -version`을 실행하여 Java 버전이 17인지 확인한다.
  Eclipse 또는 IntelliJ IDEA와 같은 IDE에서 Java 17로 실행되는지 확인한다.
- 터미널에서 Mac 또는 Linux 사용자의 경우 `./gradlew clean test` 명령을 실행하고,
  Windows 사용자의 경우 `gradlew.bat clean test` 또는 `./gradlew.bat clean test` 명령을 실행할 때 모든 테스트가 아래와 같이 통과하는지 확인한다.

```
BUILD SUCCESSFUL in 0s
```

---

## 🚀 기능 요구 사항

### 1.입출력 기능

#### 1-1.방문 날짜 입력 기능
- 숫자만 입력 가능하다.
- 1이상 31 이하의 숫자만 가능하다.
- 올바른 입력값이 아니면  "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."를 출력한다.

#### 1-2.메뉴 및 개수 입력 기능
- 메뉴판에 없는 메뉴를 입력할 경우 예외가 발생한다.
- 메뉴의 개수는 1이상의 숫자만 가능하다
- 중복 메뉴 입력시 예외가 발생한다.
- 올바른 입력값이 아니면  "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."를 출력한다.

#### 2.크리스마스 디데이 할인
- 1~25일 사이의 기간동안 적용
- 1,000원응로 시작하여 100원씩 증가

#### 3.평일 할인(일 ~ 목)
- 일요일 ~ 목요일 기간에 적용한다.
- 디저트 메뉴 1개당 2,023원 할인한다.

#### 4.주말 할인(금,토)
- 금요일, 토요일에 적용한다.
- 메인메뉴 한개당 2,023원 할인

#### 5.특별 할인
- 이벤트 달력에 별이 있으면 1000원 할인

#### 6.증정 이벤트
- 할인전 총주문 금액이 12만원 이상일때, 샴페인 1개 증정

#### 7.이벤트 배지
- 총혜택금액에 따라 배지를 부여한다.
- 5천 원 이상: 별
- 1만 원 이상: 트리
- 2만 원 이상: 산타

---

## 🎯 프로그래밍 요구 사항

- JDK 17 버전에서 실행 가능해야 한다. **JDK 17에서 정상적으로 동작하지 않을 경우 0점 처리한다.**
- 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- `build.gradle` 파일을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다.
- [Java 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java) 가이드를 준수하며 프로그래밍한다.
- 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- 프로그램 구현이 완료되면 `ApplicationTest`의 모든 테스트가 성공해야 한다. **테스트가 실패할 경우 0점 처리한다.**
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않는다.
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
    - 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.
- else 예약어를 쓰지 않는다.
    - 힌트: if 조건절에서 값을 return 하는 방식으로 구현하면 else를 사용하지 않아도 된다.
    - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
- 도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
    - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    - `Exception`이 아닌 `IllegalArgumentException`, `IllegalStateException` 등과 같은 명확한 유형을 처리한다.

### 추가된 요구 사항

- 아래 있는 `InputView`, `OutputView` 클래스를 참고하여 입출력 클래스를 구현한다.
    - 입력과 출력을 담당하는 클래스를 별도로 구현한다.
    - 해당 클래스의 패키지, 클래스명, 메서드의 반환 타입과 시그니처는 자유롭게 구현할 수 있다.
  ```java
  public class InputView {
      public int readDate() {
          System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
          String input = Console.readLine();    
          // ...
      }
      // ...
  }
  ```
  ```java
  public class OutputView {
      public void printMenu() {
          System.out.println("<주문 메뉴>");
          // ...
      }
      // ...
  }
  ```

### 라이브러리

- `camp.nextstep.edu.missionutils`에서 제공하는 `Console` API를 사용하여 구현해야 한다.
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

---

## ✏️ 과제 진행 요구 사항

- 미션은 [java-christmas-6](https://github.com/woowacourse-precourse/java-christmas-6) 저장소를 비공개 저장소로 생성해 시작한다.
- **기능을 구현하기 전 `docs/README.md`에 구현할 기능 목록을 정리**해 추가한다.
- **Git의 커밋 단위는 앞 단계에서 `docs/README.md`에 정리한 기능 목록 단위**로 추가한다.
    - [커밋 메시지 컨벤션](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 가이드를 참고해 커밋 메시지를 작성한다.
- 과제 진행 및 제출 방법은 [프리코스 과제 제출](https://docs.google.com/document/d/1cmg0VpPkuvdaetxwp4hnyyFC_G-1f2Gr8nIDYIWcKC8/edit?usp=sharing) 문서를 참고한다.
