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
