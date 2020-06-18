package com.example.poi.service;

import com.example.poi.Entity.PhwdCustomerQrCode;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.poi.Entity.PhwdCustomerQrCodeAdd;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hyy
 * @since 2020-06-12
 */
public interface PhwdCustomerQrCodeService extends IService<PhwdCustomerQrCode> {
    void batchSave(List<PhwdCustomerQrCodeAdd> list);
}
