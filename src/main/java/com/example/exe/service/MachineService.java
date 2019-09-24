package com.example.exe.service;

import com.example.exe.dao.MachineMapper;
import com.example.exe.pojo.Machine;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MachineService {

    @Resource
    private MachineMapper machineMapper;

    //向数据库中插入数据
    public int insert(Machine machine){
        return machineMapper.insert(machine);
    }
    //删除表中所有信息
    public int deleteAll(){
        return machineMapper.deleteAll();
    }
    //根据回路和地址查询
    public Machine getByCC(String circuit, String code){
        return machineMapper.getByCC(circuit,code);
    }
}
