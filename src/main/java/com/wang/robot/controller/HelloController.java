package com.wang.robot.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

/**********************************************************
 * All Rights Reserved.
 * 文件名称： HelloController
 * 摘 要： 
 * 初始版本：1.0.0
 * 原 作 者：wangch
 * 完成日期： 2018-04-03 15:02
 * 当前版本： 1.0.0
 * 作 者： wangch
 * 完成日期： 2018-04-03 15:02
 *****************************************************************/
@Controller
@EnableAutoConfiguration
public class HelloController {
    static final int VK_NUM_ASTERISK = 0x6A;

    @RequestMapping("/")
    String home() {
        return "/hello.html";
    }

    @RequestMapping("/startOrStop")
    @ResponseBody
    String stopMusic() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_ALT);

        robot.keyPress(VK_NUM_ASTERISK);// num *
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyRelease(KeyEvent.VK_ALT);
        robot.keyRelease(VK_NUM_ASTERISK);
        return "start or stop music!";
    }

}
