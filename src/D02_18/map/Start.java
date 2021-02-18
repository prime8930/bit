package D02_18.map;


import java.util.Scanner;

public class Start {

    Scanner sc = new Scanner(System.in);

    private MyHashMap hmap = new MyHashMap(10);

    private void insert(int number, String name, String phone, char gender) {
        if(hmap.insert(number, new Member(number, name, phone, gender)))
            System.out.println("성공");
        else
            System.out.println("실패");
    }

    private void select(int number) {
        Member mem = (Member) hmap.keyToValue(number);
        if(mem == null)
            System.out.println("없다");
        else
            mem.println();
    }

    private void delete(int number) {
        if(hmap.delete(number))
            System.out.println("삭제");
        else
            System.out.println("존재하지 않는 번호입니다");
    }

    public void Run() {
        while (true) {
            hmap.printAll();

            System.out.print(">> ");
            String str = sc.nextLine();
            String[] sp = str.split(" ");
            if (sp[0].equals("insert")) {   //insert id, name, phone, gender
                insert(Integer.parseInt(sp[1]), sp[2], sp[3], sp[4].charAt(0));
            } else if (sp[0].equals("select")) { //select id
                select(Integer.parseInt(sp[1]));
            } else if (sp[0].equals("delete")) { //select id
                delete(Integer.parseInt(sp[1]));
            } else if (sp[0].equals("exit")) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        new Start().Run();
    }
}