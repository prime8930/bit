package D02_09;

import java.util.*;
import java.text.*;

public class Account {
    // 1. 멤버 필드 선언
    private int accid;
    private String name;
    private int balance;
    private Calendar newTime;
    private SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
    private SimpleDateFormat format2 = new SimpleDateFormat("hh:mm");

    // 2. 생성자 선언
    public Account(int accid, String name, int balance) {
        this.accid = accid;
        this.name = name;
        this.balance = balance;
        newTime = Calendar.getInstance();
    }

    public Account(int accid, String name) {
        this(accid, name, 0);
    }

    // 3. get & set 메소드 선언
    public int getAccid() {
        return accid;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public Calendar getNewTime() {
        return newTime;
    }

    private void setAccid(int accid) {
        this.accid = accid;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setBalance(int balance) {
        this.balance = balance;
    }

    // 4. 기능 메소드 선언
    public void inputMoney(int money) throws Exception {
        if (money < 0)
            throw new Exception("잘못된 입력입니다.");
        balance += money;
    }

    public void outputMoney(int money) throws Exception {
        if (balance <= money) {
            throw new Exception("잔액이 부족합니다.");
        }
        if (money < 0) {
            throw new Exception("잘못된 입력입니다.");
        }
        balance -= money;
    }

    public void println() {
        System.out.print("[계좌번호] " + accid);
        System.out.print(" [이름] " + name);
        System.out.println(" [잔액] " + balance);
        System.out.print("[개설일자] " + format1.format(getNewTime().getTime()));
        System.out.println(" [개설시간] " + format2.format(getNewTime().getTime()));
    }


    public void print() {
        System.out.printf("[%d] 이름: %s 잔액: %d원 개설일: %s %s", accid, name, balance, format1.format(getNewTime().getTime()), format2.format(getNewTime().getTime()));
    }
}
