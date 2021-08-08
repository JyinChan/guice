package com.begin.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {

    public static void main(String[] args) throws Exception {

//        ProduceService producer = new MockProducer();
//        ConsumeService consumer = new MockConsumer();
//        GatewayService service = new GatewayServiceImpl(producer, consumer);
//        service.start();
//        Thread.sleep(10000L);
//        service.stop();

        Injector injector = Guice.createInjector(new MockGatewayModule());
        injector.getInstance(GatewayService.class).start();
        Thread.sleep(10000L);
        injector.getInstance(GatewayService.class).stop();
    }
}
