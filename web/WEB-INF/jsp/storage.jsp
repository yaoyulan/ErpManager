<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">

      <title>ERP商品入库</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
      <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/css/index.css"/>
      <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery-1.8.3.js"></script>
     <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/storage.js"></script>
  </head>
  
  <body>
  <div class="container">
        <div id="addInfo" style="color:#ff0000; "></div>
      <div class="left" id="listDiv" style="height:500px;">


      </div>
      <div class="right">
         <%-- <span  style="color: red;"></span>--%>
          <div style="border-bottom:1px solid #ccc; height:50px; line-height:50px;">
              商品入库
          </div>
          <form action="" id="addForm">
          <table  border="0" cellspacing="0" cellpadding="0">

              <tr>
                  <td>入库编号</td>
                  <td><input type="text" id="warehouseNo" name="warehouseNo" value="${currentNo}" disabled="disabled"/>

                  </td>
              </tr>
              <tr>
                  <td>商品名称</td>
                  <td><input type="text" id="commodityName" name="commodityName" />
                      <span id="commodityNameError"></span>
                  </td>
              </tr>
              <tr>
                  <td>供应商</td>
                  <td><input type="text" id="supplier" name="supplier" />
                      <span id="supplierError"></span>
                  </td>
              </tr>
              <tr>
                  <td>商品规格</td>
                  <td><input type="text"  id="specifications" name="specifications"/>
                      <span id="specificationsError"></span>
                  </td>
              </tr>
              <tr>
                  <td>商品规格单位</td>
                  <td><input type="text"  id="specificationUnit" name="specificationUnit"/>
                      <span id="specificationUnitError"></span>
                  </td>
              </tr>
              <tr>
                  <td>数量</td>
                  <td><input type="text"  id="number" name="number"/>
                      <span id="numberError"></span>
                  </td>
              </tr>
              <tr>
                  <td>计量单位</td>
                  <td>
                      <select id="unit" name="unit">
                          <option value="包">包</option>
                          <option value="箱">箱</option>
                          <option value="件">件</option>
                          <option value="个">个</option>
                          <option value="瓶">瓶</option>
                      </select>
                      <span id="unitError"></span>
                  </td>
              </tr>

              <tr>
                  <td>单价</td>
                  <td><input type="text"  id="price" name="price"/>
                      <span id="priceError"></span>
                  </td>
              </tr>
              <tr>
                  <td>入库日期</td>
                  <td><input type="text"  id="storagDate" name="storagDate"/>
                      <span id="storagDateError"></span>
                  </td>
              </tr>
              <tr>
                  <td>备注</td>
                  <td> <textarea rows="5" cols="28" id="remarks" name="remarks"></textarea>
                      <span id="remarksError"></span>
                  </td>
              </tr>


          </table>
          </form>
          <div style="border-top:1px solid #ccc; height:50px; line-height:50px;">
              <input type="button" value="保存" id="addBtn" style="margin-top:14px;" />
          </div>
      </div>
  </div>
  </body>
</html>
