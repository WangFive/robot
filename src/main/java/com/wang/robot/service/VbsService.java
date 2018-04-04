package com.wang.robot.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**********************************************************
 * All Rights Reserved.
 * 文件名称： VbsService
 * 摘 要： 执行vbs
 * 初始版本：1.0.0
 * 原 作 者：wangch
 * 完成日期： 2018-04-04 09:27
 * 当前版本： 1.0.0
 * 作 者： wangch
 * 完成日期： 2018-04-04 09:27
 *****************************************************************/
public class VbsService {

    public static void execKeyVbs(String key){
        String vbs = "Set wshell = Wscript.CreateObject(\"Wscript.Shell\")\n" +
                "key = chr(&h88" + key + ")\n" +
                "wshell.Sendkeys key";
        try {
            File file = File.createTempFile("media_control", ".vbs");
            file.deleteOnExit();
            FileWriter fw = new FileWriter(file);
            fw.write(vbs);
            fw.close();
            Runtime.getRuntime().exec("wscript " + file.getPath()).waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
