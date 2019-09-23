package com.example.exe.tomysql;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ToMysql{

    /**
     * Excel导入
     */
    public static  List<List<Object>> getBankListByExcel(InputStream inputStream, String fileName) throws Exception{
        List<List<Object>> list = null;
        //创建Excel工作薄
        Workbook work = new HSSFWorkbook(inputStream);
        if(null == work){
            throw new Exception("创建Excel工作薄为空！");
        }
        Sheet sheet = null;
        Row row = null;
        Cell cell = null;
        list = new ArrayList<List<Object>>();
        //遍历Excel中所有的sheet
        for (int i = 0; i < work.getNumberOfSheets(); i++) {
            sheet = work.getSheetAt(i);
            if(sheet==null){continue;}
            //遍历当前sheet中的所有行
            //包涵头部，所以要小于等于最后一列数,这里也可以在初始值加上头部行数，以便跳过头部
            for (int j = sheet.getFirstRowNum(); j <= sheet.getLastRowNum(); j++) {
                //读取一行
                row = sheet.getRow(j);
                //去掉空行和表头
                if(row==null||row.getFirstCellNum()==j){continue;}
                //遍历所有的列
                List<Object> li = new ArrayList<Object>();
                for (int y = row.getFirstCellNum(); y < row.getLastCellNum(); y++) {
                    cell = row.getCell(y);
                    li.add(getCellValue(cell));
                }
                list.add(li);
            }
        }
        return list;
    }

//
//    /**
//     * 描述：对表格中数值进行格式化
//     */
//    public static  Object getCellValue(Cell cell){
//        Object value = null;
//        DecimalFormat df = new DecimalFormat("0");  //格式化字符类型的数字
//        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");  //日期格式化
//        DecimalFormat df2 = new DecimalFormat("0.00");  //格式化数字
//        switch (cell.getCellType()) {
//            case Cell.CELL_TYPE_STRING:
//                value = cell.getRichStringCellValue().getString();
//                break;
//            case Cell.CELL_TYPE_NUMERIC:
//                if("General".equals(cell.getCellStyle().getDataFormatString())){
//                    value = df.format(cell.getNumericCellValue());
//                }else if("m/d/yy".equals(cell.getCellStyle().getDataFormatString())){
//                    value = sdf.format(cell.getDateCellValue());
//                }else{
//                    value = df2.format(cell.getNumericCellValue());
//                }
//                break;
//            case Cell.CELL_TYPE_BOOLEAN:
//                value = cell.getBooleanCellValue();
//                break;
//            case Cell.CELL_TYPE_BLANK:
//                value = "";
//                break;
//            default:
//                break;
//        }
//        return value;
//    }

}
