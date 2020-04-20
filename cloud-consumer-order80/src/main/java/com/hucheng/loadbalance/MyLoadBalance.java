package com.hucheng.loadbalance;

import cn.hutool.log.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author HuChan
 */
@Slf4j
@Component
public class MyLoadBalance implements LoadBalancer {

    private AtomicInteger visitCount = new AtomicInteger(0);

    @Override
    public ServiceInstance instance(List<ServiceInstance> instances) {
        int index = getVisitCount()%instances.size();
        return instances.get(index);
    }

    public final int getVisitCount() {
        int current = 0;
        int next = 0;
        do {
            current = this.visitCount.get();
            next = current >= 2147483647 ? 0 : current + 1;
        } while (!this.visitCount.compareAndSet(current, next));
        log.info("-----第" + next + "访问-----");
        return next;
    }
}
