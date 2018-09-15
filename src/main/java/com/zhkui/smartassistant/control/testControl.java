package com.zhkui.smartassistant.control;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class testControl
{
    private Logger mLog = LoggerFactory.getLogger(testControl.class);
    @RequestMapping("/index")
    public String index(Model model){
        mLog.info("hello world!");
        model.addAttribute("name","zhakui");
        return "index";
    }
}
