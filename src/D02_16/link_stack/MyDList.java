package D02_16.link_stack;

// step 1) 이중연결리스트, 노드 클래스 정의
public class MyDList {

    public class DNode {    // inner class
        Object data;
        DNode prev;
        DNode next;

        public DNode(Object data) {
            this.data = data;
            prev = null;
            next = null;
        }
    }

    // member field
    private DNode head;
    private DNode tail;
    private int size;

    // constructor
    public MyDList() {
        head = null;
        tail = null;
        size = 0;
    }

    public DNode getHead() {
        return head;
    }

    // insert method
    /*
        1. 노드 생성 및 초기화
        2. 노드 연결
            2.1 비어있는 경우
                - head와 tail 둘 다 newNode를 가리킴
            2.2 노드가 존재하는 경우
                - 새 노드가 기존 노드와 먼저 연결
                - head.prev에 새 노드 연결
                - head가 새 노드 가리킴
     */
    public boolean pushFirst(Object data) {
        DNode newNode = new DNode(data);
        if (head == null) { // head == null && tail == null
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head; // 새 노드의 다음 링크가 기존 노드 가리킴
            head.prev = newNode; // 기존 head가 가리키던 노드의 prev가 새 노드 가리킴
            head = newNode; // head가 새 노드를 가리킴
        }

        size++;
        return true;
    }

    public boolean pushLast(Object data) {
        DNode newNode = new DNode(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.prev = tail; // 새 노드의 이전 노드를 기존 tail로 연결
            tail.next = newNode; // 기존 tail의 next를 새 노드로 연결
        }
        tail = newNode; // tail은 새 노드를 가리킴
        size++;
        return true;
    }

    /*
        1. cur가 첫번째 노드일 경우
        2. cur가 중간 노드일 경우
        3. cur가 마지막 노드일 경우
     */
    public boolean pushRandom(DNode cur, Object data) {
        DNode temp = cur.next;

        if (temp == null) {
            return pushLast(data);
        }

        DNode newNode = new DNode(data);
        newNode.next = temp;
        temp.prev = newNode;
        newNode.prev = cur;
        cur.next = newNode;

        size++;
        return true;
    }

    // delete method
    /*
        1. 노드가 없을 때 : return false;
        2. 노드가 하나일 때 : head와 tail이 null
        3. 노드가 두 개이상일 때
            - head는 del의 다음 노드를 가리킴
            - del의 다음 노드의 prev는 null
     */
    public boolean removeFirst() {
        DNode del = head;

        if (del == null) {
            return false;
        }

        if (del.next == null) {
            head = null;
            tail = null;
        } else {
            head = del.next;
            del.next.prev = null;
        }

        size--;
        return true;
    }

    public boolean removeLast() {
        if (head == null) {
            return false;
        }

        if (head.next == null) {
            head = null;
            tail = null;
        } else {
            tail.prev.next = null;
            tail = tail.prev;
        }

        size--;
        return true;
    }

    /*
        1. del이 null인가?
        2. del 첫번째 노드일 경우 : del.prev가 null임
        3. del 마지막 노드일 경우 : del.next가 null임
        4. del 중간 노드일 경우  : del.next.prev / del.prev.next 를 설정
     */
    public boolean removeRandom(DNode del) {
        if (del == null) {
            return false;
        }

        if (del.prev == null) {
            return removeFirst();
        } else if (del.next == null) {
            return removeLast();
        } else {
            del.prev.next = del.next;
            del.next.prev = del.prev;
        }

        size--;
        return true;
    }

    // select method
    public DNode select(Object key) {
        DNode cur = head;
        while (cur != null) {
            int data = (int) cur.data;
            if (data == (int) key) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    // print method
    // head --> tail (next)
    public void selectAll() {
        System.out.print("["+size+"] ");
        DNode cur = head;
        while (cur != null) {
            System.out.print(cur.data + " -> ");
            cur = cur.next;
        }
        System.out.println("null");
    }

    // tail --> head (prev)
    public void selectPrev() {
        System.out.print("["+size+"] ");
        DNode cur = tail;
        while (cur != null) {
            // int data = (int) cur.data    // 언박싱!(자동) : 기본형타입 = 레퍼런스타입
            System.out.print(cur.data + " -> "); // cur.data는 Object 타입, 원래라면 주소 값이 출력, 그러나 현재 JDK 버전은 자동으로 언박싱을 해주기때문에 그 주소에 있는 값이 나옴
            cur = cur.prev;
        }
        System.out.println("null");
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }
}
