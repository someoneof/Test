<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>ȫ������</title>
		<link rel="stylesheet" href="image/style.css" />
	</head>

	<body topmargin="0" leftmargin="0" bgcolor="#F3F3F3">
		<jsp:include page="user/include/MainHeader.jsp"></jsp:include>
		<table width="1000" border="0" cellpadding="0" cellspacing="0"
			align="center">
			<tr height="30" valign="bottom">
				<td class="title">
					&nbsp;&nbsp;ȫ������
					<img alt="����RSS" src="image/feeds.gif"><a href="showRSS.action">����</a>
				</td>
			</tr>
			<tr>
				<td colspan="2" valign="top">
					<table cellpadding="4" cellspacing="1">
						<tr>
							<td>
								<table width="1000" cellpadding="6" cellspacing="1"
									bgcolor="#CCCCCC">

									<!-- ѭ����� -->
									<s:iterator value="#request.article_list" id="art">
										<tr>
											<td bgcolor="#FFFFFF">
												<font class="chinesefont105main"> <!-- ���±���  --> 
												<a href="art_showArticle.action?username=<s:property value="#art.username"/>&aid=<s:property value="#art.aid"/>"><s:property value="#art.title"/></a>
													<hr size='1' noshade color='#CCCCCC'> <br>
													<div align='right' class='smalltxt' height='32px'>
														<!-- ����ʱ�� -->
														������:
														<s:date name="#art.datetime"/>
														<!-- ���������� --> 								<!-- ��������������� -->
														|����()|���(<s:property value="#art.hasread"/>)|����:<a href="art_findByUsername.action?username=<s:property value="#art.username"/>"><s:property value="#art.username"/></a>
													</div> 
													</font>
											</td>
										</tr>
									</s:iterator>
										<tr>
											<c:forEach begin="${pageindex.startindex }" end="${pageindex.endindex }" var="wp">
											<a href="art_findAll.action?currpage=${wp }">��${ wp }ҳ&nbsp;&nbsp;</a>
											</c:forEach>
												<%-- <s:if test="#request.page.hasPrePage">
													<a href="showAllArticle.action?currentPage=1">��ҳ</a>
													<a href="showAllArticle.action?currentPage=${page.currentPage -1 }">��һҳ</a>
												</s:if>
												<s:else>
													��ҳ
													��һҳ
												</s:else>
												
												<s:if test="#request.page.hasNextPage">
													<a href="showAllArticle.action?currentPage=${page.currentPage + 1 }">��һҳ</a>
													<a href="showAllArticle.action?currentPage=${page.totalPage }">βҳ</a>			
												</s:if>
												<s:else>
													��һҳ
													βҳ
												</s:else> --%>
										</tr>
								</table>
								<table id="noCount" runat="server" width="1000" cellpadding="6"
									cellspacing="1" bgcolor="#cccccc">
									<tr bgcolor="#ffffff" height="50">
										<td align="center">
										 	���粩����
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>