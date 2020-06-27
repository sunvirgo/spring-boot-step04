package com.sunvirgo.springlistener.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * 类说明:
 *
 * @author : 黄刚
 * @date : 2020/6/27 22:56
 **/
@Slf4j
@Component
public class HelloApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("ApplicationRunner...run....");
    }
}
