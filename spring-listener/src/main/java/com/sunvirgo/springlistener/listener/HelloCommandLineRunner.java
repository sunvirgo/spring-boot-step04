package com.sunvirgo.springlistener.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 类说明:
 *
 * @author : 黄刚
 * @date : 2020/6/27 22:59
 **/
@Slf4j
@Component
public class HelloCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        log.info("CommandLineRunner...run....[{}]", Arrays.asList(args));
    }
}
