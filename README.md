[# ScheduleManagement2](https://app.sqldbm.com/MySQL/DatabaseExplorer/p310419/) ERD


일정 등록 요청 API
POST /api/regist
{
  "username":"user",
  "title":"일정 제목",
  "contents":"일정 내용"
}

응답API
{
  "username":"user",
  "title":"일정 제목"
  "contents":"일정 내용"
}

----------------------------------------------------------------------

일정 단건 조회 API

GET /api/getone
{
  "id":"일정 id 값"
}

응답 API
{
  "username":"user",
  "title":"일정 제목",
  "contents":"일정 내용",
  "date":"생성 날짜",
  "fix_date":"수정된 날짜"
}

---------------------------------------------------------------------------

일정 수정 API

PUT /api/modify
{
  "id":"일정 id",
  "title":"수정된 제목",
  "contents":"일정 내용 수정"
}

응답 API
{
  "id":"일정 id",
  "username":"작성자 이름",
  "title":"수정된 제목",
  "contents":"수정된 내용",
  "fix_date":"수정된 날짜"
}

---------------------------------------------------------------------

일정 페이징 API
{
  "pagenumber":"페이지번호",
  "size":"페이지 크기"
}

응답 API
{
  "username": "등록자이름",
  "title": "일정제목",
  "contents": "일정내용",
  "date": "2024-08-28T12:02:39.090+00:00",
  "fix_date": "2024-08-28T12:02:39.090+00:00",
  "commentcount":"댓글수"
}

---------------------------------------------------------------------

유저 등록 API

POST "/user/regist"
{
  "username":"유저이름",
  "email":"이메일"
}

---------------------------------------------------------------------

유저 단건 조회 API

GET "/user/get"
{
  "user_id":"유저아이디"
}

응답 API
{
    "username": "유저이름",
    "email": "유저 이메일",
    "date": "2024-08-28T18:33:35.610+00:00",
    "fixdate": "2024-08-28T19:07:12.777+00:00"
}

---------------------------------------------------------------------

유저 전체 조회 API

GET "/user/allget"




응답 API
{
    "username": "유저이름",
    "email": "유저 이메일",
    "date": "2024-08-28T18:33:35.610+00:00",
    "fixdate": "2024-08-28T19:07:12.777+00:00"
}

---------------------------------------------------------------------

유저 삭제 API

DELETE "/user/delete"
{
    "user_id":"유저id"
}
