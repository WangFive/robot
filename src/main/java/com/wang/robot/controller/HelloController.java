package com.wang.robot.controller;

import com.wang.robot.bean.Result;
import com.wang.robot.bean.VirtualKey;
import com.wang.robot.service.VbsService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    static final int VK_SHIFT = 0x10;
    static final int VK_CTRL = 0x11;
    static final int VK_ALT = 0x12;
    /**
     * num *
     */
    static final int VK_NUM_ASTERISK = 0x6A;
    /**
     * num +
     */
    static final int VK_NUM_PLUS = 0x6B;
    /**
     * num -
     */
    static final int VK_NUM_MINUS = 0x6D;

    int[] defaultKeys = {VK_CTRL, VK_SHIFT, VK_ALT};

    @RequestMapping("/")
    String home() {
        return "/hello.html";
    }

    @RequestMapping("/qqmusicControl")
    @ResponseBody
    String qqmusicControl(String cmd){
        List<Integer> keys = getKeys();
        switch (cmd){
            case "startOrStop":
                keys.add(VK_NUM_ASTERISK);
                break;
            case "prevSong":
                keys.add(KeyEvent.VK_P);
                break;
            case "nextSong":
                keys.add(KeyEvent.VK_N);
                break;
            case "increaseVolume":
                keys.add(VK_NUM_PLUS);
                break;
            case "decreaseVolume":
                keys.add(VK_NUM_MINUS);
                break;
            default:
                keys.add(VK_NUM_ASTERISK);
                break;
        }
        Result<String> result = keyPressAndRelease(keys);
        return cmd;
    }

    @RequestMapping("/mediaControl")
    @ResponseBody
    String mediaControl(String cmd){
        switch (cmd){
            case "playOrPause":
                VbsService.execKeyVbs(VirtualKey.VK_MEDIA_PLAY_PAUSE.getKeyValue());
                break;
            case "prevSong":
                VbsService.execKeyVbs(VirtualKey.VK_MEDIA_PREV_TRACK.getKeyValue());
                break;
            case "nextSong":
                VbsService.execKeyVbs(VirtualKey.VK_MEDIA_NEXT_TRACK.getKeyValue());
                break;
            case "volumeUp":
                VbsService.execKeyVbs(VirtualKey.VK_VOLUME_UP.getKeyValue());
                break;
            case "volumeDown":
                VbsService.execKeyVbs(VirtualKey.VK_VOLUME_DOWN.getKeyValue());
                break;
            case "volumeMute":
                VbsService.execKeyVbs(VirtualKey.VK_VOLUME_MUTE.getKeyValue());
                break;
            case "stop":
                VbsService.execKeyVbs(VirtualKey.VK_MEDIA_STOP.getKeyValue());
                break;
            default:
                VbsService.execKeyVbs(VirtualKey.VK_MEDIA_PLAY_PAUSE.getKeyValue());
                break;
        }
        return cmd;
    }

    @RequestMapping("/systemControl")
    @ResponseBody
    String systemControl(String cmd){
        String command = "";
        switch (cmd){
            case "shutdown":
                command = "shutdown -s -t 1800";
                break;
            case "cancel":
                command = "shutdown -a";
                break;
            default:
                command = "shutdown -a";
                break;
        }
        Runtime runtime = Runtime.getRuntime();
        try {
            Process process = runtime.exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cmd;
    }

    private Result<String> keyPressAndRelease(List<Integer> keys){
        Robot robot = null;
        Result<String> result = new Result<>();
        try {
            robot = new Robot();
            for (int key : keys) {
                robot.keyPress(key);
            }
            for (int key : keys) {
                robot.keyRelease(key);
            }
        } catch (AWTException e) {
            e.printStackTrace();
            result.fail();
            result.setMsg("catch exception");
        }
        return result;
    }

    private List<Integer> getKeys() {
        List<Integer> keys = new ArrayList<>(4);
        for (int key : defaultKeys) {
            keys.add(key);
        }
        return keys;
    }

}
