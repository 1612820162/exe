package com.example.exe.dao;

import com.example.exe.pojo.Machine;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MachineMapper {

    //向数据库中添加信息
    int insert(Machine machine);
    //删除表中所有信息
    int deleteAll();
    //根据回路和地址查询
    Machine seleteByCC(String circuit, String code);

}
