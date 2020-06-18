package com.example.poi.Entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
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
 * @since 2020-06-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("PHWD_CUSTOMER_QR_CODE_ADD")
public class PhwdCustomerQrCodeAdd implements Serializable {

    private static final long serialVersionUID=1L;

    // 许可证号
    @TableField("CUST_CODE")
    private String custCode;
   // 店名
    @TableField("CUST_NAME")
    private String custName;
    // 详细地址
    @TableField("CUST_ADDRESS")
    private String custAddress;
   // 联系人姓名
    @TableField("ARTIFICIAL_PERSON")
    private String artificialPerson;
  // 联系人电话
    @TableField("PHONE_NUMBER")
    private String phoneNumber;

    @TableField("PHONE_NUMBER1")
    private String phoneNumber1;
    // 市
    @TableField("CITY")
    private String city;
    // 县
    @TableField("VALUE2")
    private String value2;
    // 主键
    @TableField("CUST_ID")
    private Integer custId;
   // 精度
    @TableField("BD_LONGITUDE")
    private String bdLongitude;
    // 维度
    @TableField("BD_LATITUDE")
    private String bdLatitude;
   //精准度
    @TableField("PRECISE")
    private String precise;


}
