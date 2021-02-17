package D02_17.tree.binary;

public class MyBinarySearchTree {
    public class Node{
        int key;
        Node left;
        Node right;

        public Node(int key){
            this.key = key;
            left = right = null;
        }
    }

    private Node root;
    private int cnt;

    public MyBinarySearchTree() {
        root = null;
        cnt = 0;
    }

    // select(비재귀)
    public Node search(int key) {
        return innerSelect(key);
    }

    public Node innerSelect(int key) {
        Node cur = root;
        while(cur != null) {
            if(cur.key == key)
                return cur;
            else if(cur.key < key)
                cur = cur.right;
            else if(cur.key > key)
                cur = cur.left;
        }
        return null;
    }

	/*	재귀 select
	private Node InnserSelect(Node cur, int key) {
		if(cur == null || cur.key == key)  //없을경우 or 찾았을 경우
			return cur;
		if( cur.key > key)
			return InnserSelect(cur.left, key);
		else
			return InnserSelect(cur.right, key);
	}
	 */

    // insert(재귀)
    public void insert(int key) {
        if(root == null)
            root = new Node(key);
        else
            innerInsert(root, key);
    }

    private void innerInsert(Node cur, int key) {
        if(cur.key > key) {
            if(cur.left != null)
                innerInsert(cur.left, key);
            else {
                cur.left = new Node(key);
                cnt++;
            }
        } else if(cur.key < key)
            if(cur.right != null)
                innerInsert(cur.right, key);
            else {
                cur.right = new Node(key);
                cnt++;
            }
        else if(cur.key == key)
            return;
    }

	/* 비재귀 insert
	public void insertNonRe(int key) {
		if( root == null) {
			root = new Node(key);  count++;
			return;
		}

		Node cur = root;
		while(true) {
			if(cur.key < key) {
				if(cur.right == null) {
					cur.right = new Node(key);
					count++;
					break;
				}
				else
					cur = cur.right;
			}
			else if(cur.key > key){
				if(cur.left == null) {
					cur.left = new Node(key);
					count++;
					break;
				}
				else
					cur = cur.left;
			}
			else if(cur.key == key)
				return;
		}
	}

	 */

    // 중위 순회(오름차순 정렬)
    public void inOrder() {
        innerInOrder(root);
        System.out.println();
    }

    private void innerInOrder(Node root) {
        if(root.left != null)
            innerInOrder(root.left);
        System.out.print((int) root.key + " ");
        if(root.right != null)
            innerInOrder(root.right);
    }

    // delete(비재귀)
    public boolean delete(int key) {
        Node parent = null;
        Node del = root;

        // select 알고리즘(삭제할 노드와 그의 부모 노드를 찾는 것이 중요)
        // 반복문 종료조건 : 현재 노드 == null(검색 실패) or 값을 찾을 경우
        while( del != null && del.key != key) {
            parent = del;
            if(key < del.key)
                del = del.left;
            else
                del = del.right;
        }

        // 못찾은 경우
        if(del == null)
            return false;

        // 삭제 알고리즘
        if(del.left == null && del.right == null) { // 자식이 없는 경우

            if(parent == null) // 1. 부모가 없는 경우
                root = null;
            else { // 2. 부모가 있는 경우
                if(parent.left == del) // 삭제할 노드가 부모의 어느 부분에 존재하는가
                    parent.left = null;
                else
                    parent.right = null;
            }

        } else if(del.left == null || del.right == null) { // 자식이 하나인 경우

            // 삭제할 노드의 어느부분에 자식이 존재하는지 판단 후 child 할당
            Node child;
            if(del.left != null)
                child = del.left;
            else
                child = del.right;

            // 1. 부모가 없는 경우[root 삭제]
            if(parent == null)
                root = child;
                // 2. 부모가 있는 경우
            else {
                if(parent.left == del)
                    parent.left = child;
                else
                    parent.right = child;
            }


        } else { // 자식이 모두 있는 경우, 선택: 삭제 노드의 (왼쪽 자식 중 가장 큰 값) or (오른쪽 자식 중 가장 작은 값)

            // 삭제 노드의 자식 중 가장 작은 노드와 그 부모 노드를 찾음.
            Node move_parent = del;
            Node move = del.right;
            while(move.left != null) {
                move_parent = move;
                move = move.left;
            }

            // right는 null일 수도 있고, 노드 주소일 수도 있다.
            if(move_parent.left == move)
                move_parent.left = move.right;
            else
                move_parent.right = move.right;

            del.key = move.key; // 찾은 값을 삭제할 노드의 값에 저장
        }

        cnt--;
        return true;
    }
}
