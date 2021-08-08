package com.begin.guice;

import java.util.List;

public interface ProduceService {

    List<String> getDataList();

    void start();

    void stop();
}
