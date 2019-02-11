<%--
  Created by IntelliJ IDEA.
  User: cxx
  Date: 2019-02-01
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>商店管理</title>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel="shortcut icon" href="/favicon.ico">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="stylesheet" href="//g.alicdn.com/msui/sm/0.6.2/css/sm.min.css">
    <link rel="stylesheet" href="//g.alicdn.com/msui/sm/0.6.2/css/sm-extend.min.css">
    <link rel="stylesheet" href="../resources/css/shop/shopmanage.css">
</head>
<body>
<header class="bar bar-nav">
    <h1 class="title">商店管理</h1>
</header>
<div class="content">
    <div class="content-block">
        <div class="row">
            <div class="col-50 mb">
                <a  id="shopInfo" href="/school/shopadmin/shopoperation" class="button button-big button-fill">商铺信息</a>
            </div>
            <div class="col-50 mb">
                <a href="/school/shopadmin/productmanagement" class="button button-big button-fill">商品管理</a>
            </div>
            <div class="col-50 mb">
                <a href="/school/shopadmin/productcategorymanagement" class="button button-big button-fill">类别管理</a>
            </div>
            <div class="col-50 mb">
                <a href="/myo2o/shop/awardmanage" class="button button-big button-fill">奖品管理</a>
            </div>
            <div class="col-50 mb">
                <a href="/myo2o/shop/productbuycheck" class="button button-big button-fill">消费记录</a>
            </div>
            <div class="col-50 mb">
                <a href="/myo2o/shop/awarddelivercheck" class="button button-big button-fill">积分对换</a>
            </div>
            <div class="col-50 mb">
                <a href="/myo2o/shop/usershopcheck" class="button button-big button-fill">顾客积分</a>
            </div>
            <div class="col-50 mb">
                <a href="/myo2o/shop/shopauthmanage" class="button button-big button-fill">授权管理</a>
            </div>
            <div class="col-100 mb">
                <a href="/school/shopadmin/shoplist" class="button button-big button-fill button-danger">返回</a>
            </div>
        </div>
    </div>
</div>



<script type='text/javascript' src='//g.alicdn.com/sj/lib/zepto/zepto.min.js' charset='utf-8'></script>
<script type='text/javascript' src='//g.alicdn.com/msui/sm/0.6.2/js/sm.min.js' charset='utf-8'></script>
<script type='text/javascript' src='//g.alicdn.com/msui/sm/0.6.2/js/sm-extend.min.js' charset='utf-8'></script>
<script type='text/javascript' src='../resources/js/shop/shopmanage.js' charset='utf-8'></script>
<script type="text/javascript" src='../resources/js/common/common.js' charset='utf-8'></script>
</body>
</html>

