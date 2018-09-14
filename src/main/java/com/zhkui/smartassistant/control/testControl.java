package com.zhkui.smartassistant.control;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testControl
{
    private Logger mLog = LoggerFactory.getLogger(testControl.class);
    @RequestMapping("/")
    public String index(){
        mLog.info("hello world!");
        return "Hello world!";
    }
}
