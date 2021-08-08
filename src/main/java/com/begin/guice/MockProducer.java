package com.begin.guice;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class MockProducer extends AbstractProducerService implements ProduceService {

    private static AtomicLong counter = new AtomicLong(0);

    public List<String> getDataList() {
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Collections.singletonList(String.valueOf(counter.incrementAndGet()));
    }
}