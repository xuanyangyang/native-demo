package com.example.nativedemo;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author XYY
 * @since 1.0
 */
@RestController
public class NativeController {

    @GetMapping("ip")
    public String getIp(ServerHttpRequest request) {
        return request.getRemoteAddress().getHostString() + ":" + request.getRemoteAddress().getPort();
    }
}
