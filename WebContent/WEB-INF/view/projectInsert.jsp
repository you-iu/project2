<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form id="f1" action="add.do" method="post">
		<fieldset>
			<p>
				<label>프로젝트이름</label>
				<input type="text" name="title">
				<span class="error">제목을 입력하세요</span>
			</p>
			<p>
				<label>프로젝트 내용</label>
				<textarea rows="10" cols="60" name="content"></textarea>
				<span class="error">내용을 입력하세요</span>
			</p>
			<p>
				<label>시작날짜</label>
				<input type="text" name="regdate">
			</p>
			<p>
				<label>시작날짜</label>
				<input type="text" name="moddate">
			</p>
			<p>
				<label>상태</label>
				<select name="re">
					<option>준비</option>
					<option>진행중</option>
					<option>종료</option>
					<option>보류</option>
				</select>
			</p>
			<p>
				<input type="submit" value="저장"><input type="reset" value="취소">
			</p>
		</fieldset>
	</form>
</body>
</html>