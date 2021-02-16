package D02_16.array_queue;

import D02_16.array_stack.MyStack;

import java.util.Optional;
import java.util.Scanner;

public class Start {
    public static void main(String[] args) throws Exception {
        exam1();
    }

    /*
     *[큐 사용 명령어]
     * put 10
     * get     : 비어있는 상태에서 get했을 때의 문제점 해결 필요!
     * print
     * clear
     * exit
     *-> 모든 명령어 처리 후 스택의 상태정보를 출력할 것(printAll)
     */

    private static void exam1() throws Exception {
        Scanner sc = new Scanner(System.in);
        MyQueue queue = new MyQueue();

        System.out.println("---------------------");
        System.out.println(" 명령어 기반 스택 테스트");
        System.out.println("---------------------");

        while (true) {
            System.out.print(">> ");
            String str = sc.nextLine();
            String[] sp = str.split(" ");
            if (sp[0].equals("put")) {
                queue.put(sp[1]);
            } else if (sp[0].equals("get")) {
                System.out.println("get 결과 : " + queue.get());
            } else if (sp[0].equals("print")) {
                queue.printAll();
            } else if (sp[0].equals("clear")) {
                queue.clear();
            } else if (sp[0].equals("exit")) {
                break;
            }
        }

        System.out.println("---------------------");
        System.out.println(" 프로그램을 종료합니다.");
        System.out.println("---------------------");

        sc.close();
    }
}

