# 기능 목록

## 게시판

[O] Create (POST)
- 게시글 작성
- Table: postId(INT), title(VARCHAR(30)), content(TEXT), now(TIMESTAMP)

[O] Read (GET)
- 게시글 조회

[O] Update (PUT or PATCH)
- 게시글 수정

[O] Delete (DELETE)
- 게시글 삭제


## 회원 가입

[ ] registerUser (POST)
- 회원 등록
- Table: userName(varchar(10)), userId(VARCHAR(10)), password(VARCHAR(20)), registrationDate(TIMESTAMP)

[ ] findUserById (GET)
- 회원 정보 조회

[ ] deleteUserById (DELETE)
- 회원 삭제

## 로그인

[ ] checkUser()

[ ] login()

[ ] 
[추가할 내용]
- 페이징
- 검색

