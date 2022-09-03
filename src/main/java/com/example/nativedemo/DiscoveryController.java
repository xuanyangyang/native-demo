package com.example.nativedemo;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author XYY
 * @since 1.0
 */
@RestController
@RequestMapping("discovery")
@Slf4j
public class DiscoveryController implements InitializingBean {
    @NacosInjected
    private NamingService namingService;

    @RequestMapping(value = "find", method = RequestMethod.POST)
    public List<Instance> find(@ModelAttribute FindRequest request) throws NacosException {
        log.info("name:{}", request.getName());
        return namingService.getAllInstances(request.getName());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        namingService.registerInstance("native", "localhost", 10000);
    }

    public NamingService getNamingService() {
        return namingService;
    }
}
