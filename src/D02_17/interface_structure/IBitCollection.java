package D02_17.interface_structure;

// 배열과 연결리스트의 구현 약속
public interface IBitCollection {

    // 자동으로 public abstract 키워드가 붙어 추상 메소드가 됨.
    int getSize();
    Object getData(int idx);
    void insert(Object o) throws Exception;
    void delete(int idx) throws Exception;

}
