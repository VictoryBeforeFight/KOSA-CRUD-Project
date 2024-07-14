# miniprj

[mini 조별과제 재고관리 어플리케이션.pdf](https://github.com/gaekobalding/miniprj/files/14881980/2.pdf)<br>
[조별 1차 과제 .docx](https://github.com/gaekobalding/miniprj/files/14881982/1.2._.1.docx)

<h1>프로젝트 구조</h1><br>
<img width="163" alt="image" src="https://github.com/user-attachments/assets/e04c4c27-8e83-481b-80fe-420300407a99"><br>
<br>
<h1>테이블 구조</h1>
<img width="187" alt="image" src="https://github.com/user-attachments/assets/85e05069-3504-4896-9496-1ed1ffe65c04">
<br>
<img width="251" alt="image" src="https://github.com/user-attachments/assets/6c3a087c-2fd8-44b9-968b-8eed6c5f116b">

<h1>기능 명세</h1><br>
**(사용자)**

| 기능 | 요청 URL | 요청 파라미터 | 요청 방식 | 핸들러 메서드 | View(.jsp) | 비고 |
| --- | --- | --- | --- | --- | --- | --- |
| 로그인 | /user/login |  |  |  |  |  |
| 예약 | /user/reserve |  |  |  |  |  |
| 본인의 전체 예약 내역 조회 | /user/list/{userId} |  |  |  | user/list |  |
| 부분 예약 내역 조회(날짜로 검색) | /user/list/{checkinDate} |  |  |  | user/list |  |
| 예약 취소 | /user/delete/{reserveId} | reserveId | GET | deleteReservation() | user/listview |  |
| 예약 성공 확인(상세내역) | /user/detail/{reserveId} | reserveId | GET | updateReservation | user/detail |  |
| 예약 수정(상세내역) | /user/detail/{reserveId} | Detail detail | POST | updateReservation() | user/detail |  |
|  |  |  |  |  |  |  |

**(관리자)**

| 기능 | 요청 URL | 요청 파라미터 | 요청 방식 | 핸들러 메서드 | View | 비고 |
| --- | --- | --- | --- | --- | --- | --- |
| 전체 예약 내역 조회(모든 사용자) | /manager/list |  | GET |  | manager/list |  |
| 부분 예약 내역 조회(사용자 이름 검색) | /manager/list |  | GET |  | manager/list |  |
| 부분 예약 내역 조회(호텔 이름 검색) | /manager/list |  | GET |  | manager/list |  |

<h1>최종 SQL</h1>
```sql
DROP TABLE RESERVATION;
DROP TABLE HOTEL;
DROP TABLE CUSTOMER;

CREATE SEQUENCE customer_seq
START WITH 1
INCREMENT BY 1
NOCACHE;

CREATE TABLE customer (
    customer_id NUMBER(10) DEFAULT customer_seq.NEXTVAL PRIMARY KEY,
    customer_name VARCHAR2(260) NOT NULL,
    password VARCHAR2(260) NOT NULL,
    birth DATE NOT NULL,
    phone_number VARCHAR2(260) NOT NULL,
    email VARCHAR2(260) NOT NULL,
    CONSTRAINT unique_phone_number UNIQUE (phone_number),
    CONSTRAINT unique_email UNIQUE (email)
);

CREATE TABLE hotel (
    hotel_id NUMBER(10) PRIMARY KEY,
    hotel_name VARCHAR2(260) NOT NULL,
    address VARCHAR2(260) NOT NULL,
    hotel_number VARCHAR2(260) NOT NULL,
    price NUMBER(8) NOT NULL,
    rating NUMBER(2,1),
    hotel_image BLOB,
    CONSTRAINT unique_hotel_number UNIQUE (hotel_number)
);

INSERT INTO hotel VALUES (1, 'Grand Hyatt Seoul', '서울특별시 용산구 소월로 322', '02-001-001', 544500, 3.8, NULL);
INSERT INTO hotel VALUES (2, 'Josun Palace', '서울특별시 강남구 테헤란로 231', '02-002-002', 550000, 4.6, NULL);

CREATE SEQUENCE reservation_seq
START WITH 1
INCREMENT BY 1
NOCACHE;

CREATE TABLE reservation (
    reserve_id NUMBER(10) DEFAULT reservation_seq.NEXTVAL PRIMARY KEY,
    customer_id NUMBER(10) NOT NULL,
    hotel_id NUMBER(10) NOT NULL,
    reserve_date Timestamp DEFAULT SYSTIMESTAMP NOT NULL,
    checkin_date Date NOT NULL,
    checkout_date Date NOT NULL,
    room_number NUMBER(2) NOT NULL,
    people_number NUMBER(2) NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
    FOREIGN KEY (hotel_id) REFERENCES hotel(hotel_id)
);

SELECT * FROM CUSTOMER;
SELECT * FROM RESERVATION;
SELECT * FROM HOTEL;
```
