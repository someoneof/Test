<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>�ޱ����ĵ�</title>
<script language="javascript">
<!--
function mhEnter()
{
window.event.srcElement.className="lt1";
}
function mhLeave()
{
window.event.srcElement.className="lt0";
}
//-->
</script>
<link rel="stylesheet" href="image/style.css"/>
<style type="text/css">
<!--
.blogtitle {
	font-size: 18px;
	font-weight: bold;
}
.idiograph {
	position: relative;
	left: 50px;
}

-->
</style>
</head>

<body>
<table width="1000" border="0" cellpadding="0" cellspacing="0" align="center">
	<tr>
		<td background="image/bg1.jpg" height="150">
		<!-- ���ͱ���λ��-->
		<span class="blogtitle">${sessionScope.blogtitle}</span><br />
	    <span class="idiograph">${sessionScope.digest}     </span>		<!-- ����ǩ��λ��-->		</td>
	</tr>
	<tr height="31">
		<td background="../image/line.jpg">
			<table width="1000" border="0" cellpadding="0" cellspacing="0">
				<%
					String username = request.getParameter("username");
					if(username == null || "".equals(username)) {
				 %>
				
				<tr height="20" align="center">                            <!-- ������粩������ҳ,Ҫ����һ������username,�����ж� -->
					<td class="lt0" onmouseenter="mhEnter()" onmouseleave="mhLeave()"><a href="${pageContext.request.contextPath}/art_findAll.action">���粩����ҳ</a></td>
					<td class="ltsep">|</td>
					<td class="lt0" onmouseenter="mhEnter()" onmouseleave="mhLeave()"><a href="${pageContext.request.contextPath}/art_findByUsername.action">�û���ҳ</a></td>
					<td class="ltsep">|</td>
					<td class="lt0" onmouseenter="mhEnter()" onmouseleave="mhLeave()"><a href="${pageContext.request.contextPath}/user/editbloginfo.jsp">���Ի�����</a></td>
					<td class="ltsep">|</td>
					<td class="lt0" onmouseenter="mhEnter()" onmouseleave="mhLeave()"><a href="${pageContext.request.contextPath}/user/addArticle.jsp">д��־</a></td>
					<td class="ltsep">|</td>
					<td class="lt0" onmouseenter="mhEnter()" onmouseleave="mhLeave()"><a href="${pageContext.request.contextPath}/user/showPhoto.action">���</a></td>
					<td class="ltsep">|</td>
					<td class="lt0" onmouseenter="mhEnter()" onmouseleave="mhLeave()"><a href="../index.html">���԰�</a></td>
				</tr>
				<%
					} else {
				 %>
				 <!-- ${pageContext.request.contextPath}/ -->
				 	<tr height="20" align="center">
					<td class="lt0" onmouseenter="mhEnter()" onmouseleave="mhLeave()"><a href="${pageContext.request.contextPath}/art_findAll.action">���粩����ҳ</a></td>
					<td class="ltsep">|</td>
					<td class="lt0" onmouseenter="mhEnter()" onmouseleave="mhLeave()"><a href="${pageContext.request.contextPath}/art_findByUsername.action?username=${param.username }">�û���ҳ</a></td>
					<td class="ltsep">|</td>
					<td class="lt0" onmouseenter="mhEnter()" onmouseleave="mhLeave()"><a href="${pageContext.request.contextPath}/user/editbloginfo.jsp">���Ի�����</a></td>
					<td class="ltsep">|</td>
					<td class="lt0" onmouseenter="mhEnter()" onmouseleave="mhLeave()"><a href="${pageContext.request.contextPath}/user/addArticle.jsp">д��־</a></td>
					<td class="ltsep">|</td>
					<td class="lt0" onmouseenter="mhEnter()" onmouseleave="mhLeave()"><a href="${pageContext.request.contextPath}/user/showPhoto.action">���</a></td>
					<td class="ltsep">|</td>
					<td class="lt0" onmouseenter="mhEnter()" onmouseleave="mhLeave()"><a href="../index.html">���԰�</a></td>
				</tr>
				 <%
				 	}
				  %>
			</table>
		</td>
	</tr>
</table>
</body>
</html>
