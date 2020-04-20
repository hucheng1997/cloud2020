package com.hucheng.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author HuChan
 */
//@Configuration
//public class GatewayConfig {
//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//        RouteLocatorBuilder.Builder routes = builder.routes();
//        routes.route("/payment_route2",
//                route -> route.path("/payment/discovery/**")
//                        .uri("http://localhost:8001")
//        );
//        return routes.build();
//    }
//
//}
