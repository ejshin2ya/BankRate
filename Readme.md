## 구현한 내용 
* 은행 금리 정보 추가
* 모든 은행 금리 조회
* 은행명 입력 후 해당 정보 조회
* 은행명 입력 후 해당 정보 삭제
* 특판 금리 진행하는 은행 조회
* 특판 금리가 가장 높은 은행 정보 조회

## 구현한 기능
* BankManager에서는 기능만 구현, BankTest에서 UI 기능만 구현함으로써 분업화함
* IBankManager라는 인터페이스를 통해 분업화가 가능하도록함
* BankNotFoundException을 통해 예외상황 처리(try ~ catch문 사용)
* Gson과 save()와 load()를 통해 저장과 불러오기 기능 구현
* FileInputStram, FileOutputStram 사용하여 파일 내용 출력 및 파일 생성 
* ObjectInputStram, ObjectOutputStram는 객체 직렬화 방법으로 readObject() 함수로 객체직렬화 전으로 객체를 캐스팅, writeObject() 함수로 객체 직렬화 상태로 변환
* 상속기능을 통해 특판금리를 가지고 있는 은행정보 구현(extends)
* 싱글톤을 통해 한번의 객체 생성하여 재사용이 용이하므로 메모리 낭비를 방지(static, instance, getinstance()) 
