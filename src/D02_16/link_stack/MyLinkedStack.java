package D02_16.link_stack;

// 스택처럼 동작하기 위해 이미 구현된 이중연결리스트 클래스를 활용 및 응용함
public class MyLinkedStack {

    private MyDList list = new MyDList();

    public boolean push(Object data) {
        return list.pushFirst(data);
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
    public Object pop() {
        if (isEmpty()) {
            return null;
        }
        Object data= list.getHead().data;
        list.removeFirst();
        return data;
    }

    public void printAll() {
        list.selectPrev(); // 뒤에서부터 출력
    }

    public Object getTop() throws Exception{
        if (isEmpty()) {
            throw new Exception("비어있다.");
        }
        return list.getHead().data;
    }

    public void clear() {
        list.clear();
    }


}
