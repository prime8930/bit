package D02_16.stack_test;

public class Start {
    public static void main(String[] args) throws Exception {
        StackTest r = new StackTest();

        // reverse
        String str1 = " abcdefg";
        System.out.println(r.reverseString(str1));

        // decimal to binary
        r.decToBinary(100);

        // postFix_calculator
        String str = "1 0 /";
        System.out.println(r.postFix_cal(str));
    }
}
