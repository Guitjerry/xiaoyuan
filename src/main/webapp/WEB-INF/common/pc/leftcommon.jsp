<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017\7\24 0024
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>左侧菜单页面</title>
    <style>
        .actived{
            background-color:#3280fc ;
            color: #fff!important;
        }
        .actived-fff{
            color: #fff!important;
        }
        li,ul {
            padding: 0px!important;

        }

    </style>
</head>
<body>
<input name="msg" value="${msg}" type="hidden">
<div class="col-md-2">
    <ul id="accordion" class="accordion">
        <li>
            <div class="link">商品模块<i class="glyphicon glyphicon-shopping-cart"></i></div>
            <ul class="submenu">
                <li msg="category"><a href="<%=request.getContextPath() %>/pc/category/list?msg=category">商品类目管理</a></li>
                <li msg="good"><a href="<%=request.getContextPath() %>/pc/good/list?msg=good">商品管理</a></li>
            </ul>
        </li>

        <li>
            <div class="link"><i class="glyphicon glyphicon-leaf"></i>供货商模块<i class="fa fa-chevron-down"></i></div>
            <ul class="submenu">
                <li msg="supplier"><a href="<%=request.getContextPath() %>/pc/tbsupplier/list?msg=supplier">供货商管理</a></li>

            </ul>
        </li>

    </ul>

    <%--<nav class="menu" data-ride="menu" style="width: 200px">--%>
        <%--<ul class="nav nav-primary">--%>
            <%--<li><a href="javascript:;"><i class="icon icon-th"></i> 首页</a></li>--%>
            <%--<li class="nav-parent">--%>
                <%--<a href="javascript:;"><i class="icon icon-gift"></i>商品模块</a>--%>
                <%--<ul class="nav submenu">--%>
                    <%--<li msg="category"><a href="<%=request.getContextPath()%>/pc/category/list?msg=category">商品类目管理</a></li>--%>
                    <%--<li msg="good"><a href="<%=request.getContextPath()%>/pc/good/list?msg=good">商品管理</a></li>--%>



                <%--</ul>--%>
            <%--</li>--%>
            <%--<li class="nav-parent">--%>
                <%--<a href="javascript:;"><i class="icon icon-time"></i>供货商模块</a>--%>
                <%--<ul class="nav submenu">--%>
                    <%--<li msg="supplier"><a href="<%=request.getContextPath()%>/pc/tbsupplier/list?msg=supplier">供货商管理</a></li>--%>
                    <%--<li><a href="javascript:;">在线供货商</a></li>--%>

                <%--</ul>--%>
            <%--</li>--%>
        <%--</ul>--%>
    <%--</nav>--%>
</div>

</body>
</html>
<script>
    $(function () {
        $('.submenu li').each(function () {
            if($(this).attr('msg')==$('input[name="msg"]').val()){
                $(this).css('background-color','#4eb65c');
                $(this).children('a').css('color','#ffffff');
                $(this).parents('li').find('.submenu').css('display','block');
            }
        })

        $('#accordion .link').on('click',function (e) {
            if($(this).parents('li').hasClass('open')){
                $(this).parents('li').removeClass('open').find('.submenu').slideUp('slow').css('display','none');
            }else{
                $(this).parents('li').addClass('open').find('.submenu').slideDown('slow').css('display','block');

                $(this).parents('li').siblings('li').find('.link').removeClass('f-link').addClass('f-nolink');
                $(this).removeClass('f-nolink').addClass('f-link');
                $(this).parents('li').siblings('li').find('.submenu').slideUp('slow').css('display','none');
            }

            // $(this).parents('li').slideUp().addClass('open');
        })
    })
//    $('.submenu li').each(function () {
//        if($(this).attr('msg')!=""&&$(this).attr('msg')!=undefined&&$(this).attr('msg')==$('input[name="msg"]').val()){
//            $(this).parent('.submenu').show();
//            $(this).addClass('actived');
//            $(this).children('a').addClass('actived-fff');
//
//
//        }
//    })

</script>
