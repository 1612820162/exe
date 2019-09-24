package com.example.exe.utils;

import com.example.exe.pojo.Machine;

import java.util.ArrayList;
import java.util.List;

public class Util {

    public List<Machine> toMachine(List<List<Object>> list){
        List<Machine> machineList=new ArrayList<Machine>();
        for (int i=0;i<list.size();i++){
            Machine machine=new Machine();
            for (int j=0;j<list.get(i).size();j++){
                if (j==0){
                    machine.setCircuit(list.get(i).get(j).toString());
                }else if (j==1){
                    machine.setCode(list.get(i).get(j).toString());
                }else if (j==2){
                    machine.setFloor(list.get(i).get(j).toString());
                }else if (j==3){
                    machine.setType(list.get(i).get(j).toString());
                }else if (j==4){
                    machine.setAddress(list.get(i).get(j).toString());
                }else if (j==5){
                    machine.setMessage(list.get(i).get(j).toString());
                }
            }
            machineList.add(machine);
        }
        return machineList;
    }

    public String toStr(String hex){
        int n = Integer.parseInt(hex, 16);
        return Integer.toString(n, 10);
    }

}
