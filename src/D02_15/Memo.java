package D02_15;

public class Memo {
}

/*
 배열 : 저장 공간이 있다.
 그 안의 데이터는 물리적, 연속적으로 채워진다.
 장점 : 검색

 연결리스트 : 저장 공간이 없다.
 그 안의 데이터는 논리적으로 다음 위치의 정보를 가진다.(선형의 성질)
 시작점을 반드시 알아야 한다.(head : 첫번째 노드의 주소를 가짐)
 장점 : 삽입, 삭제
 */

/*
 insert : 저장 위치는 size
 처음에 overflow인지 확인

 delete : 시작 위치부터 어디까지 반복할 것이냐
 시작 위치는 설정한 인덱스부터 현재 size에서 1을 뺀 곳까지
 처음에 인덱스가 유효값인지 확인

 select : 인덱스 0부터 현재 용량인 size까지(순차검색)
 */

/*
 단일연결리스트 : 이동시 ++ 연산만 가능

 이중연결리스트 : 이동시, ++, -- 연산 가능

 환형연결리스트(단일 or 이중) : 마지막 노드가 첫번째 노드를 가리킨다.
 */