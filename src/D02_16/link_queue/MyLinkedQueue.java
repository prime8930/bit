package D02_16.link_queue;

public class MyLinkedQueue {
    private MyDList list = new MyDList();


    public boolean put(Object data) {
        return list.pushLast(data);
    }

    public boolean isEmpty() {
        MyDList.DNode node = list.getHead();
        return node == null;
    }

    /*
        1. 비어있는 상태 체크
        2. 삭제 전 head가 갖고 있는 값을 획득
        3. 삭제 연산(removeFirst)
        4. head 값 return
     */
    public Object get() {
        if (isEmpty()) {
            return "값이 존재하지 않습니다.";
        }
        Object data= list.getHead().data;
        list.removeFirst();
        return data;
    }

    public void printAll() {
        list.selectAll(); // 앞에서부터 출력
    }

    public void clear() {
        list.clear();
    }

}
