package com.example.poi.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.poi.Entity.PhwdCustomerQrCode;
import com.example.poi.Entity.PhwdCustomerQrCodeAdd;
import com.example.poi.common.CodeTable;
import com.example.poi.common.Response;
import com.example.poi.common.note.DateLogNote;
import com.example.poi.service.PhwdCustomerQrCodeAddService;
import com.example.poi.service.PhwdCustomerQrCodeService;
import com.example.poi.util.PoiUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author hyy
 */
@RestController
@CrossOrigin
@RequestMapping("/test")
@Slf4j
public class TestController {
    @Resource
    private PhwdCustomerQrCodeAddService phwdCustomerQrCodeAddService;
    @Resource
    private PhwdCustomerQrCodeService phwdCustomerQrCodeService;

    @RequestMapping("/test")
    @DateLogNote
    public String a(){
        return "success";
    }

    @RequestMapping("/upload")
    public Response test(@RequestParam("file") MultipartFile file){
        String[] columns = {"id","name","UUID","linkName","phone","shopName","state","province","city","value2","address","code"};
        try{
            List<Map<String, Object>> list = PoiUtil.list(file,columns);
            log.info("读取到的条数{}",list.size());
            QueryWrapper<PhwdCustomerQrCode> objectQueryWrapper = new QueryWrapper<>();
            objectQueryWrapper.orderByDesc("CUST_ID");
            List<PhwdCustomerQrCode> list2 = phwdCustomerQrCodeService.list(objectQueryWrapper);
            List<String> collect = list2.stream().map(PhwdCustomerQrCode::getCustCode).collect(Collectors.toList());
            List<Map<String, Object>> list1 = list.stream().filter(stringObjectMap -> (!StringUtils.isEmpty(stringObjectMap.get("id")) && !collect.contains(stringObjectMap.get("code").toString()))).collect(Collectors.toList());
            List<Object> repetition = list.stream().filter(stringObjectMap -> (!StringUtils.isEmpty(stringObjectMap.get("id")) && collect.contains(stringObjectMap.get("code").toString()))).map(stringObjectMap -> stringObjectMap.get("code")).collect(Collectors.toList());
            log.info("过滤去重后的条数{}",list1.size());
            log.info("重复记录的code{}",repetition.toString());
            if(list1.size() > 0) {
                phwdCustomerQrCodeAddService.batchSaveJinHua(list1,list2.get(0).getCustId()+1);
            }
        } catch (Exception e) {
            log.error("导入发生异常",e);
            return new Response(CodeTable.EXCEPTION);
        }
        return new Response();
    }

    @RequestMapping("/merge")
    public String merge(){
        List<PhwdCustomerQrCodeAdd> list = phwdCustomerQrCodeAddService.list();
        if(list.size() > 0) {
            phwdCustomerQrCodeService.batchSave(list);
            QueryWrapper<PhwdCustomerQrCodeAdd> objectQueryWrapper = new QueryWrapper<>();
            objectQueryWrapper.isNotNull("CUST_CODE");
            phwdCustomerQrCodeAddService.remove(objectQueryWrapper);
        }
        return "success";
    }
}
