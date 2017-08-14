<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017\7\25 0025
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="w" uri="http://javacrazyer.iteye.com/tags/pager" %>
<html>
<head>
    <title>供货商列表</title>
    <c:import url="../../../common/pc/include.jsp"></c:import>
</head>
<input name="msg" value="good" type="hidden" action="ajax_good_edit" about="">
<body path="<%=request.getContextPath()%>">
<div class="container-fluid">
    <div class="row">
        <c:import url="../../../common/pc/header.jsp"></c:import>
    </div>
    <div class="row">
        <c:import url="../../../common/pc/leftcommon.jsp"></c:import>
        <!--右侧内容-->
        <div class="col-md-10">


            <c:if test="${fn:length(supplierList)==0}">

                <div class="waicheng" >
                    <div style="font-size: 20px;font-weight: bold">查询不到相关数据.</div>
                    <hr>
                        <%--<div><img src="<%=request.getContextPath() %>/images/nofound.png"></div>--%>
                </div>

            </c:if>

            <button type="button" title="新增商品" class="btn btn-primary" onclick="slidePanel('adddiv','addGood')"> 新增商品</button>




        </div>
    </div>
</div>

<div id="adddiv" style="width:800px;position:absolute!important;left:20%!important;top:20%!important;"></div>
<div id="addchildrendiv" style="width: 40%;top:30%!important;right: 30%"></div>
<%--遮罩--%>
<div class='login_plugins_bg none'></div>

</body>
</html>

<script type="text/javascript">

    KindEditor.ready(function(K) {
        window.editor = K.create('textarea', {
            allowFileManager : true,
            langType : 'zh-CN',
            autoHeightMode : true
        });
        editor = K.create('#editor_id', {
        });
    })
</script>

