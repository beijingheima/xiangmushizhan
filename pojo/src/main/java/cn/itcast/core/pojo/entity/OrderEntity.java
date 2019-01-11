package cn.itcast.core.pojo.entity;

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

    private Long goodsId;

    private String goodsName;//商品名称

    private BigDecimal price;//商品价格

    private Integer num;//商品数量

    private BigDecimal payment;//订单实付金额

    private String source;//订单来源

    private Date createTime;//创建时间

    private String status;//状态

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
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
        this.status = status;
    }
}