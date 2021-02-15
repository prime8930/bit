package D02_15.single;

// step 1) 노드 클래스 정의
public class Node {
    Object data;    // 저장 타입
    Node next;      // 다음 노드의 주소(논리적 선형 자료구조)

    public Node(Object data) {
        this.data = data;
        next = null;
    }
}
