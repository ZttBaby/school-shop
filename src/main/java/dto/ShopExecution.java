package dto;

import com.qf.enums.ShopStateEnum;
import com.qf.pojo.po.Shop;

import java.util.List;

public class ShopExecution {
    //结果状态
    private int state;
    //状态标识
    private String stateInfo;
    //店铺数量
    private int count;
    //操作的shop(crud)
    private Shop shop;
    //shop列表（查询时候使用）
    private List<Shop> shopList;

    public ShopExecution(){}

    //失败的构造器：返回店铺失败的状态
    public ShopExecution(ShopStateEnum stateEnum){
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }
    //成功的构造器: 店铺操作成功返回对象与状态
    public ShopExecution(ShopStateEnum stateEnum,Shop shop){
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.shop = shop;
    }
    //成功的构造器：店铺操作成功返回对象与状态
    public ShopExecution(ShopStateEnum stateEnum,List<Shop> shopList){
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.shopList = shopList;
    }


}
