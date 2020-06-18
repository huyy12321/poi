package com.example.poi.service;

import com.example.poi.Entity.PhwdCustomerQrCodeAdd;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hyy
 * @since 2020-06-11
 */
public interface PhwdCustomerQrCodeAddService extends IService<PhwdCustomerQrCodeAdd> {

    void batchSave(List<Map<String,Object>> map,Integer id);

    void batchSaveJinHua(List<Map<String,Object>> map,Integer id);
}
