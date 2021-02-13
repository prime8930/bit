package D02_09;

public class Bank {

    private BitArray arr; // 저장 공간 사용을 위한 외부 클래스의 인스턴스 선언
    private BitArray accioList = new BitArray(100); // 거래리스트 관리 인스턴스

    // 2. singleton 패턴 방식의 생성자 선언
    private Bank() {
        arr = new BitArray(inputMax());
    }

    private static Bank bank = new Bank();

    public static Bank getInstance() {
        return bank;
    }

    // 3. 메소드
    private int inputMax() {
        return BitGlobal.inputNumber("저장 개수를 입력하세요");
    }

    private boolean isAccNumberCheck(int accid) {
        return numberToIdx(accid) == -1;
    }

    public void printAll() {
        // 1. 저장 개수 출력
        System.out.println("[저장 개수] " + arr.getSize() + "개");

        // 2. 전체 데이터 정보를 출력[배열 알고리즘] - 전체 순회
        for (int i = 0; i < arr.getSize(); i++) {
            Account acc = (Account) arr.getData(i); // Down casting -> instanceof(객체 타입 확인)
            acc.print();
            System.out.println();
        }
    }

    // 4. 기능 메소드

    // 거래리스트 저장 함수
    public void insertAccountIO(int accid, int input, int output, int balance) {
        try {
            AccountIO io = new AccountIO(accid, input, output, balance);
            accioList.insert(io);
        } catch(Exception e) {
            System.out.println("[거래내역저장에러] " + e.getMessage());
        }
    }

    // 거래리스트 출력 함수
    private void printAccountIO(int accid) {
        System.out.println("[거래개수] " + getAccountIOCount(accid) + "개");
        System.out.println("[계좌번호]\t\t[입금액]\t\t[출금액]\t\t[잔액]\t\t\t[거래시간]");
        for (int i = 0; i < accioList.getSize(); i++) {
            AccountIO accio = (AccountIO) accioList.getData(i); // Down casting -> instanceof(객체 타입 확인)
            if(accio.getAccNum() == accid)
                accio.print();
        }
    }

    // 특정계좌의 거래리스트 개수 반환
    private int getAccountIOCount(int accid) {
        int sum = 0;
        for (int i = 0; i < accioList.getSize(); i++) {
            AccountIO accio = (AccountIO) accioList.getData(i); // Down casting -> instanceof(객체 타입 확인)
            if(accio.getAccNum() == accid) {
                sum++;
            }
        }
        return sum;
    }


    // insert
    public void makeAccount() {
        try {
            int accid = BitGlobal.inputNumber("계좌 번호를 입력하세요 ");
            String name = BitGlobal.inputString("이름을 입력하세요 ");
            int balance = BitGlobal.inputNumber("잔액을 입력하세요 ");

            if (isAccNumberCheck(accid)) {
                Account acc = new Account(accid, name, balance);
                arr.insert(acc);
            } else {
                throw new Exception("이미 개설된 계좌번호가 존재합니다.");
            }
        } catch (Exception e) {
            System.out.println("[저장 실패] " + e.getMessage());
        }
    }

    // select
    public void selectAccount() {
        int accid = BitGlobal.inputNumber("계좌 번호를 입력하세요 ");

        int result = numberToIdx(accid);
        if (result == -1) {
            System.out.println("해당 회원 정보가 존재하지 않습니다.");
            return;
        }

        Account acc = (Account) arr.getData(result);
        acc.println();

        // 거래리스트 출력
        System.out.println("거래리스트");
        printAccountIO(accid);
    }

    // update
    public void inputMoney() {
        try {
            int accid = BitGlobal.inputNumber("계좌 번호를 입력하세요");
            int money = BitGlobal.inputNumber("입금할 금액을 입력하세요");

            int idx = numberToIdx(accid);
            Account acc = (Account) arr.getData(idx);
            acc.inputMoney(money);

            // ------------------
            // 1) 계좌번호 : accid
            // 2) 입금 : money
            // 3) 출금 : 0
            // 4) 잔액 : balance + money
            // ------------------

            // 입금 내역 저장
            insertAccountIO(accid, money, 0, acc.getBalance());
        } catch (Exception e) {
            System.out.println("[입금 실패] " + e.getMessage());
        }
    }

    // update
    public void outputMoney() {
        try {
            int accid = BitGlobal.inputNumber("계좌 번호를 입력하세요");
            int money = BitGlobal.inputNumber("출금할 금액을 입력하세요");

            int idx = numberToIdx(accid);
            Account acc = (Account) arr.getData(idx);
            acc.outputMoney(money);

            // ------------------
            // 1) 계좌번호 : accid
            // 2) 입금 : 0
            // 3) 출금 : money
            // 4) 잔액 : balance - money
            // ------------------

            // 출금 내역 저장
            insertAccountIO(accid, 0, money, acc.getBalance());
        } catch (Exception e) {
            System.out.println("[출금 실패] " + e.getMessage());
        }
    }

    // delete
    public void deleteAccount() {
        int accid = BitGlobal.inputNumber("계좌 번호를 입력하세요");
        int result = numberToIdx(accid);
        try {
            arr.delete(result);
            System.out.println("삭제 성공");
        } catch (Exception e) {
            System.out.println("[삭제 실패] " + e.getMessage());
        }
    }

    private int numberToIdx(int accid) {
        for (int i = 0; i < arr.getSize(); i++) {
            Account acc = (Account) arr.getData(i);
            if (acc.getAccid() == accid) {
                return i;
            }
        }
        return -1;
    }

}
