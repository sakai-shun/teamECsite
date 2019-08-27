<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/table.css">
<link rel="stylesheet" href="./css/message.css">
<link rel="stylesheet" href="./css/title.css">
<link rel="stylesheet" href="./css/header.css">
<title>カート</title>
</head>
<body>
<script src="./js/cart.js"></script>
<jsp:include page="header.jsp"/>
<div id="contents">
	<h1>カート画面</h1>
	<s:if test="cartInfoList != null && cartInfoList.size()>0">
		<s:form id="cartForm">
			<table class="horizontal-list-table">
				<thead>
					<tr>
						<th><s:label value="#"/></th>
						<th><s:label value="商品名"/></th>
						<th><s:label value="商品名ふりがな"/></th>
						<th><s:label value="商品画像"/></th>
						<th><s:label value="値段"/></th>
						<th><s:label value="発売会社名"/></th>
						<th><s:label value="発売年月日"/></th>
						<th><s:label value="購入個数"/></th>
						<th><s:label value="合計金額"/></th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="cartInfoList">
						<tr>
							<td><input type="checkbox" name="checkList" class="checkList" value='<s:property value="productId"/>' onchange="checkValue(this)"></td>
							<td><s:property value="productName"/></td>
							<td><s:property value="productNameKana"/></td>
							<td><img src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>' /></td>
							<td><s:property value="price"/>円</td>
							<td><s:property value="releaseCompany"/></td>
							<td><s:property value="releaseDate"/></td>
							<td><s:property value="productCount"/>個</td>
							<td><s:property value="subTotalPrice"/>円</td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
			<h2><s:label value="カート合計金額 :"/><s:property value="totalPrice"/>円</h2><br>
			<div class="submit-Box">
				<div class="submit_btn_box1">
					<s:submit value="決済" class="submit_btn" onclick="goSettlementConfirmAction()"/>
				</div>

				<div class="submit_btn_box2">
					<s:submit value="削除" id="deleteButton" class="submit_btn" onclick="goDeleteCartAction()" disabled="true"/>
				</div>
			</div>
		</s:form>
	</s:if>
	<s:else>
		<div class="info">
		カート情報がありません。
		</div>
	</s:else>
</div>
</body>
</html>