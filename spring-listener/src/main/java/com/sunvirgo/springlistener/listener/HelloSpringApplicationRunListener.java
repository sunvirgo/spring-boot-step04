package com.sunvirgo.springlistener.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * 类说明:
 *
 * @author : 黄刚
 * @date : 2020/6/27 22:24
 **/
@Slf4j
public class HelloSpringApplicationRunListener implements SpringApplicationRunListener {
    public HelloSpringApplicationRunListener(SpringApplication application, String[] args){

    }
    @Override
    public void starting() {
        log.info("SpringApplicationRunListener...starting....");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        Object o = environment.getSystemProperties().get("os.name");
        log.info("SpringApplicationRunListener...environmentPrepared....,[{}]", o);
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        log.info("SpringApplicationRunListener...contextPrepared....");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        log.info("SpringApplicationRunListener...contextLoaded....");
    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        log.info("SpringApplicationRunListener...started....");
    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        log.info("SpringApplicationRunListener...starting....");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        log.info("SpringApplicationRunListener...starting....");
    }
}
