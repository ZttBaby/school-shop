<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>SUI Mobile Demo</title>
    <meta name="description" content="MSUI: Build mobile apps with simple HTML, CSS, and JS components.">
    <meta name="author" content="阿里巴巴国际UED前端">
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel="shortcut icon" href="/favicon.ico">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="format-detection" content="telephone=no">

    <!-- Google Web Fonts -->

    <link rel="stylesheet" href="//g.alicdn.com/msui/sm/0.6.2/css/sm.min.css">
    <link rel="stylesheet" href="//g.alicdn.com/msui/sm/0.6.2/css/sm-extend.min.css">
    <link rel="apple-touch-icon-precomposed" href="/assets/img/apple-touch-icon-114x114.png">

    <script>
        //ga
    </script>
    <script>
        var _hmt = _hmt || [];
        (function () {
            var hm = document.createElement("script");
            hm.src = "//hm.baidu.com/hm.js?ba76f8230db5f616edc89ce066670710";
            var s = document.getElementsByTagName("script")[0];
            s.parentNode.insertBefore(hm, s);
        })();
    </script>

</head>
<body>
<div class="page-group">
    <div id="page-label-input" class="page">
        <header class="bar bar-nav">
            <a class="button button-link button-nav pull-left back" href="/school/shopadmin/shoplist">
                <span class="icon icon-left"></span>
                返回
            </a>
            <h1 class="title">商铺信息</h1>
        </header>
        <div class="content">
            <div class="list-block">
                <ul>
                    <!-- Text inputs -->
                    <li>
                        <div class="item-content">
                            <div class="item-inner">
                                <div class="item-title label">商铺名称</div>
                                <div class="item-input">
                                    <input type="text" id="shop-name" placeholder="商铺名称">
                                </div>
                            </div>
                        </div>
                    </li>
                    <!-- 商铺分类 -->
                    <li>
                        <div class="item-content">
                            <div class="item-inner">
                                <div class="item-title label">商铺分类</div>
                                <div class="item-input">
                                    <select id="shop-category">

                                    </select>
                                </div>
                            </div>
                        </div>
                    </li>
                    <!-- 区域分类 -->
                    <li>
                        <div class="item-content">
                            <div class="item-inner">
                                <div class="item-title label">所属区域</div>
                                <div class="item-input">
                                    <select id="area">

                                    </select>
                                </div>
                            </div>
                        </div>
                    </li>
                    <!-- 详细地址 -->
                    <li>
                        <div class="item-content">
                            <div class="item-inner">
                                <div class="item-title label">详细地址</div>
                                <div class="item-input">
                                    <input type="text" id="shop-adder" placeholder="详细地址">
                                </div>
                            </div>
                        </div>
                    </li>
                    <!-- 联系电话 -->
                    <li>
                        <div class="item-content">
                            <div class="item-inner">
                                <div class="item-title label">联系电话</div>
                                <div class="item-input">
                                    <input type="text" id="shop-phone" placeholder="联系电话">
                                </div>
                            </div>
                        </div>
                    </li>
                    <!-- 缩略图 上传 -->
                    <li>
                        <div class="item-content">
                            <div class="item-inner">
                                <div class="item-title label">店铺图片</div>
                                <div class="item-input">
                                    <input type="file" id="shop-img">
                                </div>
                            </div>
                        </div>
                    </li>
                    <!-- 店铺简介 -->
                    <li class="align-top">
                        <div class="item-content">
                            <div class="item-inner">
                                <div class="item-title label">店铺简介</div>
                                <div class="item-input">
                                    <textarea id="shop-desc" placeholder="店铺简介"></textarea>
                                </div>
                            </div>
                        </div>
                    </li>
                    <!-- 验证码 -->
                    <li>
                        <div class="item-content">
                            <div class="item-inner">
                                <div class="item-title label">验证码</div>
                                <input type="text" id="j_captcha" placeholder="验证码">
                                <div class="item-input">
                                    <img id="captcha_img" alt="点击更换" title="点击更换"
                                    onclick="changeVerifyCode(this)" src="../Kaptcha" >
                                </div>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
            <div class="content-block">
                <div class="row">
                    <div class="col-50"><a href="#" class="button button-big button-fill button-danger">返回</a></div>
                    <div class="col-50"><a href="#" class="button button-big button-fill button-success"
                                           id="submit">提交</a></div>
                </div>
            </div>
        </div>
    </div>

</div>
<script type='text/javascript' src='//g.alicdn.com/sj/lib/zepto/zepto.min.js' charset='utf-8'></script>
<script type='text/javascript' src='//g.alicdn.com/msui/sm/0.6.2/js/sm.min.js' charset='utf-8'></script>
<script type='text/javascript' src='//g.alicdn.com/msui/sm/0.6.2/js/sm-extend.min.js' charset='utf-8'></script>
<script type="text/javascript" src='../resources/js/shop/shopoperation.js' charset='utf-8'></script>
<script type="text/javascript" src='../resources/js/common/common.js' charset='utf-8'></script>
</body>
</html>
