package D02_17.project.member;

import java.util.*;

public class MemberManager {

    private BitLinkedList list;

    Scanner sc = new Scanner(System.in);

    // singleton pattern
    private MemberManager() {
        list = new BitLinkedList();
    }

    private static MemberManager memberManager = new MemberManager();

    public static MemberManager getInstance() {
        return memberManager;
    }

    // 특정회원정보조회
    public Member select() {
        String id = inputString("검색할 ID를 입력하세요");

        try {
            Member mem = (Member) list.getData(numberToIdx(Integer.parseInt(id))); // 수정(1) 완료
            if(mem == null) {
                throw new Exception("존재하지 않는 회원입니다.");
            } else {
                return mem;
            }
        } catch(Exception e) {
            System.out.println("[조회 실패] " + e.getMessage());
            return null;
        }

    }

    private int numberToIdx(int number) {
        for(int i=0; i< list.getSize(); i++) {
            int num = Integer.parseInt(((Member) list.getData(i)).getId());
            if( num == number)
                return i;
        }
        return -1;
    }

    // 전체회원조회
    public void printAll() {
        System.out.println("===================");
        System.out.println("<전체 회원정보 조회>");
        for (int i = 0; i < list.getSize(); i++) {      // 수정(2) 완료
            Member mem = (Member) list.getData(i);
            mem.println();
            System.out.println("        ↓");
        }
        System.out.println("       end");
        System.out.println("===================");
    }

    // 회원가입
    public boolean insert(){
        try {
            String id = inputString("생성할 ID를 입력하세요");
            if( list.getData(numberToIdx(Integer.parseInt(id))) == null) {            // 수정(3) 완료
                String name = inputString("이름을 입력하세요");
                String phone = inputString("휴대폰 번호를 입력하세요");
                Member newMember = new Member(id, name, phone);
                list.insert(newMember);              // 수정(4)
            } else {
                throw new Exception("이미 생성된 ID입니다.");
            }
        } catch(Exception e) {
            System.out.println("[생성 실패] " + e.getMessage());
            return false;
        }
        return true;
    }

    // 회원탈퇴
    public boolean delete() {
        String id = inputString("탈퇴할 ID를 입력하세요");
        int del = numberToIdx(Integer.parseInt(id));          // 수정(5)
        try {
            if( del < 0 || del >= list.getSize()) {
                throw new Exception("존재하지 않는 회원입니다.");
            } else {
                list.delete(del);                 // 수정(6)
            }
        } catch(Exception e) {
            System.out.println("[탈퇴 실패] " + e.getMessage());
            return false;
        }
        return true;
    }

    // 회원정보수정
    public boolean update() {
        String id = inputString("수정할 회원 ID를 입력하세요");
        Member modify_info = (Member) list.getData(numberToIdx(Integer.parseInt(id)));      // 수정(7)
        try {
            if( modify_info == null) {
                throw new Exception("존재하지 않는 회원입니다.");
            } else {
                String name = inputString("변경할 이름을 입력하세요");
                String phone = inputString("변경할 전화번호를 입력하세요");
                modify_info.setName(name);
                modify_info.setPhone(phone);
                modify_info.println();
            }
        } catch (Exception e) {
            System.out.println("[수정 실패] " + e.getMessage());
            return false;
        }
        return true;
    }


    private String inputString(String msg) {
        System.out.print(msg + " : ");
        return sc.nextLine();
    }

}
