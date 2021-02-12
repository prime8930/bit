import java.util.Calendar;

public class AccountIO {

    // 1. 멤버 필드 선언
    private int accNum;
    private int input;
    private int output;
    private int balance;
    Calendar cd;

    // 2. 생성자
    public AccountIO(int accNum, int input, int output, int balance) {
        this.accNum = accNum;
        this.input = input;
        this.output = output;
        this.balance = balance;
        cd = Calendar.getInstance();
    }

    // 3. get & set 메소드 선언
    public int getAccNum() {
        return accNum;
    }

    // 날짜 정보
    public String getDate() {
        return String.format("%04d-%02d-%02d", cd.get(Calendar.YEAR) ,cd.get(Calendar.MONTH), cd.get(Calendar.DAY_OF_MONTH));
    }

    // 시간 정보
    public String getTime() {
        return String.format("%02d:%02d:%02d", cd.get(Calendar.HOUR_OF_DAY), cd.get(Calendar.MINUTE), cd.get(Calendar.SECOND));
    }

    // 4. 기능 메소드 선언
    // 출력기능
    public void print() {
        System.out.printf("%5d\t\t\t%d\t\t\t%d\t\t%d\t\t\t%s %s\n", accNum, input, output, balance, getDate(), getTime());
    }
}
