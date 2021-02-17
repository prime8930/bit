package D02_17.common;

public class MyStack {
    private Object[] arr;
    private int max;
    private int top;


    public MyStack() {
        this(10);
    }

    public MyStack(int max) {
        this.max = max;
        arr = new Object[max];
        this.top = -1;
    }


    public void push(Object data) throws Exception {
        if (isOverflow()) {
            return;
        }
        arr[++top] = data;
    }

    private boolean isOverflow() {
        return top + 1 >= max;
    }


    public Object pop() {
        if (isEmpty()) {
            return null;
        }
        return arr[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }


    public void printAll() {
        for (int i = 0; i <= top; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    public Object getTop() throws Exception {
        if (isEmpty()) {
            throw new Exception("비어있습니다.");
        }
        return arr[top];
    }

    public void clear() {
        top = -1;
    }
}

