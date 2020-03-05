package io.cxy.jcartstoreback.vo;

public class OrderProductVO {
    private Integer productId;

    private Integer quantity;

    private Double unitPrice;

    private Double productTotal;

    private Integer unitRewordPoints;

    private Integer totalRewordPoints;

    public Integer getUnitRewordPoints() {
        return unitRewordPoints;
    }

    public void setUnitRewordPoints(Integer unitRewordPoints) {
        this.unitRewordPoints = unitRewordPoints;
    }

    public Integer getTotalRewordPoints() {
        return totalRewordPoints;
    }

    public void setTotalRewordPoints(Integer totalRewordPoints) {
        this.totalRewordPoints = totalRewordPoints;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getProductTotal() {
        return productTotal;
    }

    public void setProductTotal(Double productTotal) {
        this.productTotal = productTotal;
    }
}
