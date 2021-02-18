package D02_18.map;

// Member 객체 저장(number값을 key로 사용!) [회원번호, 회원정보]
public class Member {
    private int number;
    private String name;
    private String phone;
    private char gender;

    //생성자
    public Member(int number, String name, String phone, char gender) {
        this.setNumber(number);
        this.setName(name);
        this.setPhone(phone);
        this.setGender(gender);
    }

    public Member(int number, String name) {
        this(number, name, "", ' ');
    }

    //get & set
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    //method
    public void println() {
        System.out.println("[회원번호]" + number);
        System.out.println("[이름]" + name);
        System.out.println("[전화번호]" + phone);
        System.out.println("[성별]" + gender);
    }

    public void print() {
        System.out.printf("[%d] %s %s %c\n", number, name, phone, gender);
    }

}
