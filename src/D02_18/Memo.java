package D02_18;

public class Memo {
}

/*
    1. 해쉬(Hash)
        1) 개념
            - 원소가 저장될 자리가 원소의 값에 의해 결정되는 자료구조
            - O(1) 시간에 삽입, 삭제, 검색이 가능
            - 매우 빠른 응답을 요하는 응용에 유용

            예시) 긴급구조 호출, 호출번호 관련 정보 검색, 주민등록 시스템

        2) 특징
            - 자료 수 N에 상관없이 O(1) 검색 길이를 가지는 검색
            - bucket : 아파트 현관에 호실 번호에 따른 우체통의 하나하나를 의미
            - slot : 우체통의 꽂힌 우편물의 개수
            - key : 주소(저장할 값)
            - hash value : 우편 번호(저장할 버킷 번호) [=hash function(key)]
            - hash table : bucket의 집합(전체 우체통)
            
            => key에 의해 이미 hash value가 정해져 있다.
            예시) 123(key) 을 저장한다면 123 % 10(hash function) = 3(hash value)로 정해져 나온다.
            
            * slot 충돌 : 같은 장소에 다른 key값들이 모일 때 이를 synonym이라 하고 synonym 발생하는 현상
            
        3) 해시 함수
            - key의 입력이 빨라야 하며, 해시 테이블에 골고루 분포시켜야 한다.
            - 대표적인 방법 : 나누기, 곱하기 방법이 있다.(계산이 간단해야 함)

            + 충돌 해결
                [배열]
                    1. 선형 탐사법[linear probing] = 선형 개방 주소 지정법[open addressing]
                    2. 이중 해시법
                [배열 + 연결리스트] : bucket 안에 여러 개의 slot, 하나의 bucket에 여러 개의 데이터 저장 가능
                    3. 연결법(체인 이용법[chainning])

        4) 선형 탐사법(linear probing)
            - 충돌이 일어나더라도 어떻게든 주어진 테이블 공간에서 해결한다.
            - 빈자리가 생길때까지 해시값을 계속 만든다.

            - 특징
                1) 정적인 해시 테이블 = 배열
                2) 입력 수는 해시테이블의 버킷 수를 초과할 수 없다.
                3) 정적 해시 검색도 충돌이 발생한다.
                4) 다른 key가 버킷에 들어있다면 단순히 다음 버킷에 삽입

            - 장점: 해시테이블 구조 간단
            
            - 단점: 충돌 발생 시, 최악의 경우 해시테입르 전체를 검색해야 하는 경우 발생 / 무한 루프

            - overflow : 버킷 크기 1이며, 충돌 발생 시 동시에 오버플로우 발생
                => 클러스터(덩어리) : 10개 삽입 시키고 싶으면 버킷 크기 12로 생성

 */
