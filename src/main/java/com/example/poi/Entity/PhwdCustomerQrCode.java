package com.example.poi.Entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author hyy
 * @since 2020-06-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("PHWD_CUSTOMER_QR_CODE")
public class PhwdCustomerQrCode implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("VALUE4")
    private String value4;

    @TableField("VALUE5")
    private String value5;

    @TableField("VALUE6")
    private String value6;

    /**
     * 市场人员id
     */
    @TableField("VALUE3")
    private String value3;

    @TableField("ORG_CODE")
    private String orgCode;

    @TableField("SALE_REG_CODE_REAL")
    private String saleRegCodeReal;

    @TableField("DIST_DEPT_CODE")
    private String distDeptCode;

    @TableField("CUST_CODE")
    private String custCode;

    @TableField("CUST_NAME")
    private String custName;

    @TableField("CUST_TYPE_CODE")
    private String custTypeCode;

    @TableField("CUST_ADDRESS")
    private String custAddress;

    @TableField("DISTRICT_CODE")
    private String districtCode;

    @TableField("ARTIFICIAL_PERSON")
    private String artificialPerson;

    @TableField("PHONE_NUMBER")
    private String phoneNumber;

    @TableField("PHONE_NUMBER1")
    private String phoneNumber1;

    @TableField("PHONE_NUMBER2")
    private String phoneNumber2;

    @TableField("ORDER_MODE_CODE")
    private String orderModeCode;

    @TableField("SALE_DEPT_CODE")
    private String saleDeptCode;

    @TableField("CUST_MGR_CODE")
    private String custMgrCode;

    @TableField("SALE_REG_CODE")
    private String saleRegCode;

    @TableField("REGIE_DEPT_CODE")
    private String regieDeptCode;

    @TableField("BAL_MODE_CODE")
    private String balModeCode;

    @TableField("BANK")
    private String bank;

    @TableField("BANK_ACCOUNTS")
    private String bankAccounts;

    @TableField("CUST_ORIG_CODE")
    private String custOrigCode;

    @TableField("CUST_ORIG_NAME")
    private String custOrigName;

    @TableField("WORK_STATE")
    private String workState;

    @TableField("WORK_STATE_NAME")
    private String workStateName;

    @TableField("UPDATE_TIME")
    private Date updateTime;

    @TableField("CUS_TYPE")
    private String cusType;

    @TableField("UP_FLAG")
    private String upFlag;

    @TableField("V_ORG")
    private String vOrg;

    /**
     * 百度地图纬度
     */
    @TableField("BD_LATITUDE")
    private String bdLatitude;

    /**
     * 百度题图精确度，1表示精确，0表示模糊
     */
    @TableField("PRECISE")
    private String precise;

    /**
     * 腾讯地图经度
     */
    @TableField("TC_LONGITUDE")
    private String tcLongitude;

    /**
     * 腾讯地图纬度
     */
    @TableField("TC_LATITUDE")
    private String tcLatitude;

    /**
     * 打火机发放量
     */
    @TableField("LIGHTER_STOCK")
    private Integer lighterStock;

    /**
     * 打火机领取量
     */
    @TableField("LIGHTER_DRAW")
    private Integer lighterDraw;

    /**
     * 零售户是否发起领取奖品请求  0：否  1：是
     */
    @TableField("IF_AWARD")
    private Integer ifAward;

    /**
     * 零售户二维码标识
     */
    @TableField("RETAILER_QRCODE")
    private String retailerQrcode;

    /**
     * 零售户所在城市
     */
    @TableField("CITY")
    private String city;

    /**
     * 零售户所在城市编码
     */
    @TableField("CITY_CODE")
    private String cityCode;

    @TableField("IF_SEND")
    private Integer ifSend;

    @TableField("SEND_TIME")
    private Date sendTime;

    @TableField("VALUE1")
    private String value1;

    /**
     * 标准区域名称
     */
    @TableField("VALUE2")
    private String value2;

    /**
     * 百度地图经度
     */
    @TableField("BD_LONGITUDE")
    private String bdLongitude;

    @TableField("CUST_ID")
    private Integer custId;

    /**
     * 数据删除状态，0：未删除、1：已删除
     */
    @TableField("DELETEFLAG")
    private Integer deleteflag;


}
