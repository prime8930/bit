package D02_16.link_stack;



import java.util.Scanner;

public class Start {
    public static void main(String[] args) throws Exception {
        exam1();
    }

    private static void exam1() throws Exception {
        Scanner sc = new Scanner(System.in);
        MyLinkedStack stack = new MyLinkedStack();

        System.out.println("---------------------");
        System.out.println(" 명령어 기반 스택 테스트");
        System.out.println("---------------------");

        while (true) {
            System.out.print(">> ");
            String str = sc.nextLine();
            String[] sp = str.split(" ");
            if (sp[0].equals("push")) {
                stack.push(sp[1]);
            } else if (sp[0].equals("pop")) {
                System.out.println("pop 결과 : " + stack.pop());
            } else if (sp[0].equals("print")) {
                stack.printAll();
            } else if (sp[0].equals("get")) {
                System.out.println(stack.getTop());
            } else if (sp[0].equals("clear")) {
                stack.clear();
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
