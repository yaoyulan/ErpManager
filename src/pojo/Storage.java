package pojo;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class Storage {
    private String  warehouseNo;
    private String commodityName;
    private String supplier;
    private String specifications;
    private String specificationUnit;
    private Integer number;
    private String unit;
    private Double price;
    @JSONField(format = "yyyy-MM-dd")
    private Date storagDate;
    private String remarks;



    public String getWarehouseNo() {
        return warehouseNo;
    }

    public void setWarehouseNo(String warehouseNo) {
        this.warehouseNo = warehouseNo;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public String getSpecificationUnit() {
        return specificationUnit;
    }

    public void setSpecificationUnit(String specificationUnit) {
        this.specificationUnit = specificationUnit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getStoragDate() {
        return storagDate;
    }

    public void setStoragDate(Date storagDate) {
        this.storagDate = storagDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "warehouseNo='" + warehouseNo + '\'' +
                ", commodityName='" + commodityName + '\'' +
                ", supplier='" + supplier + '\'' +
                ", specifications='" + specifications + '\'' +
                ", specificationUnit='" + specificationUnit + '\'' +
                ", number=" + number +
                ", unit='" + unit + '\'' +
                ", price=" + price +
                ", storagDate=" + storagDate +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
