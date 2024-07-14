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


