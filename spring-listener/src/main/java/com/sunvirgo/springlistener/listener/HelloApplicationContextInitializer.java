package com.sunvirgo.springlistener.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 类说明:
 *
 * @author : 黄刚
 * @date : 2020/6/27 22:22
 **/
@Slf4j
public class HelloApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        log.info("ApplicationContextInitializer...initialize....");
    }
}
