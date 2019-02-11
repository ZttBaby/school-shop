<%--
  Created by IntelliJ IDEA.
  User: cxx
  Date: 2019-02-01
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>商店列表</title>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel="shortcut icon" href="/favicon.ico">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="stylesheet" href="//g.alicdn.com/msui/sm/0.6.2/css/sm.min.css">
    <link rel="stylesheet" href="//g.alicdn.com/msui/sm/0.6.2/css/sm-extend.min.css">
    <link rel="stylesheet" href="../resources/css/shop/shoplist.css">
</head>
<body>
<header class="bar bar-nav">
    <h1 class="title">商店列表</h1>
</header>
<div class="content">
    <div class="content-block">
        <p>你好,<span id="user-name"></span>
            <a class="pull-right" href="/school/shopadmin/shopoperation">增加店铺</a>
        </p>

        <div class="row row-shop">
            <div class="col-40">商店名称</div>
            <div class="col-40">状态</div>
            <div class="col-20">操作</div>
        </div>
        <div class="shop-wrap">

        </div>
    </div>
    <div class="content-block">
        <div class="row">
            <div class="col-50">
                <a href="" id="log-out"
                   class="button button-big button-fill button-danger">退出系统</a>
            </div>
            <div class="col-50">
                <a href="/myo2o/shop/changepsw" class="button button-big button-fill button-success">修改密码</a>
            </div>
        </div>
    </div>
</div>



<script type='text/javascript' src='//g.alicdn.com/sj/lib/zepto/zepto.min.js' charset='utf-8'></script>
<script type='text/javascript' src='//g.alicdn.com/msui/sm/0.6.2/js/sm.min.js' charset='utf-8'></script>
<script type='text/javascript' src='//g.alicdn.com/msui/sm/0.6.2/js/sm-extend.min.js' charset='utf-8'></script>
<script type='text/javascript' src='../resources/js/shop/shoplist.js' charset='utf-8'></script>
</body>
</html>
