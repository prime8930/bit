package D02_16.array_queue;

public class MyQueue {

    private Object[] arr;
    private int max;
    private int rear;
    private int front;

    public MyQueue() {
        this(10);
    }

    public MyQueue(int max) {
        this.max = max;
        arr = new Object[max];
        rear = 0;
        front = 0;
    }

    /*
        insert
        1. overflow 확인
        2. 데이터 먼저 저장
        3. 원형 이동 : (rear + 1) % max
     */
    public boolean put(Object data) {
        if (overflow()) {
            return false;
        }
        arr[rear] = data;
        rear = (rear + 1) % max;
        return true;
    }

    private boolean overflow() {
        return front == (rear + 1) % max;
    }

    /*
        delete
        1. isEmpty 확인
        2. 임시 변수에 데이터를 저장
        3. front 원형 이동 : (front + 1) % max
        4. 값 반환
     */
    public Object get() throws Exception {
        if (isEmpty()) {
            return "값이 존재하지 않습니다.";
        }
        Object temp = arr[front];
        //arr[front] = null;
        front = (front + 1) % max;
        return temp;
    }

    private boolean isEmpty() {
        return front == rear;
    }

    public void printAll() {
        System.out.print("[front] <- ");
        for (int i = front; i != rear; i = (i+1) % max) {   // rear는 데이터 존재 X
            System.out.print(arr[i] + " <- ");
        }
        System.out.print("[rear]");
        /*while (arr[front] != null) {
            System.out.print(arr[front] + " ");
            front = (front + 1) % max;
        }*/

        System.out.println();
    }

    public void clear() {
        rear = front = 0;
    }
}
