package D02_18.hash;

public class Start {

    public static void main(String[] args) {
        exam1();
    }

    private static void exam1() {
        MyHash hash = new MyHash(10);

        int data = 0;

        // insert test
        for (int i = 0; i < 10; i++) {
            data = (int) (Math.random() * 100) + 1;
            hash.insert(data);
        }

        // print test
        hash.printAll();

        // select test
        int idx = hash.select(data);
        if(idx == -1)
            System.out.println("없다.");
        else
            System.out.println("검색결과 : " + hash.getData(idx));

        // delete test
        hash.delete(data);
        hash.printAll();

    }

}
