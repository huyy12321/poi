package com.example.poi.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;


/**
 * @author hyy
 */
public class PoiUtil {

    private static String XLSX = ".xlsx";

    private static String XLS = ".xls";

    /**
     * 传进来文件，从文件直接读取
     * @param file 输入的文件
     * @param columns 文件有的字段
     */
    public static List<Map<String,Object>> list(MultipartFile file, String[] columns) throws Exception{
        String originalFilename = file.getOriginalFilename();
        assert originalFilename != null;
        String name = originalFilename.substring(originalFilename.lastIndexOf("."));
        if(XLS.equals(name)) {
            return readByWb(new HSSFWorkbook(file.getInputStream()),columns);
        } else if(XLSX.equals(name)){
            return readByWb(new XSSFWorkbook(file.getInputStream()),columns);
        }
        return new ArrayList<>(0);
    }

    /**
     * 根据路径去读本地的一个文件
     * @param url 文件路径
     * @param columns 表格中的字段
     */
    public static List<Map<String,Object>> list(String url,String[] columns) {
        String filePath = "D:\\"+url;
        Workbook wb = readExcel(filePath);
        return readByWb(wb,columns);
    }

    private static List<Map<String,Object>> readByWb(Workbook wb, String[] columns){
        // 用来存放表中数据
        List<Map<String,Object>> list = new ArrayList<>();
        String cellData;
        if(wb != null){
            // 获取第一个sheet
            Sheet sheet = wb.getSheetAt(0);
            // 获取最大行数
            int rownum = sheet.getPhysicalNumberOfRows();
            // 获取第一行
            Row row = sheet.getRow(4);
            // 获取最大列数
            int colnum = row.getPhysicalNumberOfCells();
            for (int i = 1; i<rownum; i++) {
                Map<String,Object> map = new LinkedHashMap<>();
                row = sheet.getRow(i);
                if(row !=null){
                    for (int j=0;j<colnum;j++){
                        cellData = (String) getCellFormatValue(row.getCell(j));
                        if(!StringUtils.isEmpty(row.getCell(0)) && !"序号".equals(getCellFormatValue(row.getCell(0)))){
                            map.put(columns[j], cellData);
                        }
                    }
                }else{
                    break;
                }
                list.add(map);
            }
        }
        return list;
    }

    /**
     * 读取excel
     * @param filePath 文件绝对路径
     */
    private static Workbook readExcel(String filePath){
        if(filePath == null){
            return null;
        }
        String extString = filePath.substring(filePath.lastIndexOf("."));
        InputStream is;
        try {
            is = new FileInputStream(filePath);
            if(XLS.equals(extString)){
                return new HSSFWorkbook(is);
            }else if(XLSX.equals(extString)){
                return new XSSFWorkbook(is);
            }else{
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 进行格式转换，将各种类型的都转成String读出来
     * @param cell 每一列的具体的值
     */
    private static Object getCellFormatValue(Cell cell){
        Object cellValue;
        if(cell!=null){
            //判断cell类型
            switch(cell.getCellTypeEnum()){
                case NUMERIC:{
                    BigDecimal big=new BigDecimal(cell.getNumericCellValue());
                    cellValue = big.toString();
                    break;
                }
                case FORMULA:{
                    // 判断cell是否为日期格式
                    if(DateUtil.isCellDateFormatted(cell)){
                        // 转换为日期格式YYYY-mm-dd
                        cellValue = cell.getDateCellValue();
                    }else{
                        // 数字
                        cellValue = String.valueOf(cell.getNumericCellValue());
                    }
                    break;
                }
                case STRING:{
                    cellValue = cell.getRichStringCellValue().getString();
                    break;
                }
                default:
                    cellValue = "";
            }
        }else{
            cellValue = "";
        }
        return cellValue;
    }

}