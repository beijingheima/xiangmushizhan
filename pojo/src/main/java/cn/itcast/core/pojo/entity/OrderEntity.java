package cn.itcast.core.pojo.entity;

<<<<<<< HEAD
=======
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

>>>>>>> 23838065779416bd1fb3de6991d23dd0f38af438
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/*

商品价格
商品数量
订单实付
订单来源
创建时间
状态
 */
public class OrderEntity implements Serializable {

<<<<<<< HEAD
    private Long goodsId;
=======




    private Long orderId;//订单id

    private String orderIdStr;//订单idString类型,防止js丢失精度
>>>>>>> 23838065779416bd1fb3de6991d23dd0f38af438

    private String goodsName;//商品名称

    private BigDecimal price;//商品价格

    private Integer num;//商品数量

    private BigDecimal payment;//订单实付金额

    private String source;//订单来源

    private Date createTime;//创建时间

    private String status;//状态

<<<<<<< HEAD
    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
=======
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
>>>>>>> 23838065779416bd1fb3de6991d23dd0f38af438
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public BigDecimal getPayment() {
        return payment;
    }

    public void setPayment(BigDecimal payment) {
        this.payment = payment;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
<<<<<<< HEAD
        this.status = status;
    }
}
=======
        status = status;
    }

    public String getOrderIdStr() {
        return orderIdStr;
    }

    public void setOrderIdStr(String orderIdStr) {
        this.orderIdStr = orderIdStr;
    }
}
>>>>>>> 23838065779416bd1fb3de6991d23dd0f38af438
