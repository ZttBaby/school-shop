 $(function () {
     var shopId = getQueryString('shopId');
     var shopInfoUrl = '/school/shopadmin/getshopmanagementinfo?shopId=' + shopId;
     $.getJSON(shopInfoUrl,function (data) {
         if (data.redirect){
             window.location.hre = data.url;
         }else {
             if(data.shopId != undefined && data.shopId !=null){
                 shopId = data.shopId;
             }
             $('#shopInfo')
                 .attr('href','/school/shopadmin/shopoperation?shopId='+shopId);
         }
     });
 });