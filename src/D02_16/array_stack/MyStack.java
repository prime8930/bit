package D02_16.array_stack;


public class MyStack {

    // step 1) 클래스, 멤버 필드, 생성자 정의
    // memeber field
    private Object[] arr;
    private int max;
    private int top;

    // constructor
    public MyStack() {
        this(10);
    }

    public MyStack(int max) {
        this.max = max;
        arr = new Object[max];
        this.top = -1;
    }

    // step 2) 메소드 정의
    // insert
    public void push(Object data) throws Exception {
        if (isOverflow()) {
            return;
        }
        arr[++top] = data; // 전치 : 해당문장(;) 에서 가장 먼저 처리되는 것
    }

    private boolean isOverflow() {
        return top + 1 >= max;
    }

    // delete
    public Object pop() {
        if (isEmpty()) {
            return null;
        }
        return arr[top--];
    }

    public boolean isEmpty() {  // 메소드 원칙은 이름에 대한 답을 줘야 한다.
        return top == -1;
    }

    // printAll
    public void printAll() {
        for (int i = 0; i <= top; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // top에 있는 값 출력
    public Object getTop() throws Exception {
        if (isEmpty()) {
            throw new Exception("비어있습니다.");
        }
        return arr[top];
    }

    // 초기화
    public void clear() {
        top = -1;
    }
}
