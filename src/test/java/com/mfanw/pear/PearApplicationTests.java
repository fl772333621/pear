package com.mfanw.pear;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mfanw.core.log.MonitorLogger;
import com.mfanw.core.log.SystemLogger;
import com.mfanw.pear.mail.biz.IMailBiz;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PearApplicationTests {

    private MonitorLogger monitor = MonitorLogger.getInstance();

    private SystemLogger system = SystemLogger.getInstance();

    @Autowired
    private IMailBiz mailBiz;

    @Test
    public void contextLoads() {
        mailBiz.sendText("772333621@qq.com", "我是主题", "我是内容");
    }

    @Test
    public void testLogger() {
        monitor.debug("我是debug");
        monitor.error("我是error");
        system.event("我是event");
        system.sql("我是sql");
    }

}
