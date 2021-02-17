package D02_17.interface_structure;

/*
 	BitArray의 사용 메소드
 	1) getSize() : 저장 개수 반환
 	2) getData(idx) : 인덱스 저장정보 반환
 	3) insert(data) : 저장
 	4) delete(idx) : 해당 인덱스의 정보 삭제
 */
public class Manager {
    //private BitArray arr = new BitArray();
    private BitLinkedList arr = new BitLinkedList();

    public void selectAll() {
        System.out.println("[저장개수] " + arr.getSize() + "개");
        for(int i=0; i< arr.getSize(); i++)
        {
            int number = (int)arr.getData(i);  //Down Casting...-> instanceof
            System.out.println(number);
        }
    }

    public void insert() {
        try {
            arr.insert(10);
            //4. 결과출력
            System.out.println("저장 성공!");
        }
        catch(Exception ex) {
            System.out.println("[저장실패] " + ex.getMessage());
        }
    }

    //검색 알고리즘(순차 검색)
    //회원번호를 전달 --> 배열의 idx 반환(실패 : -1)
    private int numberToIdx(int number) {
        for(int i=0; i< arr.getSize(); i++) {
            int num = (int)arr.getData(i);
            if( num == number)
                return i;
        }
        return -1;
    }

    public void select() {
        int idx = numberToIdx(10);
        if(idx != -1) {
            int number = (int)arr.getData(idx);
            System.out.println(number);
        }
        else
            System.out.println("없다\n");
    }

    public void update() {
        try {
            //int idx = NameToMember(10);
            //arr.getData(idx)= 20;
            System.out.println("수정 성공\n");
        }
        catch(Exception ex) {
            System.out.println("[수정오류]" + ex.getMessage());
        }
    }

    public void delete() {
        //사용자에게 회원번호를 입력받아 검색 후 해당 회원을 삭제(BitArray.Delete함수를 활용)
        //전반적인 흐름 : Select와 유사하다.
        try {
            int idx = numberToIdx(10);
            if(idx == -1)
                throw new Exception("없는 회원번호 입니다.");	//<=======
            arr.delete(idx);
            System.out.println("삭제되었습니다.");
        }
        catch(Exception ex) {
            System.out.println("[삭제 에러] " + ex.getMessage());
        }
    }
}
