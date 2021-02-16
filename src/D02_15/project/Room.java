package D02_15.project;

public class Room {
    private MyDList wait;
    private MyDList game1;
    private MyDList game2;
    private MyDList game3;

    public Room() {
        wait = new MyDList();
        game1 = new MyDList();
        game2 = new MyDList();
        game3 = new MyDList();
    }

    // 대기방 입장
    public boolean insert(int number) {
        wait.pushFirst(number);
        System.out.println(number + "번 회원이 대기방으로 입장하였습니다.");
        return true;
    }

    // 대기방 퇴장
    public boolean delete(int number) {
        return wait.removeRandom(wait.select(number));
    }

    // 게임방 입장
    public boolean gameRoomIn(int idx, int number) {
        MyDList.DNode member = wait.select(number);
        if (member == null) {
            System.out.println(number + "번 회원은 대기방에 없습니다.");
            return false;
        } else {
            delete(number);
            switch (idx) {
                case 1 :
                    game1.pushFirst(number);
                    break;
                case 2 :
                    game2.pushFirst(number);
                    break;
                case 3 :
                    game3.pushFirst(number);
            }
        }
        System.out.println(number + "번 회원이 게임방" + idx + " 로 이동하였습니다.");
        return true;
    }

    //게임방 퇴장
    public boolean gameRoomOut(int idx, int number) {
        MyDList.DNode member = game1.select(number); // 수정 필요

        if (member == null) {
            System.out.println(number + "번 회원은 게임방" + idx + " 에 없습니다.");
            return false;
        } else {
            switch (idx) {
                case 1 :
                    game1.removeRandom(member);
                    break;
                case 2 :
                    game2.removeRandom(member);
                    break;
                case 3 :
                    game3.removeRandom(member);
            }
            insert(number);
            System.out.println(number + "번 회원이 대기방으로 이동하였습니다.");
        }
        return true;
    }

    // 연결리스트 4개를 출력
    public void printAll() {
        System.out.print("대기방 ");
        wait.selectAll();
        System.out.print("게임방1 ");
        game1.selectAll();
        System.out.print("게임방2 ");
        game2.selectAll();
        System.out.print("게임방3 ");
        game3.selectAll();
    }
}
