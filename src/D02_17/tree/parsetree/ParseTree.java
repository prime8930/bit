package D02_17.tree.parsetree;

import D02_16.array_stack.MyStack;

public class ParseTree {

    public class Node {
        int key;
        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
            left = right = null;
        }

    }

    // member field
    Node root; // 루트 주소를 저장할 레퍼런스 변수
    int cnt; // 노드 개수

    // constructor
    public ParseTree() {
        root = null;
        cnt = 0;
    }

    // get method
    public int getCount() {
        return cnt;
    }

    public int getRootValue() {
        return root.key;
    }

    // method

    /*
     * 	<수식나무 구성>
     * 	1. 스택 자료구조 생성 [ HAS A ]
     *	2. 반복문(문장의 끝까지)
     *		2.1 연산자라면?
     *			2.1.1 노드 생성, cnt 증가
     *			2.1.2 pop -> 오른쪽 자식으로 할당
     *			2.1.3 pop -> 왼쪽 자식으로 할당
     *			2.1.4 2.1.1에서 만든 노드 push
     *		2.2 연산자가 아니라면?
     *			2.2.1 노드 생성, cnt 증가
     *			2.2.2 push
     *	3. root = pop
     */
    void makeParseTree(String str) throws Exception {
        MyStack stack = new MyStack();

        for(char c : str.toCharArray() ) {
            Node node = new Node(c);

            if(c == ' ') {
                continue;
            } else if(isOperand(c)) { // Character.isDigit(c) 로도 가능
                node.right = (Node) stack.pop();
                node.left = (Node) stack.pop();
                stack.push(node);
            } else {
                stack.push(node);
            }
            cnt++;
        }

        root = (Node) stack.pop();

    }


    // 연산자 식별 함수
    private boolean isOperand(int value) {
        return value == '+' || value == '-' || value == '*' || value == '/';
    }

    // 순회코드(재귀) --> 알고리즘 경진대회에서는 재귀 사용 시 오버플로우로 인해 사용 불가
    public void preOrder() {
        innerPreOrder(root);
        System.out.println();
    }

    private void innerPreOrder(Node root) {
        if(root != null) {
            System.out.print((char) root.key + " ");
            innerPreOrder(root.left);
            innerPreOrder(root.right);
        }
    }

    public void inOrder() {
        innerInOrder(root);
        System.out.println();
    }

    private void innerInOrder(Node root) {
        if(root.left != null)
            innerInOrder(root.left);
        System.out.print((char) root.key + " ");
        if(root.right != null)
            innerInOrder(root.right);
    }

    public void postOrder() {
        innerPostOrder(root);
        System.out.println();
    }

    private void innerPostOrder(Node root) {
        if(root.left != null)
            innerPostOrder(root.left);
        if(root.right != null)
            innerPostOrder(root.right);
        System.out.print((char) root.key + " ");
    }

    // 순회코드(비재귀-스택)
    /*
     * 	1. push(root)
     * 	2. 반복문(!stack.isEmpty())
     * 		2.1 pop()
     * 		2.2 if(자식 노드 != null)
     * 			2.2.1 방문(print())
     * 				- 오른쪽 자식 push()
     * 				- 왼쪽 자식 push()
     */
    // stack에 null을 push하는 방법
    public void preOrder_stack1() throws Exception { // C -> L -> R
        MyStack stack = new MyStack();

        stack.push(root);

        while(!stack.isEmpty()) {
            Node temp = (Node) stack.pop();
            if(temp != null) {
                System.out.print((char) temp.key + " ");
                stack.push(temp.right);
                stack.push(temp.left);
            }
        }
    }

    // stack에 null을 push하지 않는 방법(개선)
    public void preOrder_stack2() throws Exception { // C -> L -> R
        MyStack stack = new MyStack();
        stack.push(root);

        while(!stack.isEmpty()) {
            Node temp = (Node) stack.pop();
            System.out.print((char) temp.key + " ");
            if(temp.right != null)
                stack.push(temp.right);
            if(temp.left != null)
                stack.push(temp.left);
        }
    }

    /*
     * 	Node node = root
     * 	while(true)
     * 		1. 반복(node != null)
     * 			1.1 push(node)
     * 			1.2 node = node.left
     * 		2. if(!stack.isEmpty)
     * 			2.1 pop()
     * 			2.2 print()
     * 			2.3 node = node.right
     * 		3. if(stack.isEmpty())
     * 			break
     */
    public void inOrder_stack() throws Exception { // L -> C -> R
        MyStack stack = new MyStack();
        Node node = root;

        while(true) {
            while(node != null) {
                stack.push(node);
                node = node.left;
            }

            if(stack.isEmpty()) {
                break;
            } else {
                node = (Node) stack.pop();
                System.out.print((char) node.key + " ");
                node = node.right;
            }
        }
    }

    public void postOrder_stack() throws Exception { // L -> R -> C
    }

}
