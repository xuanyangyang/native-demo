package com.example.nativedemo;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.config.ConfigService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class NativeDemoApplicationTests {
    @Autowired
    private DiscoveryController discoveryController;

    @Test
    void contextLoads() {
        log.info("has discoveryController:{}", discoveryController != null);
        if (discoveryController != null) {
            log.info("has namingService:{}", discoveryController.getNamingService() != null);
        }
    }

}
