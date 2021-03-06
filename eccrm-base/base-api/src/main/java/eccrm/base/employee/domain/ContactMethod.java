package eccrm.base.employee.domain;

import com.ycrl.base.common.CommonDomain;

/**
 * Generated by chenl on 2014-10-22.
 */

public class ContactMethod extends CommonDomain {

    /**
     *目标类型
     */
    private String targetType;
    /**
     *目标编号
     */
    private String targetNo;
    /**
     *联系类型（电话，邮箱，email）
     */
    private String supType;
    /**
     *子类型（只有移动号码，固定号码）
     */
    private String subType;
    /**
     *国家
     */
    private String country;
    /**
     *省
     */
    private String province;
    /**
     *市
     */
    private String city;
    /**
     *区
     */
    private String district;
    /**
     *区号
     */
    private String preAddr;
    /**
     *地址（如果是email，地址就是，固定号码有区号 号码 分机三部分组成，此处号码就是地址字段）
     */
    private String address;
    /**
     *分机号
     */
    private String aftAddr;
    /**
     *邮编
     */
    private Integer zipCode;
    /**
     *是否显示（如果不显示，就是用152******5634） 1:显示 2：不显示 3：其他（微信，email）
     */
    private String  isShow;
    /**
     *是否默认
     */
    private Boolean isDefualt;
    /**
     *已核实
     */
    private Boolean isConfirm;
    private String method ;
    public String getTargetType() {
        return targetType;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }


    public String getTargetNo() {
        return targetNo;
    }

    public void setTargetNo(String targetNo) {
        this.targetNo = targetNo;
    }

    public String getSupType() {
        return supType;
    }

    public void setSupType(String supType) {
        this.supType = supType;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPreAddr() {
        return preAddr;
    }

    public void setPreAddr(String preAddr) {
        this.preAddr = preAddr;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAftAddr() {
        return aftAddr;
    }

    public void setAftAddr(String aftAddr) {
        this.aftAddr = aftAddr;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public String getIsShow() {
        return isShow;
    }

    public void setIsShow(String isShow) {
        this.isShow = isShow;
    }

    public Boolean getIsDefualt() {
        return isDefualt;
    }

    public void setIsDefualt(Boolean isDefualt) {
        this.isDefualt = isDefualt;
    }

    public Boolean getIsConfirm() {
        return isConfirm;
    }

    public void setIsConfirm(Boolean isConfirm) {
        this.isConfirm = isConfirm;
    }
}
