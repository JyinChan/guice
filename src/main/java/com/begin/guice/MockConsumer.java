package com.begin.guice;

import java.util.List;

public class MockConsumer implements ConsumeService {

    public void consume(List<String> dataList) {
        System.out.println("MockConsumer: " + dataList);
    }
}
