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

                                    <input type="text" class="form-control" name="name" placeholder="用户名">
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
            <div class="cm-pd10 info-panel cm-f14">

            </div>
            <h3 class="cm-cor-f08300 cm-f16 cm-pdb15">SKU</h3>
            <p class="soliline"></p>
            <div class="cm-pd10 info-panel cm-f14">

            </div>
            <h3 class="cm-cor-f08300 cm-f16 cm-pdb15">商品明细</h3>
            <p class="soliline"></p>
            <div class="cm-pd10 info-panel cm-f14">

            </div>

        </div>
        <div class="cm-tac f-mb10">
            <button class="btn btn-info " type="submit">确定</button>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <button class="btn " type="button" onclick="closeSlidePanel()">取消</button>
        </div>
    </div>
</div>

</body>
</html>
