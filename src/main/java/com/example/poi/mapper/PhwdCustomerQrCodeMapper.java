package com.example.poi.mapper;

import com.example.poi.Entity.PhwdCustomerQrCode;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.poi.Entity.PhwdCustomerQrCodeAdd;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hyy
 * @since 2020-06-12
 */
public interface PhwdCustomerQrCodeMapper extends BaseMapper<PhwdCustomerQrCode> {

    void batchSave(@Param("list") List<PhwdCustomerQrCodeAdd> list);
}
