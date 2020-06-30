package com.sunvirgo.starter;

/**
 * 类说明:
 *
 * @author : 黄刚
 * @date : 2020/6/29 23:57
 **/
public class HelloService {
    HelloProperties helloProperties;
    public String sayHelloSunvirgo(String name){
        return helloProperties.getPrefix() + "_" + name + ":" + helloProperties.getSuffix();
    }

    public HelloProperties getHelloProperties() {
        return helloProperties;
    }

    public void setHelloProperties(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }
}
