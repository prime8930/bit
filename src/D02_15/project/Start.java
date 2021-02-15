package D02_15.project;

import D02_15.single.MyList;
import D02_15.single.Node;

import java.util.Scanner;

public class Start {

    Room room = new Room();

    // 전체 정보 출력
    // 명령어를 입력받고 그에 따른 분기 처리
    public void run() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("---------------------");
            room.printAll();
            System.out.println("---------------------");

            System.out.print(">> ");
            String str = sc.nextLine();
            String[] sp = str.split(" ");

            if (sp[0].equals("insert")) {
                room.insert(Integer.parseInt(sp[1]));
            } else if (sp[0].equals("delete")) {
                room.delete(Integer.parseInt(sp[1]));
            } else if (sp[0].equals("gameIn")) {
                room.gameRoomIn(Integer.parseInt(sp[1]), Integer.parseInt(sp[2]));
            } else if (sp[0].equals("gameOut")) {
                room.gameRoomOut(Integer.parseInt(sp[1]), Integer.parseInt(sp[2]));
            } else if (sp[0].equals("exit")) {
                break;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Start s = new Start();
        s.run();
    }
}
