package D02_17.project.member;

import java.util.Scanner;

public class Test {
    Scanner sc = new Scanner(System.in);

    MemberManager manager = MemberManager.getInstance();

    public void run() {
        while (true) {
            manager.printAll();

            System.out.print(">> ");
            String str = sc.nextLine();
            String[] sp = str.split(" ");

            if (sp[0].equals("insert")) {   //insert id, name, phone, gender
                manager.insert();
            } else if (sp[0].equals("select")) { //select id
                Member mem = manager.select();
                if (mem == null)
                    continue;
                else
                    mem.println();
            } else if (sp[0].equals("delete")) { //select id
                manager.delete();
            } else if (sp[0].equals("update")) { //select id
                if (!manager.update())
                    continue;
            } else if (sp[0].equals("exit")) {
                break;
            }

        }
    }

    public static void main(String[] args) {
        new Test().run();
    }

}
