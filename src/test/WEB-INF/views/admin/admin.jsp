<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form id="admin_form">
	<h1> 일반 사용자 회원정보</h1>
	<input type="button" id="btn_custTest" value="출력" /><hr/>
	<h1> 업체 회원정보</h1>
	<input type="button" id="btn_companyTest" value="출력" /><hr/>
	<h1> 관리자 회원정보</h1>
	<input type="button" id="btn_AdminTest" value="출력" /><hr/>
</form>
<table class="plus-content">

</table>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>	
<script type="text/javascript" src="/resources/admin/adminRest.js?v=<%=System.currentTimeMillis() %>"></script>
<script>
$("#btn_custTest").on("click", function(e){
	e.preventDefault();
	var cust=1;
	adminRest.getCustList(
		cust,
		function(data){
			alert("하하");
		}
	
	);
});
$("#btn_companyTest").on("click", function(e){
	e.preventDefault();
	var cust=1;
	adminRest.getCompanyList(
		cust,
		function(data){
			alert("하하");
		}
	
	);
});
$("#btn_AdminTest").on("click", function(e){
	e.preventDefault();
	var cust=1;
	adminRest.getAdminList(
		cust,
		function(list){
			var str="";
			str+="<tr>"+
				 "	<td>아이디</td>"+
				 "	<td>비밀번호</td>"+
				 "	<td>이름</td>"+
				 "	<td>핸드폰번호</td>"+
				 "	<td>이메일</td>"+
				 "	<td>주소</td>"+
				 "	<td>생일</td>"+
				 "	<td>성별</td>"+
				 "	<td>가입여부</td>"+
				 "	<td>가입날짜</td>"+
				 "	<td>가입유저</td>"+
				 "	<td>수정날짜</td>"+
				 "	<td>수정유저</td>"+
				 "	<td>등급</td>"+
				 "</tr>";

			for(var i=0; i<list.length; i++){
				str+=
				"	<tr>"+
				"		<td>"+list[i].MEMBERID+		"</td>"+
				"		<td>"+list[i].PASSWORD+		"</td>"+
				"		<td>"+list[i].NAME+			"</td>"+
				"		<td>"+list[i].PHONE+		"</td>"+
				"		<td>"+list[i].EMAIL+		"</td>"+
				"		<td>["+list[i].ADDR_POST+"] "+list[i].ADDR_CITY+" "+list[i].ADDR_DETAIL+"</td>"+
				"		<td>"+list[i].BIRTH+		"</td>"+
				"		<td>"+list[i].SEX+		"</td>"+
				"		<td>"+list[i].MEMBER_YN+	"</td>"+
				"		<td>"+list[i].REGDATE+		"</td>"+
				"		<td>"+list[i].REGUSER+		"</td>"+
				"		<td>"+list[i].EDITDATE+		"</td>"+
				"		<td>"+list[i].EDITUSER+		"</td>"+
				"		<td>"+list[i].ACC_LEVEL+	"</td>"+
				"		<td><input type='button' id='btn_modify' value='수정하기' /><td>"+
				"	</tr>";
			}
			$(".plus-content").html(str);
		}
	);
});

</script>

</body>
</html>