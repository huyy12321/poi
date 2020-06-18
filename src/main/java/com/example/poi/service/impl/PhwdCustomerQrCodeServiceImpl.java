package com.example.poi.service.impl;

import com.example.poi.Entity.PhwdCustomerQrCode;
import com.example.poi.Entity.PhwdCustomerQrCodeAdd;
import com.example.poi.mapper.PhwdCustomerQrCodeMapper;
import com.example.poi.service.PhwdCustomerQrCodeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hyy
 * @since 2020-06-12
 */
@Service
public class PhwdCustomerQrCodeServiceImpl extends ServiceImpl<PhwdCustomerQrCodeMapper, PhwdCustomerQrCode> implements PhwdCustomerQrCodeService {

    @Resource
    private PhwdCustomerQrCodeMapper phwdCustomerQrCodeMapper;
    @Override
    public void batchSave(List<PhwdCustomerQrCodeAdd> list) {
        phwdCustomerQrCodeMapper.batchSave(list);
    }
}
