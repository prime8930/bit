package D02_15.doubly;

import D02_16.link_stack.MyDList;

public class Start {
    public static void main(String[] args) {
        exam1();
    }

    private static void exam1() {
        MyDList list = new MyDList();

        for (int i = 10; i <=50; i+=10) {
            list.pushLast(i);
        }

        list.selectAll();
//        list.selectPrev();

//        MyDList.DNode node = list.getHead();
//        node = node.next.next;
//        list.pushRandom(node, 35);

        list.removeRandom(list.select(20));

        list.selectAll();


        //list.selectPrev();

        /*MyDList.DNode cur = list.select(10);
        if (cur != null) {
            System.out.println("검색결과 : " + (int) cur.data);
        } else {
            System.out.println("없다.");
        }*/
    }


}
