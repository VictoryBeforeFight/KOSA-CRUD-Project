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

<H1>역할 분담</H1>
1. **예약 페이지 (사용자 입장) 지은**
    1. 정보 입력
        1. 사용자명, 생년월일, 전화번호, 이메일, 예약날짜, 호텔명, 인원수
        2. 확인, 취소 버튼
            1. 확인버튼
                1. 예약 가능 시 → “예약되었습니다” 팝업창 → 예약 정보 확인 페이지
                2. 예약 불가능 시(남은 방 수 없거나 호텔명 잘못된 경우) : “예약이 불가능합니다” 팝업창
            2. 취소버튼 → 입력한 내용 다 삭제

1. **전체 조회 페이지 청**
    1. 사용자 입장
        1. 본인의 예약 내역 전체 리스트 확인 → 날짜순
    2. 관리자 입장
        1. 모든 사용자의 예약 내역 전체 리스트 확인

1. **부분 조회 페이지 태호**
    1. 사용자 입장
        1. 날짜로 검색하여, 해당 예약 리스트 확인 → 날짜로 조회
        2. ~~호텔 이름으로 검색하여, 해당 호텔의 예약 리스트만 확인~~
    2. 관리자 입장
        1. 이메일로 검색하여, 해당 사용자의 예약 리스트만 확인
        2. 호텔 이름으로 검색하여, 해당 호텔의 예약 리스트만 확인
            
            
2. **예약 취소(삭제) 팝업 (사용자 입장) 석영**
    1. “정말 예약을 취소하시겠습니까?” 팝업
    2. 예약테이블 내용만 삭제

1. **예약 정보 수정 및 확인 페이지(사용자 입장) 석영**
    1. 예약 후 성공했을 때, 성공한 예약 내역을 보여주는 페이지 이자 수정 가능한 페이지
        1. 사용자명, 생년월일, 전화번호, 이메일, 예약날짜, 호텔명, 객실수, 인원수
        2. 전화번호, 객실수, 인원수만 수정
