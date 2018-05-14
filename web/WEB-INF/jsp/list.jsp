<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/7
  Time: 23:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c"%>
<table border="1" cellspacing="0" cellpadding="0">
    <thead>
    <tr>
        <td colspan="2">商品信息</td>

    </tr>
    </thead>
    <tr>
        <td>商品编号</td>
        <td>商品名称</td>
    </tr>
    <tbody id="tbody">
    <c:if test="${!empty pager.list and pageCount!=0}">
        <c:forEach items="${pager.list}" var="item">
            <tr warehouseNo="${item.warehouseNo}">
                <td>${item.warehouseNo}</td>
                <td>${item.commodityName}</td>
            </tr>
        </c:forEach>
    </c:if>
    </tbody>
    <c:if test="${empty pager.list or pageCount==0}">
        <tr>
            <td style="color:red;text-align: center; " colspan="2">暂无商品记录</td>
        </tr>
    </c:if>


</table>
<c:if test="${!empty pager.list and pageCount!=0}">
    <div id="pagerBtn">
        <a href="javascript:;" pageIndex="1">首页</a>
        <a href="javascript:;" pageIndex="${pager.pageIndex-1}">上一页</a>
        <c:forEach begin="1" end="${pager.pageCount}" varStatus="statu">
            <a href="javascript:;" pageIndex="${statu.count}">${statu.count}</a>
        </c:forEach>
        <a href="javascript:;" pageIndex="${pager.pageIndex+1}">下一页</a>
        <a href="javascript:;" pageIndex="${pager.pageCount}">末页</a>
    </div>
</c:if>
