package com.begin.guice;

import com.google.inject.Binder;
import com.google.inject.Module;

public class MockGatewayModule implements Module {

    @Override
    public void configure(Binder binder) {
        binder.bind(ConsumeService.class).to(MockConsumer.class);
        binder.bind(ProduceService.class).to(MockProducer.class);
        binder.bind(GatewayService.class).to(GatewayServiceImpl.class).asEagerSingleton();
    }
}
