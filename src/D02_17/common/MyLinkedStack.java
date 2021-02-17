package D02_17.common;

public class MyLinkedStack {
    private MyDList list = new MyDList();

    public boolean Push(Object data) {
        return list.pushLast(data);
    }

    public boolean IsEmpty() {
        MyDList.DNode node = list.getHead();
        if(node == null)
            return true;
        else
            return false;
    }

    public Object Pop() {
        //비어있는 상태 체크(비어있다면 null)
        if(IsEmpty())
            return null;
        //삭제하기 전에 head가 갖고 있는 값을 획득!
        //MyDList.DNode node = list.getHead();
        //Object data = node.data;
        Object data = list.getHead().data;
        list.removeFirst();
        return data;
    }

    public void PrintAll() {
        list.selectPrev();
    }

    public Object GetTop() throws Exception{
        MyDList.DNode node = list.getHead();
        if(node == null)
            throw new Exception("비어있다.");
        return node.data;
    }

    public void clear() {
        list.clear();
    }
}

