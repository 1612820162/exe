package com.example.exe.controller;

import com.example.exe.pojo.Machine;
import com.example.exe.service.MachineService;
import com.example.exe.tomysql.GetExcel;
import com.example.exe.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/excel")
public class ExcelUploadController {

    @Autowired
    private MachineService machineService;
    Util util;

    @RequestMapping("/upload")
    public String export(@RequestParam(value = "file") MultipartFile file) {
        GetExcel getExcel =new GetExcel();
        util =new Util();
        List<List<Object>> list=null;
        try {
            InputStream inputStream = file.getInputStream();
            list= getExcel.getBankListByExcel(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        List<Machine> machineList= util.toMachine(list);
        for (int i=0;i<machineList.size();i++){
            int isOk=machineService.insert(machineList.get(i));
        }
        System.out.println(machineList.size());
        return "上传成功";
    }

    //返回前端输入指令对应的命令
    @RequestMapping("/react")
    public String react(@RequestParam("command") String command){
        String string1=command.substring(0,2);
        String string2=command.substring(2,4);
        String string3=command.substring(4,6);
        String reaction="";
        Machine machine;
        int n2 = Integer.parseInt(string2, 16);
        int n3 = Integer.parseInt(string3, 16);
        String str2 = Integer.toString(n2, 10);
        String str3 = Integer.toString(n3, 10);
        switch (string1){
            case "01":
                machine = machineService.seleteByCC(str2, str3);
                if (machine==null){
                    reaction="查询信息不存在";
                    break;
                }else {
                    reaction="火警：回路"+machine.getCircuit()+"地址"+machine.getCode();
                    break;
                }
            case "02":
                machine = machineService.seleteByCC(str2, str3);
                if (machine==null){
                    reaction="查询信息不存在";
                    break;
                }else {
                    reaction="设备故障：回路"+machine.getCircuit()+"地址"+machine.getCode();
                    break;
                }
            case "05":
                machine = machineService.seleteByCC(str2, str3);
                if (machine==null){
                    reaction="查询信息不存在";
                    break;
                }else {
                    reaction="设备故障恢复：回路"+machine.getCircuit()+"地址"+machine.getCode();
                    break;
                }
            case "09":
                machine = machineService.seleteByCC(str2, str3);
                if (machine==null){
                    reaction="查询信息不存在";
                    break;
                }else {
                    reaction="联动回答：回路"+machine.getCircuit()+"地址"+machine.getCode();
                    break;
                }
            case "0B":
                machine = machineService.seleteByCC(str2, str3);
                if (machine==null){
                    reaction="查询信息不存在";
                    break;
                }else {
                    reaction="联动回答消除：回路"+machine.getCircuit()+"地址"+machine.getCode();
                    break;
                }
            case "12":
                if ("00".equals(string2)){
                    reaction="主电源正常";
                    break;
                }else if ("01".equals(string2)){
                    reaction="主电源故障";
                    break;
                }
            case "13":
                if ("00".equals(string2)){
                    reaction="备电源正常";
                    break;
                }else if ("01".equals(string2)){
                    reaction="备电源故障";
                    break;
                }
            case "30":
                reaction="消音";
                break;
            case "40":
                machine = machineService.seleteByCC(str2, str3);
                if (machine==null){
                    reaction="查询信息不存在";
                    break;
                }else {
                    reaction="联动请求：回路"+machine.getCircuit()+"地址"+machine.getCode();
                    break;
                }
            case "44":
                machine = machineService.seleteByCC(str2, str3);
                if (machine==null){
                    reaction="查询信息不存在";
                    break;
                }else {
                    reaction="联动启动：回路"+machine.getCircuit()+"地址"+machine.getCode();
                    break;
                }
            case "50":
                reaction="设备总复位";
                break;
            default:
                break;
        }
        return reaction;
    }
}