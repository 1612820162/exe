package com.example.exe;

import com.example.exe.dao.MachineMapper;
import com.example.exe.tomysql.GetExcel;
import com.example.exe.utils.Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExeApplicationTests {
    @Resource
    MachineMapper machineMapper;

    @Test
    public void contextLoads() {

    }

    @Test
    public void aVoid(){
        InputStream inputStream=null;
        GetExcel getExcel =new GetExcel();
        List<List<Object>> list=null;
        try {
            inputStream=new FileInputStream("D:/excel/A1.xls");
            list= getExcel.getBankListByExcel(inputStream);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(list.size());

    }

    @Test
    public void H(){
        Util util=new Util();
        String a=util.toStr("9a");
        System.out.println(a);
    }

    @Test
    public void deleteAll(){
        int isOK=machineMapper.deleteAll();
        System.out.println(isOK);
    }

}
