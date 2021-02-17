package D02_17.tree.parsetree;

public class Start {

    public static void main(String[] args) throws Exception {
        ParseTree ptree = new ParseTree();

        String str = "3 2 + 4 * 2 -";

        ptree.makeParseTree(str);

        // 체크
        // 1. 개수 : 7개
        System.out.println(ptree.getCount());

        // 2. root : -
        System.out.println( (char) ptree.getRootValue());

        // 순회 체크(재귀)
        System.out.print("전위(재귀) : ");
        ptree.preOrder();
        System.out.print("중위 : ");
        ptree.inOrder();
        System.out.print("후위 : ");
        ptree.postOrder();

        // 순회 체크(스택(비재귀))
        System.out.print("전위(스택) : ");
        ptree.preOrder_stack2();
        System.out.print("중위(스택) : ");
        ptree.inOrder_stack();
//		System.out.print("후(스택) : ");
//		ptree.postOrder_stack();

    }
}

