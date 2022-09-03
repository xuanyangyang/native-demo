package com.example.nativedemo;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author XYY
 * @since 1.0
 */
@RestController
@RequestMapping("config")
@Slf4j
public class ConfigController {
    @NacosInjected
    private ConfigService configService;

    @GetMapping(value = "get")
    public String get(String dataId) throws NacosException {
        log.info("data:{}", dataId);
        String config = configService.getConfig(dataId, "native", 100);
        return config;
    }
}
