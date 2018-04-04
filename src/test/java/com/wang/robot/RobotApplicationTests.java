package com.wang.robot;

import com.wang.robot.bean.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.AWTException;
import java.awt.Robot;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RobotApplicationTests {

	@Test
	public void contextLoads() {
		System.setProperty("java.awt.headless", "false");
		Robot robot = null;
		Result<String> result = new Result<>();
		try {
			robot = new Robot();
			robot.keyPress(0xAE);
			robot.keyRelease(0xAE);
		} catch (AWTException e) {
			e.printStackTrace();
			result.fail();
			result.setMsg("catch exception");
		}
	}

}
