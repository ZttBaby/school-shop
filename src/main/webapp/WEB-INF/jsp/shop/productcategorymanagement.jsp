<%--
  Created by IntelliJ IDEA.
  User: cxx
  Date: 2019-02-02
  Time: 12:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>商品分类管理</title>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel="shortcut icon" href="/favicon.ico">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="stylesheet" href="//g.alicdn.com/msui/sm/0.6.2/css/sm.min.css">
    <link rel="stylesheet" href="//g.alicdn.com/msui/sm/0.6.2/css/sm-extend.min.css">
    <link rel="stylesheet" href="../resources/css/shop/productcategorymanage.css">
</head>
<body>
<header class="bar bar-nav">
    <h1 class="title">商品分类管理</h1>
</header>
<div class="content">
    <div class="content-block">
        <div class="row row-product-category">
            <div class="col-33">类别</div>
            <div class="col-33">优先级</div>
            <div class="col-33">操作</div>
        </div>
        <div class="category-wrap">

        </div>
    </div>
    <div class="content-block">
        <div class="row">
            <div class="col-50">
                <a href="#" class="button button-big button-fill button-success" id="new">新增</a>
            </div>
            <div class="col-50">
                <a href="#" class="button button-big button-fill" id="submit">提交</a>
            </div>
        </div>
    </div>
</div>



<script type='text/javascript' src='//g.alicdn.com/sj/lib/zepto/zepto.min.js' charset='utf-8'></script>
<script type='text/javascript' src='//g.alicdn.com/msui/sm/0.6.2/js/sm.min.js' charset='utf-8'></script>
<script type='text/javascript' src='//g.alicdn.com/msui/sm/0.6.2/js/sm-extend.min.js' charset='utf-8'></script>
<script type='text/javascript' src='../resources/js/shop/productcategorymanage.js' charset='utf-8'></script>
</body>
</html>
