public class BitArray {

    // 1. 멤버 필드 선언
    private Object[] base;
    private int max;
    private int size;

    // 2. 생성자 선언
    public BitArray() {
        this(10); // this()는 매개변수가 많은 생성자의 것을 사용한다.
    }

    public BitArray(int max) {
        this.max = max;
        size = 0;
        base = new Object[this.max];
    }

    // 3. get & set 메소드 선언
    public int getMax() {
        return max;
    }

    public int getSize() {
        return size;
    }

    public boolean isOverflow() {
        return size < max;
    }

    public boolean isUseIdx(int idx) {
        return idx >= 0 && idx <= size - 1;
    }

    // 기능 메소드 선언
    public Object getData(int idx) {
        if (isUseIdx(idx)) {
            return base[idx];
        } else {
            return null;
        }
    }

    public void insert(Object o) throws Exception {
        if (isOverflow()) {
            base[size] = o;
            size++;
        } else {
            throw new Exception("저장 공간이 부족합니다.");
        }
    }

    public void delete(int idx) throws Exception {
        if (isUseIdx(idx)) {
            for (int i = idx; i < size-1; i++) {
                base[i] = base[i + 1];
            }
            size--;
        } else {
            throw new Exception("유효하지 않은 접근입니다.");
        }

    }

    public void select(Object data) {
        for (int i = 0; i < size; i++) {
            if (base[i] == data) {
                System.out.println("해당 데이터가 존재합니다.");
                return;
            }
        }
        System.out.println("해당 데이터가 존재하지 않습니다.");
    }


}

