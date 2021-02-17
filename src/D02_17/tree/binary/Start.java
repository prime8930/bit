package D02_17.tree.binary;


public class Start {

    public static void main(String[] args) {
        MyBinarySearchTree bst = new MyBinarySearchTree();

        System.out.print("저장값: " );
        int value = 0;
        for(int i =0; i<10; i++) {
            value = (int) (Math.random()*100) +1;
            System.out.print(value + " ");
            bst.insert(value);
        }

        // 결과 확인
        System.out.println("\n[순회 결과값]");
        bst.inOrder();

        // 검색 테스트
        MyBinarySearchTree.Node node = bst.search(value);
        if(node == null)
            System.out.println("없다.");
        else
            System.out.println("찾은값 : " + node.key);

        // 삭제 테스트
        bst.delete(value);

        System.out.println("\n[삭제 후 순회 결과값]");
        bst.inOrder();
    }

}
