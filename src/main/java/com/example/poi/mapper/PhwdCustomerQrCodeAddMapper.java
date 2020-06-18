package com.example.poi.mapper;

import com.example.poi.Entity.PhwdCustomerQrCodeAdd;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hyy
 * @since 2020-06-11
 */
@Mapper
public interface PhwdCustomerQrCodeAddMapper extends BaseMapper<PhwdCustomerQrCodeAdd> {

    void batchSave(@Param("list") List<Map<String,Object>> list,
                   @Param("id")Integer id);

    void batchSaveJinHua(@Param("list") List<Map<String,Object>> batchSaveJinHua,
                         @Param("id")Integer id);
}
