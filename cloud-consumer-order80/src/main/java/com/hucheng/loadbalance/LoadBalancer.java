package com.hucheng.loadbalance;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author HuChan
 */
public interface LoadBalancer {
    /**
     *
     * @return return selected instance
     */
    ServiceInstance instance(List<ServiceInstance> instances);
}
