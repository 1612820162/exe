package com.example.exe.controller;

import org.apache.el.stream.Stream;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/excel")
public class ExcelUploadController {

    @RequestMapping("/upload")
    public String export(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
        try {
            InputStream inputStream = request.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传成功";
    }
}


//    @RequestMapping("/upload")
//    public void uploadExcel(){
//        System.out.println("nihao");

//        HSSFWorkbook book;
//        try {
//            book = new HSSFWorkbook(new FileInputStream("D:/excel/A1区消防设备登记表+.xls"));
//            HSSFSheet sheet=book.getSheet("表");
//            //得到表格的第一行
//            HSSFRow row=sheet.getRow(0);
//            Iterator<Cell> ite=row.cellIterator();
//            while(ite.hasNext()){
//                HSSFCell cell=(HSSFCell)ite.next();
//                String cname=cell.getStringCellValue();
//                System.out.print(cname);
//                System.out.print(",");
//            }
//            System.out.println("\n");
//            System.out.println("---------------------------------------");
//            //得到表格的其他行，即不包括第一行
//            Iterator<Row> it= sheet.rowIterator();
//            while(it.hasNext()){//遍历所有行
//                row=(HSSFRow)it.next();
//                ite=row.cellIterator();
//                while(ite.hasNext()){//遍历当前行的所有列
//                    HSSFCell cell=(HSSFCell)ite.next();
//                    String cname=cell.getStringCellValue();
//                    System.out.print(cname);
//                    System.out.print(",");
//                }
//                System.out.println("\n");
//            }
//            book.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//    }
//}
