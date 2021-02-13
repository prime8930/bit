package D02_09;

import java.util.*;

public class BitGlobal {

    static Scanner sc = new Scanner(System.in);

    public static void logo() {
        System.out.println("**************************************");
        System.out.print("   계좌 관리 프로그램");
        System.out.print(" (2021.02.09)");
        System.out.println(" 오종수");
        System.out.println("**************************************");
    }

    public static void ending() {
        System.out.println("**********************************");
        System.out.println("           프로그램 종료");
        System.out.println("**********************************");
    }

    public static char menuPrint() {
        System.out.println("---------");
        System.out.println("[1] 계좌 개설\n"
                + "[2] 계좌 조회\n"
                + "[3] 입금\n"
                + "[4] 출금\n"
                + "[5] 계좌 삭제\n"
                + "[6] 종료");
        System.out.println("---------");
        System.out.print(">> ");
        return sc.nextLine().charAt(0);
    }

    public static void pause() {
        System.out.print("엔터 키를 누르세요.");
        sc.nextLine(); // nextLine() : 엔터키까지 입력받는다.
    }

    public static int inputNumber(String msg) {
        System.out.print(msg + " :");
        return Integer.parseInt(sc.nextLine());
    }

    public static String inputString(String msg) {
        System.out.print(msg + " :");
        return sc.nextLine();
    }
}
