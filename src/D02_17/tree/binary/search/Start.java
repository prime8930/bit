package D02_17.tree.binary.search;

public class Start {

    public static int search(char[] str, char key) {
        int mid;

        int left = 0;
        int right = str.length - 1;

        int cnt = 0;
        while (right >= left) {
            mid = (right + left) / 2; // 구간의 중간값을 획득

            if (key == str[mid]) {
                return mid;
            } else if (key < str[mid]) { // key는 왼쪽에 있다.
                right = mid - 1;
            } else if (key > str[mid]) { // key는 오른쪽에 있다.
                left = mid + 1;
            }
            System.out.println("검색 횟수: " + cnt++);
        }
        return -1; // key가 존재하지 않는다.
    }

    public static void main(String[] args) {
        String str = "abcdefghij";

        int idx = search(str.toCharArray(), 'c');

        if(idx == -1) {
            System.out.println("없다.");
        } else {
            System.out.println("찾은 결과: " + str.charAt(idx));
        }
    }
}
