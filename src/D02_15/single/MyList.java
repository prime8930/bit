package D02_15.single;

// step 2) 연결리스트 구조체 정의
public class MyList {
    private Node head;    // 시작 노드를 저장
    private int size;      // 노드 저장 개수

    // step 3) 초기화(생성자)
    public MyList() {
        head = null;
        size = 0;
    }

    // step 4) insertFirst
    /*
        1. 노드 생성
        2. 노드 초기화(데이터 저장, null)
        3. 앞에 연결
          - 3.1 비어있을 때
                head가 새 노드를 연결한다.
          - 3.2 노드가 존재할 때
                먼저 새 노드가 기존 첫번째 노드를 연결한다.
                head가 새 노드를 연결한다.
        + 비어있는 노드의 판단
            - 비어있다 : head는 null이다. if(head == null)
            - 노드 존재 :
                1) newNode.next = head(기존 첫번째 노드 주소);
                2) head = newNode;
    */
    public boolean insertFirst(Object data) {
        Node newNode = new Node(data);
        if (head != null) {
            newNode.next = head;
        }
        head = newNode;
        size++;
        return true;
    }

    // step 5) selectAll(선형 순회)
    /*
        1. 순회할 레퍼런스 변수 선언 <- 첫번째 노드 Node cur = head;
        2. cur 이동        cur = cur.next;
        3. 언제까지?        cur == null
     */
    public void selectAll() {
        System.out.println("[" + size + "]");
        Node cur = head;

        while (cur != null) {
            int data = (int) cur.data;          // unboxing(auto) : 기본형 타입 = 레퍼런스 타입
            System.out.print(data + " -> ");
            cur = cur.next;
        }
        System.out.println();
    }

    // step 6) insertLast
    /*
        1. 노드 생성
        2. 노드 초기화(데이터 저장, null)
        3. 뒤에 연결
          - 3.1 비어있을 때
                head가 새 노드를 연결한다.
          - 3.2 노드가 존재할 때
                마지막 노드를 찾는다.(순회)
                    cur.next = null;
                마지막 노드가 새 노드를 연결한다.
                    cur.next = newNode;
    */
    public boolean insertLast(Object data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node cur = head;
            while (cur.next != null) { // 마지막 노드를 찾는 과정(순회)
                cur = cur.next;
            }
            cur.next = newNode; // 연결
        }

        size++;
        return true;
    }

    // step 7) select(검색 데이터 --> Node 반환(실패: null)
    public Node select(Object key) {
        Node cur = head;
        while (cur != null) {
            int data = (int) cur.data;
            if (data == (int) key) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    // step 8) removeFirst
    /*
        1. 삭제할 노드를 찾는다.
            - 노드가 없는 경우
            - 삭제 후 노드가 없을 경우와 있을 경우(구분할 필요가 없다)
        2. 삭제 알고리즘
     */
    public boolean removeFirst() {
        Node del = head;

        if (del == null) {  // 노드가 없는 상태
            return false;
        }

        head = del.next;
        size--;
        return true;
    }

    /*
        1. 삭제할 노드와 이전 노드를 찾는다.
            - 꼬리 찾기
        2. 삭제 알고리즘
     */
    public boolean removeLast() {
        Node del = head;
        Node prev = head;

        if (del == null) {  // 노드가 없는 상태
            return false;
        }

        if (del.next == null) {    // 노드가 한 개일 때
            head = null;
        } else {            // 노드가 두 개이상일 때
            while (del.next != null) { // 삭제 노드와 이전 노드를 찾는다.
                prev = del;
                del = del.next;
            }
            prev.next = null;   // 삭제 연산
        }

        size--;
        return true;
    }

    // cur의 다음 노드에 연결
    // cur 다음에 value값을 갖는 노드를 추가
    public boolean insertRandom(Node cur, Object data) {
        Node newNode = new Node(data);

        if (cur.next != null) { // 노드가 여러 개일 때
            newNode.next = cur.next;
        }
        cur.next = newNode;

        size++;
        return true;
    }


    // prev의 다음 노드 삭제
    public boolean removeRandom(Node prev) {
        Node del = prev.next;

        if (del == null) {
            return false;
        }
        prev.next = del.next;

        size--;
        return true;
    }
}
