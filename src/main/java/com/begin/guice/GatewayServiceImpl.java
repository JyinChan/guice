package com.begin.guice;

import com.google.inject.Inject;

import java.util.List;

public class GatewayServiceImpl implements GatewayService {

    private ConsumeService consumer;

    private ProduceService producer;

    private volatile boolean isRunning = false;

    @Inject
    public GatewayServiceImpl(ProduceService producer, ConsumeService consumer) {
        this.producer = producer;
        this.consumer = consumer;
    }

    public void start() {
        if (isRunning) {
            throw new IllegalStateException("already running");
        }

        new Thread(new Runnable() {
            public void run() {
                try {
                    isRunning = true;
                    while (isRunning) {
                        List<String> dataList = producer.getDataList();
                        consumer.consume(dataList);
                    }
                } finally {
                    isRunning = false;
                }
            }
        }, "gateway-service").start();
    }

    public void stop() {
        this.isRunning = false;
    }
}
