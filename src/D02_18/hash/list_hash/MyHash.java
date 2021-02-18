package D02_18.hash.list_hash;

public class MyHash {
    //맴버 필드
    private MyDList[] arr;	//
    private int max;		//저장의 최대 크기[Overflow 조건 검사]
    private int size;		//현재 저장된 갯수

    //생성자
    public MyHash(int max) {
        this.max = max;
        this.size = 0;

        arr = new MyDList[max];				//배열 생성
        for(int i=0; i< arr.length; i++)
            arr[i] = new MyDList();			//각 배열의 저장공간에 연결리스트를 생성
    }

    //get & set 메서드
    public Object getData(int idx) {

        return null;
        //return arr[idx];
    }

    private boolean isOverflow() {
        return false;
    }

    private boolean isUniq(Object key) {
        for(int i=0; i<arr.length; i++) {
            MyDList list = arr[i];
            MyDList.DNode node = list.Select(key);
            if(node != null)
                return false;
        }
        return true;
    }

    public boolean insert(Object key) {
        if(isUniq(key) == false)
            return false;

        if(isOverflow() == true)
            return false;

        int hvalue = hashFunction(key);

        MyDList list = arr[hvalue];
        list.push_front(key);
        size++;

        return true;
    }

    public Object select(Object key) {
        int hvalue = hashFunction(key);
        MyDList list = arr[hvalue];
        MyDList.DNode node = list.Select(key);
        if(node != null)
            return node.data;
        return null;
    }


    public boolean delete(Object key) {
        int hvalue = hashFunction(key);
        MyDList list = arr[hvalue];
        MyDList.DNode node = list.Select(key);
        if(node != null) {
            list.erase_random(node);
            return true;
        }
        else
            return false;
    }

    public void clear() {
        this.size = 0;

        for(int i=0; i< arr.length; i++) {
            MyDList list = arr[i];
            list.Clear();
        }
    }

    public void printAll() {
        System.out.println("저장개수 : " + size);
        System.out.println("\n--------------------------------------------------------------------------------------");
        for(int i=0; i< arr.length; i++) {
            System.out.print("[" + i + "]" );
            MyDList list = arr[i];
            list.Select_PrevAll();
            System.out.println();
        }
        System.out.println("\n--------------------------------------------------------------------------------------");
    }

    //해쉬 함수
    private int hashFunction(Object key) {
        return ((int)key % max);
    }
}
