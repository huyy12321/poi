package com.example.poi.service.impl;

import com.example.poi.Entity.PhwdCustomerQrCode;
import com.example.poi.Entity.PhwdCustomerQrCodeAdd;
import com.example.poi.mapper.PhwdCustomerQrCodeAddMapper;
import com.example.poi.service.PhwdCustomerQrCodeAddService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hyy
 * @since 2020-06-11
 */
@Service
public class PhwdCustomerQrCodeAddServiceImpl extends ServiceImpl<PhwdCustomerQrCodeAddMapper, PhwdCustomerQrCodeAdd> implements PhwdCustomerQrCodeAddService {

    @Resource
    private PhwdCustomerQrCodeAddMapper phwdCustomerQrCodeAddMapper;


    @Override
    public void batchSave(List<Map<String,Object>> list,Integer id) {
        phwdCustomerQrCodeAddMapper.batchSave(list,id);
    }

    @Override
    public void batchSaveJinHua(List<Map<String, Object>> map,Integer id) {
        phwdCustomerQrCodeAddMapper.batchSaveJinHua(map,id);
    }
}
