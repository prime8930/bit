package D02_15.single;

import java.util.Scanner;

public class Start {
    public static void main(String[] args) {
        exam4();

    }

    private static void exam1() {
        MyList list = new MyList();
        for (int i = 10; i < 50; i+=10) {
            list.insertFirst(i); // boxing(Object = int)
        }

        list.selectAll();

        // 검색 확인
        Node cur = list.select(40);     // 시작값, 중간값, 마지막값이 동작하면 어느정도 검증된 테스트
        if (cur != null) {
            System.out.println("검색 결과: " + (int) cur.data);
        } else {
            System.out.println("존재하지 않는다.");
        }
    }

    private static void exam2() {
        MyList list = new MyList();
        for (int i = 10; i < 50; i+=10) {
            list.insertLast(i); // boxing(Object = int)
        }

        list.selectAll();
    }

    private static void exam3() {
        MyList list = new MyList();
        for (int i = 10; i <= 50; i+=10) {
            list.insertLast(i); // boxing(Object = int)
        }

        list.selectAll();

        for (int i = 0; i < 6; i++) {
            list.removeLast();
            list.selectAll();
        }

    }

    // 명령어 기반
    /*
        insertFirst 10
        insertLast 10
        select 20
        removeFirst
        removeLast
        insertRandom
        removeRandom
        exit
     */

    public static void exam4() {
        Scanner sc = new Scanner(System.in);
        MyList list = new MyList();

        System.out.println("---------------------");
        System.out.println(" 명령어 기반 단일 연결리스트 테스트");
        System.out.println("---------------------");

        while (true) {
            System.out.println(">> ");
            String str = sc.nextLine();
            String[] sp = str.split(" ");
            if (sp[0].equals("insertFirst")) {
                int value = Integer.parseInt(sp[1]);
                list.insertFirst(value);
            } else if (sp[0].equals("insertLast")) {
                int value = Integer.parseInt(sp[1]);
                list.insertLast(value);
            } else if (sp[0].equals("select")) {
                int value = Integer.parseInt(sp[1]);
                Node cur = list.select(value);
                if (cur != null) {
                    System.out.println("검색 결과 " + (int) cur.data);
                } else {
                    System.out.println("존재하지 않습니다.");
                }
            } else if (sp[0].equals("removeFirst")) {
                list.removeFirst();
            } else if (sp[0].equals("removeLast")) {
                list.removeLast();
            } else if (sp[0].equals("insertRandom")) {
                int find = Integer.parseInt(sp[1]);
                int value = Integer.parseInt(sp[2]);
                if (list.select(find) != null) {
                    list.insertRandom(list.select(find), value);
                } else {
                    System.out.println("존재하지 않는다.");
                }
            } else if (sp[0].equals("removeRandom")) {
                int find = Integer.parseInt(sp[1]);
                if (list.select(find) != null) {
                    list.removeRandom(list.select(find));
                } else {
                    System.out.println("존재하지 않는다.");
                }
            } else if (sp[0].equals("exit")) {
                break;
            }
            list.selectAll();
            System.out.println();
        }

        System.out.println("---------------------");
        System.out.println(" 프로그램을 종료합니다.");
        System.out.println("---------------------");

        sc.close();
    }

}
