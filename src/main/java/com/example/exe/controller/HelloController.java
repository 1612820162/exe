package com.example.exe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/getexcel")
    public String getExcel(){
        return "/html/fileupload.html";
    }

    @RequestMapping("/command")
    public String commandInput(){
        return "/html/command.html";
    }
}
