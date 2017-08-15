<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 17/8/9
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>商品信息</title>
    <c:import url="../../../common/pc/include.jsp"></c:import>
    <style>
        td:first-child{
            padding: 14px;
        }
    </style>
</head>
<body>
<div class="container-fluid clearfix">

    <!-- 主内容 -->
    <div class="main-container" id="mainContainer">
        <div class=" cm-pd10 cm-mt10">

            <h3 class="cm-cor-f08300 cm-f16 cm-pdb15">基础信息</h3>
            <p class="soliline"></p>
            <div class="cm-pd10 info-panel cm-f14">

                    <table class="f-addtb">
                        <tr>
                            <td >
                                <label><span class="cm-required">*</span>名称:</label>
                            </td>
                            <td >
                                <div class="input-group">

                                    <input type="text" class="form-control" name="name" placeholder="商品名称">
                                </div>
                            </td>
                            <td >
                                <label><span class="cm-required">*</span>商品编号:</label>
                            </td>
                            <td >
                                <div class="input-group">

                                    <input type="text" class="form-control" name="code" placeholder="商品编号">
                                </div>
                            </td>


                        </tr>

                        <tr>
                            <td class="f-pr10">
                                <label>商品价格:</label>
                            </td>
                            <td class="f-pr50">
                                <div class="input-group">

                                    <input type="text" class="form-control" name="price" placeholder="商品价格">
                                </div>
                            </td>
                            <td class="f-pr10">
                                <label>排序:</label>
                            </td>
                            <td>
                                <div class="input-group">

                                    <input type="text" class="form-control" name="sort" placeholder="商品排序">
                                </div>
                            </td>
                        </tr>

                        <tr>
                            <td class="f-pr10">
                                <label>商品分类:</label>
                            </td>
                           <td>
                               <select name="categoryid" style="width: 163px" id="categoryid">
                                   <option>食品</option>
                                   <option>文具</option>

                               </select>
                           </td>
                            <td class="f-pr10">
                                <label>热销级别:</label>
                            </td>
                            <td>
                                <div class="input-group">

                                    <select name="hotlevel" style="width: 163px" id="hotlevel">
                                        <option>1</option>
                                        <option>2</option>

                                    </select>
                                </div>
                            </td>
                        </tr>

                        <tr>
                            <td class="f-pr10">
                                <label>商品图片:</label>
                            </td>
                            <td>
                                <div class="upload-viewer">
                                    <span class="imgDelete icon-remove-sign" title="清空图片" data-baseurl="<%=request.getContextPath()%>"
                                          data-defaultPhoto="<%=request.getContextPath()%>/images/default-photo.jpg" data-file=""></span>
                                    <a href="javascript:void(0);"></a>
                                    <img src="<%=request.getContextPath()%>/images/default-photo.jpg" border="0" width="100%">
                                </div>
                                <input type="hidden" name="picurl"
                                       id="picurl" value="<%=request.getContextPath()%>/${picth}/${good.picurl}" class=""/>
                                <input class="fileupload" id="fileupload1" type="file" name="files[]" role="_upload"
                                       data-show="true" data-target="picurl" accept="image/gif,image/jpeg,image/png">
                            </td>
                        </tr>
                    </table>


            </div>

            <h3 class="cm-cor-f08300 cm-f16 cm-pdb15">属性信息</h3>
            <p class="soliline"></p>
            <div class="cm-pd10 info-panel cm-f14 row" >

                <table class="col-md-6">

                    <c:forEach items="${tbAttrList}" var="attr">
                        <tr>
                            <td>
                                <label>${attr.attrname}</label>
                            </td>
                            <td>
                                <input type="text" class="form-control" name="attrs" placeholder="${attr.attrname}">
                            </td>
                        </tr>
                    </c:forEach>
                </table>

                <table class="col-md-6">
                    <c:forEach items="${tbAttrListCa}" var="attr">
                        <tr>
                            <td>
                                <label>${attr.attrname}</label>
                            </td>
                            <td>
                                <input type="text" class="form-control" name="attrs" placeholder="${attr.attrname}">
                            </td>
                        </tr>
                    </c:forEach>

                </table>
            </div>
            <%--先不考虑--%>
            <%--<h3 class="cm-cor-f08300 cm-f16 cm-pdb15">SKU</h3>--%>
            <%--<p class="soliline"></p>--%>
            <%--<div class="cm-pd10 info-panel cm-f14">--%>


            </div>
            <h3 class="cm-cor-f08300 cm-f16 cm-pdb15">商品明细</h3>
            <p class="soliline"></p>
            <textarea id="editor_id"></textarea>
            </textarea>
            <div class="cm-pd10 info-panel cm-f14">

            </div>

        </div>
        <div class="cm-tac f-mb10">
            <button class="btn btn-info " onclick="addGoodSure()">确定</button>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <button class="btn " type="button" onclick="closeSlidePanel()">取消</button>
        </div>
    </div>
</div>

</body>
</html>
<script>
    $(function () {
        $('.ke-container').css('width','100%');
    })
    KindEditor.ready(function(K) {
        window.editor = K.create('textarea', {
            allowFileManager : true,
            langType : 'zh-CN',
            autoHeightMode : true
        });
        editor = K.create('#editor_id', {
        });
    })
    function addGoodSure() {
        var name = $('input[name="name"]').val();
        var code = $('input[name="code"]').val();
        var price = $('input[name="price"]').val();
        var sort = $('input[name="sort"]').val();
        var categoryid = $('#categoryid').val();
        var hotlevel = $('#hotlevel').val();
        var fileupload1 = $('#fileupload1').val();
        var attrs =$('input[name="attrs"]').val();//属性值
        var data={"name":name,"code":code,"price":price,"sort":sort,"categoryid":categoryid,"hotlevel":hotlevel,"pic":fileupload1};
        $.ajax({
            type:"post",
            url:"ajax_good_edit",
            data:"orderJson="+JSON.stringify(data),
            contentType:'application/json;charset=UTF-8',
            success:function (data) {

            }
        });

//        var goodinfo={"name"}
    }
</script>
