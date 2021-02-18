package D02_17.project.member;

public class Member {
    // member field
    private String id;
    String name;
    String phone;

    // constructor

    public Member(String id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void println() {
        System.out.println("-----------------");
        System.out.println("회원 아이디  : " + id);
        System.out.println("회원 이름    : " + name);
        System.out.println("회원 전화번호 : " + phone);
        System.out.println("-----------------");
    }

}
