package D02_18.map;

/*
    Map : pair 형태의 자료구조
          [Key, Value]
          Key : 검색에 활용, 중복 X
          Value : 실제 값, 중복 O
 */

//  1. Pair[K, V] 형태로 관리할 데이터 타입
class PairData {
    int key;        // 회원번호
    Member mem;     // 저장 값

    public PairData(Member mem) {
        key = mem.getNumber();
        this.mem = mem;
    }
}

/*
    저장 공간의 일관성
    자바 Collection 클래스
    1.  Object 저장(초기에는 JDK에 템플릿 문법 X)
        하나의 저장소에 정수, 객체 섞어서 저장해도 저장이 가능! 문제점.
    2.  템플릿 기반 저장( JDK 1.2?)
    ==> Object를 저장하는 형태로 수정!!!!!!!! null(비어있을 때)
 */


public class MyHashMap {

    // member field
    private Object[] arr;   // 배열을 max값보다 120% 크기로 생성
    private int bucket_max; // 배열의 실제 크기[배열 생성 or 원형 이동]
    private int max;    // 저장 최대 크기[Overflow 조건 검사]
    private int size;   // 현재 저장된 개수

    // constructor
    public MyHashMap(int max) {
        this.max = max;
        size = 0;
        bucket_max = (int) (max * 1.2);

        // 배열 생성 및 초기화
        arr = new Object[bucket_max];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }
    }

    // get & set method
    public Object getData(int idx) {
        return arr[idx];
    }

    // functional method
    // bucket의 상태 값 (비어있는 상태 : -1 / 삭제된 상태 : -2 / 값이 저장된 상태 : 0~N)
    /*
        1. overflow 조건 검사(정적 구조)
        2. 해시 값 획득(해시 함수 활용)
        3. 저장 알고리즘
            빈 공간 or 삭제 공간을 찾아(반복문, 시작점 : 해시값의 위치부터)
                - 이동 시 원형 이동 필요!
            찾은 공간 위치에 저장
            size++
     */
    public boolean insert(Object key, Object value) {
        if (isExist(key))    // 값 중복 검사
            return false;

        if (max <= size)    // overflow 검사
           return false;

        int hval = hashFunction(key);

        while (arr[hval] != null && ((Member) arr[hval]).getNumber() != -2) {
            hval = (hval + 1) % bucket_max;
        }

        arr[hval] = value;
        size++;

        return true;
    }

    /*
    private boolean IsOverflow() {
		if( max <= size)
			return true;
		else
			return false;
	}
     */

    private boolean isExist(Object key) {
        for (int i = 0; i < arr.length; i++) {
            Member mem = (Member) arr[i];
            if(mem != null && mem.getNumber() == (int)key )
                return true;
        }
        return false;
    }

    /*
        1. 해시 값 얻는다(해시테이블)
        2. 반복문 활용 검색([해시 값, 해당 버킷이 비어있을때(-1)])
            if(저장 값과 키 값을 비교)
        [결과 값] 버킷의 인덱스 반환(실패 시 -1)
     */
    public int select(Object key) {
        int hval = hashFunction(key);
        int i = hval;
        while(true) {
            try {
                Member mem = (Member) arr[i];
                if (((Member)arr[i]).getNumber() != -1)
                    if (mem.getNumber() == (int) key)
                        return i;
                break;
            }
            catch(Exception ex) {
            }
            i = (i + 1) % bucket_max;
        }
        return -1;
    }


    public Object keyToValue(int key) {
        int idx = select(key);
        if(idx == -1)
            return null;
        return arr[idx];
    }

    /*
        1. key 값이 저장된 버킷의 인덱스 값을 획득(select 활용)
        2. 없는 경우(select의 반환 값이 -1)
            return false
        3. 찾은 경우
            해당 버킷의 값을 -2로 저장
            size--
            return true
     */
    public boolean delete(Object key) {
        int idx = select(key);

        if( idx == -1)
            return false;

        ((Member)arr[idx]).setNumber(-2);      // <======= 문제
        size--;
        return true;
    }

    public void clear() {
        size = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = null;
        }
    }

    public void printAll() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i + "\t");
        }
        System.out.println("\n---------------------------------------------");
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == null)
                System.out.print("-1\t");
            else
                System.out.print(((Member)arr[i]).getNumber() + "\t");
        }

        System.out.println("\n---------------------------------------------");

        /*

		System.out.println("\n--------------------------------------------------------------------------------------");
		for(int i=0; i< arr.length; i++) {
			if( (int)arr[i] == -1)
				System.out.print("-1" + "\t");
			else if((int)arr[i] == -2)
				System.out.print("-2" + "\t");
		}
		System.out.println("\n--------------------------------------------------------------------------------------");
	}

         */
    }

    // hash function
    private int hashFunction(Object key) {
        return (int) key % bucket_max;
    }


}
